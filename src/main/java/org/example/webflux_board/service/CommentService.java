package org.example.webflux_board.service;

import org.example.webflux_board.model.Comment;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CommentService {
    // 저장
    Mono<Comment> save(Long board_id, Comment comment);

    // 전체 조회
    Flux<Comment> findAll(Long board_id);

    // 수정
    Mono<Comment> update(Long board_id, Long id, Comment comment);

    // 삭제
    Mono<Void> delete(Long board_id, Long id);
}
