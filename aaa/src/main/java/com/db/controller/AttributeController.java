package com.db.controller;

import com.db.service.AttriButeService;
import com.db.utils.JsonResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author swedsn
 * @version 1.0
 * @date 2023-06-06 09:35
 */
@RestController
@CrossOrigin
public class AttributeController {
    @Autowired
    AttriButeService attriButeService;

    // 前端展示页面的查询方式（找房方式、类型、租金、特色户型）
    @GetMapping("/attr/show")
    public JsonResultUtils show(){
        return attriButeService.showAttr();
    }
}
