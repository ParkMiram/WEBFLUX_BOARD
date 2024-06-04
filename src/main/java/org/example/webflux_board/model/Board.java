package org.example.webflux_board.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

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
    // created와 updqted는 db에서 default NOW() 줬음
    private LocalDateTime board_created_at;
    private LocalDateTime board_updated_at;

    public Board(String board_author,
                 String board_title,
                 String board_content) {
        this.board_author = board_author;
        this.board_title = board_title;
        this.board_content = board_content;
    }
}
