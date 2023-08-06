package com.tikkeul.app.mapper;

import com.tikkeul.app.domain.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Slf4j
public class ItemMapperTests {
    //    상품페이지
    @Autowired
     private ItemMapper itemMapper;

    @Test
    public void itemtest(){
        itemMapper.selectAllItem();
    }

}

