package org.example.webflux_board.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

import javax.annotation.processing.Generated;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("boards")
public class Board {
    @Id
    private Long board_id;
    private String board_author;
    private String board_title;
    private String board_content;
    @CreatedDate
    private LocalDateTime board_created_at;
    @LastModifiedDate
    private LocalDateTime board_updated_at;

    public Board(String board_author,
                 String board_title,
                 String board_content) {
        this.board_author = board_author;
        this.board_title = board_title;
        this.board_content = board_content;
    }
}
