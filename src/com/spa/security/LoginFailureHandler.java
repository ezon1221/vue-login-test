package com.spa.security;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception) throws IOException {

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json; charset=UTF-8");

        // 사용자가 입력한 ID 추출
        String inputUsername = request.getParameter("username");
        String message;

        // 테스트용 사용자만 하드코딩 확인
        if (!"tester".equals(inputUsername)) {
            message = "아이디를 확인해주세요.";
        } else if (exception instanceof BadCredentialsException) {
            message = "비밀번호를 확인해주세요.";
        } else {
            message = "로그인에 실패하였습니다.";
        }

        response.getWriter().write("{\"status\":\"fail\", \"message\":\"" + message + "\"}");
        response.getWriter().flush();
    }
}
