public class DAY2_Main {
    public static void main(String[] args) {
        /* ----- 연산자(P.80) -----
         *
         * A, B, C, ... (피연산자, 오퍼랜드, Operand)를
         * 가지고 어떠한 행위를 해서 나온 결과물을 저장한다.
         *
         * 연산자의 우선순위 :
         *      산술 > 관계 > 논리 > 할당
         *
         * 산술 : 정수/실수
         *      덧셈       (정수/실수 C = A + B),
         *      뺄셈       (정수/실수 C = A - B),
         *      곱셈       (정수/실수 C = A * B),
         *      나눗셈      (정수/실수 C = A / B),
         *      나머지셈    (정수/실수 C = A % B)
         * 관계 : 판별
         *      같다        (판별 C = A == B)
         *      다르다      (판별 C = A != B)
         *      크다        (판별 C = A < B)
         *      작다        (판별 C = A > B)
         *      크거나 같다  (판별 C = A <= B)
         *      작거나 같다  (판별 C = A >= B)
         * 논리 : 판별
         *      그리고, AND (판별 C = A && B) => A도, B도 모두 참
         *      또는,   OR  (판별 C = A || B) => A나 B가 하나라도 참
         *      아닌,   NOT (판별 C = !A) => A가 거짓 > 참, 참 > 거짓
         * 할당 :
         *      값저장      (B의타입 A = B) => A의 타입과 B의 타입은 같다.
         *
         * - 비트 연산자
         *
         *   16(0x~)   10     2
         *    1         1     1
         *    2         2    10
         *    3         3    11
         *    4         4   100
         *    5         5   101
         *    6         6   110
         *    7         7   111
         *    8         8  1000
         *    9         9  1001
         *    A        10  1010
         *    B        11  1011
         *    C        12  1100
         *    D        13  1101
         *    E        14  1110
         *    F        15  1111
         *
         * AND (A & B) : 두 2진수에서 두 비트 모드 1일 경우 1로 설정, 아닐 경우 0으로 설정
         *
         *    A   B
         *    0   0 = 0
         *    1   0 = 0
         *    0   1 = 0
         *    1   1 = 1
         *
         * OR (A | B) : 두 2진수에서 한 비트라도 1일 경우 1로 설정, 아닐 경우 0으로 설정
         *  ? = 2(10b) | 1 (01b)
         *         10
         *         01
         *       ------
         *         11b
         *
         *    A   B
         *    0   0 = 0
         *    1   0 = 1
         *    0   1 = 1
         *    1   1 = 1
         *
         * XOR (A ^ B) : 두 2진수에서 서로 다른 비트일 경우 1로 설정, 같은 비트일 경우 0으로 설정
         *
         *    A   B
         *    0   0 = 0
         *    1   0 = 1
         *    0   1 = 1
         *    1   1 = 0
         *
         * Right-Shift(A >> B) : 2진수에서 1비트씩 우측으로 이동
         * Left-Shift(A << B) : 2진수에서 1비트씩 좌측으로 이동
         * Unsigned Right-Shift(A >>> B) : 2진수에서 1비트씩 우측으로 이동
         */

        // 산술 예시
        int resultPlus = 0;

        resultPlus = 1 + 1; // 상수 + 상수

        int a = 1123;
        resultPlus = a + 1; // 변수 + 리터럴(상수)

        int b = 124345;
        resultPlus = a + b; // 변수 + 변수

        final int c = 0x7834;
        resultPlus = resultPlus + c; // 자기자신 = 자기자신 + 변수

        // 관계 예시
        boolean bool = false;

        bool = resultPlus > 10;

        boolean bool2 = false;

        bool2 = 10 <= 11;

        // 논리 예시
        boolean bool3 = bool && bool2;

        boolean bool4 = bool && bool2 && bool3;
        //안되는예
        //boolean adsf = x1 > x2 > x3;

        /* ----- 제어문(P.104) -----
        * 조건식 : 결과물은 boolean <-- 관계 or 논리
        * if문 : 흐름제어용, 조건식이 참이면 코드블럭을 실행해주는 구문 (+ else)
        * - else : if 문들간에 묶어주기위함, 마지막 최종적으로 모든 거짓을 처리할 때
        * if( /// 조건식 /// ) {
        *     // 참일 때, 실행할 코드들
        * } else if ( /// 조건식 /// ) {
        *     // 참일 때, 실행할 코드들
        * } else if ( /// 조건식 /// ) {
        *     // 참일 때, 실행할 코드들
        * } ... {
        *     // 참일 때, 실행할 코드들
        * } else {
        *     // 앞의 조건식들이 모두 거짓일 경우 실행할 코드들
        * }
        */

        // 나머지 연산 : x % n >> 0 ~ n-1
        // x % 3  >> 0, 1, 2

        // 입력된 정수가
        int input = 0;
        // 홀수일 경우 "홀수입니다."를 출력하고,
        // 짝수일 경우 "짝수입니다."를 출력한다.
        if(input % 2 == 0) {// 짝수
            System.out.println("짝수입니다.");
        } else {
            System.out.println("홀수입니다.");
        }

        // 두 숫자 중 더 큰 수를 출력하세요.
        // 제한시간 : 5분

        int A = 2839;
        int B = 127839;
        // TODO:: A < B
        if(A < B) {
            System.out.println(B);
        }
        // TODO:: A > B
        else if(A > B) {
            System.out.println(A);
        }
        // TODO:: A == B
        else {
            System.out.println(A);
        }

        // 세 숫자 중 가장 큰 수 찾기
        // 제한시간 : 10분

        // if(A < B < C) {}   => 연산자
        // if(A < B && B && C) {}
        int x = 32789;
        int y = 347895237;
        int z = 57854;

        int max = x;
        if(max < y) {
            max = y;
        }
        if(max < z) {
            max = z;
        }
        System.out.println(max);
    }
}
