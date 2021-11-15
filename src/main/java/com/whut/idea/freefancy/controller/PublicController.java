package com.whut.idea.freefancy.controller;

import com.whut.idea.freefancy.common.response.ResponseCode;
import com.whut.idea.freefancy.common.response.ResponseJson;
import com.whut.idea.freefancy.dto.UserManageDTO;
import com.whut.idea.freefancy.entity.UserManage;
import com.whut.idea.freefancy.service.UserManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author LiMing
 * @date 2021/11/11 16:07
 */
@Api(value = "PublicController",tags = "公共功能接口")
@RestController
@RequestMapping("/public")
public class PublicController {
    private static final Logger LOG = LoggerFactory.getLogger(PublicController.class);

    @Autowired
    UserManageService userManageService;

    @GetMapping("/index")
    public Object index(){
        return ResponseJson.success();
    }

    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public void login(String username, String password){
    }

    @ApiOperation(value = "登出")
    @GetMapping("/logout")
    public void logout(){
    }

    @ApiOperation(value = "注册")
    @PostMapping("/register")
    @Transactional
    public Object register(@RequestBody @Validated UserManageDTO userManageDTO){
        UserManage userManage = new UserManage(userManageDTO);
        UserManage user = userManageService.getOneByUsername(userManage.getUsername());
        if (user != null) {
            return ResponseJson.failure(ResponseCode.USER_HAS_EXISTED);
        }
        if (userManageService.save(userManage)) {
            return ResponseJson.success();
        }else {
            return ResponseJson.failure(ResponseCode.SYSTEM_INNER_ERROR);
        }
    }

}
