package com.tikkeul.app.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class DoranCommentDTO {
    private Long id;
    private String content;
    private String registerDate;
    private String updateDate;
    private String doranboardId;
    private Long userId;
    private String name;

}
