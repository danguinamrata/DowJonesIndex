package com.dangui.namrata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import com.dangui.namrata.model.*;
import com.dangui.namrata.utils.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;


@Controller
public class BasicController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CustomerRepository repository;

    @Autowired
    FileService fileService;

    @GetMapping("/")
    public String index() {
        return "index";

    }

    @GetMapping("/customer")
    public String displayCustomer(Model model){
        log.info("Showing Mongo Customer records .........................................");
        List<Customer> result = new ArrayList<Customer>();
        for(Customer customer: repository.findByLastName("Dangui1") ) {
            result.add(customer);
        }
        model.addAttribute("customer", result);
        return "listCustomer";
    }

    @GetMapping("/uploadFile")
    public String uploadGet() {
        log.info("I am here finally ..............");
        return "upload";
    }

    @PostMapping(value = "/uploadFile")
    public String uploadFile(@RequestParam("file")MultipartFile file, RedirectAttributes redirectAttributes){
        try {
            fileService.uploadFile(file);

            redirectAttributes.addFlashAttribute("message",
                    "You have successfully uploaded " + file.getOriginalFilename() + "!"
            );
        }
        catch (Exception e) {
            e.printStackTrace();

        }

        return "redirect:/";
    }
}
