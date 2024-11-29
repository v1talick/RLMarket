package com.exercise.RLMarket;

import com.exercise.RLMarket.DTOs.ItemDTO;
import com.exercise.RLMarket.DTOs.TradeItemDTO;
import com.exercise.RLMarket.enteties.*;
import com.exercise.RLMarket.enteties.enums.ItemType;
import com.exercise.RLMarket.mappers.TradeMapper;
import com.exercise.RLMarket.repositories.ItemRepository;
import com.exercise.RLMarket.repositories.TradeRepository;
import com.exercise.RLMarket.repositories.UserRepository;
import com.exercise.RLMarket.services.ItemService;
import com.exercise.RLMarket.utils.ItemUrlGenerator;
import com.exercise.RLMarket.utils.ObjectJsonMapper;
import com.exercise.scpecifications.ItemSpecs;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.domain.Specification;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class RlMarketApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(RlMarketApplication.class, args);
    }
}
