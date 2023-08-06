package com.tikkeul.app.domain.vo;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class DoranCommentVO {
    private Long id;
    private String content;
    private String registerDate;
    private String updateDate;
    private Long doranboardId;
    private Long userId;
}
