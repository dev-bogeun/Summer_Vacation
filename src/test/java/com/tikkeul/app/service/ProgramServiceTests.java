package com.tikkeul.app.service;

import com.tikkeul.app.domain.dto.SavingLevelDTO;
import com.tikkeul.app.domain.dto.SavingLevelFileDTO;
import com.tikkeul.app.domain.type.FileType;
import com.tikkeul.app.service.main.MainService;
import com.tikkeul.app.service.program.ProgramService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
@Slf4j
public class ProgramServiceTests {
    @Autowired
    ProgramService programService;
}
