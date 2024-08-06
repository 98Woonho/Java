public class DAY11_Main {
    public static void main(String[] args) throws Exception {
        /**
         * - 에러(Error) vs 예외(Exception)
         *   >> 에러 : 크리티컬하게 문제가 발생해서 프로그램이 종료되는 오류 => 오류가 프로그램 종료로 이어지면, 에러
         *   >> 예외 : 문제를 예상할 수 있어서 프로그램 종료를 막을 수 있는 오류 => 프로그램이 종료되지 않으면, 예외
         *
         * - 예외처리를 사용함에 있어서 주의사항
         *   >> 예외처리는 성능을 떨어트림(if문 1000개 사용한 것과 비슷)
         *   >> 꼭 사용해야하는 부분에서만 사용
         *
         * - 예외처리(Exception) : 프로그램이 종료되지 않도록 오류에 대한 처리를 하는 것
         *
         *   >> 예외 던지기(throw) : throw new [EXCEPTION_CLASS]( [String message] );
         *   >> 메소드가 예외를 호출 측에 오류처리에 대해서 맡김(throws) : throws [EXCEPTION_CLASS]
         *
         * try {
         *     // ... 오류 테스트되는 코드들 ...
         * } catch([EXCEPTION_CLASS] [NAME]) { //파라미터로 들어옴
         *     // ... 지정된 예외가 일어났을 때 실행될 코드들 ...
         * } catch ... {
         *
         * } finally {
         *     // ... 성공/실패와 관계없이 실행될 수 있는 코드들 ...
         * }
         */

        DAY11_Main main = new DAY11_Main();
        // main.throwsMethod();
        main.throwsHandle();
        System.out.println("동작 끝!");
    }

    void throwsHandle() {
        try {
            // try 에 있는 코드들에서, 예외가 발생하지 않을 코드들까지
            // 예외가 발생했는지 체크를 함 => 결과적으로 성능이 느려짐

            // 예외발생하지 않을 다른 코드들은 넣지 않는 것 권장
            throwsMethod();
            //throw new Exception("예외!");
            // 예외발생하지 않을 다른 코드들은 넣지 않는 것 권장
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("예외 발생시 실행");
        } finally {
            System.out.println("성공여부 상관없이 실행");
        }
    }

    void throwsMethod() throws Exception {
        throw new Exception("예외발생한 사유");
    }
}
