package com.db.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.db.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author swedsn
 * @version 1.0
 * @date 2023-05-31 08:23
 */
@Repository
@Mapper
public interface UsersMapper extends BaseMapper<Users> {

}
