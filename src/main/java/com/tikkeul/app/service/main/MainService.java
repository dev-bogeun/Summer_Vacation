package com.tikkeul.app.service.main;

import com.tikkeul.app.domain.dto.ItemFileSavingLevelDTO;
import com.tikkeul.app.domain.dto.SavingLevelFileDTO;
import com.tikkeul.app.domain.vo.FileVO;
import com.tikkeul.app.domain.vo.SavingLevelVO;

import java.util.List;

public interface MainService {
//  레벨 목록
    public List<SavingLevelFileDTO>  getsavinglevelList();


}
