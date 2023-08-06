package com.tikkeul.app.service.item;

import com.tikkeul.app.dao.FileDAO;
import com.tikkeul.app.dao.ItemDAO;
import com.tikkeul.app.dao.ItemFileDAO;
import com.tikkeul.app.domain.dto.ItemDTO;
import com.tikkeul.app.domain.dto.ItemFileSavingLevelDTO;
import com.tikkeul.app.domain.dto.OrderDTO;
import com.tikkeul.app.domain.type.CategoryType;
import com.tikkeul.app.domain.type.FileType;
import com.tikkeul.app.domain.vo.ItemFileVO;
import com.tikkeul.app.domain.vo.ItemFileVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Qualifier("item") @Primary
public class ItemServiceImpl implements ItemService {
    private final ItemDAO itemDAO;
    private final ItemFileDAO itemFileDAO;
    private final FileDAO fileDAO;

    //    김보령 작업공간
    //    열매샵 제품 목록 가져오기 : list.html
    @Override
    public List<ItemDTO> getList(CategoryType categoryType) {
        return itemDAO.findAll(categoryType);
    }

    //    열매샵 제품 상세 보기 : readDetail.html
    @Override
    public Optional<ItemDTO> readDetail(Long id) {
        return itemDAO.readDetail(id);
    }

    //    제품 후기 후, 별점
    @Override
    public Optional<OrderDTO> readScoreAndCountOfReview(Long id) {
        return itemDAO.readScoreAndCountOfReview(id);
    }


//    홍윤기 작업공간

    @Override
    public List<ItemFileSavingLevelDTO> getitemList() {
        return itemDAO.findAllItem();
    }

    @Override
    public List<ItemFileSavingLevelDTO> getOptionItemList(Long savingLevelId) {
        return itemDAO.findAllOptionItem(savingLevelId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void writeItem(ItemDTO itemDTO) {
        itemDAO.saveItem(itemDTO);
        for (int i = 0; i < itemDTO.getFiles().size(); i++) {
            itemDTO.getFiles().get(i).setItemId(itemDTO.getId());
            itemDTO.getFiles().get(i).setFileType(i == 0 ? FileType.REPRESENTATIVE.name() : FileType.NON_REPRESENTATIVE.name());
            fileDAO.saveItem(itemDTO.getFiles().get(i));
        }
        itemDTO.getFiles().forEach(itemFileDTO ->
        {
            ItemFileVO itemFileVO = new ItemFileVO();
            itemFileVO.setId(itemFileDTO.getId());
            itemFileVO.setItemId(itemFileDTO.getItemId());
            itemFileDAO.saveItem(itemFileVO);
        });
    }

}