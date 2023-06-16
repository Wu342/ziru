package com.db.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.db.entity.Tenant;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author swedsn
 * @version 1.0
 * @date 2023-05-31 09:18
 */
@Repository
public interface TenantMapper extends BaseMapper<Tenant> {
}
