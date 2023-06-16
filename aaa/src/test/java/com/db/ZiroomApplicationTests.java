package com.db;

import com.db.entity.Tenant;
import com.db.mapper.RoomsMapper;
import com.db.mapper.TenantMapper;
import com.db.service.RoomsService;
import com.db.service.TenantService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ZiroomApplicationTests {

    @Autowired
    private RoomsService roomsService;

    @Autowired
    private RoomsMapper roomsMapper;

    @Autowired
    private TenantService tenantService;

    @Test
    public void testRoomInfo(){

    }
}
