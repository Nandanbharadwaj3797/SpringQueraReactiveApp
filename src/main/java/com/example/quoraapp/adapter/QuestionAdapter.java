package com.example.quoraapp.adapter;

import com.example.quoraapp.dto.QuestionResponseDTO;
import com.example.quoraapp.models.Question;

import java.time.LocalDateTime;

public class QuestionAdapter {

    public static QuestionResponseDTO toQuestionResponseDTO(Question question) {
        return QuestionResponseDTO.builder()
                .id(question.getId())
                .title(question.getTitle())
                .content(question.getContent())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
