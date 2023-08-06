package com.tikkeul.app.dao;

import com.tikkeul.app.domain.vo.SavingLevelFileVO;
import com.tikkeul.app.mapper.SavingLevelFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SavingLevelFileDAO {
    private final SavingLevelFileMapper savingLevelFileMapper;

    public void save(SavingLevelFileVO savingLevelFileVO){
        savingLevelFileMapper.insert(savingLevelFileVO);
    }

    public void delete(Long savinglevelId){
        savingLevelFileMapper.delete(savinglevelId);
    }
}
