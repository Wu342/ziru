package com.db.controller;

import com.db.entity.Rooms;
import com.db.service.RoomsService;
import com.db.utils.JsonResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @author swedsn
 * @version 1.0
 * @date 2023-05-31 09:47
 */
@RestController
@CrossOrigin
public class RoomsController {

    @Autowired
    RoomsService roomsService;

    // 按照条件查询房屋（按照小区名称、地铁站查询）
    @GetMapping("/rooms/queryRoomsByCondition")
    public JsonResultUtils queryRoomsByCondition(String condition, int current, int size, String sort){
        Object info = roomsService.queryRoomByCondition(condition, current, size, sort);
        return new JsonResultUtils(1, info);
    }

    // 通过房屋id查询房屋详细信息(包括标签、轮播图以及对应的销售人员)
    @GetMapping("/rooms/queryRoomInfoById")
    public JsonResultUtils queryRoomInfoById(Integer roomsId){
        Rooms rooms = roomsService.queryRoomInfoById(roomsId);
        return new JsonResultUtils(1, rooms);
    }
    @GetMapping("/rooms/selectRoomsByCategory")
    public JsonResultUtils selectRoomsByCategory(@RequestParam("idList") List<Integer> idList, int current, int size, String sort){
        Object info = roomsService.selectRoomsByCategory(idList, current, size, sort);
        return new JsonResultUtils(1, info);
    }

}
