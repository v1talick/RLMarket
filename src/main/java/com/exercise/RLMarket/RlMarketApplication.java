package com.exercise.RLMarket;

import com.exercise.RLMarket.DTOs.TradeItemDTO;
import com.exercise.RLMarket.enteties.*;
import com.exercise.RLMarket.enteties.enums.ItemType;
import com.exercise.RLMarket.mappers.TradeMapper;
import com.exercise.RLMarket.repositories.ItemRepository;
import com.exercise.RLMarket.repositories.TradeRepository;
import com.exercise.RLMarket.repositories.UserRepository;
import com.exercise.RLMarket.services.ItemService;
import com.exercise.RLMarket.utils.ObjectJsonMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class RlMarketApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(RlMarketApplication.class, args);

    }
}
