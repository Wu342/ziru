package com.db.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

/**
 * @author swedsn
 * @version 1.0
 * @date 2023-05-31 08:38
 */

@Data
@TableName("attribute")
//信息属性表
public class Attribute {
    @TableId(type = IdType.AUTO)
    private Integer attrId;// 属性ID
    private String attrName;// 属性名称

    @TableField(exist = false)
    private List<AttrValue> attrValueList;// 使用list来描述属性值与属性值之间的关系
}
