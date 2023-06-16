package com.db.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author swedsn
 * @version 1.0
 * @date 2023-05-31 08:36
 */
@Data
@TableName("consultsee")
public class ConsultSee {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private int roomId;
    private int uid;
    private String seeTime;
    private String seePhone;
}
