package com.tikkeul.app.dao;

import com.tikkeul.app.domain.vo.ItemFileVO;
import com.tikkeul.app.mapper.ItemFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ItemFileDAO {
    private final ItemFileMapper itemFileMapper;

    public void saveItem(ItemFileVO itemFileVO){
        itemFileMapper.insertItem(itemFileVO);
    }
}