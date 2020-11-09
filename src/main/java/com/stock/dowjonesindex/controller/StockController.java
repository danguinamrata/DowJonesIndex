package com.stock.dowjonesindex.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stock.dowjonesindex.model.StockEntity;
import com.stock.dowjonesindex.model.StockRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("stocks")
public class StockController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    StockRepository stockRepository;

    @GetMapping
    public String retrieve(@RequestParam(value = "stock", defaultValue = "") String stock) {
        log.info("Showing Mongo Stocks records ......................................... ");
        List<StockEntity> stockEntities = stockRepository.findByStock(stock);
        ObjectMapper Obj = new ObjectMapper();

        try {
            log.info("The count of records found is " + stockEntities.size());
            final String result = Obj.writeValueAsString(stockEntities);

            return result;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;

    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public String create(@RequestBody StockEntity stockEntity) {
        log.info("Showing Mongo Stocks records ......................................... ");
        final StockEntity saved = stockRepository.save(stockEntity);
        ObjectMapper Obj = new ObjectMapper();

        try {
            final String result = Obj.writeValueAsString(saved);
            return result;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;

    }

}

