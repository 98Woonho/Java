public class DAY6_Main {
    // 여기서 작성 또는 아래쪽에서 작성

    public static void main(String[] args) {
        /**
         * - 함수(Function) : 특정한 입력을 넣었을 때, 일정한 결과 값을 출력하는 기능
         *
         *   >> 수학 : y = f(x)
         *   >> 프로그래밍 : y = f(x, ... , ...)
         *
         *   [RETURN_TYPE]  [NAME]  ( [PARAMETER] ) {
         *       /// 실행할 코드들 ///
         *   }
         *
         *   >> [NAME] : 아무 이름이나 모두 가능, 단, 숫자만 아니면 됨(변수 이름 규칙과 동일)
         *               이름을 봤을 때, 어떤 역할을 하는지 알 수만 있도록 작명
         *               아래처럼 선언함(예시)
         *               plus
         *
         *               >> 카멜(Camel) : 낙타, 단어가 시작될 때마다 첫 문자만 대문자, 나머지 다 소문자(e.g. helloWorld)
         *               >> 스네이크(Snake) : 뱀, 단어 사이에 언더라인(_)으로 구분, 문자는 모두 소문자(e.g. hello_world)
         *
         *               카멜을 더 선호, 단, "리소스 파일(Resource)"들은 언더라인으로 구분해주는게 좋음
         *
         *  >> [PARAMETER] : 인수(Arguments), 인자/매개변수(Parameter) 라고도 부름
         *                   호출 측으로부터 들어오는 입력 값, 작명은 어떤 역할을 하는지 알 수 있도록 작성
         *                   아래처럼 선언함(예시)
         *                   (int a, int b)
         *
         * >> [RETURN_TYPE] : 결과 값의 타입 (+ return 이라는 키워드를 함께 사용)
         *                    결과 값의 타입을 작성
         *                    아래처럼 선언함(예시)
         *                    int
         *
         * 위의 예시를 코드로 작성하면,
         * int plus(int a, int b) {
         *     int result = 0;
         *     ...
         *     //변수나 상수나 또 다른 함수를 호출해서 그 결과를 돌려줄 수도 있음
         *     return result;
         * }
         *
         * >> 자바는 클래스 안에서만 함수를 선언할 수 있음
         *    클래스는 뭔데요? class 키워드로 작성된 부분의 코드 블럭 사이에 작성
         * >> 함수 안에 다른 함수 선언 불가(클래스 안에서만 작성 가능)
         *
         * - 함수 동작 과정
         * 1. 함수를 호출
         * 2. 코드에서 몇번째 행을 실행하고 있는지 가리키는 프로그램 카운터(Program Counter)의 값을 레지스터(Register)에서 기억
         * 3. 함수 선언부로 이동(public static void fn() 부분으로 이동)
         * 4. 함수 헤더(Header)을 읽음(void fn()) => 파라미터(입력), 리턴(출력) 내용을 읽음
         * 5. 함수 호출 시 전달했던 값을 차례로 집어넣음
         * 6. 함수 바디(Body, 코드블럭)를 차례로 실행 (언제까지? return 을 만날 때까지 실행)
         *    ( 함수 안에 어떤 함수를 호출 하는 과정이 있으면 이 과정이 반복됨 )
         *    ( return 키워드가 없으면요? 없을 시 자동으로 선언해줌 또는 블럭의 끝에 도달하면 있는 것으로 간주 )
         * 7. return을 만났을 때, 값과 리턴 타입이 일치하는지 확인 후 값을 복사해옴
         *    ( 변수였더라도 변수에 있는 값을 가져옴 )
         * 8. 프로그램 카운터의 위치의 값을 꺼내와서 원래 위치로 돌아옴
         */

        main2();
        example();
    }

    // 여기서 작성 또는 위쪽에서 작성

    // 클래스라는 것을 아직 못배웠기 때문에 public static 키워드를 붙여준다.
    public static int plus(int n1, int n2) {
        int result = n1 + n2;
        // 이렇게 했을 때, result라는 변수가 반환되는게 아니라,
        // result에 있는 값이 반환됨
        return result;
    } // a = plus(5, 3) -> n1에 5 저장, n2에 3 저장해서 result = 5 + 3이 되고 8이 반환되어서 a에 8이 저장됨.

    // 리턴이 없으면 어떻게 하나요? void 사용

    // 유형 1 : 반환 값도 없고, 입력 값도 없음
    public static void fn() {
    }

    // 유형 2 : 반환 값은 없고, 입력 값은 있음
    public static void pfn(int param) {
    }

    // 유형 3 : 반환 값은 있고, 입력 값은 없음
    public static int rfn() {
        // 좋은 습관 : 디버거(Debugger)로 추적 가능(IDE에서는 우측 상단에 벌레모양 아이콘)
        //    >> 디버거 사용법 : 좌측에 행번호와 코드 에디터 사이에 클릭하면, 빨간색 점(브레이크 포인트)이 생김 > 디버거로 실행
        //                     호출이 안되는데요? 그 빨간색 점 위치가 실행이 안되었기 때문
        int result = 0;
        return result; //이 때는 return 키워드 사용!
    }

    // 유형 4 : 반환 값 있고, 입력 값도 있음
    public static int rpfn(int param) {
        int result = 0;
        return result;
    }

    // 재귀함수(Recursive Function) : 함수가 자기자신을 재호출하는 기능
    // 주의사항 : StackoverflowException 발생 가능
    //
    // Stack? 메모리에 대해서 알 필요가 있음
    // (https://www.google.com/search?rlz=1C1JJTC_koKR1064KR1064&q=%EB%A9%94%EB%AA%A8%EB%A6%AC+%EA%B5%AC%EC%A1%B0&tbm=isch&sa=X&ved=2ahUKEwijktvZ8Pb_AhUbaN4KHTULDp4Q0pQJegQIDBAB&biw=1920&bih=937&dpr=1#imgrc=bkYGAqI7lN1foM)
    // 메모리 공간 상에서 Stack 을 한마디로 정의하면, 임시저장공간(메모리구조는 위에 링크 참조)
    //  >> Overflow? +방향으로 넘침(e.g. int의 최대값보다 클 경우)
    //  >> Underflow? -방향으로 넘침(e.g. int의 최소값보다 작을 경우)
    //  >> Stackoverflow? Stack이 넘쳤음(함수 호출 가능 횟수 초과)
    //
    // 작성 순서
    // 1. 종료조건 작성
    // 2. 리턴문 + 자기자신 호출 작성
    // 3. 무조건 단위 테스트(Unit Test, 프로그래머가 작성한 코드를 스스로 테스트 해보는 것) 진행
    //
    // 잘 작성하는 방법
    // 1. 잘 될거라고 믿어야 함
    // 2. 작성 순서를 잘 지키면서 작성
    public static int recursive(int n) {
        // !!중요!! 중단점(종료조건) 필요
        // 없다면, StackoverflowException
        if (n <= 0) {// 예상치 못한 값까지 커버할 수 있는 조건으로 사용할 것
            return 0;
        }
        return n + recursive(n - 1);
    }

    // static? 클래스/정적 메소드로 만들어줌 > 클래스를 객체화 하지 않고 즉각 호출 가능하도록 해줌
    public static void main2() {
        // 이렇게 안됨
        //public static void f() {}

        // 유형 1 호출
        fn();
        // 유형 2 호출
        pfn(21);
        // 유형 3 호출
        int returned = rfn(); // 반환 값을 다른 변수 하나를 선언하면서 할당
        // 유형 4 호출
        returned = rpfn(324678); // 반환 값을 기존 변수에 할당

        // 재귀함수 호출
        returned = recursive(12);
    }

    public static void example() {
        // 사칙연산 함수를 만들고, 호출하기
        // 함수이름 : add(), sub(), mul(), div(), mod()
        int a = add(5, 3);
        int b = sub(5, 3);
        int c = mul(5, 3);
        int d = div(5, 3);
        int e = mod(5, 3);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
    }


    public static int add(int n, int m) {
        int result = n + m;
        return result;
    }

    public static int sub(int n, int m) {
        int result = n - m;
        return result;
    }

    public static int mul(int n, int m) {
        int result = n * m;
        return result;
    }

    public static int div(int n, int m) {
        int result = n / m;
        return result;
    }

    public static int mod(int n, int m) {
        int result = n % m;
        return result;
    }
}
