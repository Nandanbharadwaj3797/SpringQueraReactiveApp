package com.example.quoraapp.models;

import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "question")
public class Question {
    @Id
    private String id;

    @NotBlank(message = "Title is required")
    @Size(min=10,max = 255, message="Title must be between 10 to 255 characters")
    private String title;

    @NotBlank(message = "Content is required")
    @Size(min=10,max=1000,message="Content must be between 10 to 1000 characters")
    private String content;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
