package com.stock.dowjonesindex.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stock.dowjonesindex.model.Customer;
import com.stock.dowjonesindex.model.CustomerRepository;
import com.stock.dowjonesindex.model.StockEntity;
import com.stock.dowjonesindex.model.StockRepository;
import com.stock.dowjonesindex.utils.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;


@Controller
public class UploadController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CustomerRepository repository;

    @Autowired
    FileService fileService;
    @Autowired
    StockRepository stockRepository;

    @GetMapping("/")
    public String index() {
        return "index";

    }

    @GetMapping("/customer")
    public String displayCustomer(Model model) {
        log.info("Showing Mongo Customer records ......................................... ");
        List<Customer> result = new ArrayList<Customer>();
        for (Customer customer : repository.findByLastName("Dangui")) {
            result.add(customer);
        }
        model.addAttribute("customer", result);
        return "listCustomer";
    }

    @GetMapping("/uploadFile")
    public String uploadGet() {
        return "upload";
    }

    @PostMapping(value = "/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        try {
            fileService.uploadFile(file);

            redirectAttributes.addFlashAttribute("message",
                    "You have successfully uploaded " + file.getOriginalFilename() + "!"

            );
        } catch (final Exception e) {
            e.printStackTrace();

        }

        return "redirect:/";
    }

}
