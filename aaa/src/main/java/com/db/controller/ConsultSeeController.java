package com.db.controller;

import com.alibaba.fastjson.JSONObject;
import com.db.entity.ConsultSee;
import com.db.service.ConsultSeeService;
import com.db.utils.JsonResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author swedsn
 * @version 1.0
 * @date 2023-05-31 10:07
 */
@RestController
@CrossOrigin
public class ConsultSeeController {
    @Autowired
    private ConsultSeeService consultSeeService;

    // 7、预约看房（时间、手机号）
    @PostMapping("/see/insert")
    public JsonResultUtils consultSeeInsert(ConsultSee consultSee){
        boolean save = consultSeeService.save(consultSee);
        if (save){
            return new JsonResultUtils(1, "提交成功");

        }
        return new JsonResultUtils(0, "提交失败");
    }
}
