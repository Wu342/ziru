package com.db.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.db.entity.Attribute;
import com.db.entity.Users;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author swedsn
 * @version 1.0
 * @date 2023-06-06 08:29
 */
@Repository
public interface AttriButeMapper extends BaseMapper<Attribute> {

    List<Attribute> findAttr();

}
