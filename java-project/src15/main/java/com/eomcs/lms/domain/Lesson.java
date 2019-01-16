package com.eomcs.lms.domain;

import java.sql.Date;

public class Lesson {
  private int no;
  private String title;
  private String contents;
  private Date startDate;
  private Date endDate;
  private int totalHours;
  private int dayHours;
  
  public void setNo(int no) {
    this.no = no;
  }
  public int getNo() {
    return this.no;
  }
  
  public void setTitle(String title) {
    this.title = title;
  }
  public String getTitle() {
    return this.title;
  }

  public void setContents(String contents) {
    this.contents = contents;
  }
  public String getContents() {
    return this.contents;
  }
  
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }
  public Date getStartDate() {
    return this.startDate;
  }
  
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }
  public Date getEndDate() {
    return this.endDate;
  }
  
  public void setTotalHours(int totalHours) {
    this.totalHours = totalHours;
  }
  public int getTotalHours() {
    return this.totalHours;
  }
  
  public void setDayHours(int dayHours) {
    this.dayHours = dayHours;
  }
  public int getdayHours() {
    return this.dayHours;
  }
}
