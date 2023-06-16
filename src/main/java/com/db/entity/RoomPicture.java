package com.db.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author swedsn
 * @version 1.0
 * @date 2023-05-31 08:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomPicture {
    @TableId(type = IdType.AUTO)
    private int id;
    private int roomId;
    private String pictureURL;
}
