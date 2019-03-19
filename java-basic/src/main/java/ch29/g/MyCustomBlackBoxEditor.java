package ch29.g;

import java.beans.PropertyEditorSupport;
import java.sql.Date;

public class MyCustomBlackBoxEditor extends PropertyEditorSupport {

  @Override
  public void setAsText(String text) throws IllegalArgumentException {

    // 바꾸고자 하는 객체를 만든다.
    BlackBox blackBox = new BlackBox();
    // XML 파일에 입력한 문자열 값을 분석하여 
    String[] blackBoxParams = text.split(",");
//    String[] blackBoxParams = text.split(",", 2); // 똑같다. 
    // split메서드의 파라미터로 문자 하나를 주면 그 문자로 나눠서 String 배열에 담아 리턴
    // split 메서드의 파라미터로 문자 하나 + 숫자를 주면 
    // 문자를 기준으로 숫자 개수만큼 나눠서 배열에 담아 리턴
    // 나눌 때 가장 첫번째로 나오는 해당 문자부터 기준점으로 해서 개수로 나눈다.
    // 만약 파라미터로 주는 숫자가 양수인 경우 양수개수만큼 나눈다.
    // 파라미터로 주는 숫자가 0(zero)인 경우 나눌 수 있을만큼 문자기준으로 나눈 후 맨 마지막 뒤에 공백으로
    // 표시되는 문자는 무시한다.
    // 파라미터로 주는 숫자가 음수인 경우 나눌 수 있을 만큼 문자기준으로 나눈 후 공백문자열까지 포함해서
    // 배열에 모두 넣는다.
    blackBox.setMaker(blackBoxParams[0]);
    blackBox.setModel(blackBoxParams[1]);

    this.setValue(blackBox);
  }
}
