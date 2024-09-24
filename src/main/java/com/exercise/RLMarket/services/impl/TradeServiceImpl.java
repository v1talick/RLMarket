package com.exercise.RLMarket.services.impl;

import com.exercise.RLMarket.DTOs.TradeDTO;
import com.exercise.RLMarket.DTOs.creationDTOs.TradeCreationDTO;
import com.exercise.RLMarket.mappers.TradeMapper;
import com.exercise.RLMarket.repositories.TradeRepository;
import com.exercise.RLMarket.services.TradeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeServiceImpl implements TradeService {
    TradeRepository tradeRepository;
    @Override
    public void saveTrade(TradeCreationDTO trade) {
        tradeRepository.save(TradeMapper.tradeCreationDTOtoTrade(trade));
    }

    @Override
    public void deleteTrade(int tradeId) {
        tradeRepository.deleteById(tradeId);
    }

    @Override
    public List<TradeDTO> getAllTrades() {
        return tradeRepository.findAll().stream().map(TradeMapper::tradeToTradeDTO).toList();
    }

    @Override
    public List<TradeDTO> getTradesByUser(int userId) {
        return tradeRepository.findTradesByUserId(userId).stream().map(TradeMapper::tradeToTradeDTO).toList();
    }

    @Override
    public TradeDTO getTrade(int id) {
        return TradeMapper.tradeToTradeDTO(tradeRepository.findById(id).get());
    }
}
