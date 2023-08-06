package com.tikkeul.app.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ReviewVO {
    private Long id;
    private String content;
    private int score;
    private String registerDate;
    private Long orderId;
}
