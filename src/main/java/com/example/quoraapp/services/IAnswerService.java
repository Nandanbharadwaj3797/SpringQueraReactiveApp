package com.example.quoraapp.services;

import com.example.quoraapp.dto.AnswerRequestDTO;
import com.example.quoraapp.dto.AnswerResponseDTO;
import reactor.core.publisher.Mono;

public interface IAnswerService {

    public Mono<AnswerResponseDTO> createAnswer(AnswerRequestDTO answerRequestDTO);

    public Mono<AnswerResponseDTO> getAnswerById(String id);

}
