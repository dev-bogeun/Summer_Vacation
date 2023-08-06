package com.tikkeul.app.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class OrderDTO {
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
    private Long reviewId;
    private String content;
    private int score;
    private String registerDate;
    private Long orderId;
    private Long countOfReviews;
    private Long avgScore;
    private String userIdentification;
    private String userName;
    private String itemName;


}
