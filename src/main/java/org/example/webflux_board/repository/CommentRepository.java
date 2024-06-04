package org.example.webflux_board.repository;

import org.example.webflux_board.model.Comment;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CommentRepository extends ReactiveCrudRepository<Comment, Long> {
//    Flux<Comment> findByBoard_id(Long baord_id);  // board_id로 댓글을 찾는 메소드
//
//    Mono<Void> deleteByBoard_idAndComment_id(Long baord_id, Long id);
}