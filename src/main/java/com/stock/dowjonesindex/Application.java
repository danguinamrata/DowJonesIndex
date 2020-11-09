package com.stock.dowjonesindex;

import com.stock.dowjonesindex.model.CustomerRepository;
import com.stock.dowjonesindex.model.StockEntity;
import com.stock.dowjonesindex.model.StockRepository;
import com.stock.dowjonesindex.utils.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

import java.io.File;
import java.util.Arrays;
import java.util.List;


@SpringBootApplication
@EnableAsync
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private CustomerRepository repository;
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    FileService fileService;
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {


        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");



//            String fileName = "/home/shashank" + File.separator + "dow_jones_index.data";
//            List<StockEntity> stockEntities = fileService.readFile(fileName);
           // stockRepository.saveAll(stockEntities);

         //   List<StockEntity> aaStocks = stockRepository.findByStock("AA");
            //System.out.println("AA stocks count:"+ aaStocks.size());
          //  stockRepository.deleteAll();

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }

}
