package com.db.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author swedsn
 * @version 1.0
 * @date 2023-05-31 08:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "租客实体类")
public class Tenant {
    @ApiModelProperty(value = "租客ID")
    @TableId(type = IdType.AUTO)
    private Integer tId;

    @ApiModelProperty(value = "租客昵称")
    private String tNickname;
    @ApiModelProperty(value = "租客电话号码")
    private String tPhone;
    @ApiModelProperty(value = "租客电子邮箱")
    private String tEmail;
    private String tPassword;
}
