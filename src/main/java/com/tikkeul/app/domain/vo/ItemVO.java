package com.tikkeul.app.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ItemVO {
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

}
