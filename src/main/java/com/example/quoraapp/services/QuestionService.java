package com.example.quoraapp.services;

import com.example.quoraapp.adapter.QuestionAdapter;
import com.example.quoraapp.dto.QuestionResponseDTO;
import com.example.quoraapp.repositories.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.example.quoraapp.dto.QuestionRequestDTO;
import com.example.quoraapp.models.Question;

import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class QuestionService implements IQuestionService {


    private final QuestionRepository questionRepository;


    @Override
    public Mono<QuestionResponseDTO>createQuestion(QuestionRequestDTO questionRequestDTO) {
        Question question = Question.builder()
                .title(questionRequestDTO.getTitle())
                .content(questionRequestDTO.getContent())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        return questionRepository.save(question)
                .map(QuestionAdapter::toQuestionResponseDTO)
                .doOnSuccess(response->System.out.println("Question Created Successfully:"+response))
                .doOnError(error->System.out.println("Error creating question:"+error));

    }

}
