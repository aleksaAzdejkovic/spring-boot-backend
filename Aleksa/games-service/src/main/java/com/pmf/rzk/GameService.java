package com.pmf.rzk;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmf.rzk.model.GamesAzd;
import com.pmf.rzk.repository.GameRepo;

@Service
public class GameService {
    @Autowired
    private GameRepo gameRepository;

    public GamesAzd addGame(GamesAzd game) {
        return gameRepository.save(game);
    }

    public Optional<GamesAzd> updateGame(Integer gameId, GamesAzd g) {
        Optional<GamesAzd> game = gameRepository.findById(gameId);
        if (game.isPresent()) {
            GamesAzd existingGame = game.get();
            existingGame.setName(g.getName());
            existingGame.setHomeOdds(g.getHomeOdds());
            existingGame.setDrawOdds(g.getDrawOdds());
            existingGame.setAwayOdds(g.getAwayOdds());
            return Optional.of(gameRepository.save(existingGame));
        }
        return Optional.empty();
    }

    public List<GamesAzd> getAllGames() {
        return gameRepository.findAll();
    }
}	