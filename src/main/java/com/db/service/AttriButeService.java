package com.db.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.db.entity.Attribute;
import com.db.utils.JsonResultUtils;

/**
 * @author swedsn
 * @version 1.0
 * @date 2023-06-06 09:29
 */
public interface AttriButeService extends IService<Attribute> {

    JsonResultUtils showAttr();
}
