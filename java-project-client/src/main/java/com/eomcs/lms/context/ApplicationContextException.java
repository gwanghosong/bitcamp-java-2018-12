package com.eomcs.lms.context;

// 상속 받는 Exception 클래스는 Exception/RuntimeException
// 전자는 반드시 처리해야 하는 예외, 후자는 처리하지 않아도 되지만 나중에 문제가 생기면 멈추는 예외
// 예외 클래스를 상속 받는 것은 기능을 추가하기위해서 만든 것이 아니라
// 예외 클래스의 이름이 필요하기 때문이다.
// Exception 클래스 이름을 직관적으로 함으로써 예외가 발생했을때,
// 어디에서 예외가 발생했는지 한 눈에 알아보게하기 위함.
// 이렇게 이름을 바꿔주면 이름을 보자마자
// 디버깅을 어디서 해야하는지 알 수 있고 더 빠르게 유지보수할 수 있게된다.
public class ApplicationContextException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public ApplicationContextException() {
    super();
  }

  public ApplicationContextException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public ApplicationContextException(String message, Throwable cause) {
    super(message, cause);
  }

  public ApplicationContextException(String message) {
    super(message);
  }

  public ApplicationContextException(Throwable cause) {
    super(cause);
  }
}
