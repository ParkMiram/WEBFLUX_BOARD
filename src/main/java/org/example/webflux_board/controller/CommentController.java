package org.example.webflux_board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.webflux_board.model.Comment;
import org.example.webflux_board.service.CommentService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/boards/{bid}/comments")
public class CommentController {
    private final CommentService commentService;

    @GetMapping
    public Flux<Comment> getComments(@PathVariable("bid") Long boardId){
        return commentService.findAll(boardId);
    }

    @PostMapping
    public Mono<Comment> createComment(@PathVariable("bid") Long boardId,
                                       @RequestBody Comment comment) {
        return commentService.save(boardId, comment);
    }

    @PutMapping("/{id}")
    public Mono<Comment> updateComment(@PathVariable("bid") Long boardId,
                                       @PathVariable("id") Long commentId,
                                       @RequestBody Comment comment) {
        return commentService.update(boardId, commentId, comment);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteComment(@PathVariable("bid") Long boardId,
                                    @PathVariable("id") Long commentId) {
        return commentService.delete(boardId, commentId);
    }
}
