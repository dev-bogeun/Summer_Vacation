package com.tikkeul.app.mapper;

import com.tikkeul.app.domain.dto.ItemDTO;
import com.tikkeul.app.domain.dto.ItemFileSavingLevelDTO;
import com.tikkeul.app.domain.dto.OrderDTO;
import com.tikkeul.app.domain.type.CategoryType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;


@Mapper
public interface ItemMapper {
    //    김보령 작업공간
    //    열매샵 제품 목록 가져오기 : list.html
    public List<ItemDTO> selectAll(CategoryType categoryType);

    //    열매샵 제품 상세 보기 : readDetail.html
    public Optional<ItemDTO> select(Long id);

    //    후기 가져오기
    public Optional<OrderDTO> selectScoreAndCountOfReview(Long id);
//  홍윤가 적업공간
//  메인페이지

    public void insertItem(ItemDTO itemDTO);






//    홍윤기 작업공간
    //  메인페이지
    public List<ItemFileSavingLevelDTO> selectAllItem();

    public List<ItemFileSavingLevelDTO> selectAllOptionItem(Long savingLevelId);
}

