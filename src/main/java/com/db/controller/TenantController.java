package com.db.controller;

import com.alibaba.fastjson.JSONObject;
import com.db.entity.Tenant;
import com.db.service.TenantService;
import com.db.utils.JsonResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    @GetMapping("/tenant/login")
    public JSONObject teanantLogin(Tenant tenant){
        Tenant tenant1 = tenantService.tenantLogin(tenant);
        JSONObject json = new JSONObject();
        if (tenant1 != null){
            json.put("code", 1);
            json.put("info", "登陆成功");
        }
        else {
            json.put("code", 0);
            json.put("info", "登陆失败");
        }
        return json;
    }

    // 2、租客注册（手机号、密码）
    @GetMapping("/tenant/register")
    public JSONObject teanantRegister(Tenant tenant){
        Integer integer = tenantService.tenantRegister(tenant);
        JSONObject json = new JSONObject();
        json.put("code", integer);
        json.put("info", tenant);
        return json;
    }

    // 租客修改个人信息
    @GetMapping("/tenant/update")
    public JsonResultUtils tenantUpdate(Tenant tenant){
        boolean flag = tenantService.updateById(tenant);
        return new JsonResultUtils(1, "修改成功");
    }

}
