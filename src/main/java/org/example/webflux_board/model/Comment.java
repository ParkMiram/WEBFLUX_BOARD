package org.example.webflux_board.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("comments")
public class Comment {
    @Id
    private Long comment_id;
    private String comment_author;
    private String comment_content;
    @CreatedDate
    private LocalDateTime comment_created_at;
    @LastModifiedDate
    private LocalDateTime comment_updated_at;
    // 외래키
    @Column("board_id")
    private Long boardId;
}
