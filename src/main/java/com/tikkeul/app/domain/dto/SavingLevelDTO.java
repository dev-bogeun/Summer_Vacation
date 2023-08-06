package com.tikkeul.app.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class SavingLevelDTO {
    private Long id;
    private String name;
    private int goalMoney;
    private int dailyMoney;
    private List<SavingLevelFileDTO> files = new ArrayList<>();
    private List<Long> fileIdsForDelete = new ArrayList<>();

}
