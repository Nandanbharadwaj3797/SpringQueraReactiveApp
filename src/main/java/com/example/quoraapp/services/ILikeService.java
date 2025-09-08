package com.example.quoraapp.services;

import com.example.quoraapp.dto.LikeRequestDTO;
import reactor.core.publisher.Mono;

public interface ILikeService {

    Mono<LikeRequestDTO> createLike(LikeRequestDTO likeRequestDTO);

    Mono<LikeRequestDTO> countLikesByTargetIdAndTargetType(String targetId, String targetType);

    Mono<LikeRequestDTO> countDisLikesByTargetIdAndTargetType(String targetId, String targetType);

    Mono<LikeRequestDTO> toggleLike(String targetId, String targetType, Boolean isLike);



}
