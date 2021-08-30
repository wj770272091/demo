//package com.example.demo.config;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Calendar;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @NAME: CustomAuthenticationFailureHandler
// * @USER: 77027
// * @DATE: 2021/1/4
// * @TIME: 11:03
// */
//public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
//    private ObjectMapper objectMapper = new ObjectMapper();
//    @Override
//    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
//        httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
//        Map<String, Object> data = new HashMap<>();
//        data.put(
//                "timestamp",
//                Calendar.getInstance().getTime());
//        data.put(
//                "exception",
//                e.getMessage());
//        System.out.println(data.toString());
//        httpServletResponse.getOutputStream()
//                .println(objectMapper.writeValueAsString(data));
//
//    }
//}
