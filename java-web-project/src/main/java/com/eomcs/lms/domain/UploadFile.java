package com.eomcs.lms.domain;

import java.io.Serializable;
import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

public class UploadFile implements Cloneable, Serializable {

  private static final long serialVersionUID = 1L;
  
  int id;
  int articleId;
  String fileName;
  String saveFileName;
  String filePath;
  String ContentType;
  long size;
  
  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
  Date regDate;

  @Override
  public String toString() {
    return "UploadFile [id=" + id + ", articleId=" + articleId + ", fileName=" + fileName
        + ", saveFileName=" + saveFileName + ", filePath=" + filePath + ", ContentType="
        + ContentType + ", size=" + size + ", regDate=" + regDate + "]";
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getArticleId() {
    return articleId;
  }

  public void setArticleId(int articleId) {
    this.articleId = articleId;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public String getSaveFileName() {
    return saveFileName;
  }

  public void setSaveFileName(String saveFileName) {
    this.saveFileName = saveFileName;
  }

  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  public String getContentType() {
    return ContentType;
  }

  public void setContentType(String contentType) {
    ContentType = contentType;
  }

  public long getSize() {
    return size;
  }

  public void setSize(long size) {
    this.size = size;
  }

  public Date getRegDate() {
    return regDate;
  }

  public void setRegDate(Date regDate) {
    this.regDate = regDate;
  }
  
}
