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
//        System.out.println("�α��� �� �Էµ� ���̵�:::::::::::::::"+userId);
//        System.out.println("�α��� �� �Էµ� ��й�ȣ:::::::::::::::"+password);
//        if ("tester".equals(userId) && "pswd1234".equals(password)) {
//            return "success";
//        } else {
//            return "fail";
//        }
//    }
//}
