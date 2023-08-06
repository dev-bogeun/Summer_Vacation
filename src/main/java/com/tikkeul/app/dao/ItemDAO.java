package com.tikkeul.app.dao;

import com.tikkeul.app.domain.dto.ItemDTO;
import com.tikkeul.app.domain.dto.ItemFileSavingLevelDTO;
import com.tikkeul.app.domain.dto.OrderDTO;
import com.tikkeul.app.domain.type.CategoryType;
import com.tikkeul.app.domain.vo.ItemVO;
import com.tikkeul.app.mapper.ItemMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ItemDAO {
    private final ItemMapper itemMapper;

    //    김보령 작업공간
//    열매샵 제품 목록 가져오기 : list.html
    public List<ItemDTO> findAll(CategoryType categoryType) {
        return itemMapper.selectAll(categoryType);
    }

    //    열매샵 제품 상세 보기 : readDetail.html
    public Optional<ItemDTO> readDetail(Long id) {
        return itemMapper.select(id);
    }

    //    후기 수 별점
    public Optional<OrderDTO> readScoreAndCountOfReview(Long id) {
        return itemMapper.selectScoreAndCountOfReview(id);
    }



//    홍윤기 작업공간
    public List<ItemFileSavingLevelDTO> findAllItem() { return itemMapper.selectAllItem();
    }

    public List<ItemFileSavingLevelDTO> findAllOptionItem(Long savingLevelId) { return itemMapper.selectAllOptionItem(savingLevelId);
    }
    //    제품 등록 ( 관리자 )
    public void saveItem(ItemDTO itemDTO){
        itemMapper.insertItem(itemDTO);
    }
}