package com.tikkeul.app.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class FileVO {
    private Long id;
    private Long fileSize;
    private String originName;
    private String uuid;
    private String filePath;
    private String fileType;

}
