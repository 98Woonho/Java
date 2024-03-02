public class DAY7_Main {
    public static void main(String[] args) {
        /**
         * - 인수/아규먼트(Argument) vs 인자/매개변수/파라미터(Parameter)
         *   >> 인수/아규먼트(Argument) : 호출하는 측에서 값을 넣어줄 때 변수를 부르는 명칭
         *   >> 인자/매개변수/파라미터(Parameter) : 호출받는 측에서 값을 입력받을 때 변수를 부르는 명칭
         */

        /**
         * - 가변 갯수 파라미터(Dynamic number of parameter) : 동일한 타입의 파라미터를 동적으로 여러 개 받는 기능
         *   >> 동적 : 런타임(사용자가 우리 프로그램을 사용할 때)에서 무언갈할 때
         *   >> 정적 : 컴파일타임(우리가 코드 작성할 때)에서 무언갈할 때
         *   >> 빌드 : 컴파일되어서 프로그램으로 생성하는 것
         */

        practice();
        dynamicNumberOfParameterFn();
        dynamicNumberOfParameterFn(1);
        dynamicNumberOfParameterFn(3, 2);
        dynamicNumberOfParameterFn(3, 2, 5, 7, 9);


    }

    // 이렇게 했다면, 호출할 때에는 배열을 전달해야함
    // dynamicNumberOfParameterFn(new int[]{});
    // dynamicNumberOfParameterFn(new int[]{1});
    // dynamicNumberOfParameterFn(new int[]{3, 2});
    // dynamicNumberOfParameterFn(new int[]{3, 2, 5, 7, 9});
//    public static void dynamicNumberOfParameterFn(
//        int[] numbers
//    ) {
    public static void dynamicNumberOfParameterFn(
        //int number1, int number2, int number3, ...
        int... numbers // == int[] numbers
        //String... strs //가변 갯수 파라미터 사용은 함수당 딱 1회만 가능
    ) {
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
        }
    }

    // Object    <- 최상위 클래스(Top Class/Root Class)
    //    ㄴ int
    //    ㄴ String
    //    ㄴ boolean
    //    ㄴ Wrapper Class
    //    ㄴ ...
    //
    // anyParameters();
    // anyParameters(1, "str");
    // anyParameters(1, "str", true);
    public static void anyParameters(Object... args) {
    }

    public static void practice() {
        // https://ko.wikipedia.org/wiki/ASCII
        char a = 'a';
        char A = 'A';
        boolean result = a < A;
        System.out.println((int)a);
        System.out.println((int)A);

        DAY7_Main main = new DAY7_Main();

        // 문자열을 인자로 받아서, 해당 문자열을 거꾸로 뒤집은 결과를 반환하는 함수를 작성하시오.
        String reversed = main.reverseString("Hello, World");

        // 주어진 문자열에서 알파벳 순서로 정렬하여 반환하는 함수를 작성하시오.
        String sorted = main.sort("rhvgu");
        System.out.println(sorted);

        // 정수를 인자로 받아서, 해당 정수의 팩토리얼 값을 반환하는 함수를 작성하시오.

        // 주어진 리스트에서 짝수만을 필터링하여 새로운 리스트로 반환하는 함수를 작성하시오.

        // 여러 개의 숫자를 인자로 받아서, 해당 숫자들의 평균 값을 반환하는 함수를 작성하시오.

        // 두 개의 리스트를 인자로 받아서, 두 리스트에 모두 존재하는 공통된 요소들로 이루어진 새로운 리스트를 반환하는 함수를 작성하시오.
        // 옵션 기능 : 중복 가능 여부

        // 주어진 문자열이 회문인지(앞으로 읽으나 뒤로 읽으나 동일한지) 판별하는 함수를 작성하시오.
    }

    // public static 없이...
    String reverseString(String input) {
        String result = "";

        // String 에서 이런식으로 인덱서를 통한 접근 불가
        // char c = input[0];

        //                      |  i 위치
        // H e l l o ,  W o r l d
        // |                       j 위치
        // d l r o W ,  o l l e H

        char[] chars = new char[ input.length() ];

        for(int i = chars.length-1, j = 0; i >= 0; i--, j++) {
            // i : n-1 >> n-2 >> n-3 >> ... >> 0
            char c = input.charAt(i);//문자 한 개를 가져옴
            // j : 0 >> 1 >> 2 >> 3 >> 4 >> ... >> n-1
            chars[j] = c;
        }
        result = new String(chars);
        return result;
    }


    String sort(String input) {
        char[] chars = new char[ input.length() ]; // 문자를 받을 리스트 생성
        String result = ""; // 결과값을 받을 변수 생성
        int[] list1 = new int[input.length()-1]; //
        for(int k=0 ; k<input.length()-1 ; k++) {
            list1[k] = k+1;    // input.length() = 5일 때 [1,2,3,4] 가 되어야 함.
        }

        for(int i=0 ; i<input.length()-1 ; i++) {
            char max = input.charAt(i);
            for(int j=list1[i] ; j<input.length() ; j++) {
                if ((int)max < (int)input.charAt(j)) {
                    max = input.charAt(j);
                }
            }
            chars[i] = max;
            // 기존 문자열에서 max의 위치를 어떻게 옮기지?

        }
        result = new String(chars);
        return result;
    }


    /**
     * [RETURN_TYPE]  [NAME] ( [INPUT_TYPE] [INPUT_NAME], ...반복... ) {
     *     ...
     *     [ return ~~~~; ] // [RETURN_TYPE] != void
     * }
     *
     * 함수 작성법
     * 1. 입력 값을 결정/작성한다. (갯수도 결정해야함)
     * 2. 출력 값을 결정/작성한다.
     * 3. 이름을 작성한다.
     * 4. 코드 작성
     *
     * 입력 값/출력 값이라고 하니 헷갈립니다.
     *
     * 입력 값 >> 변수 >> 타입 이름 >> 값에 따라서 변수의 타입 결정
     * 출력 값 >> 변수 >> 타입 >> 값에 따라서 변수의 타입 결정
     *
     * 기본 타입의 종류 ==> 입력 값, 출력 값에서 사용할 수 있는 타입
     * byte (Byte 랩퍼 클래스)
     * short (Short 랩퍼 클래스)
     * int (Integer 랩퍼 클래스)
     * long (Long 랩퍼 클래스)
     * float (Float 랩퍼 클래스)
     * double (Double 랩퍼 클래스)
     * char (Char 랩퍼 클래스)
     * String (String 랩퍼 클래스)
     * boolean (Boolean 랩퍼 클래스)
     *
     * Collection 타입 종류
     * Array : new ~[]
     * ArrayList<TYPE> : TYPE은 클래스명을 넣는다.
     * List<TYPE>
     * Set<TYPE>
     * Map<KEY_TYPE, VALUE_TYPE>
     *
     * 라는 단어와 매칭시키면 됨
     */

    // 기본모양
    //void function() {}
}
