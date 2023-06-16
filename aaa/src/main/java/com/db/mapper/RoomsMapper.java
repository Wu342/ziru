package com.db.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.db.entity.Rooms;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author swedsn
 * @version 1.0
 * @date 2023-05-31 10:13
 */
@Repository
public interface RoomsMapper extends BaseMapper<Rooms> {

    // 通过rooms的ID查询房间的所有信息
    Rooms queryRoomInfo(Integer roomsId);

    // 按照条件查询房间
    List<Rooms> selectRoomsByCategory(Rooms rooms);
}
