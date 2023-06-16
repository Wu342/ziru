package com.db.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.db.entity.AttrValue;
import com.db.entity.Attribute;
import com.db.entity.RoomTitle;
import com.db.entity.Rooms;
import com.db.mapper.AttrValueMapper;
import com.db.mapper.AttriButeMapper;
import com.db.mapper.RoomTitleMapper;
import com.db.mapper.RoomsMapper;
import com.db.service.RoomTitleService;
import com.db.service.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import springfox.documentation.spring.web.json.Json;

import java.util.ArrayList;
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

    @Autowired
    private AttriButeMapper attriButeMapper;

    @Autowired
    private AttrValueMapper attrValueMapper;
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

    //@Override
    public HashMap<String, Object> selectRoomsByCategory(List<Integer> idList, int current, int size, String sort) {
        LambdaQueryWrapper<Rooms> lambdaQueryWrapper = new LambdaQueryWrapper<>();

        for (Integer id: idList){
            AttrValue attrValue = attrValueMapper.selectById(id);
            if (attrValue.getAttrId() == 1){// 找房方式
                if (48<id & id<51){// 朝向
                    lambdaQueryWrapper.lt(Rooms::getAreaLocation, attrValue.getValueName());
                }
                if (52<id & id<55){// 地铁站
                    lambdaQueryWrapper.lt(Rooms::getSubway, attrValue.getValueName());
                }
            } else if (attrValue.getAttrId() == 2) {// 类型
                lambdaQueryWrapper.lt(Rooms::getTenementName, attrValue.getValueName());
            }else if (attrValue.getAttrId() == 3) {// 租金金额
                if (id == 5){
                    lambdaQueryWrapper.lt(Rooms::getRoomPrice, 1500);
                }
                if (id == 6){
                    lambdaQueryWrapper.ge(Rooms::getRoomPrice, 1500).lt(Rooms::getRoomPrice, 2500);
                }
                if (id == 7){
                    lambdaQueryWrapper.ge(Rooms::getRoomPrice, 2500).lt(Rooms::getRoomPrice,3500);
                }
                if (id == 8){
                    lambdaQueryWrapper.ge(Rooms::getRoomPrice, 3500).lt(Rooms::getRoomPrice, 4500);
                }
                if (id == 9){
                    lambdaQueryWrapper.ge(Rooms::getRoomPrice, 4500).lt(Rooms::getRoomPrice, 6000);
                }
                if (id == 10){
                    lambdaQueryWrapper.ge(Rooms::getRoomPrice, 6000).lt(Rooms::getRoomPrice, 8000);
                }
                if (id == 11){
                    lambdaQueryWrapper.ge(Rooms::getRoomPrice, 9000);
                }
            }else if (attrValue.getAttrId() == 4) {// 特性户型
                lambdaQueryWrapper.lt(Rooms::getCharacterName, attrValue.getValueName());
            }else if (attrValue.getAttrId() == 5) {// 特惠活动
                lambdaQueryWrapper.lt(Rooms::getSpecialOffer, attrValue.getValueName());
            }else if (attrValue.getAttrId() == 6) {// 房屋面积
                if (id == 23){
                    lambdaQueryWrapper.lt(Rooms::getRoomArea, 10);
                }
                if (id == 24){
                    lambdaQueryWrapper.ge(Rooms::getRoomArea, 10).lt(Rooms::getRoomArea, 20);
                }
                if (id == 25){
                    lambdaQueryWrapper.ge(Rooms::getRoomArea, 20);
                }
                if (id == 26){
                    lambdaQueryWrapper.lt(Rooms::getRoomArea, 40);
                }
                if (id == 27){
                    lambdaQueryWrapper.ge(Rooms::getRoomArea, 40).lt(Rooms::getRoomArea, 60);
                }
                if (id == 28){
                    lambdaQueryWrapper.ge(Rooms::getRoomArea, 60).lt(Rooms::getRoomArea, 80);
                }
                if (id == 29){
                    lambdaQueryWrapper.ge(Rooms::getRoomArea, 80).lt(Rooms::getRoomArea, 100);
                }
                if (id == 30){
                    lambdaQueryWrapper.ge(Rooms::getRoomArea, 100).lt(Rooms::getRoomArea, 120);
                }
            }else if (attrValue.getAttrId() == 7) {//房屋朝向
                lambdaQueryWrapper.lt(Rooms::getOrientationName, attrValue.getValueName());
            }else if (attrValue.getAttrId() == 8) {// 供暖方向
                lambdaQueryWrapper.lt(Rooms::getHeatingType, attrValue.getValueName());
            }else if (attrValue.getAttrId() == 9) {// 租期时长
                if (id == 56){
                    lambdaQueryWrapper.lt(Rooms::getRoomtime, 24);
                }
                if (id == 57){
                    lambdaQueryWrapper.eq(Rooms::getRoomtime, 24);
                }
                if (id == 58){
                    lambdaQueryWrapper.ge(Rooms::getRoomtime, 24);
                }
            }else if (attrValue.getAttrId() == 10) {// 房源状态
                lambdaQueryWrapper.lt(Rooms::getTenementName, attrValue.getValueName());
            }

            // 2、排序
            if (sort.equals("price")){
                lambdaQueryWrapper.orderBy(true, true,Rooms::getRoomPrice);
            } else if (sort.equals("area")) {
                lambdaQueryWrapper.orderBy(true, true,Rooms::getRoomArea);
            }
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
}
