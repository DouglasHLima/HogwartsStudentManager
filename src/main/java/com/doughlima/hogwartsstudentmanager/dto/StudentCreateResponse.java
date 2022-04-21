package com.doughlima.hogwartsstudentmanager.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class StudentCreateResponse {
    private UUID id;
    private String name;
    private String grade;
    private UUID house;
}
