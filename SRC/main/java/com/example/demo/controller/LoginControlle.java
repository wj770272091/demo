package com.example.demo.controller;

import cn.hutool.extra.qrcode.QrCodeUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * @NAME: LoginControlle
 * @USER: WangJie
 * @DATE: 2021/10/19
 * @TIME: 14:42
 */
public class LoginControlle {

    @RequestMapping(value = "/getLoginQr",method = RequestMethod.GET)
    public void createCodeImg(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Pragma","No-cache");
        response.setHeader("Cache-Control","No-cache");
        response.setDateHeader("Expires",0);
        response.setContentType("image/jpeg");
        String uuid = UUID.randomUUID().toString();
        response.setHeader("uuid",uuid);
        try {
            QrCodeUtil.generate(uuid, 300, 300, "jpg",response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
