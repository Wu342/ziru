package com.db.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author swedsn
 * @version 1.0
 * @date 2023-05-31 08:35
 */
@Data
@Builder
@TableName("consulthouse")
public class ConsultHouse {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private int roomId;
    private int uid;
    private String problem;
    private String cPhone;
}
