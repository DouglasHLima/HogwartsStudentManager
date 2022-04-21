package com.doughlima.hogwartsstudentmanager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class SortingHatResponse {
    @JsonProperty(value = "sorting-hat-choice")
    private UUID sortingHatChoice;
}
