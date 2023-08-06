package com.tikkeul.app.mapper;

import com.tikkeul.app.domain.dto.SavingLevelDTO;
import com.tikkeul.app.domain.dto.SavingLevelFileDTO;
import com.tikkeul.app.domain.vo.SavingLevelVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface SavingLevelMapper {
    public void insertSavingLevel(SavingLevelDTO savingLevelDTO);

    public List<SavingLevelVO> admminSelectSavingLevelAll();

    public List<SavingLevelFileDTO> savingLevelFileAll();

    public Optional<SavingLevelDTO> adminSelectSavingLevel(Long id);

    public void adminUpdateSavingLevel(SavingLevelDTO savingLevelDTO);

    public void adminDeleteSavingLevel(Long id);



}
