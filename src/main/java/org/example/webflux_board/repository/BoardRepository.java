package org.example.webflux_board.repository;

import org.example.webflux_board.model.Board;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BoardRepository extends ReactiveCrudRepository<Board, Long> {

}