package com.onesight.searchdemo.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class HomeController {

    @GetMapping
    @CrossOrigin(origins = {"*"})
    public Map<String, String> index() {
        Map<String, String> versionDetails = new HashMap<>();
        versionDetails.put("app-version", "2.0.0");
        return versionDetails;
    }
}
