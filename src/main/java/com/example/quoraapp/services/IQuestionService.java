package com.example.quoraapp.services;

import com.example.quoraapp.dto.QuestionRequestDTO;
import com.example.quoraapp.dto.QuestionResponseDTO;
import com.example.quoraapp.models.QuestionElasticDocument;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface IQuestionService {

    public Mono<QuestionResponseDTO> createQuestion(QuestionRequestDTO questionRequestDTO);

    public Flux<QuestionResponseDTO> searchQuestions(String searchTerm,int offset,int page);

    public Flux<QuestionResponseDTO> getAllQuestions(String cursor, int size);

    public Mono<QuestionResponseDTO> getQuestionById(String id);

    public Mono<Void> deleteQuestionById(String id);

    public List<QuestionElasticDocument>searchQuestionsByElasticSearch(String query);
}
