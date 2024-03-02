import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.http.HttpRequest;

public class DAY13_Main {
    public static void main(String[] args) {
        /**
         * - 웹 통신(HTTP 통신)
         *
         *   >> HTTP(Hyper-Text Transfer Protocol)
         *   >> 하이퍼 텍스트 : 클릭 가능한 텍스트(어딘가로 이어지는 링크로 연결되어있음)
         *
         * - HTTP 통신 방법 : https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods
         *
         *   >> GET : URL(URI)에 파라미터(값)을 심어서 보내는 방식
         *      (e.g. http://domain.com/?a=1&b=true <<- base64 인코딩)
         *   >> POST : HTTP HEADER에 파라미터(값)을 심어서 보내는 방식
         *      (e.g. 사용자의 눈에 안 보임, 소켓 통신 연결할 때 보임)
         *
         *   >> PUT : DATA INSERT > 서버 개발자가 만들어놔야 함
         *   >> PATCH : DATA UPDATE > 서버 개발자가 만들어놔야 함
         *   >> DELETE : DATA DELETE > 서버 개발자가 만들어놔야 함
         *
         *   >> HEAD
         *   >> TRACE
         *   >> OPTIONS
         */

        // java.net.URL : URL 을 표현하는 클래스
        final String urlStr = "http://www.naver.com";
        URL url = null;
        try {
            url = new URL(urlStr);
        } catch (MalformedURLException e) {
            // 잘못된 URL일 때 발생하는 예외
        }

        // URL을 못 가져온 경우
        if(url == null) {
            return;
        }

        // 연결성 확보
        HttpURLConnection connection = null;
        try {
            // HttpURLConnection 은 URLConnection 을 구현했기 때문에 캐스팅 가능
            connection = (HttpURLConnection)url.openConnection();
        } catch (IOException e) {
            // 연결 못했을 때 발생하는 예외
        }

        // 연결 실패
        if(connection == null) {
            return;
        }

        // 송신 처리 - 요청 HEADER 정보 송신
        try {
            connection.setRequestMethod("POST");
        } catch (ProtocolException e) {
            // 없는 프로토콜을 사용했을 때
        }

        // setRequestProperty : HEADER 라는 곳에 입력되어야 하는 정보인 경우 입력
        // user-agent : 사용자 환경 정보 표시
        //              e.g. https://www.whatismybrowser.com/guides/the-latest-user-agent/windows
        //connection.setRequestProperty("User-Agent", "");

        // 입력 스트림 또는 출력 스트림 사용 여부
        connection.setDoInput(true);
        connection.setDoOutput(true);

        // 송신 처리 - 요청 BODY 정보 송신
        DataOutputStream outputStream = null;
        try {
            outputStream = new DataOutputStream(connection.getOutputStream());
            outputStream.writeBytes("MY_DATA");
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            // 스트림을 열지 못했을 경우
        }

        // 수신 처리 - 응답 HEADER 정보 수신
        try {
            int code = connection.getResponseCode();
            String message = connection.getResponseMessage();
        } catch (IOException e) {
            // 결과를 받지 못했을 경우
        }

        // InputStream, OutputStream : 스트림 그 자체
        // BufferedInputStream, BufferedOutputStream : 스트림 자체를 버퍼라는 곳에 담아서 처리
        // InputStreamReader, OutputStreamWriter : 라인별로 처리
        // BufferedReader, BufferedWriter : 버퍼에 담아서 라인별로 처리
        // - 버퍼? 속도를 최적화
        //   >> 승용차 1대 1개 물건을 담을 수 있음
        //   >> 트럭 1대 N개 물건을 담을 수 있음
        //   >> 트럭 1번 가는게 더 많은 물건을 송신
        //   >> 트럭처럼 역할을 하는게 버퍼
        //   >> 버퍼를 너무 크게할 경우 오히려 성능 저하

        // - 문자열 결합
        // StringBuffer : 버퍼라는 곳에 주어지는 문자열을 결합 후 문자열로 최종 배출
        // 실제로 문자열 결합할 때 덧셈 연산자(+)로 할 경우 성능이 StringBuffer보다 느림
        // 비슷한 클래스로 StringBuilder가 있는데, StringBuffer보다는 빠르지만, 안정성이 낮음
        // - 문자열 분해
        // StringTokenizer : 주어진 특정 문자를 기준으로 토큰 단위로 분해
        // String.split 을 사용할 경우 제대로 못 잘라오는 경우가 생김

        // 수신 처리 - 응답 BODY 정보 수신
        BufferedReader inputStream;
        String line;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            // 줄 단위로 입력
            inputStream = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            // 값을 받아옴
            while((line = inputStream.readLine()) != null) {
                stringBuffer.append(line);
            }
            // 사용 후 닫음
            inputStream.close();
        } catch (IOException e) {
            // 스트림 열기 실패
        }
        System.out.println(stringBuffer.toString());
    }
}
