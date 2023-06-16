package com.db;

import com.db.mapper.RoomsMapper;
import com.db.service.RoomsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ZiroomApplicationTests {

    @Autowired
    private RoomsService roomsService;

    @Autowired
    private RoomsMapper roomsMapper;

    @Test
    public void testRoomInfo(){
        //LambdaQueryWrapper<Rooms> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //lambdaQueryWrapper.like(Rooms::getRoomName, "一号线").or().like(Rooms::getSubway, "一号线");
        //Page<Rooms> page = new Page<>(1, 10);
        //Page<Rooms> reslut = roomsMapper.selectPage(page, lambdaQueryWrapper);
        //
        //List<Rooms> roomsList = reslut.getRecords();
        //
        //System.out.println();

        int page = (int) Math.ceil((double) 20/3);
        System.out.println(page);
    }
}
