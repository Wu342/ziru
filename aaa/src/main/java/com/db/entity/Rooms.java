package com.db.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author swedsn
 * @version 1.0
 * @date 2023-05-31 08:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//@TableName("rooms")
public class Rooms {
    @TableId(value = "roomId", type = IdType.AUTO)
    private Integer roomId;
    private String roomName;
    private String roomArea;
    private String roomNumber;
    private String roomNumbers;
    private String houseType;
    private String floor;
    private String roomLocation;
    private String elevator;
    private String completion;
    private String heatingType;
    private String afforest;
    private String areaLocation;
    private String subway;
    private String tenementName;
    private String roomPrice;
    private String characterName;
    private String orientationName;
    private String statusName;
    private String specialOffer;
    private String roomtime;
    private String videoURL;
    private String roomPic;
    private int uid;
    //
    //@TableField(exist = false)
    //private RoomPrice getPriceMargin;

    // 查询房屋时的所有属性，包括房屋标签
    @TableField(exist = false)
    private List<RoomTitle> roomTitle;

    // 查询房屋时的所有属性，包括轮播图的图片
    @TableField(exist = false)
    private List<RoomPicture> roomPictures;

    @TableField(exist = false)
    private Users users;

}
