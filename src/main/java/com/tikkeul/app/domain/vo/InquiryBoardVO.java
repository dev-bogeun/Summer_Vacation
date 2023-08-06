package com.tikkeul.app.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@Data
@NoArgsConstructor
public class InquiryBoardVO {
    private Long id;
    private String inquireType;
    private String inquireTitle;
    private String inquireContent;
    private String inquireDate;
    private String inquireUpdate;
    private String status;
    private Long userId;


}

