package com.tikkeul.app.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/mypage/*")
@RequiredArgsConstructor
public class MypageController {

    @GetMapping("gumaehugi")
    public void gkgk(){;}

    @GetMapping("mypage")
    public void gkk(){;}

    @GetMapping("changeInfo")
    public void g(){;}

    @GetMapping("chage-password")
    public void gk(){;}

    @GetMapping("mypage-doranbang")
    public void gkksa(){;}

    @GetMapping("mypage-pay")
    public void gksk(){;}

    @GetMapping("mypage-review")
    public void gkkd(){;}

    @GetMapping("mypage-review-change")
    public void gdkkd(){;}

    @GetMapping("mypage-review-details")
    public void gdasdkkd(){;}

    @GetMapping("UpdateBasicInfo")
    public void gadkk(){;}

    @GetMapping("jjim")
    public void gadkka(){;}

    @GetMapping("DropOutUser")
    public void gadkak(){;}



}
