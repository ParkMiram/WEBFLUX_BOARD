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
                .commentAuthor(comment.getCommentAuthor())
                .commentContent(comment.getCommentContent())
                .commentCreatedAt(LocalDateTime.now())
                .commentUpdatedAt(LocalDateTime.now())
                .build();
        return commentRepository.save(saveComment);
    }

    @Override
    public Flux<Comment> findAll(Long board_id) {
        return commentRepository.findByBoardId(board_id);
    }

    @Override
    public Mono<Comment> update(Long boardId, Long id, Comment comment) {
        return commentRepository.findById(id)
                .flatMap(existingComment -> {
                    Comment updatedComment = Comment.builder()
                            .boardId(existingComment.getBoardId())
                            .commentId(existingComment.getCommentId())
                            .commentAuthor(existingComment.getCommentAuthor())
                            .commentContent(comment.getCommentContent() != null ? comment.getCommentContent() : existingComment.getCommentContent())
                            .commentCreatedAt(existingComment.getCommentCreatedAt())
                            .commentUpdatedAt(LocalDateTime.now())
                            .build();
                    return commentRepository.save(updatedComment);
                });
    }

    @Override
    public Mono<Void> delete(Long board_id, Long id) {
        return commentRepository.deleteByBoardIdAndCommentId(board_id, id);
    }
}
