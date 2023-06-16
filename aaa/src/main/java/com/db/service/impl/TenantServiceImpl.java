package com.db.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.db.entity.Tenant;
import com.db.mapper.TenantMapper;
import com.db.service.TenantService;
import com.db.utils.RandomNameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author swedsn
 * @version 1.0
 * @date 2023-05-31 09:19
 */
@Service
public class TenantServiceImpl extends ServiceImpl<TenantMapper, Tenant> implements TenantService {
    @Autowired
    private TenantMapper tenantMapper;
    @Override
    public Tenant tenantLogin(String username,  String password) {

        LambdaQueryWrapper<Tenant> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper
                .eq(Tenant::getTPhone, username)
                .or().eq(Tenant::getTEmail, username)
                .or().eq(Tenant::getTNickname, username)
                .eq(Tenant::getTPassword,password);
        return tenantMapper.selectOne(lambdaQueryWrapper);
    }

    @Override
    public Integer tenantRegister(Tenant tenant) {
        if (tenantSearchByTel(tenant.getTPhone())){
            return 0;
        }
        tenant.setTNickname(RandomNameUtils.generateRandomString(6));
        return tenantMapper.insert(tenant);
    }

    @Override
    public Boolean tenantSearchByTel(String telephone) {
        LambdaQueryWrapper<Tenant> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Tenant::getTPhone, telephone);
        Tenant tenant1 = tenantMapper.selectOne(lambdaQueryWrapper);
        return tenant1 !=null;
    }



}
