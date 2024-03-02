public class DAY8_Main {
    public static void main(String[] args) {
        /**
         * - 프로그래밍 패러다임
         * (과거) 절차 지향 프로그래밍 >
         * (종전) 객체 지향 프로그래밍 >
         * (현재) 함수형 프로그래밍(Functional Programming) +@ 선언형 프로그래밍
         *
         * - (과거) 절차 지향 프로그래밍(Modulation, 함수) >
         * 객체 지향 프로그래밍(OOP : Object-Oriented Programming)
         * : 세상의 모든 것을 사물로 보고, 그것의 공통점을 클래스로 만들고,
         *   그 클래스로부터 객체라는 것을 만들어내서, 부품처럼 사용한다.
         *
         *   >> 클래스
         *   >> 추상화 : 추상 클래스
         *   >> 추상화 : 인터페이스
         *
         * - 클래스 : 일종의 틀(X), 대상의 공통점을 코드로 만들어낸 것
         * Class : (1,2,3,..)반(Class), 분류
         *   >> 멤버 : 속성/필드/변수와 기능or행동/메소드/함수
         *      >> 속성(Property/Attribute) / 필드(Field) / 멤버변수(Member Variable)
         *      >> 기능or행동(Behaviour) / 메소드(Method) / 멤버함수(Member Function)
         *   >> 멤버는 두 가지로 나뉨 : 인스턴스/동적 멤버 / 클래스/정적 멤버
         *      >> 인스턴스(Instance) / 동적(Dynamic) : 객체화되었을 때(메모리에 오브젝트가 상주할 때)
         *          >> 클래스로부터 만들어진 객체
         *      >> 클래스(Class) / 정적(Static) : 객체화되기 전(메모리에서 텍스트 영역에 있을 때)
         *          >> 클래스 그 자체
         *
         * - 클래스와 객체의 관계 : 1개 클래스 - N개 객체
         *   >> 클래스로부터 객체를 여러 개 만들 수 있음
         *   >> 객체 간에는 서로 다른 객체가 된다. (값 공유 안됨)
         *   >> 객체 간 공유되는 공통점은 "클래스" 라는 개념 뿐...
         *
         *   A 클래스 ( class ~~~{} )
         *      ㄴ 1번 객체  --------- 1~N번 객체 간의 관계 : 1~N번 객체까지는 서로 다른 것
         *      ㄴ 2번 객체              ㄴ 값 공유 안됨(속성/필드/멤버변수가 가진 값이 공유될 수 없음)
         *      ㄴ 3번 객체  ( new ~~~() )
         *      ㄴ ...
         *      ㄴ N번 객체
         *
         * // 클래스 선언
         * class [NAME] {
         *     // ... 클래스 멤버들에 대한 코드들 ...
         * }
         * // 클래스로부터 객체 생성
         * [CLASS_NAME]  [VAR_NAME] = new [CLASS_NAME]();
         */

        MyClass myClass = new MyClass();
        myClass.method();
        //myClass.localVar = 20;
        //속성 값 변경
        myClass.property = 30;
        myClass.method();

        System.out.println("------------- myClassDif");
        MyClass myClassDif = new MyClass();
        myClassDif.method();
    }
}

class MyClass {
    // 멤버변수/필드/속성 : 객체가 살아있는 동안 값을 유지하기 위해서 사용
    int property = 10;

    int fromLocal = 0;

    // 멤버함수/메소드
    void method() {
        // 지역변수 : 외부에서 호출할 수 없음
        int localVar = 20;
        System.out.println("Property : "+property);
        System.out.println("fromLocal : "+fromLocal);

        // 지역변수를 멤버변수에 저장할 때
        fromLocal = localVar;
    }
}
