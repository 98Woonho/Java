public class DAY3_Main {
    public static void main(String[] args) {
        // 학생들의 수학 시험 성적을 입력받아 성적에 따른 학점을 계산하여 출력
        //
        // - 성적이 90 이상인 경우, 학점은 'A'입니다.
        // - 성적이 80 이상 90 미만인 경우, 학점은 'B'입니다.
        // - 성적이 70 이상 80 미만인 경우, 학점은 'C'입니다.
        // - 성적이 60 이상 70 미만인 경우, 학점은 'D'입니다.
        // - 성적이 60 미만인 경우, 학점은 'F'입니다.

        int score = 100;

        // 디펜스 코드 :
        // 다음 코드들이 정상동작할 수 있게끔(오류없이 동작할 수 있게끔) 값을 체크하거나 하는 행위를 통해
        // 오류를 방지하는 코드

        if(score < 0){
            score = 0;
        }
        if(score > 100) {
            score = 100;
        }

        String result = "";
        if(score < 60) {
            result = "F";
        } else if(score < 70) {
            result = "D";
        } else if(score < 80) {
            result = "C";
        } else if(score < 90) {
            result = "B";
        } else {
            result = "A";
        }

        // 3항 연산자 : /// 조건식 /// ? /// 참일 경우의 값 /// : /// 거짓일 경우의 값 ///
//        if(score < 0){
//            score = 0;
//        }
        score = score > 0? score : 0;
//        if(score > 100) {
//            score = 100;
//        }
        score = score < 100? score : 100;

        String str = null; // null != ""   null != 0  ==>>>> 값이 없음!!
//        if(str != null) {
//            if(str.length() >= 0) {
//
//            }
//        }
        // 개선된 코드
        str = str != null? str : "";
        if(str.length() >= 0) { /* sdhfjshjkd */ }

        //도시의 기온 정보를 입력받아서 현재 날씨 상태를 판별
        //
        //기온이 30도 이상일 경우, "매우 더워요!"를 출력합니다.
        //기온이 20도 이상 30도 미만일 경우, "따뜻한 날씨입니다."를 출력합니다.
        //기온이 10도 이상 20도 미만일 경우, "좋은 날씨입니다."를 출력합니다.
        //기온이 0도 이상 10도 미만일 경우, "쌀쌀한 날씨입니다."를 출력합니다.
        //기온이 0도 미만일 경우, "추운 날씨입니다."를 출력합니다.

        // 비선호
//        double temp = 0.0;
//        String tempStr = temp >= 30
//                        ? "매우 더워요!"
//                        : temp < 20
//                            ? "따뜻한 날씨입니다."
//                            : "좋은 날씨입니다.";

        /**
         * switch-case-default : 주어진 변수를 상수와 비교해서 택 1하여 실행한다.
         *
         * - JAVA의 경우 : byte, short, int, long, char 만 변수/상수 자리에 사용 가능
         * - 타언어의 경우 : String, boolean 도 지원
         *
         * switch ( /// 숫자변수 /// ) {
         *     case /// 숫자 /// : // if
         *         // 실행할 코드들
         *         break;
         *     case /// 숫자 /// :
         *     case /// 숫자 /// : // else if
         *         // 실행할 코드들
         *         break;
         *     default : // else와 같은 구문
         *         // 실행할 코드들
         *         break;
         * }
         */

        // 이런 문제의 경우 if 문 활용
        int temp = 0;
        final int HOT = 29;
        switch(temp) {
            case 30:
            case HOT:
                System.out.println("매우 더움");
                break;
            case 28:
                System.out.println("더움");
                break;
            case 27:
                System.out.println("보통");
                break;
            case 26:
                System.out.println("시원");
                break;
            default:
                System.out.println("~~~");
                break;
        }

        q();

        /**
         * 반복문 : 주어진 구문을 주어진 조건이 참인 동안에 반복해서 실행한다.
         *
         * 자료형 >> Array : 배열(일자로 변수를 여러 개, 한번에 선언)
         * 자료형 >> ArrayList : 목록형(중복 가능, 배열같은 목록형)
         * 자료형 >> List : 목록형(중복 가능, 목록)
         * 자료형 >> Set : 목록형(중복 불가)
         * 자료형 >> Map : 테이블형(Key-Value)
         *
         * - while
         * - do-while
         * - for
         */
    }

    public static void q() {
//        학생들의 수학 시험 성적을 입력받아 성적에 따른 학점을 계산
//
//        성적이 90 이상인 경우, 학점은 'A'입니다.
//        성적이 80 이상 90 미만인 경우, 학점은 'B'입니다.
//        성적이 70 이상 80 미만인 경우, 학점은 'C'입니다.
//        성적이 60 이상 70 미만인 경우, 학점은 'D'입니다.
//        성적이 60 미만인 경우, 학점은 'F'입니다.
        // if문 사용 => switch문으로 "학점은 '~'입니다."
//        나왔는 결과를 switch문을 이용해서 출력

        // Key Point.
        // 상수 활용
        // 값을 변수에 최대한 모음

        final char A = 'A';
        final int A_SCORE = 100;

        final char B = 'B';
        final int B_SCORE = 90;

        final char C = 'C';
        final int C_SCORE = 80;

        final char D = 'D';
        final int D_SCORE = 70;

        final char F = 'F';
        final int F_SCORE = 60;

        int score = 80;

        char grade = F;
        if(score < F_SCORE) {
            grade = F;
        } else if(score < D_SCORE) {
            grade = D;
        } else if(score < C_SCORE) {
            grade = C;
        } else if(score < B_SCORE) {
            grade = B;
        } else {
            grade = A;
        }

        String print;
        switch(grade) {
            case A:
                print = "학점은 " + grade + " 입니다.";
                break;
            case B:
                print = "학점은 " + grade + " 입니다.";
                break;
            case C:
                print = "학점은 " + grade + " 입니다.";
                break;
            case D:
                print = "학점은 " + grade + " 입니다.";
                break;
            case F:
            default:
                print = "학점은 " + grade + " 입니다.";
                break;
        }
        System.out.println(print);
    }
}
