package com.tikkeul.app.controller;

import com.tikkeul.app.domain.dto.ItemDTO;
import com.tikkeul.app.domain.dto.ItemFileSavingLevelDTO;
import com.tikkeul.app.domain.vo.UserVO;
import com.tikkeul.app.mapper.UserMapper;
import com.tikkeul.app.service.email.RegisterMail;
import com.tikkeul.app.service.item.ItemService;
import com.tikkeul.app.service.join.JoinService;
import com.tikkeul.app.service.main.MainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/join/*")
public class JoinController {
    private final  UserMapper userMapper;
    private final JoinService joinService;
    private final MainService mainService;
    private final ItemService itemService;


    //    아이디 중복검사
    @GetMapping("check-id/{identification}")
    @ResponseBody
    public boolean checkId(@PathVariable String identification){
        return joinService.checkId(identification).isPresent();
    }

//  회원가입폼으로 이동
    @GetMapping("join")
    public void goToJoin(UserVO userVO){;}

//        회원가입
    @PostMapping("join")
    public RedirectView join(UserVO userVO) {
        userVO.setRegisteredType("NORMAL");
        joinService.join(userVO);
        return new RedirectView("/join/login");
    };

//  로그인으로 이동
    @GetMapping("login")
    public void gotoLogin(UserVO userVO){;}


//  로그인
    @PostMapping("login")
    public RedirectView login(String identification, String password, HttpSession session, RedirectAttributes redirectAttributes){
        log.info("들어옴");
        final Optional<UserVO> foundUser = joinService.login(identification, password);
        if(foundUser.isPresent()){
            if(foundUser.get().getRoll().equals("ADMIN")){
                return new RedirectView("/admin/main");
            }if(foundUser.get().getStatus().equals("EXIT")){
                return new RedirectView("/join/login");
            }
            session.setAttribute("id", foundUser.get().getId());
            return new RedirectView("/join/mainpage");
        }
        redirectAttributes.addFlashAttribute("login", "fail");
        return new RedirectView("/join/login");
    }

    //    로그아웃
    @GetMapping("logout")
    public RedirectView logout(HttpSession session){
        session.invalidate();
        return new RedirectView("/join/mainpage");
    }

//    메인페이지로 이동
    @GetMapping("mainpage")
    public void goToMain(Model model){
        model.addAttribute("savinglevels",mainService.getsavinglevelList());
    }



//  메인페이지에서 모든 상품 불러오기
    @GetMapping("getItemAll")
    @ResponseBody
    public List<ItemFileSavingLevelDTO>  getItemAll(){
        log.info(itemService.getitemList().toString());
       return itemService.getitemList();
    }

//  메인 페이지에서 해당 상품 불러오기
    @GetMapping("getItem")
    @ResponseBody
    public List<ItemFileSavingLevelDTO> getItem(@RequestParam("savingLevelId") Long savingLevelId){
       return itemService.getOptionItemList(savingLevelId);
    }











    // 이메일 인증
    // 회원가입 메일 서비스
    private final RegisterMail registerMail;

    @PostMapping("mailConfirm")
    @ResponseBody
    String mailConfirm(@RequestParam("email") String email) throws Exception {
        String code = registerMail.sendSimpleMessage(email);
        System.out.println("인증코드 : " + code);
        return code;
    }
//   아이디 찾기 페이지
    @GetMapping("findid")
    public void goTofindid(){;}

//  비밀번호 찾기 페이지
    @GetMapping("findpw")
    public void goToFindPassword(){
        ;
    }

//  비밀번호 변경
    @PostMapping("changepw")
    @ResponseBody
    public String changePassWord(@RequestParam("email") String identification, @RequestParam("password") String password){
        joinService.updatePassword(identification,password);
        return "/join/login";
    }

//  비밀번호 조회
    @PostMapping("gofindpw")
    @ResponseBody
    public String findPassWord(@RequestParam("email") String identification, @RequestParam("password") String password){
        return joinService.findPassword(identification,password);
    }


//  네이버인지 아닌지 판단해서 계정을 업데이트 후 로그인시키거나 회원가입시킴
    @GetMapping("joinOrUpdate")
    @ResponseBody
    public String joinNaver(@RequestParam(value="identification", required=false) String identification,@RequestParam(value="name", required=false)String name,@RequestParam(value="id", required=false) String id, HttpSession session) {
        UserVO userVO = new UserVO();
        userVO.setIdentification(identification);
        userVO.setPassword(id);
        userVO.setName(name);
        Optional<UserVO> foundId = joinService.checkId(identification);
        if(foundId.isPresent()){
            if(foundId.get().getRoll().equals("ADMIN")){
                return "/admin/main";
            }
            if(foundId.get().getStatus().equals("EXIT")){return "/join/login";}
            if (foundId.get().getRegisteredType().equals("KAKAO") || foundId.get().getRegisteredType().equals("NORMAL") ) {
                return "/join/login";
            }else{
                joinService.updateNaverUser(userVO);
                Optional<UserVO> newid = joinService.checkId(identification);
                session.setAttribute("id", newid.get().getId());
                log.info("로그인되면서 업데이트됨");
                return "/join/mainpage";
            }
        }
        userVO.setRegisteredType("NAVER");
        joinService.join(userVO);
        Optional<UserVO> newid2 = joinService.checkId(identification);
        session.setAttribute("id",newid2.get().getId());
        log.info("회원가입됨");
        return "/join/mainpage";
    }

//  이메일이 소셜회원인지 체크
    @PostMapping("checkemailisSocial")
    @ResponseBody
    public String checkidisok(@RequestParam("email") String email) throws Exception {
        if(joinService.checkId(email).isEmpty()) {
            return "false";
        }else if(joinService.checkId(email).isPresent()) {
            return joinService.checkId(email).get().getRegisteredType();
        }
        return null;
    }
}
