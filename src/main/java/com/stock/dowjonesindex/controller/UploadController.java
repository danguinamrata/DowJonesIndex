package com.stock.dowjonesindex.controller;

import com.stock.dowjonesindex.model.StockRepository;
import com.stock.dowjonesindex.utils.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class UploadController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    FileService fileService;
    @Autowired
    StockRepository stockRepository;

    @GetMapping("/")
    public String index() {
        return "index";

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
