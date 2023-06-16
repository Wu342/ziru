package com.db.controller;

import com.alibaba.fastjson.JSONObject;
import com.db.entity.Tenant;
import com.db.service.TenantService;
import com.db.utils.JsonResultUtils;
import com.db.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author swedsn
 * @version 1.0
 * @date 2023-05-31 09:14
 */
@RestController
public class TenantController {

    @Autowired
    private TenantService tenantService;

    //1、租客登陆（手机号/邮箱/昵称、密码）
    @PostMapping("/tenant/login")
    public JsonResultUtils teanantLogin(String username, String password){
        Tenant tenant = tenantService.tenantLogin(username, password);
        if (tenant != null){
            String token = JwtUtils.generateToken(tenant.getTPhone());
            return new JsonResultUtils(1, token);
        }
        return new JsonResultUtils(0, "登陆失败");
    }

    // 2、租客注册（手机号、密码）
    @GetMapping("/tenant/register")
    public JsonResultUtils teanantRegister(Tenant tenant){
        Integer integer = tenantService.tenantRegister(tenant);
        if (integer ==0 ){
            return new JsonResultUtils(0,"该电话号码已存在");
        }

        return new JsonResultUtils(1,"注册成功");
    }

}
