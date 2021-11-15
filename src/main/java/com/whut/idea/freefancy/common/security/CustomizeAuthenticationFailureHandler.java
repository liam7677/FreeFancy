package com.whut.idea.freefancy.common.security;

import com.alibaba.fastjson.JSON;
import com.whut.idea.freefancy.common.response.ResponseCode;
import com.whut.idea.freefancy.common.response.ResponseJson;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author LiMing
 * @date 2021/11/13 14:34
 */
@Component
public class CustomizeAuthenticationFailureHandler implements AuthenticationFailureHandler {


    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        //返回json数据
        ResponseJson result = null;
        if (e instanceof BadCredentialsException) {
            //密码错误
            result = ResponseJson.failure(ResponseCode.USER_LOGIN_ERROR);
        } else if (e instanceof DisabledException) {
            //账号不可用
            result = ResponseJson.failure(ResponseCode.USER_ACCOUNT_FORBIDDEN);
        } else if (e instanceof InternalAuthenticationServiceException) {
            //用户不存在
            result = ResponseJson.failure(ResponseCode.USER_NOT_EXIST);
        } else {
            //其他错误
            result = ResponseJson.failure(ResponseCode.COMMON_FAILURE);
        }
        //处理编码方式，防止中文乱码的情况
        httpServletResponse.setContentType("text/json;charset=utf-8");
        //塞到HttpServletResponse中返回给前台
        httpServletResponse.getWriter().write(JSON.toJSONString(result));
    }
}