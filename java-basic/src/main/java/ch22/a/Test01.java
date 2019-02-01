// java.io.File 클래스 : 폴더 다루기
package ch22.a;

import java.io.File;

public class Test01 {

  public static void main(String[] args) throws Exception {
    // File 클래스
    // 디렉토리나 파일을 다룰 때 사용하는 클래스이다.
    // 디렉토리나 파일을 생성, 삭제, 변경할 수 있다.
    
    // 현재 디렉토리를 조회
    // '.' 으로 표현한다.
    // 이클립스 : 프로젝트 디렉토리를 가리킨다.
    // 콘솔 : 현재 명령어를 실행하는 위치를 가리킨다.
    // 자바에서 File의 의미 : 파일 및 디렉토리 경로명을 추상적으로 표현한 형태.
    File dir = new File("../../teacher/java-basic");
    System.out.println(dir.getName()); // 폴더명, 즉 현재 프로젝트 폴더
    System.out.println(dir.getPath()); // 경로
    System.out.println(dir.getAbsolutePath()); // 절대 경로, 계산할 경로까지 포함한 경로
    System.out.println(dir.getCanonicalPath()); // 계산된 경로, 계산이 끝나고 정리된 최종경로
    
    // 디렉토리가 존재하지 않는 경우 크기는 0이 나온다.
    System.out.println(dir.getTotalSpace()); // HDD 전체 용량
    System.out.println(dir.getFreeSpace()); // 빈 용량
    System.out.println(dir.getUsableSpace()); // 빈 용량 중에서 사용할 수 있는 용량
    
    // 디렉토리가 존재하지 않는 경우 리턴 값은 false이다.
    System.out.println(dir.isDirectory()); // 디렉토리냐?
    System.out.println(dir.isFile()); // 파일이냐?
    System.out.println(dir.isHidden()); // 숨김 파일이냐?
    System.out.println(dir.exists()); // 존재하냐?
    System.out.println(dir.canExecute()); // 실행할 수 있냐?
    
    System.out.println("--------------------------------");
    
    dir = new File(".");
    System.out.println(dir.getName()); // 폴더명, 즉 현재 프로젝트 폴더
    System.out.println(dir.getPath()); // 경로
    System.out.println(dir.getAbsolutePath()); // 절대 경로, 계산할 경로까지 포함한 경로
    System.out.println(dir.getCanonicalPath()); // 계산된 경로, 계산이 끝나고 정리된 최종경로
    
    // 디렉토리가 존재하지 않는 경우 크기는 0이 나온다.
    System.out.println(dir.getTotalSpace()); // HDD 전체 용량
    System.out.println(dir.getFreeSpace()); // 빈 용량
    System.out.println(dir.getUsableSpace()); // 빈 용량 중에서 사용할 수 있는 용량
    
    // 디렉토리가 존재하지 않는 경우 리턴 값은 false이다.
    System.out.println(dir.isDirectory()); // 디렉토리냐?
    System.out.println(dir.isFile()); // 파일이냐?
    System.out.println(dir.isHidden()); // 숨김 파일이냐?
    System.out.println(dir.exists()); // 존재하냐?
    System.out.println(dir.canExecute()); // 실행할 수 있냐?
    
    System.out.println("--------------------------------");
  }
}
