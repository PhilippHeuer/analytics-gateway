package com.github.philippheuer.restapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/greeting")
public class GreetingController {

    /**
     * Logger
     */
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * Greetings
     *
     * @param name
     * @return
     */
    @RequestMapping("/print")
    public Mono<Map> greeting(@RequestParam(value="name", defaultValue="World") String name) {
        Map<String, String> result = new HashMap<>();
        result.put("id", "1");
        result.put("text", String.format("Hello, %s!", name));

        return Mono.just(result);
    }
}
