package me.cikai.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cikai
 */
@Controller
@RequestMapping(path = "/admin")
public class AdminController {

  @GetMapping(path = "")
  public String index() {
    return "admin/index";
  }

  @GetMapping(path = "/blog")
  public String blog() {
    return "admin/blog";
  }
}
