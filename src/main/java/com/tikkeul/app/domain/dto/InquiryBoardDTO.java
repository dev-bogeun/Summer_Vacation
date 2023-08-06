package com.tikkeul.app.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class InquiryBoardDTO {
    private Long id;
    private String inquireType;
    private String inquireTitle;
    private String inquireContent;
    private String inquireDate;
    private String inquireUpDate;
    private String status;
    private Long userId;
    private String name;
    private String identification;
}
