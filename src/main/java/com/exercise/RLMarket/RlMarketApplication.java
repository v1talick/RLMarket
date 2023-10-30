package com.exercise.RLMarket;

import com.exercise.RLMarket.enteties.Item;
import com.exercise.RLMarket.repositories.ItemRepository;
import com.exercise.RLMarket.services.ItemService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class RlMarketApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(RlMarketApplication.class, args);

		ItemRepository itemRepository = context.getBean(ItemRepository.class);
		ItemService service = context.getBean(ItemService.class);
		System.out.println(service.getItem(44));
	}

}
