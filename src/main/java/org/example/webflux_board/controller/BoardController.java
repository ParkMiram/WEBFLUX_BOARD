package org.example.webflux_board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.webflux_board.model.Board;
import org.example.webflux_board.service.BoardService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/boards")
public class BoardController {
    private final BoardService boardService;

    @GetMapping
    public Flux<Board> getBoards() {
        return boardService.findAll();
    }

    @PostMapping
    public Mono<Board> createBoard(@RequestBody Board board) {
        return boardService.save(board);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteBoard(@PathVariable Long id) {
        return boardService.deleteById(id);
    }
}
