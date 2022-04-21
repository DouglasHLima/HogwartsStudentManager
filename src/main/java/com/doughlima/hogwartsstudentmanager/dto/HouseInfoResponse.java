package com.doughlima.hogwartsstudentmanager.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class HouseInfoResponse {
    private String name;
    private String animal;
    private String founder;
    private List<Value> values;

    @Getter @Setter
    private static class Value{
        private String name;
    }
}
