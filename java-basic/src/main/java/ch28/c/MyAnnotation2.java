package ch28.c;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

// 애노테이션 사용 범위
@Target(ElementType.FIELD) // 필드에만 붙일 수 있다.
public @interface MyAnnotation2 {

}
