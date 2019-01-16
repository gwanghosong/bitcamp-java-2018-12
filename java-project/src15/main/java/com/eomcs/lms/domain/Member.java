package com.eomcs.lms.domain;

import java.sql.Date;

public class Member {
  private int no;
  private String name;
  private String email;
  private String password;
  private String photo;
  private String tel;
  private Date registeredDate;
  
  public void setNo(int no) {
    this.no = no;
  }
  public int getNo() {
    return this.no;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  public String getName() {
    return this.name;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }
  public String getEmail() {
    return this.email;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }
  public String getPassword() {
    return this.password;
  }
  
  public void setPhoto(String photo) {
    this.photo = photo;
  }
  public String getPhoto() {
    return this.photo;
  }
  public void setTel(String tel) {
    this.tel = tel;
  }
  public String getTel() {
    return this.tel;
  }
  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }
  public Date getRegisteredDate() {
    return this.registeredDate;
  }
}
