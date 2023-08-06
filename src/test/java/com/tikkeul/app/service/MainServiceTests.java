package com.tikkeul.app.service;

import com.tikkeul.app.domain.dto.SavingLevelFileDTO;
import com.tikkeul.app.service.main.MainService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest @Slf4j
public class MainServiceTests {
    @Autowired
    MainService mainService;
    @Test
    public List<SavingLevelFileDTO> getsavinglevelListTest(){
        return null;
    };
}
