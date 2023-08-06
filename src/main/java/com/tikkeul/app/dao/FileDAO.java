package com.tikkeul.app.dao;

import com.tikkeul.app.domain.dto.ItemFileDTO;
import com.tikkeul.app.domain.dto.SavingLevelFileDTO;
import com.tikkeul.app.mapper.FileMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class FileDAO {
    private final FileMapper fileMapper;

//    열매샵 파일조회



    public void save(SavingLevelFileDTO savingLevelFileDTO){
        fileMapper.insert(savingLevelFileDTO);
    }

    public List<SavingLevelFileDTO> savingLevelFindAll(Long savinglevelId){
        log.info(savinglevelId.toString());
        return fileMapper.savingLevelSelectlAll(savinglevelId);
    }

    public void savingLevelDelete(Long id){
        fileMapper.savingLevelDelete(id);
    }

    public void saveItem(ItemFileDTO itemFileDTO){
        fileMapper.insertItem(itemFileDTO);
    }
}