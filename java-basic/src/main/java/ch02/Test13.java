// 콘솔로 출력하기 - 형식을 갖춰서 날짜 값 출력하기
package ch02;

public class Test13 {
  public static void main(String[] args) {
    //현재 날짜 및 시각 정보를 생성한다.
    // java.lang 패키지의 멤버를 사용할 때는 그냥 이름을 지정하면 된다.
    // 그 외 다른 패키지의 멤버를 사용할 때는 반드시 패키지 이름을 함께 지정해야 한다.
    java.util.Date today=new java.util.Date();
    
    // %t[날짜 및 시각 옵션]
    // %1$ 1$는 첫번째 값을 사용하겠다.
    // 날짜 및 시각 옵션
    // Y : 날짜 및 시각데이터에서 년도를 추출하여 4자리로 표현한다.
    // y : 날짜 및 시각데이터에서 년도를 추출하여 뒤의 2자리로 표현한다.
    System.out.printf("%1$tY\n, %1$ty\n", today);
    
    // B : 날짜 및 시각데이터에서 월을 추출하여 전제 이름으로 표현한다. January
    // b : 날짜 및 시각데이터에서 월을 추출하여 단축 이름으로 표현한다. Jan
    System.out.printf("%1$tB\n, %1$tb\n", today);
    // m : 날짜 및 시각데이터에서 월을 추출하여 2자리 숫자로 표현한다. 01
    System.out.printf("%1$tm\n", today);
    
    // d : 날짜 및 시각데이터에서 일을 추출하여 2자리 숫자로 표현한다. 01,22
    // e : 날짜 및 시각데이터에서 일을 추출하여 1자리 숫자로 표현한다. 1, 22
    System.out.printf("%1$td %1$te\n", today);
    
    // A : 날짜 및 시각데이터에서 요일을 추출하여 긴 이름으로 표현한다. Sunday
    // a : 날짜 및 시각데이터에서 요일을 추출하여 짧은 이름으로 표현한다. Sun
    System.out.printf("%1$tA %1$ta\n", today);
    
    // H : 날짜 및 시각데이터에서 시각을 추출하여 24시로 표현한다.
    // I : 날짜 및 시각데이터에서 시각을 추출하여 12시로 표현한다. 
    System.out.printf("%1$tH %1$tI\n", today);
    
    // M : 날짜 및 시각데이터에서 시각을 추출하여 12시로 표현한다. 
    System.out.printf("%1$tM\n", today);
    // S : 초
    System.out.printf("%1$tS\n", today);
    // L : 밀리초
    System.out.printf("%1$tL\n", today);
    // N : 나노초
    System.out.printf("%1$tN\n", today);
    
    System.out.printf("%1$tS %1$tL %1$tN\n", today);
    
    // p : 오전 오후
    // 소문자 t = am or pm, 대문자 T = AM or PM
    // 한글은 의미없다.
    System.out.printf("%1$tp\n", today);
    
    // 년-월-일-시:분:초 출력  2019-01-04 12:04:30
    System.out.printf("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\n", today);

    
    
    

  }
}

/*
\n line feed LF 0x0a
\r Carrage Return CR 0x0d
\f Form Feed 0x0c 다음페이지부터 출력
\t Tab 0x09
\b Backspace 0x08
\' sing quote 0x27
\" double quote 0x22
\\ Backslash 0x5c

 */














