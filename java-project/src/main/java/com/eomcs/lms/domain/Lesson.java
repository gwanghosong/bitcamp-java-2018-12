package com.eomcs.lms.domain;

import java.sql.Date;

public class Lesson {
  public int no;// public 설정을 하지 않으면 내부패키지에서만 사용가능하기때문에 public 해!
  public String title;
  public String contents;
  public Date startDate;
  public Date endDate;
  public int totalHours;
  public int dayHours;
}
