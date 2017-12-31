package me.cikai.website.controller;

import me.cikai.website.model.Blog;
import me.cikai.website.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path = "/blog")
public class BlogController {

  @Autowired
  JdbcTemplate jdbcTemplate;

  @GetMapping(path = "")
  public String index(Model model) {
    List blogs = (List) jdbcTemplate.query("SELECT `id`, `title`, `postedAt` FROM `blog` ORDER BY  `postedAt` DESC;",
      (RowMapper) (rs, rowNumber) -> {
        Blog blog = new Blog();
        blog.setId(rs.getInt("id"));
        blog.setTitle(rs.getString("title"));
        blog.setPostedAt(rs.getString("postedAt"));
        return blog;
      }
    );
    model.addAttribute("blogs", blogs);
    return "blog/index";
  }

  @GetMapping(path = "/post")
  public String blog(String id, Model model) {
    Blog blog = new Blog();
    jdbcTemplate.query("SELECT `id`, `title`, `content`, `postedAt` FROM `blog` WHERE `id`=" + id + " ORDER BY `postedAt` DESC;",
      (RowMapper) (rs, rowNumber) -> {
        blog.setId(rs.getInt("id"));
        blog.setTitle(rs.getString("title"));
        blog.setContent(rs.getString("content"));
        blog.setPostedAt(rs.getString("postedAt"));
        return blog;
      }
    );

    List<Comment> comments = (List) jdbcTemplate.query("SELECT `id`, `reader`, `comment`, `commentAt` FROM `comment` WHERE `blogId`=" + id + " ORDER BY `commentAt` DESC;",
      (RowMapper) (rs, rowNumber) -> {
        Comment comment = new Comment();
        comment.setId(rs.getInt("id"));
        comment.setReader(rs.getString("reader"));
        comment.setComment(rs.getString("comment"));
        comment.setCommentAt(rs.getString("commentAt"));
        return comment;
      }
    );
    model.addAttribute("blog", blog);
    model.addAttribute("comments", comments);
    return "blog/blog";
  }

  @PostMapping(path = "/comment")
  public void comment(String blogId, String reader, String comment) {
    List<Object[]> values = Arrays.asList(blogId, reader, comment).stream()
      .map(el -> el.split(" "))
      .collect(Collectors.toList());
    jdbcTemplate.batchUpdate("INSERT INTO `comment` (`blogId`, `reader`, `comment`) VALUES (?,?,?)", values);
  }
}
