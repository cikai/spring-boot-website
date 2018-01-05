package me.cikai.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cikai
 */
@Controller
@RequestMapping(path = "/tool")
public class ToolController {

  @GetMapping(path = "")
  public String tool() {
    return "tool";
  }
}
