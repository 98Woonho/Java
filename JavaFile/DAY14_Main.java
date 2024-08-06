import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class DAY14_Main {
    public static void main(String[] args) {
        /**
         * - 네트워크(Network) : 망, 거미줄처럼 엉켜있지만, 연결되어있음
         *
         *   >> 인터네트워크(Inter-Network) : 광범위(외부적으로도) 연결
         *   >> 인트라네트워크(Intra-Network) : 내부적으로만 연결
         *
         * - 네트워크 통신(Communication) : 사용자 기기와 다른 타 기기를 연결해서 데이터를 주고 받는 것
         *
         * - 네트워크 통신에 사용되는 주소
         *
         *   >> MAC주소 : 물리적 주소
         *   >> IP주소 : 논리적 주소
         *   >> Port번호 : 프로그램 구분 번호(Socket 구분 번호)
         *
         * - OSI7계층 / TCP/IP Protocol
         *
         *   >> OSI7 계층(ISO) : 네트워크 통신에 있어서의 단계를 계층으로 표기한 것
         *   >> TCP/IP 프로토콜(미국방성) : 네트워크 통신에 있어서의 단계를 계층으로 표기한 것
         *
         * - OSI7 계층
         *
         *   >> 물리(Physical, == NetworkInterface, L1) : 전기적 송수신(장치 : 케이블, NIC, 무선송수신장치)
         *   >> 데이터링크(DataLink, == NetworkInterface, L2, Hub/Switch) : MAC 주소 기준으로 가까이에 있는 장치 구분(ARP)
         *   >> 네트워크(Network, == Internet, L3, Router) : IP 주소 기준으로 눈에 보이지 않는(원격) 장치 구분(IP)
         *   >> 트랜스포트(Transport, == Transport, L4, Firewall) : Port 번호 기준으로 장치 내 프로그램(소켓) 구분(TCP, UDP)
         *   >> 세션(Session, == Application, L5) : 연결 완료
         *   >> 프레젠테이션(Presentation, == Application, L6) : 인코딩/디코딩, 암호화/복호화
         *   >> 애플리케이션(Application, == Application, L7) : 사용자 화면에 보이는 모든 것
         *
         * - 네트워크 디자인에서 네트워크 통신 시 주의사항
         *
         *   >> NAT(AP, Router) : 내/외부 네트워크 분할 => 장치가 없는데도 안되는데요? 서브네팅(IP분할 + 서브넷마스크)
         *   >> 방화벽(Firewall) : PC/기기 안에서 함부로 접근 불가하도록 처리하는 소프트웨어 장치
         *                        (Port 번호, 프로그램 등을 단위로해서 접근 유무 처리)
         *                        기기 외부에서 처리하는 경우 하드웨어 장치
         *   ==> IP 대역, Subnet Mask 확인해서 통신 가능한지 확인
         *   ==> 방화벽에서 Port 번호가 열려있는지(허용되어있는지) 확인
         *   ==> 이런 내용을 잘 모르겠다고 했을 때, 되는지 확인하는 방법? 소켓 작성 후 연결 요청
         *
         * - 통신 층(Tier)
         *   >> 2-tier : Client/Server, 기기/SW(물리/논리) 2개
         *   >> 3-tier : Client + WAS(Web Application Server) + 웹(HTTP) 서버, 기기/SW(물리/논리) 3개
         *   >> 4-tier : ..., 기기/SW(물리/논리) 4개
         *   >> ...
         *
         * - 소켓(Socket) : OS에서 NIC(Network Interface Card)에 접근할 수 있도록 제공해주는 API
         *   >> NIC? 네트워크에 접속되는 장치(유선/무선, Ethernet, Wi-Fi, Bluetooth, Zigbee, UWB, ...)
         *   >> 팁 : 소켓은 일정시간동안 단 1비트라도 데이터를 주고 받지 않으면, 연결이 끊긴 것으로 간주한다.
         *   >> 모든 프로그래밍에서 사용되는 개념, OS에서 해주기 때문에 과정이 동일할 수 밖에 없음
         *
         * - 소켓 유형
         *   >> TCP : 연결 확립해서 통신(connect/disconnect 과정이 있음)
         *   >> UDP : 연결 확립없이 통신(connect/disconnect 과정이 없음) == Datagram
         *
         * - 소켓 데이터 송수신 과정
         *   소켓 생성 > OS에 소켓 연결(bind) > 소켓 연결 요청/시작(connect) > 소켓 데이터 송수신 > 소켓 연결 종료(diconnect)
         *
         * - 소켓 종류(소켓 통신 == C/S 통신, 2-Tier 통신)
         *   >> Server(대기 측) : 클라이언트 연결을 대기하다가, 클라이언트가 연결이 되고난 후 데이터 송수신 및 종료, 이후 계속 대기
         *   >> Client(연결 측) : 서버에 연결 요청을 해서, 연결이 되고난 후 데이터 송수신 및 종료
         *
         * - 소켓에서 예약된 Port 번호 (1024개, 1~1023번까지 예약되어있음)
         *   >> 20, 21 : FTP(파일 송수신)
         *   >> 22 : SSH(원격 보안 쉘, 명령프롬프트)
         *   >> 23 : Telnet(원격)
         *   >> 25 : SMTP(메일)
         *   >> 80 : HTTP(웹)
         *   >> 443 : HTTPS(보안 웹)
         *
         *   ==> 소켓 개발 시 권장되는 Port 번호 : XXXXX 이상 사용(~ 65535까지, 2^16)
         *   ==> 겹치면? 둘 중 하나는 사용 불가, 그래서 변경 가능하도록 제시 필요
         *
         * 소켓 생성 (-> TCP면 연결) -> 데이터송수신 (-> Java에서는 모두다 종료과정 있지만, 일반적으로는 TCP면 연결종료) -> 종료
         */

        // 클라이언트용 TCP 소켓 : 클라이언트 또는 서버라고 구분함
        Socket tcp;
        try {
            // IP주소 : 예약된 IP주소 또는 목적지 주소
            // (예약)0.0.0.0 : 아무 주소나 허용
            // (예약)127.0.0.1 : 루프백(Loopback) 주소라고도 함, 나 자신에게 보내는 주소, NIC까지 도달 후 돌아옴
            // (예약)localhost : 나 자신에게 보내는 주소, 가상의 주소
            // 000.000.000.000 : 형식에 맞춰서 작성된 목적지의 주소
            // ==> 이 주소를 모르면요? 통신 불가, 우리 일상에서 봤을 때 상대방의 주소를 모르면 우편을 보낼 수 있는가?
            tcp = new Socket("IP주소", 0);// 이렇게 작성할 경우 내부적으로 bind() + connect() 호출
            // bind() : OS에 연결( OS 연결 여부 확인 tcp.isBound() )
            // connect() : 목적지에 연결 요청
        } catch (IOException e) {// 연결 실패
            throw new RuntimeException(e);
        }

        // InputStream + BufferedInputStream(Output 동일) : 바이트 단위로 송신
        // InputStream + InputStreamReader + BufferedReader(Output 동일) : 행(\r\n 또는 \n) 단위로 송신
        BufferedReader is;
        BufferedWriter os;
        try {
            is = new BufferedReader(new InputStreamReader(tcp.getInputStream()));
            os = new BufferedWriter(new OutputStreamWriter(tcp.getOutputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 수신
        StringBuffer sb = new StringBuffer();
        String str;
        try {
            while((str = is.readLine()) != null && tcp.isConnected()) {
                sb.append(str);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 송신
        if(tcp.isConnected()) {
            try {
                os.write("문자열");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // 수신 종료
        try {
            is.close();
        } catch (IOException e) { }

        // 송신 종료
        try {
            os.close();
        } catch (IOException e) { }

        // 통신 종료, 통신이 종료되었는지 tcp.isClosed()
        if(!tcp.isClosed()) {
            try {
                tcp.close();// == disconnect();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        // 서버용 TCP 소켓
        ServerSocket serverSocket;
        try {
            // 클라이언트 TCP가 연결 요청을 할 때 요청을 들을 Port 번호
            serverSocket = new ServerSocket(8080);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if(!serverSocket.isBound()) {
            try {
                serverSocket.bind(createSocketAddress("0.0.0.0", 8080));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // listen 메소드가 있는 경우가 있음 : 클라이언트 소켓이 연결 요청하는 것에 대해 듣기 시작하는 함수

        // 클라이언트 TCP 소켓 연결 요청 허용
        // 프로그래머가 적절한 시기를 결정하거나 사용자에게 그렇게 할 수 있도록 제공하는 플래그 변수
        boolean isActiveServer = true;
        try {
            // 연결 요청 허용에 대한 처리
            do {
                Socket clientSocket = serverSocket.accept();

                // 송수신 처리

            } while(isActiveServer);
        } catch (IOException e) { }

        // 서버 TCP 소켓 종료
        if(!serverSocket.isClosed()) {
            try {
                serverSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // UDP 소켓 : 클라이언트 또는 서버라고 구분하지 않음
        DatagramSocket udp;
        try {
            udp = new DatagramSocket();
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }

        // OS에 연결 : receive할 때의 주소와 포트번호
        if(!udp.isBound()) {
            try {
                udp.bind(createSocketAddress("0.0.0.0", 8080));
            } catch (SocketException e) {
                throw new RuntimeException(e);
            }
        }

        // 송신
        // UDP 소켓 생성자에서 주소나 포트주소를 넣지 않는 이유는?
        // 연결/종료 과정이 없기 때문
        String udpStr = "Hello, World";
        byte[] strBytes = udpStr.getBytes(StandardCharsets.UTF_8);
        DatagramPacket packet = new DatagramPacket(strBytes, strBytes.length);
        // IP주소
        byte[] ipv4Address = new byte[]{ (byte)192, (byte)168, 0, 1 };
        try {
            packet.setAddress(InetAddress.getByAddress(ipv4Address));
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        packet.setPort(0);
        try {
            udp.send(packet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 수신
        byte[] receiveBuf = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveBuf, receiveBuf.length);
        try {
            udp.receive(receivePacket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 여기서의 close는 disconnect가 아님
        if(!udp.isClosed()) {
            udp.close();
        }
    }

    static SocketAddress createSocketAddress(String ip, int port) {
        InetAddress ipAddress = null;
        try {
            ipAddress = InetAddress.getByName(ip != null? ip : "0.0.0.0");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        return new InetSocketAddress(ipAddress, port);
    }
}
