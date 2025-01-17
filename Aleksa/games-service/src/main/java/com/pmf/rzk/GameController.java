package com.pmf.rzk;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pmf.rzk.model.GamesAzd;

@RestController
@RequestMapping("/games")
public class GameController {
    @Autowired
    private GameService gameService;

    @PostMapping("/add")
    public ResponseEntity<GamesAzd> addGame(@RequestBody GamesAzd game) {
        return ResponseEntity.ok(gameService.addGame(game));
    }

    @PutMapping("/{gameId}")
    public ResponseEntity<GamesAzd> updateGame(@PathVariable Integer gameId, @RequestBody GamesAzd gameDetails) {
        Optional<GamesAzd> updatedGame = gameService.updateGame(gameId, gameDetails);
        if (updatedGame.isPresent()) {
            return ResponseEntity.ok(updatedGame.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<GamesAzd>> getAllGames() {
        return ResponseEntity.ok(gameService.getAllGames());
    }
}