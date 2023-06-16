package com.db.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.List;

/**
 * @author swedsn
 * @version 1.0
 * @date 2023-05-31 08:39
 */
@Data
// 对应Attribute的子属性
@TableName("attrvalue")
public class AttrValue {
    @TableId(type = IdType.AUTO)
    private int id;
    private int attrId;
    private String valueName;

    @TableField(exist = false)
    private List<String> nameList;// 使用list来解决attrId解决二级属性的关系

}
