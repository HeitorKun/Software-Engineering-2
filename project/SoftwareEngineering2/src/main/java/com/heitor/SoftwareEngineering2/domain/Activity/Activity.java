package com.heitor.SoftwareEngineering2.domain.Activity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Activity {
    private Long id;
    private String title;
    private boolean state;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer userId;

}
