package me.cikai.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cikai
 */
@Controller
@RequestMapping(path = "")
public class AppController {

  @GetMapping(path = "")
  public String index() {
    return "index";
  }
}
