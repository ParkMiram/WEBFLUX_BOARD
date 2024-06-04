package org.example.webflux_board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.webflux_board.model.Board;
import org.example.webflux_board.repository.BoardRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;

    // 저장 (단일)
    @Override
    public Mono<Board> save(Board board) {
        return boardRepository.save(board);
    }
    // 저장 (복수)
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
    // 수정
    @Override
    public Mono<Board> update(Long id, Board board) {
        return boardRepository.findById(id)
                .flatMap(existingBoard -> {
                    // flatMap: 게시판이 존재하는 경우
                    // existingBoard: 업데이트할 필드들을 객체에 복사하거나 업데이할 필드를 직접 변경 가능
                    Board updatedBoard = Board.builder()
                            .board_id(existingBoard.getBoard_id())
                            .board_author(existingBoard.getBoard_author())
                            .board_title(board.getBoard_title() != null ? board.getBoard_title() : existingBoard.getBoard_title())
                            .board_content(board.getBoard_content() != null ? board.getBoard_content() : existingBoard.getBoard_content())
                            .board_created_at(existingBoard.getBoard_created_at())
                            .board_updated_at(LocalDateTime.now())
                            .build();
                    return boardRepository.save(updatedBoard);
                });
    }
    // 삭제 (단일)
    @Override
    public Mono<Void> delete(Long id) {
        return boardRepository.deleteById(id);
    }
    // 삭제 (복수)
    @Override
    public Mono<Void> deleteAll(Flux<Board> boards) {
        return boardRepository.deleteAll();
    }
}
