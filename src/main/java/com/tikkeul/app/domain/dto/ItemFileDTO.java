package com.tikkeul.app.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ItemFileDTO {
    private Long id;
    private Long itemId;
    private Long fileSize;
    private String originName;
    private String uuid;
    private String filePath;
    private String fileType;
}