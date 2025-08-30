package com.example.quoraapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionRequestDTO {

    @NotBlank(message = "Title is required")
    @Size(min=10,max=255,message = "Title must be between 10 and 255 character")
    private String title;

    @NotBlank(message = "Content is required")
    @Size(min=10,max=1000,message = "Content must be between 10 and 1000 characters")
    private String content;

}
