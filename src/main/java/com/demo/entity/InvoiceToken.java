package com.demo.entity;


import java.util.Date;

public class InvoiceToken {

  private long id;

  /**
   * token值
   */
  private String accessToken;

  /**
   * token的有效时间
   */
  private long expiresIn;

  /**
   * token的获取时间
   */
  private Date creatTime;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }


  public long getExpiresIn() {
    return expiresIn;
  }

  public void setExpiresIn(long expiresIn) {
    this.expiresIn = expiresIn;
  }


  public Date getCreatTime() {
    return creatTime;
  }

  public void setCreatTime(Date creatTime) {
    this.creatTime = creatTime;
  }

}
