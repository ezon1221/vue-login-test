//package com.spa.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletRequest;
//
//@Controller
//public class LoginController {
//
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    @ResponseBody
//    public String login(HttpServletRequest request) {
//        String userId = request.getParameter("userId");
//        String password = request.getParameter("password");
//        System.out.println("로그인 시 입력된 아이디:::::::::::::::"+userId);
//        System.out.println("로그인 시 입력된 비밀번호:::::::::::::::"+password);
//        if ("tester".equals(userId) && "pswd1234".equals(password)) {
//            return "success";
//        } else {
//            return "fail";
//        }
//    }
//}
