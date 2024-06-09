package org.example.webflux_board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.webflux_board.model.Board;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class BoardResponse {
    private Long board_id;
    private String board_author;
    private String board_title;
    private LocalDateTime board_created_at;
    private LocalDateTime board_updated_at;

    public static BoardResponse from (Board board) {
        return BoardResponse.builder()
                .board_id(board.getBoard_id())
                .board_author(board.getBoard_author())
                .board_title(board.getBoard_title())
                .board_created_at(board.getBoard_created_at())
                .board_updated_at(board.getBoard_updated_at())
                .build();
    }
}
