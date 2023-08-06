package com.tikkeul.app.mapper;

import com.tikkeul.app.domain.dto.ItemFileSavingLevelDTO;
import com.tikkeul.app.domain.vo.ItemFileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemFileMapper {



    public List<ItemFileSavingLevelDTO> selectitemfile();


    public void insertItem(ItemFileVO itemFileVO);
}
