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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pmf.rzk.model.BetsAzd;

@RestController
@RequestMapping("/bets")
public class BetsController {

    @Autowired
    private BetService betService;

    @PostMapping("/userBet/{userId}")
    public ResponseEntity<BetsAzd> createBet(@PathVariable int userId, @RequestBody BetsAzd bet) {
        BetsAzd createdBet = betService.createBet(bet, userId);
        return ResponseEntity.ok(createdBet);
    }

    @GetMapping("/userAll/{userId}")
    public ResponseEntity<List<BetsAzd>> getBetsByUserId(@PathVariable int userId) {
        List<BetsAzd> bets = betService.getBetsByUserId(userId);
        return ResponseEntity.ok(bets);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BetsAzd> updateBetStatus(@PathVariable int id, @RequestParam String status) {
        Optional<BetsAzd> updatedBet = betService.updateBetStatus(id, status);
        if (updatedBet.isPresent()) {
            return ResponseEntity.ok(updatedBet.get());
        }
        return ResponseEntity.notFound().build();
    }
}