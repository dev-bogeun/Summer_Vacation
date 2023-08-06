package com.tikkeul.app.controller;

import com.tikkeul.app.dao.UserDAO;
import com.tikkeul.app.domain.vo.UserVO;
import com.tikkeul.app.service.KakaoService;
import com.tikkeul.app.service.join.JoinService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/kakao/*")
public class KakaoController {

    private final KakaoService kakaoService;
    private final UserDAO userDAO;
    private final JoinService joinService;
    @ResponseBody
    @GetMapping("login")
    public RedirectView  kakaoCallback(@RequestParam String code, HttpSession session , RedirectAttributes redirectAttributes) throws Exception {
        log.info(code);
        String token = kakaoService.getKaKaoAccessToken(code);
        Optional<UserVO> kakaoUser = Optional.ofNullable(kakaoService.getKakaoInfo(token));
        Optional<UserVO> user = joinService.checkId(kakaoUser.get().getIdentification());


        if(user.isPresent()){
            if(user.get().getRoll().equals("ADMIN")){
                return new RedirectView("/admin/main");
            }
            if(user.get().getStatus().equals("EXIT")){
                return new RedirectView("/join/login");
            }
            if(user.get().getRegisteredType().equals("NORMAL")){
                redirectAttributes.addFlashAttribute("login","already-exist-NORMAL");
                return new RedirectView("/join/login");
            }else if(user.get().getRegisteredType().equals("NAVER")){
                redirectAttributes.addFlashAttribute("login","already-exist-NAVER");
                return new RedirectView("/join/login");
            }else{   //네이버, 노말아닌 카카오 계정일경우 -> updatee
                kakaoUser.get().setId(user.get().getId());
                log.info(kakaoUser.get().toString());
                joinService.updateKakaoUser(kakaoUser);
                session.setAttribute("token", token);
                session.setAttribute("id",user.get().getId());
                return new RedirectView("/join/mainpage");
            }
        }
        joinService.join(kakaoUser.get());


        Optional<UserVO> foundId = joinService.login(kakaoUser.get().getIdentification(),kakaoUser.get().getPassword());

        log.info(foundId.toString());
        session.setAttribute("id",foundId.get().getId());
        session.setAttribute("token", token);

        return new RedirectView("/join/mainpage");
    }

    @GetMapping("logout")
    public RedirectView kakaoLogout(HttpSession session){
        log.info("logout");
        kakaoService.logoutKakao((String)session.getAttribute("token"));
        session.invalidate();
        return new RedirectView("/join/login");
    }
}

