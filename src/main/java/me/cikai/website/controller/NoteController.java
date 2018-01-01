package me.cikai.website.controller;

import me.cikai.website.model.AliyunEcsFee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author cikai
 */
@Controller
@RequestMapping(path = "/note")
public class NoteController {

  @Autowired
  JdbcTemplate jdbcTemplate;

  @GetMapping(path = "")
  public String note(Model model) {
    List aliyunEcsFeeList = (List) jdbcTemplate.query("SELECT `id`, `date`, `fee` FROM `aliyun-ecs-fee`",
        (RowMapper) (rs, rowNumber) -> {
          AliyunEcsFee aliyunEcsFee = new AliyunEcsFee();
          aliyunEcsFee.setId(rs.getInt("id"));
          aliyunEcsFee.setDate(rs.getString("date"));
          aliyunEcsFee.setFee(rs.getInt("fee"));
          return aliyunEcsFee;
        }
    );
    model.addAttribute("alifees", aliyunEcsFeeList);
    return "note";
  }
}
