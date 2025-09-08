package com.example.quoraapp.controllers;

import com.example.quoraapp.dto.QuestionRequestDTO;
import com.example.quoraapp.dto.QuestionResponseDTO;
import com.example.quoraapp.services.IQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    private final IQuestionService questionService;

    @PostMapping
    public Mono<QuestionResponseDTO> createQuestion(@RequestBody QuestionRequestDTO questionRequestDTO) {
        return questionService.createQuestion(questionRequestDTO)
                .doOnSuccess(response->System.out.println("Question Created Successfully:"+response))
                .doOnError(error->System.out.println("Error creating question:"+error));

    }

    @GetMapping("/{id}")
    public Mono<QuestionResponseDTO> getQuestionById(@PathVariable String id) {
        return questionService.getQuestionById(id)
                .doOnSuccess(response -> System.out.println("Question retrieved successfully: " + response))
                .doOnError(error -> System.out.println("Error retrieving question: " + error));

    }

    @GetMapping
    public Flux<QuestionResponseDTO> getAllQuestions(
            @RequestParam(required=false)String cursor,
            @RequestParam(defaultValue = "10") int size
    ) {
        return  questionService.getAllQuestions(cursor, size)
                .doOnError(error -> System.out.println("Error searching questions: " + error))
                .doOnComplete(() -> System.out.println("Questions searched successfully"));
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteQuestionById(@PathVariable String id) {
        return questionService.deleteQuestionById(id)
                .doOnSuccess(aVoid -> System.out.println("Question deleted successfully with id: " + id))
                .doOnError(error -> System.out.println("Error deleting question: " + error));
    }

    @GetMapping("/search")
    public Flux<QuestionResponseDTO> searchQuestions(
            @RequestParam String query,
        @RequestParam(defaultValue="0")int page,
        @RequestParam(defaultValue = "10") int size
    ) {
        return questionService.searchQuestions(query, page, size)
                .doOnError(error -> System.out.println("Error searching questions: " + error))
                .doOnComplete(() -> System.out.println("Questions searched successfully"));
    }

    @GetMapping("/tag/{tag}")
    public Flux<QuestionResponseDTO> getQuestionsByTag(@PathVariable String tag) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
