package com.db.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.db.entity.Tenant;

/**
 * @author swedsn
 * @version 1.0
 * @date 2023-05-31 09:19
 */
public interface TenantService extends IService<Tenant> {

    // 租客登陆
    public Tenant tenantLogin(String username, String password);

    // 租客注册
    public Integer tenantRegister(Tenant tenant);

    // 通过电话号码查询该租客是否存在
    public Boolean tenantSearchByTel(String telephone);

}
