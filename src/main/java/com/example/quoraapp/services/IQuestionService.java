package com.example.quoraapp.services;

import com.example.quoraapp.dto.QuestionRequestDTO;
import com.example.quoraapp.dto.QuestionResponseDTO;
import reactor.core.publisher.Mono;

public interface IQuestionService {

    public Mono<QuestionResponseDTO> createQuestion(QuestionRequestDTO questionRequestDTO);
}
