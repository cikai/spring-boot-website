package me.cikai.website.model;

import com.google.gson.Gson;

/**
 * @author cikai
 */
public class AliyunEcsFee {
  private int id;
  private String date;
  private int fee;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public int getFee() {
    return fee;
  }

  public void setFee(int fee) {
    this.fee = fee;
  }

  @Override
  public String toString() {
    return new Gson().toJson(AliyunEcsFee.this);
  }

}
