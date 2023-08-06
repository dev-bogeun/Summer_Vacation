package com.tikkeul.app.domain.type;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CategoryType {
    private String category;
    private String level;
    private String sort;
    private Long count;

}
