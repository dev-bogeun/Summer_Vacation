package com.tikkeul.app.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class UserVO {
    private Long id;
    private String identification;
    private String name;
    private String password;
    private String phoneNumber;
    private String address;
    private String status;
    private String roll;
    private String createdDate;
    private String profileImageName;
    private Long profileImageSize;
    private String profileImageUuid;
    private String profileImagePath;
    private String registeredType;
    private Long levelId;

}
