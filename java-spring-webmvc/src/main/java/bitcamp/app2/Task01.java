package bitcamp.app2;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Task01 {
  
  // 10초마다
  @Scheduled(cron="*/10 * * * * *")
  public void m1() {
    System.out.println("m1()");
  }
  
  // 1분마다
  @Scheduled(cron="0 */1 * * * *")
  public void m2() {
    System.out.println("m2()");
  }
  
  // 1시간마다
  @Scheduled(cron="0 0 */1 * * *")
  public void m3() {
    System.out.println("m3()");
  }
}
