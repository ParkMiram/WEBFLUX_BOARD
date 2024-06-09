package org.example.webflux_board.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
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
    @CreatedDate
    private LocalDateTime board_created_at;
    @LastModifiedDate
    private LocalDateTime board_updated_at;
}
