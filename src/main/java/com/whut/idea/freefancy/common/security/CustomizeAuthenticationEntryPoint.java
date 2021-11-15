package com.whut.idea.freefancy.common.security;

import com.alibaba.fastjson.JSON;
import com.whut.idea.freefancy.common.response.ResponseCode;
import com.whut.idea.freefancy.common.response.ResponseJson;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author LiMing
 * @date 2021/11/13 14:15
 */
@Component
public class CustomizeAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        ResponseJson responseJson = ResponseJson.failure(ResponseCode.USER_NOT_LOGGED_IN);
        httpServletResponse.setContentType("text/json;charset=utf-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(responseJson));
    }
}
