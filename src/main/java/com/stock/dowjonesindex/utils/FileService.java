package com.stock.dowjonesindex.utils;

import com.stock.dowjonesindex.model.StockEntity;
import com.stock.dowjonesindex.model.StockRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Stream;

import static java.lang.System.out;
import static java.nio.file.Files.lines;
import static java.nio.file.Paths.get;
import static java.util.stream.Collectors.toList;

@Service
public class FileService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Value("${app.upload.dir:${user.home}}")
    public String uploadDir;
    @Autowired
    private StockRepository stockRepository;

    public void uploadFile(MultipartFile file) {
        Path copyLocation = null;
        try {
            final String uuid = UUID.randomUUID().toString().replace("-", "_");
            copyLocation = get(uploadDir + File.separator + StringUtils.cleanPath(uuid + file.getOriginalFilename()));
            Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
            List<StockEntity> stockEntities = readFile(copyLocation);
            stockRepository.saveAll(stockEntities);

        } catch (Exception e) {
            e.printStackTrace();
            throw new FileStorageException("Error uploading File" + file.getOriginalFilename()
                    + ". Please try again!");
        } finally {
            if (copyLocation != null) {
                try {
                    if (Files.deleteIfExists(copyLocation)) {
                       log.debug("File" + copyLocation.toString() +" deleted successfully");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<StockEntity> readFile(final Path filePath) {
        List<String> list = new ArrayList<>();
        try (final Stream<String> stream = lines(filePath)) {
            list = stream
                    .filter(line -> !line.startsWith("quarter")).collect(toList());

        } catch (final IOException e) {
            e.printStackTrace();
        }
        list.forEach(System.out::println);
        List<StockEntity> stockEntities = list.stream().map(StockEntityMapper::mapToStockEntity).collect(toList());
        stockEntities.forEach(out::println);
        return stockEntities;
    }

    public List<StockEntity> readFile(final String fileName) {
        List<String> list = new ArrayList<>();
        try (final Stream<String> stream = lines(get(fileName))) {
            list = stream
                    .filter(line -> !line.startsWith("quarter")).collect(toList());

        } catch (final IOException e) {
            e.printStackTrace();
        }
        list.forEach(System.out::println);
        List<StockEntity> stockEntities = list.stream().map(StockEntityMapper::mapToStockEntity).collect(toList());
        stockEntities.forEach(out::println);
        return stockEntities;
    }



}
