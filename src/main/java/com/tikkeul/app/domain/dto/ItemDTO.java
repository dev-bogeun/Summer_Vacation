package com.tikkeul.app.domain.dto;

import com.tikkeul.app.domain.vo.FileVO;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data

public class ItemDTO {
    private Long id;
    private String name;
    private int price;
    private int currentStock;
    private int originStock;
    private String status;
    private String brand;
    private String category;
    private String registerDate;
    private String updateDate;
    private Long savingLevelId;
    private String savingLevelName;
    private Long countOfUser;
    private Long countOfLikes;
    private List<ItemFileDTO> files = new ArrayList<>();
    private List<Long> fileIdsForDelete = new ArrayList<>();
}
