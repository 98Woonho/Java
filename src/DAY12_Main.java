import java.io.*;

public class DAY12_Main {
    public static void main(String[] args) {
        /**
         * - 스트림(Stream) : 물길이 일자로 쭉 이어지는 것을 연상하면 됨
         *   >> 특정 대상에 송수신을 할 수 있도록 처리
         *
         * InputStream : 입력(input) / 수신(receive) / 읽기(read)
         * OutputStream : 출력(output) / 송신(send) / 쓰기(write)
         *
         * 특정 사용처 : 네트워크 송수신, 파일 읽기쓰기
         */

        // 상대경로 : 현재 위치를 기준으로 측정하는 경로(./ 현재위치, ../ 상위위치)
        // ./~
        //
        // 절대경로 : 절대적 위치를 기준으로 측정하는 경로
        // 윈도우 : C:\~~
        // 맥 : /Users/~

        // C언어 : fopen("파일 경로", '읽기/쓰기모드 결정')  >> 파일이 열림
        // 자바 : 파일 존재여부, 권한 등만 관리, 즉, 파일이 열린 상황이 아님
        File file = new File("./text.txt");

        if(!file.exists()) { // 파일 존재 여부 확인 > 없을수도 있기 때문에...
            // 없으면 만들어준다? > 흐름제어 디펜스 코드
            return; // 종료한다? > 실패처리 디펜스 코드
        }

        // 기타명령
        // 명령연결 : 버티컬바(|)는 앞에 명령이 성공 여부와 관계없이 실행
        //           앤드마크(&)는 앞에 명령이 반드시 성공해야 다음 명령 실행
        //
        // (소켓열림여부) linux$ netstat
        // (실행된 명령에서 특정 문구 존재여부 확인) linux$ grep '문자열'
        //   e.g. rpm -qa | grep '패키지명'   >> 특정 패키지가 설치되어있으면 그 문구를 출력
        //
        // 파일에 대한 권한 확인
        // - 권한 : 파일에 대한 접근 제어
        //   (권한부여)  linux$ chmod 777 파일  >> (차례대로 R:4, W:2, X:1)
        //   (소유자변경)linux$ chown 파일
        //   (권한확인)  linux$ ls -al
        //   drwxrwxrwx 1 pi pi 5720 Jul  3 20:06 a.out
        //   d          rwx         rwx       rwx
        //   디렉토리?   소유자권한    그룹권한    타사용자권한
        //   >> 그룹 권한
        //   >> 사용자 권한
        //   >> 소유자 권한
        if(!file.canRead()) { // 읽기 가능?
            return;
        }
        if(!file.canWrite()) { // 쓰기 가능?
            return;
        }
        if(!file.canExecute()) { // 실행 가능?
            return;
        }

        InputStream in = null;
        OutputStream out = null;

        // file.canRead() 가 true 여야 함
        try {
            in = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            // 대안적 처리 방법 제공
        } catch (SecurityException e) {
            // 대안적 처리 방법 제공
        }

        // file.canWrite() 가 true 여야 함
        try {
            out = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            // 대안적 처리 방법 제공
        } catch (SecurityException e) {
            // 대안적 처리 방법 제공
        }

        // 스트림이 잘 생성되었는지 확인
        if(in == null || out == null) {
            return;
        }

        // 버퍼없이 읽는 방법
        int[] buffer = new int[1024];
        int i = 0;
        int l = 0;
        do {
            try {
                l = in.read();
            } catch (IOException e) { }

            if(l > -1) {
                buffer[i++] = l;
            }
        } while(l > -1);

        // 버퍼에 담아서 가져오는 방법
//        byte[] buffer = new byte[1024];
//        int offset = 0;
//        int readLength = 8;
//        while(in.read(buffer, offset, readLength)) {
//            offset += readLength;
//        }

//        out.write();

        // 남은 데이터 비우기
        try {
            out.flush();
        } catch (IOException e) {
        }

        // 사용 후 스트림 닫기
        try {
            in.close();
        } catch (IOException e) {
        } finally {
            in = null;
        }

        // 사용 후 스트림 닫기
        try {
            out.close();
        } catch (IOException e) {

        } finally {
            out = null;
        }

        // 결과적으로 흐름은 이렇다.
        // 1. 파일의 존재 여부 확인(java.io.File 클래스)
        // 2. 파일에서 스트림 열기(java.io.InputStream, java.io.OutputStream 클래스)
        // 3. 스트림을 통해 입출력(java.io.InputStream, java.io.OutputStream 클래스)
        // 4. 스트림 닫기(java.io.InputStream, java.io.OutputStream 클래스)
    }
}
