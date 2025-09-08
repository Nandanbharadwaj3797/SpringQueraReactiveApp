package com.example.quoraapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class LikeRequestDTO {

    @NotBlank(message="Target Id is required")
    private String targetId;

    @NotBlank(message="Target Type  is required")
    private String  targetType;

    @NotNull(message="Is Like is required")
    private Boolean isLike;

}
