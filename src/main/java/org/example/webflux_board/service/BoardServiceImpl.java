package org.example.webflux_board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.webflux_board.model.Board;
import org.example.webflux_board.repository.BoardRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;

    // 저장 & 수정 (단일)
    @Override
    public Mono<Board> save(Board board) {
        return boardRepository.save(board);
    }
    // 저장 & 수정 (복수)
    @Override
    public Flux<Board> saveAll(Flux<Board> boards) {
        return boardRepository.saveAll(boards);
    }
    // 조회 (단일)
    @Override
    public Mono<Board> findById(Long id) {
        return boardRepository.findById(id);
    }
    // 조회 (복수)
    @Override
    public Flux<Board> findAll() {
        return boardRepository.findAll();
    }
    // 삭제 (단일)
    @Override
    public Mono<Void> deleteById(Long id) {
        return boardRepository.deleteById(id);
    }
    // 삭제 (복수)
    @Override
    public Mono<Void> deleteAll(Flux<Board> boards) {
        return boardRepository.deleteAll();
    }
}
