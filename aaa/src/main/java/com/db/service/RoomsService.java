package com.db.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.db.entity.Attribute;
import com.db.entity.RoomTitle;
import com.db.entity.Rooms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author swedsn
 * @version 1.0
 * @date 2023-05-31 10:13
 */
public interface RoomsService extends IService<Rooms>{

    // 通过房间ID查询房间的所有详细信息
    public Rooms queryRoomInfoById(Integer roomsId);

    // 按照条件查询房屋
    public Object queryRoomByCondition(String condition, int current, int size, String sort);

    // 将查询到的rooms遍历，查询对应的roomTitle属性
    public List<RoomTitle> queryRoomTileById(Integer roomsId);

    public HashMap<String, Object> selectRoomsByCategory(List<Integer> idList, int current, int size, String sort);

}
