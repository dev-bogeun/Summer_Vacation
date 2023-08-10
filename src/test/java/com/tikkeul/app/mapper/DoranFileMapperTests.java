package com.tikkeul.app.mapper;

import com.tikkeul.app.domain.type.FileType;
import com.tikkeul.app.domain.vo.DoranFileVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class DoranFileMapperTests {
    @Autowired
    private DoranFileMapper doranFileMapper;

    @Test
    public void insertTest(){
        DoranFileVO doranFileVO = new DoranFileVO();
        doranFileVO.setFileName("하이.png");
        doranFileVO.setFileSize(1231231L);
        doranFileVO.setFileUuid(UUID.randomUUID().toString());
        doranFileVO.setFilePath("2023/08/05");;
        doranFileVO.setFileType(FileType.REPRESENTATIVE.name());
        doranFileVO.setDoranBoardId(415L);
        doranFileMapper.insert(doranFileVO);
    }

    @Test
    public void selectAllTest(){
          doranFileMapper.selectAll(362L).stream().map(DoranFileVO::toString).forEach(log::info);
    }

    @Test
    public void deleteTest(){
        doranFileMapper.delete(165L);
        assertThat(doranFileMapper.selectAll(543L)).hasSize(0);
    }

    @Test
    public void deleteAllTest(){
        doranFileMapper.deleteAll(362L);
        assertThat(doranFileMapper.selectAll(362L)).hasSize(0);
    }
    @Test
    public void selectYesterdayTest(){
        final File file = Paths.get("C:/upload", "2023/05/26").toFile();

        Arrays.stream(file.listFiles()).forEach(f -> log.info(f.getAbsolutePath()));
        Arrays.stream(file.listFiles()).forEach(f -> log.info(f.getName()));

//        log.info(fileMapper.selectYesterday().toString());
    }
}
