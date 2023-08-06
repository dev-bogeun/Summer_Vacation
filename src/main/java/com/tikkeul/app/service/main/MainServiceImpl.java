package com.tikkeul.app.service.main;

import com.tikkeul.app.dao.SavingLevelDAO;
import com.tikkeul.app.domain.dto.ItemFileSavingLevelDTO;
import com.tikkeul.app.domain.dto.SavingLevelFileDTO;
import com.tikkeul.app.domain.vo.FileVO;
import com.tikkeul.app.domain.vo.SavingLevelVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("main") @Primary
@Slf4j
public class MainServiceImpl implements MainService{
    private final SavingLevelDAO savingLevelDAO;
//    레벨 목록
    @Override
    public List<SavingLevelFileDTO> getsavinglevelList() {
        log.info(savingLevelDAO.findAll().toString());
        return savingLevelDAO.findAll();
    }
}
