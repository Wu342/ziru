package com.db.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.db.entity.Attribute;
import com.db.mapper.AttriButeMapper;
import com.db.service.AttriButeService;
import com.db.utils.JsonResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author swedsn
 * @version 1.0
 * @date 2023-06-06 09:30
 */
@Service
public class AttriButeServiceImpl extends ServiceImpl<AttriButeMapper, Attribute> implements AttriButeService {

    @Autowired
    AttriButeMapper attriButeMapper;

    @Override
    public JsonResultUtils showAttr() {
        List<Attribute> attr = attriButeMapper.findAttr();
        return new JsonResultUtils(1, attr);
    }
}
