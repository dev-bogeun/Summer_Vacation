package com.tikkeul.app.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class OrderVO {
    private Long id;
    private int orderAmount;
    private String orderDate;
    private String deliveryStartDate;
    private String deliveryCompleteDate;
    private String orderStatus;
    private String orderAddress;
    private String payStatus;
    private Long itemId;
    private Long userId;
}
