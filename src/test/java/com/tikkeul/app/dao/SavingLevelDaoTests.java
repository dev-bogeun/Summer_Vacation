package com.tikkeul.app.dao;


import com.tikkeul.app.domain.vo.SavingLevelVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class SavingLevelDaoTests {
    @Autowired
    SavingLevelDAO savingLevelDAO;
    @Test
    public void savingLevelAllTest(){
        log.info(savingLevelDAO.findAll().toString());
    }
}
