package com.db.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author swedsn
 * @version 1.0
 * @date 2023-05-31 14:28
 */
@Data
public class RoomPrice {
    @TableId(type = IdType.AUTO)
    private int id;
    private String priceMargin;
}
