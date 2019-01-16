package com.eomcs.lms.domain;

import java.sql.Date;

public class Board {
  private int no;
  private String contents;
  private Date createdDate;
  private int viewCount;
  
  public void setNo(int no) {
    this.no = no;
  }
  public int getNo() {
    return this.no;
  }
  
  public void setContents(String contents) {
    this.contents = contents;
  }
  public String getContents() {
    return this.contents;
  }
  
  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }
  public Date getCreatedDate() {
    return this.createdDate;
  }
  
  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }
  public int getViewCount() {
    return this.viewCount;
  }
}
