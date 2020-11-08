package com.stock.dowjonesindex.model;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StockRepository extends MongoRepository<StockEntity, String> {
    /**
     * @param stock
     * @return
     */
    public List<StockEntity> findByStock(final String stock);


}
