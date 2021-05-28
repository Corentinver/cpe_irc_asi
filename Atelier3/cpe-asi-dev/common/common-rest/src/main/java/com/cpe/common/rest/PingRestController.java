package com.cpe.common.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ping", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PingRestController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String ping() {
        return "pong";
    }

}
