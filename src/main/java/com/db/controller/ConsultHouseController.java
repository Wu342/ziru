package com.db.controller;

import com.db.entity.ConsultHouse;
import com.db.service.ConsultHouseService;
import com.db.utils.JsonResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author swedsn
 * @version 1.0
 * @date 2023-05-31 10:07
 */
@RestController
@CrossOrigin
public class ConsultHouseController {

    @Autowired
    private ConsultHouseService consultHouseService;

    // 8、咨询房源(用户咨询问题+留电话号码)
    @GetMapping("/house/insert")
    public JsonResultUtils consultHouseInsert(ConsultHouse consultHouse){
        boolean save = consultHouseService.save(consultHouse);
        return new JsonResultUtils(1, "添加成功");
    }
}
