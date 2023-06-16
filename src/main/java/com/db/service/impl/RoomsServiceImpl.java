package com.db.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.db.entity.RoomTitle;
import com.db.entity.Rooms;
import com.db.mapper.RoomTitleMapper;
import com.db.mapper.RoomsMapper;
import com.db.service.RoomTitleService;
import com.db.service.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfox.documentation.spring.web.json.Json;

import java.util.HashMap;
import java.util.List;

/**
 * @author swedsn
 * @version 1.0
 * @date 2023-05-31 10:14
 */
@Service
public class RoomsServiceImpl extends ServiceImpl<RoomsMapper, Rooms> implements RoomsService {

    @Autowired
    private RoomsMapper roomsMapper;
    @Autowired
    private RoomTitleMapper roomTitleMapper;

    //@Override
    public Rooms queryRoomInfoById(Integer roomsId) {
        return roomsMapper.queryRoomInfo(roomsId);
    }

    @Override
    public HashMap<String, Object> queryRoomByCondition(String condition, int current, int size, String sort) {
        // 1、查询条件
        LambdaQueryWrapper<Rooms> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Rooms::getRoomName, condition).or().like(Rooms::getSubway, condition);
        // 2、排序
        if (sort.equals("price")){
            lambdaQueryWrapper.orderBy(true, true,Rooms::getRoomPrice);
        } else if (sort.equals("area")) {
            lambdaQueryWrapper.orderBy(true, true,Rooms::getRoomArea);
        }
        // 3、分页查询
        Page<Rooms> page = new Page<>(current, size);
        Page<Rooms> reslut = roomsMapper.selectPage(page, lambdaQueryWrapper);

        // 查询对应的rooms（这里的rooms需要遍历来获取对应的rooms标签属性）
        List<Rooms> roomsList = reslut.getRecords();
        for (Rooms rooms: roomsList){
            List<RoomTitle> roomTitles = queryRoomTileById(rooms.getRoomId());
            rooms.setRoomTitle(roomTitles);
        }
        // hashmap的方式返回
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("roomlist", roomsList);
        hashMap.put("count", page.getTotal());
        hashMap.put("page", page.getPages());
        return hashMap;
    }


    @Override
    public List<RoomTitle> queryRoomTileById(Integer roomsId) {
        LambdaQueryWrapper<RoomTitle> titleLambda = new LambdaQueryWrapper<>();
        titleLambda.eq(RoomTitle::getRoomId, roomsId);
        return roomTitleMapper.selectList(titleLambda);
    }
}
