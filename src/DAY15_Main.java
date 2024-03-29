public class DAY15_Main {
    public void main(String[] args) {
        /**
         * - 프로세스(Process) : 프로그램의 단위
         *   >> OS는 한 개 프로그램을 열 때마다 1개 프로세스를 생성
         *      이 프로세스에 id 매겨줌 => pid(process id)
         *   >> CPU 연관 필요 : CPU는 유한, 프로세스당 처리 시간을 공정하게 분배해야함
         *      OS를 공부해보면 다양한 공정한 시간 분배 알고리즘(e.g. 라운드로빈)을 알 수 있음
         *      CPU를 공부해보면 코어(Core), 스레드(Thread) 갯수를 명시해주는 것을 알 수 있음
         *      보통은 CPU 코어당 성능 vs 코어당 성능이 떨어지지만 코어의 수 증가
         *
         *  CPU : Central Processing Unit (Similar. GPU, Graphic Processing Unit)
         *        (ALU + Register + ...)            (ALU + ...)
         *        ALU? Arithmetic and Logic Unit
         *        ALU가 핵심(컴퓨터는 모든게 숫자/수치/산술로 동작)
         *
         *        e.g.
         *        MySQL DB : 싱글코어 동작 >> 코어하나당 성능이 높으면 유리
         *        Some DB : 멀티코어 동작 >> 코어가 많을수록 유리
         *
         * - 스레드(Thread) : 프로세스를 나누어 루틴을 처리하는데 사용하는 방법
         *   >> 관리 방법 : 직접 생성을 통한 스레드 관리 vs Pool을 통한 스레드 자동 관리
         *   >> 그럼 스레드를 많이 나눠도 상관은 없네요? 스레드는 컨텍스트 스위칭(Context Switching)을 통해 동작
         *      컨텍스트 스위칭? 스레드가 자기정보를 CPU에 올리는 일
         *      예를 들어, 스레드가 2개 있을 때, A스레드가 동작위해서 자기자신의 정보를 CPU 탑재해서 동작
         *      B스레드도 이 순간에 또 같이 동작을 해야한다면, CPU에 다시 자기자신의 정보를 CPU 탑재 후 동작
         *      이 과정이 반복(CPU는 한번에 하나만 처리 가능, 시간 단위로 잘라서 두 스레드에게 처리 시간 제공)
         *      ==>> 너무 많을 경우 오히려 느려질 수 있음
         *   >> 생성 기준 : 필요한 처리가 있을 때만 생성하고 처리 후 제거
         *   >> 프로그램 최초 동작 시 최소 1개의 스레드를 생성(프로그램 종료까지 살아남음) => UI스레드/메인스레드라고 함
         *      백그라운드(뒤에서 동작) 스레드를 필요 시 생성 및 사용 후 제거
         *      그럼 백그라운드 스레드를 사용할 필요가 있나요? UI스레드에서 어떤 특정한 처리로 인해 바빠서 UI를 갱신할 수 없음,
         *                                               "렉(Lack)걸렸다" 또는 "멈췄네?/죽었네?" 같은 현상 발생
         *                                               그래서, 백그라운드 스레드로 이 작업을 뒤에 안보이는 곳으로 분리/처리
         *   >> 여러 개의 처리를 동시에 하기위해서 사용해야만 함
         *
         *   >> +@ 코루틴(Coroutine) : 스레드를 다시 쪼개서 처리를 동시에 하는 방법(스레드가 더 필요할 경우 자동으로 생성 후 사용/제거)
         *      Java에서는 지원하지 않음 / Kotlin에서는 지원 => 언어적인 환경 + OS 수준에서 지원해줘야 함
         *      컨텍스트 스위칭없이 동작
         *   >> +@ 소프트웨어 다운로드받을 때 safe vs unsafe 문구 : 싱글 스레딩(safe) vs 멀티 스레딩(unsafe)
         *   >> 스레드에 고급 기술 : 스레드 간에 간단하게 데이터 공유 가능 => 뮤텍스(Mutex)/세마포어(Semaphore)
         *      프로세스 간에 간단하게 데이터 공유는 불가 => IPC 통신(Inter-Process Communication)으로 프로세스간 데이터 공유
         *      그럼 그냥 공유하면 되는거 아닌가요? 동시 접근의 문제때문에 데이터(변수)에 대한 접근제어 기술을 사용해야함
         *      Java에서는 synchronized 키워드(동기화 처리)를 제공해서, 뮤텍스/세마포어 없이 할 수 있게 해줌
         *      단, 성능이 좋지 않음(남발 시 스레드로 분리한 이유가 없어짐 => 뮤텍스/세마포어 로 처리)
         *      + volatile 키워드는 변수를 '메인 메모리에 저장' 할 것을 명시하기 위해 사용한다. (공유되는 변수에서 사용)
         *
         *   >> 부모 스레드 / 자식 스레드 : 어떤 스레드가 새로운 스레드를 생성하면, 자식 스레드를 가짐
         *      자식 스레드가 있어도, 자식 스레드가 전혀 분리되어 동작하기 때문에, 부모 스레드는 종료되어버리는 문제 => join() 사용
         */

        // 스레드 생성 및 실행 방법 #1
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // 스레드에서 처리할 내용
            }
        });
        // 이 스레드가 끝날 때까지 현재 스레드가 끝나지 않도록 대기시킴
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread.start();// run 실행

        // 불가 => 스레드는 종료된 이후 재사용 불가
