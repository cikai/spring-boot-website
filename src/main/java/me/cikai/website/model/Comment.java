package me.cikai.website.model;

import com.google.gson.Gson;

public class Comment {
  private int id;
  private String reader;
  private String comment;
  private String commentAt;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getReader() {
    return reader;
  }

  public void setReader(String reader) {
    this.reader = reader;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getCommentAt() {
    return commentAt;
  }

  public void setCommentAt(String commentAt) {
    this.commentAt = commentAt;
  }

  @Override
  public String toString() {
    return new Gson().toJson(Comment.this);
  }
}
