package org.example.webflux_board.controller;

import lombok.RequiredArgsConstructor;
import org.example.webflux_board.model.Board;
import org.example.webflux_board.service.BoardService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.spring6.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring6.context.webflux.ReactiveDataDriverContextVariable;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
@RequiredArgsConstructor
public class BoardViewController {
    private final BoardService boardService;

    @GetMapping()
    public String index(Model model) {
        Flux<Board> users = boardService.findAll().delayElements(Duration.ofSeconds(1));
        IReactiveDataDriverContextVariable userDataDrivenMode = new ReactiveDataDriverContextVariable(users, 1);

        model.addAttribute("boards", userDataDrivenMode);

        return "index";
    }
}