//        thread.stop();
//        thread.start();

        // 스레드 생성 및 실행 방법 #3 => 99% 이런식으로 사용안함, super.run이 어디로 가느냐에 따라 동작이 달라질 수 있음
        CustomThread threadWithRunnable = new CustomThread(new Runnable() {
            @Override
            public void run() {

            }
        });
        threadWithRunnable.start();

        // 멀티 스레드 동작
        Thread thread2 = new Thread(new Runnable() {
            // 종료 여부 결정 플래그
            boolean isActive = true;
            @Override
            public void run() {
                while(isActive) {
                    // 처리

                    // !!주의!! 잠들기 전(대기상태로 가기전)에 깨워줄(활성 상태로 전환해줄) 스레드를 반드시 시작시킬 것
                    // 데드락(Dead Lock) : 멈춘 상태
                    thread3.start();
                    try {
                        // 잠들기 => 대기 상태
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    // 현재 동작 중인 스레드는 무엇? run 메소드와 관계없음
                    Thread.currentThread();

                    // 스레드를 밀리초동안 잠듬(대기 상태)
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        thread2.start();

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                // 깨우기 => 활성 상태
                thread2.interrupt();
            }
        });
    }

    Thread thread2;
    Thread thread3;

    // 스레드 생성 및 실행 방법 #2
    class CustomThread extends Thread {
        CustomThread(Runnable runnable) {
            super(runnable);
        }
        @Override
        public void run() {
            super.run();
            // 스레드에서 처리할 내용
        }
    }

    // synchronized 메소드 : 동기화되어서 동작하는 메소드
    // 이 메소드는 두 스레드가 동시에 실행 불가 => 둘 중 하나씩 차례로 실행 가능
    synchronized void method() { }

    // DCL : Double Checked Lock
    // 싱글톤(Singleton) 패턴 : 객체를 여러 개 생성하지 않고, 딱 하나만 생성해서 사용하는 패턴
    // 싱글톤 객체를 여러 스레드가 동시에 가져올 때, synchronized 를 호출할 때마다 느려질 수 있음 => DCL로 완화
    static Object lock = new Object();// Locking 용 ==>> 이런 식으로 하면, 프로그램이 시작되자마자 이 객체 생성
    static Object instance = null;// 싱글톤 객체
    Object getInstance() {
        // 멀티스레딩에서 싱글톤 객체 사용하는 방법
        // 싱글스레딩에서는 이런 방법으로 구현할 필요가 없음 => 이렇게 구현한다면 오히려 성능 저하

        // 이렇게 안하고 그냥 객체 생성해놓고 쓰면 안되나요?
        // 됩니다만은, 실제로 이 객체를 사용하기 전이라면, 불필요한 메모리 공간 차지
        if(instance == null) {// NULL 이면 객체 생성 필요
            synchronized (lock) {// 생성 과정을 동기화 처리
                if(instance == null) {// 처리 후 실제로 NULL인지 체크를 한번 더 처리
                    instance = new Object();
                }
            }
        }
        return instance;
    }

    // DCL 형태 #2
    void methodByInstance() {
        if(instance == null) {
            return;
        }

        synchronized (lock) {
            if(instance != null) {
                // 원하는 처리
            }
        }
    }
}
