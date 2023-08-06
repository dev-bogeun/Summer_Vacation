package com.tikkeul.app.service.program;


import com.tikkeul.app.domain.dto.SavingLevelDTO;
import com.tikkeul.app.domain.dto.SavingLevelFileDTO;
import com.tikkeul.app.domain.vo.FileVO;
import com.tikkeul.app.domain.vo.SavingLevelVO;

import java.util.List;
import java.util.Optional;

public interface ProgramService {

    //    프로그램 추가 ( 관리자 )
    public void writeSavingLevel(SavingLevelDTO savingLevelDTO);

    //    프로그램 조회 ( 관리자 )
    public List<SavingLevelVO> getSavingLevelAll();

    //    프로그램 상세 조회 ( 괸리자 )
    public SavingLevelDTO getSavingLevel(Long id);

    //    프로그램 수정 ( 관리자 )
    public void modify(SavingLevelDTO savingLevelDTO);

    //    프로그램 삭제 ( 관리자 )
    public void removeSavingLevel(Long id);

    default SavingLevelDTO toDTO(SavingLevelVO savingLevelVO){
        SavingLevelDTO savingLevelDTO = new SavingLevelDTO();
        savingLevelDTO.setId(savingLevelVO.getId());
        savingLevelDTO.setName(savingLevelVO.getName());
        savingLevelDTO.setGoalMoney(savingLevelVO.getGoalMoney());
        savingLevelDTO.setDailyMoney(savingLevelVO.getDailyMoney());
        return savingLevelDTO;
    }

    default SavingLevelFileDTO toDTO(FileVO fileVO){
        SavingLevelFileDTO savingLevelFileDTO = new SavingLevelFileDTO();
        savingLevelFileDTO.setId(fileVO.getId());
        savingLevelFileDTO.setOriginName(fileVO.getOriginName());
        savingLevelFileDTO.setFilePath(fileVO.getFilePath());
        savingLevelFileDTO.setUuid(fileVO.getUuid());
        savingLevelFileDTO.setFileSize(fileVO.getFileSize());
        return savingLevelFileDTO;
    }

}