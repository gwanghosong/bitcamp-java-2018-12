package com.eomcs.lms.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class PhotoBoard implements Serializable{

  private static final long serialVersionUID = 1L;
  
  private int no;
  private int lessonNo;
  private String title;
  private Date createdDate;
  private int viewCount;
  
  private Lesson lesson;
  private List<PhotoFile> files;
  
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public int getLessonNo() {
    return lessonNo;
  }
  public void setLessonNo(int lessonNo) {
    this.lessonNo = lessonNo;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public Date getCreatedDate() {
    return createdDate;
  }
  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }
  public int getViewCount() {
    return viewCount;
  }
  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }
  public List<PhotoFile> getFiles() {
    return files;
  }
  public void setFiles(List<PhotoFile> files) {
    this.files = files;
  }
  public Lesson getLesson() {
    return lesson;
  }
  public void setLesson(Lesson lesson) {
    this.lesson = lesson;
  }
  
  
}
