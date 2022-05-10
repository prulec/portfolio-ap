package com.argprograma.portfolio.service;

import com.argprograma.portfolio.model.Portfolio;
import com.argprograma.portfolio.model.Social;
import com.argprograma.portfolio.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PortfolioService implements IPortfolioService {
    
    @Autowired
    private PortfolioRepository portfolioRepo;
    @Autowired
    private IUserService userService;

    @Override
    public Portfolio createPortfolio(Portfolio portfolio) {
        Portfolio savedPortfolio = portfolioRepo.save(portfolio);
        savedPortfolio.getUser().getPortfolioSet().add(savedPortfolio);
        userService.updateUser(savedPortfolio.getUser());
        return savedPortfolio;
    }

    @Override
    public Portfolio findPortfolioById(Long id) {
        return portfolioRepo.findById(id).orElse(null);
    }

    @Override
    public Portfolio findPortfolioByName(String name) {
        return portfolioRepo.findByName(name);
    }

    @Override
    public Portfolio updatePortfolio(Portfolio portfolio) {
        return portfolioRepo.save(portfolio);
    }

    @Override
    public void deletePortfolio(Portfolio portfolio) {
        portfolio.getUser().getPortfolioSet().remove(portfolio);
        userService.updateUser(portfolio.getUser());
    }

    @Override
    public Portfolio disconnectSocial(Social social) {
        Portfolio portfolio = social.getPortfolio();
        portfolio.getSocialSet().remove(social);
        return this.updatePortfolio(portfolio);
    }
    
}
