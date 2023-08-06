package com.tikkeul.app.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.security.SecureRandom;

@Controller
@Slf4j
@RequiredArgsConstructor
public class LoginController {

    private String CLIENT_ID = "ny2peuJ25fyfAu4Z7mI9"; //애플리케이션 클라이언트 아이디값";
    private String CLI_SECRET = "xo_Sh8qTRf"; //애플리케이션 클라이언트 시크릿값";
    @RequestMapping(value="login/oauth2/code/naver", method= RequestMethod.GET)
    public String loginPOSTNaver(Model model, HttpSession session)throws UnsupportedEncodingException, UnknownHostException {

        log.info("callback controller");
        String redirectURI = URLEncoder.encode("http://localhost:10000/callback1", "UTF-8");
        SecureRandom random = new SecureRandom();
        String state = new BigInteger(130, random).toString();
        String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
        apiURL += String.format("&client_id=%s&redirect_uri=%s&state=%s",
                CLIENT_ID, redirectURI, state);
        model.addAttribute("apiURL", apiURL);
        return "callback";
    }
}