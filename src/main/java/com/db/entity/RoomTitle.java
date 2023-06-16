package com.db.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author swedsn
 * @version 1.0
 * @date 2023-05-31 08:44
 */
@Data
@TableName("roomtitle")
public class RoomTitle {
    @TableId(type = IdType.AUTO)

    private Integer id;
    private int roomId;
    private String titleName;
}
