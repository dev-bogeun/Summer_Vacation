package com.tikkeul.app.mapper;

import com.tikkeul.app.domain.vo.SavingLevelFileVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SavingLevelFileMapper {
    public void insert(SavingLevelFileVO savingLevelFileVO);

    public void delete(Long savinglevelId);
}
