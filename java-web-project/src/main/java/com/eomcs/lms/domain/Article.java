package com.eomcs.lms.domain;

import java.io.Serializable;
import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Article implements Cloneable, Serializable {
  
  private static final long serialVersionUID = 1L;
  
  int id;
  String subject;
  String content;
  
  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
  Date regDate;
  
  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
  Date updDate;
  
  @Override
  public String toString() {
    return "Article [id=" + id + ", subject=" + subject + ", content=" + content + ", regDate="
        + regDate + ", updDate=" + updDate + ", getClass()=" + getClass() + ", hashCode()="
        + hashCode() + ", toString()=" + super.toString() + "]";
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Date getRegDate() {
    return regDate;
  }

  public void setRegDate(Date regDate) {
    this.regDate = regDate;
  }

  public Date getUpdDate() {
    return updDate;
  }

  public void setUpdDate(Date updDate) {
    this.updDate = updDate;
  }
  
  
  
  
  
}
