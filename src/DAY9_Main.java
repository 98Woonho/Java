public class DAY9_Main {
    public static void main(String[] args) {
        /**
         * 패키지(Package) : 클래스의 묶음, 클래스만의 공간 제공(네임스페이스 제공, 타 언어중 일부는 namespace 라고 키워드를 줌)
         *                  (자바)패키지 == 네임스페이스(타 언어)
         */
        //이름이 겹칠 경우 패키지명까지 합쳐서 기입
        a.b.c.My cmy = new a.b.c.My();//or import a.b.c.My;
        a.b.f.My fmy = new a.b.f.My();//or import a.b.f.My;

        /**
         * - 클래스 : 접근제한자(Access Modifier) : 객체 안에 멤버에 접근 가능 범위를 변경한다.
         *
         * public           : 모두 접근 가능. 즉, 패키지 외부 + 클래스 외부에서도 접근 가능
         * protected        : 상속 관계 접근 가능. 즉, 자기자신 + 자식 클래스에 한정해서 접근 가능
         * private          : 자기자신만 접근 가능.
         * package-private  : (아무것도 적지 않았을 때 기본)패키지 안에서만 접근 가능
         *                    >> 라이브러리 라는 개념과 섞어서 확인해야함
         *
         * OOP 중요 개념 중 하나는 정보은닉, 정보은닉은 결국엔 "클래스가 어떻게 구현되어있는지 몰라도 된다." 제공
         * 그래서 클래스 멤버변수는 99.9%는 모두다 private,
         * 그리고 외부에서 접근하게끔 할 수 있게 해주고 싶다면, 액세서(Accessor)를 제공해야 한다.
         *
         * - 클래스 : 액세서(Accessor) : 멤버변수에 대한 접근 통로 제공
         *   접근자(Getter) : get~() 메소드, private 멤버변수의 값/레퍼런스를 가져옴
         *   설정자(Setter) : set~(value) 메소드, private 멤버변수의 값/레퍼런스를 변경함
         *
         * 레퍼런스(Reference)? 값을 찾아갈 수 있게끔 제공되는 주소인 참조주소를 의미, 포인터(Pointer)와는 조금 다름
         *
         * - 클래스 : 생성자(Constructor) : 클래스로부터 객체를 생성하는 함수
         * Class cls = new Class(); <- 생성자 함수
         *
         * class [ClassName] {
         *     // 생성자
         *     [ClassName]( /// 파라미터 /// ) { // 함수 파라미터 : 입력 값 변수 선언(일반 변수 선언과 동일)
         *         // ... 초기화 코드들 ...
         *         // 초기화? 멤버변수나 기타 등등 이 클래스가 처음으로 객체로 만들어졌을 때 초기에 가질 상태(값)를 결정하는 것
         *     }
         * }
         */

        Printer printer = new Printer();
        printer.printingNewLine("Hello, World!");
        printer.printing("Hello, World!");
    }
}

//e.g. Overloading : 옵션 값을 만들어줄 때 일반적으로 많이 사용
class Printer {
    void printingNewLine(String str) {
        printing(str, true);
    }

    void printing(String str) {
        printing(str, false);
    }

    void printing(String str, boolean newLine) {
        if(newLine) {
            System.out.println(str);
        } else {
            System.out.print(str);
        }
    }
}

class ClassA {
    public int publicVar = 1;
    protected int protectedVar = 2;
    private int privateVar = 3;

    // - 오버로딩(Overloading) : 같은 이름을 가진 함수를 여러 개 선언하는 것
    //   >> 선언 조건 : 함수 시그니처(선언부/헤더)가 달라야 선언 가능
    //      함수 시그니처가 달라야한다는 이야기는,
    //      파라미터가 달라야 다른 함수로 취급.
    //      리턴 타입이 다른 것은 같은 함수로 취급.
    //   >> 여러 개 선언 되었지만, 같은 동작을 할 가능성이 매우 다분(99%) => 이름이 똑같으니까...
    //   >> 어떤 함수에서 입력 값 옵션을 만들어줄 때 일반적으로 많이 사용
    void method() { method(0, 2); }
    // int method() { return 0; } // 'method()' clashes with 'method()'; both methods have same erasure
    void method(int x) { method(x, 2); }
    void method(int x, int y) { /* 동작할 코드 */ }

    // - 생성자 오버로딩(Constructor Overloading) : 생성자 함수를 여러 개 선언하는 것
    // 외부로부터 초기화될 값만 받으면 됨
    // 모든 값을 외부에서 결정해줄 수 있도록 제공할 필요는 없음

    //ClassA constructor( ... ) { ... } ==> ClassA( ... ) { ... }
    ClassA(
        int publicVar
    ) {
        this.publicVar = publicVar;
    }

    ClassA(
        int publicVar,
        int protectedVar,
        int privateVar
    ) {
        this.publicVar = publicVar;
        this.protectedVar = protectedVar;
        this.privateVar = privateVar;
    }

    // Getter/Setter for protectedVar => 상속 외 다른 클래스에서 접근 대응
    // 외부에서 값에 접근할 수 있다면, 게터 선언 필요. 값을 가져갈 수 없게 한다면, 불필요
    public int getProtectedVar() {
        return protectedVar;
    }
    // 외부에서 값을 변경할 수 있다면, 이렇게 세터 선언 필요. 변경할 수 없게 한다면, 불필요
    public void setProtectedVar(int protectedVar) {
        this.protectedVar = protectedVar;
    }
}
class ClassB {
    ClassB(ClassA a) {
        int publicVar = a.publicVar;
        // ERROR: java: protectedVar has protected access in ClassA
        //int protectedVar = a.protectedVar;
        // ERROR: java: privateVar has private access in ClassA
        //int privateVar = a.privateVar;
    }
}
