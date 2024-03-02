
public class DAY1_Main {
    //main 함수 : 최초 진입점(JVM) 시스템 약속 지점(인터페이스 지점)
    public static void main(String[] args) {
        // 주석(Comment)
        // 단일줄 주석 : // 메모 작성
        // 여러줄 주석 : /* 메모 작성 */
        // 문서화 주석 : /** 문서화용 주석 **/

//        { } : 퀄리 브래킷
//        [ ] : 브래킷
//        ( ) : 라운드 브래킷
//        " " : 더블 쿼터
//        ' ' : 싱글 쿼터
//
//        >>> 코드블럭(Code Block)
//        {
//              !!여기 안에서 작성할 것!!
//        }
//
//        메인 함수 호출
//        public   class  Main   {
//            public  static   void  main(String[] args) {
//                // 원하는 코드 작성
//            }
//        }
//
//        함수 : console에 출력 함수
//        System.out.println ( "문자열" );
//
//        console ? 명령 프롬프트 창


        // 변수 및 상수
        // 변수 : 변하는 값이 담기는 메모리 공간
        // 상수 : 고정된 값이 담기는 메모리 공간
        //
        // 변수 작성법
        int a = 5; // [TYPE] [이름] = [값] ;
        //
        // 상수 작성법
        final int b = 8; // final [TYPE] [이름] = [값] ;
        //
        // [TYPE] : 데이터타입(자료형) >> 데이터 의 유형 결정
        System.out.println(Byte.MIN_VALUE + " ~ " + Byte.MAX_VALUE);
        System.out.println(Short.MIN_VALUE + " ~ " + Short.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE + " ~ " + Integer.MAX_VALUE);
        System.out.println(Long.MIN_VALUE + " ~ " + Long.MAX_VALUE);
        System.out.println(Float.MIN_VALUE + " ~ " + Float.MAX_VALUE);
        System.out.println(Double.MIN_VALUE + " ~ " + Double.MAX_VALUE);

        // Signed : 부호있는 숫자
        // Unsigned : 부호없는 숫자 >> Java 에서는 지원안함
        //숫자 + 문자열 + ... ==> 문자열
//        - 정수형 ( 값이 안잘릴만큼 충분한 크기, 표현범위순서 : byte < short < int < long )
//        byte : 1 byte == 8 bit >> 2^8 == 256 >> 표현범위 -128~127
//        short : 4 byte >> 2^32 >> 표현범위 +-2^16
//        int : 8 byte >> 많이 사용 (기본값)
//        long : 16 byte
//
//        - 실수형 ( 정밀도로 결정, 표현범위순서 : float < double )
//        float : 8 >> 많이 사용
//        double : 16 (기본값)
//
//        - 문자열형
//        String : 문자열
//        char : ASCII용 글자하나
//
//        - 판별형
//        boolean : true/false

        // 메모리 상에서 증발
        // 10;
        // 변수를 통해서 값을 담아두기 위함
        byte j = 127;
        short s = 31294;
        int n = 10;
        long l = 128908092349835783L;// L? long 값이라는걸 의미
        float f = 123.172891f;// f? float 값이라는걸 의미
        double d = 182793.712894;
        String str = "안녕하세요!";// !!더블쿼터!!
        char c = 'a';// !!싱글쿼터!!
        // 문자열이 되지 않을까? >> XXX
        // char[] s = 'afdfasdf';
        // 위의 값부분들은 리터럴 값(Literal)
        // 리터럴 ? 고정값(상수)


        // 정수 변수 4개 선언 (값은 아무거나)

        // 실수 변수 4개 선언 (값은 아무거나)

        // 문자열 변수 4개 선언 (값은 아무거나)


        double varDouble = 71823.438590384;
        // 상수 선언 (값은 아무거나)
        final double CONST_DOUBLE = 6789.789789;
        varDouble = 712893789.834957890;
        //!!불가능!! >> 상수라서...
        //CONST_DOUBLE = 178293.27389;
    }
}