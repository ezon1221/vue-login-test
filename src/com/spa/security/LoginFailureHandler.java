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

        // ����ڰ� �Է��� ID ����
        String inputUsername = request.getParameter("username");
        String message;

        // �׽�Ʈ�� ����ڸ� �ϵ��ڵ� Ȯ��
        if (!"tester".equals(inputUsername)) {
            message = "���̵� Ȯ�����ּ���.";
        } else if (exception instanceof BadCredentialsException) {
            message = "��й�ȣ�� Ȯ�����ּ���.";
        } else {
            message = "�α��ο� �����Ͽ����ϴ�.";
        }

        response.getWriter().write("{\"status\":\"fail\", \"message\":\"" + message + "\"}");
        response.getWriter().flush();
    }
}
