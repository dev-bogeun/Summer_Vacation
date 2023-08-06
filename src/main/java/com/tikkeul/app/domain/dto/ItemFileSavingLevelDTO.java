package com.tikkeul.app.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ItemFileSavingLevelDTO {
    private Long itemId;
    private String itemName;
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
    private Long fileId;
    private Long fileSize;
    private String fileOriginName;
    private String fileUuid;
    private String filePath;
    private String fileType;
}
