package com.SrpingBoot.Shopping.Kakao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/member")
public class KakaoController {

    @Autowired
    KakaoService s;

    @Value("${kakao.client.id}")
    private String CLIENT_ID;

    @Value("${kakao.client.secret}")
    private String CLIENT_SECRET;
    @Value("${kakao.redirect.url}")
    private String REDIRECT_URL;
    @GetMapping("/do")
    public String loginPage(Model model){
        model.addAttribute("CLIENT_ID", CLIENT_ID);
        model.addAttribute("REDIRECT_URL", REDIRECT_URL);
        return "login";
    }

    @GetMapping("/kakao")
    public String getCI(@RequestParam String code, Model model) throws IOException{
        System.out.println("code = "+code);
        String access_token = s.getToken(code);
        Map<String,Object> userInfo=s.getUserInfo(access_token);
        model.addAttribute("code", code);
        model.addAttribute("access_token", access_token);
        model.addAttribute("userInfo", userInfo);

        //ci는 비즈니스 전환후 검수신청 -> 허락받아야 수집 가능
        return "index";
    }
}
