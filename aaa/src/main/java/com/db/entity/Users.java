package com.db.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author swedsn
 * @version 1.0
 * @date 2023-05-31 08:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @TableId(type = IdType.AUTO)
    private Integer uid;
    private String uname;
    private String upicture;
}
