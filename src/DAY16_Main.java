import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

public class DAY16_Main {
    public static void main(String[] args) {
        /**
         * - JVM과 바이트코드
         *   >> Java 언어? JVM을 공부한 것 > JVM에서 동작할 수 있는 코드가 JAVA
         *   >> JVM에서 동작할 수 있는 코드는 실제로 바이트 코드(Byte code)
         *   >> 바이트 코드를 제작하기 위한 언어가 Java 언어
         *   >> 그렇다면 바이트 코드만 만들어낸다면 어느 언어든 관계가 없겠네요? 정답입니다.
         *   >> 바이트 코드를 만들어내는 언어? Java, Kotlin, ...
         *   >> JVM 에서 동작하는 코드가 바이트 코드, 그렇다면, Java와 Kotlin은 서로 호출 가능한가? 네, 맞습니다.
         *   >> Kotlin도 바이트 코드로 컴파일된다.
         *   >> Java, Kotlin 언어로 할 수 있는 것 ? 스프링, 안드로이드, ...
         *
         * - 주해(Annotation) : 코드 안에서 읽힐 수 있는 주석(Comment)
         *   >> 컴파일러에게 읽힘 > 특정한 코드를 실행
         *   >> 코드 실행? 리플렉션(Reflection) 기능을 통해 애노테이션이 있으면 어떤 코드를 실행
         *   >> 애노테이션 사용하는 측 : 내가 아닌 다른 프로그래머
         *      그 프로그래머에 의해서 결정된 값을 토대로 특정한 코드 실행을 자동화
         *   >> e.g. 스프링에서 DI(Dependency Injection)에서 @Autowired 사용
         *           Gson 라이브러리에서 @SerializedName 사용
         *           Kotlin에서 @Parcelize 사용
         *
         * - 애노테이션 대상 지정(OPTION 입력사항, @Target)
         *   > 클래스 : ElementType.TYPE
         *   > 필드 : ElementType.FIELD
         *   > 메소드 : ElementType.METHOD
         *   > 파라미터 : ElementType.PARAMETER
         *   > 블럭 내 특정 코드 : 아무것도 지정하지 않으면 됨
         *
         * - `@interface` 키워드를 사용해서 선언
         * - 애노테이션의 값 정의 타임 : 컴파일 타임(런타임 XXXXXX)
         *   >> 컴파일타임? 실행파일로 만들어지는 시기 == 우리가 코드를 입력하는 타임 == 컴파일타임 상수(이미 코드 입력시 값 결정)
         *   >> 런타임? 실행파일이 동작하는 시기 == 사용자가 우리 프로그램을 사용하는 타임 == 변수 또는 런타임 상수(코드 입력이후 값 결정)
         */


        // 애노테이션 정보 가져오는 방법 #1
        // 클래스 가져오기 : 코드 영역(텍스트 영역)에 선언되어있는 우리가 선언한 클래스 또는 라이브러리에 있는 클래스
        Class<Annotated> annotatedClass = Annotated.class;
        CustomAnnotation annotation1 = annotatedClass.getAnnotation(CustomAnnotation.class);

        // 애노테이션 정보 가져오는 방법 #2
        Annotated annotated = new Annotated();
        CustomAnnotation annotation2 = annotated.getClass().getAnnotation(CustomAnnotation.class);

        // 애노테이션의 값 가져오기
        String value = annotation2.value();

        // 애노테이션의 값을 이용해서 원하는 동작을 구현
        System.out.println(value);


    }
}

//@Retention()
// 타입과 필드에만 넣을 수 있도록 하고 싶을 때
@Target({
    ElementType.TYPE,
    ElementType.FIELD,
})
@interface CustomAnnotation {
    // [입력타입]  [입력값명칭]  default [기본값];
    String value() default "";//문자열 값
    int intValue() default 0;//정수 값
    double[] doubleArr() default {};
}

@CustomAnnotation(
    value = "",
    intValue = 0,
    doubleArr = {
        0.1,
        0.2
    }
)
class Annotated {
    @CustomAnnotation( /* 값 지정*/ )
    int prop;
}
