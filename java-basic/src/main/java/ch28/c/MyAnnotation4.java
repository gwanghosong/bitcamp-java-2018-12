package ch28.c;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

// 애노테이션 사용 범위
@Target(ElementType.LOCAL_VARIABLE) // 로컬 변수에만 붙일 수 있다.
public @interface MyAnnotation4 {

}