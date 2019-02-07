package com.eomcs.lms.context;

import java.util.Map;

public interface ApplicationListener {
  // 추상 메서드니까 몸체가 없다.
  void startApplication(Map<String, Object> context);
  void endApplication(Map<String, Object> context);
}
