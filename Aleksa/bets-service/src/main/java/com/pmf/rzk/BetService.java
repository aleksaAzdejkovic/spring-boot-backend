package com.pmf.rzk;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmf.rzk.model.BetsAzd;
import com.pmf.rzk.model.UsersAzd;
import com.pmf.rzk.repository.BetRepo;
import com.pmf.rzk.repository.UserRepo;

@Service
public class BetService {

    @Autowired
    private BetRepo betRepo;

    @Autowired
    private UserRepo userRepository;

    public BetsAzd createBet(BetsAzd bet, int userId) {
        Optional<UsersAzd> user = userRepository.findById(userId);
        if (user.isPresent()) {
            bet.setUsersAzd(user.get());
            return betRepo.save(bet);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public List<BetsAzd> getBetsByUserId(int userId) {
        Optional<UsersAzd> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return betRepo.findByUsersAzd(user.get());
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public Optional<BetsAzd> updateBetStatus(int betId, String status) {
        Optional<BetsAzd> bet = betRepo.findById(betId);
        if (bet.isPresent()) {
            BetsAzd existingBet = bet.get();
            existingBet.setStatus(status);
            return Optional.of(betRepo.save(existingBet));
        } else {
            return Optional.empty();
        }
    }
}