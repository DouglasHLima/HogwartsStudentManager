package com.doughlima.hogwartsstudentmanager.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class StudentResponse {
    private UUID id;
    private String name;
    private String grade;
    private HouseInfoResponse house;
}
