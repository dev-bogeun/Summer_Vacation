package com.tikkeul.app.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest@Slf4j
public class ItemFileMapperTest {
    @Autowired
    ItemFileMapper itemFileMapper;

    @Test
    public void savingLevelAllTest(){
         log.info(itemFileMapper.selectitemfile().toString());
    }
}
