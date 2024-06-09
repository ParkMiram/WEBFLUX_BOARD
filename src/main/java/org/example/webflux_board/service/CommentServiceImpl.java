package org.example.webflux_board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.webflux_board.model.Comment;
import org.example.webflux_board.repository.BoardRepository;
import org.example.webflux_board.repository.CommentRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    @Override
    public Mono<Comment> save(Long boardId, Comment comment) {
        Comment saveComment = Comment.builder()
                .boardId(boardId)
                .comment_author(comment.getComment_author())
                .comment_content(comment.getComment_content())
                .comment_created_at(LocalDateTime.now())
                .comment_updated_at(LocalDateTime.now())
                .build();
        return commentRepository.save(saveComment);
    }

    @Override
    public Flux<Comment> findAll(Long boardId) {
        return commentRepository.findByBoardId(boardId);
    }

    @Override
    public Mono<Comment> update(Long boardId, Long id, Comment comment) {
        return commentRepository.findById(id)
                .flatMap(existingComment -> {
                    Comment updatedComment = Comment.builder()
                            .boardId(existingComment.getBoardId())
                            .comment_id(existingComment.getComment_id())
                            .comment_author(existingComment.getComment_author())
                            .comment_content(comment.getComment_content() != null ? comment.getComment_content() : existingComment.getComment_content())
                            .comment_created_at(existingComment.getComment_created_at())
                            .comment_updated_at(LocalDateTime.now())
                            .build();
                    return commentRepository.save(updatedComment);
                });
    }

    @Override
    public Mono<Void> delete(Long boardId, Long id) {
        return commentRepository.deleteById(id);
    }
}
