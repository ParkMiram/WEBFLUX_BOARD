package org.example.webflux_board.service;

import org.example.webflux_board.model.Board;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BoardService {
    // 저장
    Mono<Board> save(Board board);
    Flux<Board> saveAll(Flux<Board> boards);

    // 조회
    Mono<Board> findById(Long id);
    Flux<Board> findAll();

    // 수정
    Mono<Board> update(Long id, Board board);

    // 삭제
    Mono<Void> delete(Long id);
    Mono<Void> deleteAll(Flux<Board> boards);
}
