import java.math.BigInteger;
import java.util.*;

public class DAY4_Main {
    public static void main(String[] args) {
        /**
         * 기본 자료형의 크기 결정 요소
         *
         * - 32Bit : 2^5
         * - 64Bit : 2^6
         *
         * int,
         * double
         *
         * 설치한 환경 : Java라면 가상머신을 X비트 설치했을 때에 그 사이즈를 따라감
         */

        /**
         * 배열(Array)과 컬렉션(Collection)
         *
         * - 배열 : 변수를 한번에 '일자'로 선언하는 것
         *   >> 메모리에 일자로 n 개를 사용 예약 >> TYPE_SIZE * n = m 바이트
         *   >> 시작값 위치 : 배열은 0번째부터 시작
         *   >> 종료값 위치 : (배열.length - 1) 에서 종료
         *
         * [TYPE][] [NAME] = new [TYPE][LENGTH];
         *
         */
        int length = 4;
        int[] array = new int[length];

        // 배열의 값을 저장하는 방법
        // ==> array 라는 배열 객체의 i번째 위치에 값을 변경
        array[0] = 4;
        array[1] = 3;
        array[2] = 2;
        array[3] = 1;

        int arrayLength = array.length; // == Integer.BYTES * length
        for( int i = 0 ; i < arrayLength ; i++ ) {

            // 배열의 값을 꺼내오는 방법
            // ==> array 라는 배열 객체에서 i번째 위치의 값을 꺼내옴
            int element = array[i];

            System.out.println(element);
        }

        /**
         * - 자료구조(Data Structure) : 자료를 원하는 형태로 저장하여 구성하여 메모리 공간을 효율적으로 활용할 수 있게 함
         *   >> 스택(Stack) : LIFO(Last-Input First-Out) => 마지막에 들어갔던게 먼저 나옴(바닥이 막힌 컵에서 물건 꺼내려면?)
         *   >> 큐(Queue) : FIFO(First-Input First-Out) => 처음 들어갔던게 먼저 나옴 (바닥이 뚫린 컵에서 물건을 꺼내려면?)
         *   >> 데크(Dequeue) : 앞뒤로 입출력 다 되는 구조
         *   >> 리스트(List) : 다음 요소의 위치 + 현재 값을 갖는 구조
         *      ㄴ 링크드리스트(LinkedList) : 다음 요소(노드)의 위치 값만 갖고 있음
         *      ㄴ 더블링크드리스트(DoubleLinkedList) : 이전 요소의 위치 값 + 다음 요소의 위치 값을 갖고 있음
         *      +@ 반복자(Iterable/Iterator) : 값 접근에 대해 순차적으로 접근할 수 있도록 제공되는 기능
         *      >> +@ 셋(Set) : 값을 중복적으로 가지지 않는 리스트(DB 기능 중 distinct 와 동일, 중복제거용)
         *         ㄴ HashSet
         *         ㄴ TreeSet
         *   >> 테이블/맵(Table) : 키-값(Key-Value) 이 1:1로 매핑(Mapping)되는 구조(Key만 중복 불가)
         *   >> 그래프 : 트리, ...
         *
         * - 자료구조 성능 측정(빅오, )
         *   >> 최악 : 가장 늦게 찾는 상황
         *   >> 평균 : 일반적으로 찾아진 상황
         *   >> 최선 : 가장 빨리 찾을 수 있는 상황
         *
         * - 컬렉션(Collection) : 특정한 자료구조를 활용해서 메모리 공간에 저장하는 모음(?) ==> Java에서 부르는 자료구조
         *   >> 값의 자료형은 클래스여야 할 것
         */

        // 랩퍼 클래스 (Wrapper Class) : 무언갈 감싸는 클래스
        // 기본 자료형은 클래스로 취급이 되지 않음 <---> 자바의 모든 것은 모두 객체임, 클래스에 의해서 만들어진게 객체임
        // 의문점 : 모든게 객체면 기본자료형도 객체아닌가? ==> 기본 자료형은 불완전한 객체로 취급
        // Byte         == byte
        // Short        == short
        // Integer      == int
        // Long         == long
        // Float        == float
        // Double       == double
        // Character    == char
        // Boolean      == boolean
        // BigInteger : 매우 큰 숫자를 다루는 클래스
        // BigDecimal : 매우 작은 숫자를 다루는 클래스(소수점)
        // String은 기본 자료형인가? 엄밀히 말하면 아님, 그러나, 그에 준하는 대우정도(언어 수준에서 리터럴 값이 있음)
        //  기본자료형 int = 0;
        //  문자열은? String = "";
        //  일반적인 객체 : new ();

        // stack의 기능 : push 값입력, pop 값출력
        Stack<Integer> stack = new Stack<>();
        stack.push(10); //값 입력
        stack.push(11);
        int pop = stack.pop(); //값을 제거하면서 값 출력
        int peek = stack.peek(); //값은 그대로 두면서 값 출력, Java 한정

        // queue의 기능 : enqueue 값입력, dequeue 값출력
        // 이렇게 아님
        // Queue<Integer> queue = new Queue<>() { }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);// enqueue
        queue.add(11);
        //queue.offer();
        int dequeue = queue.poll();// dequeue
        peek = queue.peek();

        // 리스트는 리스트인데, 배열처럼 값 관리, 평균적으로 잘 동작 => 빠르지도 느리지도 않음
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(10);// 값 입력
        arrayList.add(11);
        arrayList.add(12);
        int value = arrayList.get(0);// 값 접근(삭제안함)
        arrayList.remove((Object)11);// 값을 줘서 삭제하는 방법
        arrayList.remove(1);//위치 값으로 삭제하는 방법

        // 부가 지식.....
        // 사물(Object), 개체(Entity), 객체(Instance), ...
        //   >> Object : 가장 큰 개념, 어떠한 무언가에 대해서, 물체가 될 수도, 사람이 될수도, ...
        //   >> Entity : Database
        //   >> Instance : 메모리 상에 존재하는 object
        // 전공자가 아니거나 전공자라도 한국사람이라면 어떻게 들어야할까?
        //   >> 다 똑같은 말
        //
        // Object? 최상위 클래스, 모든 클래스는 Object로부터 만들어짐
        //   >> Object는 모든걸 담을 수 있음

        // 자료구조에서의 list

        List<Integer> list = new LinkedList<>();
        // LinkedList<Integer> list = new LinkedList<>(); 도 가능하지만, 나중에 코드를 변경할 때 더 쉽게 유연성을 유지하기 위해, 인터페이스인 List로 객체를 선언하는 것이 좋음.
        list.add(10);// 값 입력
        list.add(11);
        list.add(12);
        value = list.get(0);// 값 접근(삭제안함)
        list.remove((Object)11);// 값을 줘서 삭제하는 방법
        list.remove(1);//위치 값으로 삭제하는 방법

        // Set
        Set<Integer> set = new HashSet<>();
        // 위와 마찬가지로, 클래스인 HashSet으로 객체를 선언하기 보다, 인터페이스 Set으로 선언하는 것이 좋음.
        list = List.copyOf(set);// Set > List 변환
        list = new LinkedList<>(set);// Set > List 변환
        list = new ArrayList<>(set);// Set > List 변환

        // Table/Map
        Map<String, Integer> map = new HashMap<>();
        map.put("Key1", 10);// 값 입력
        map.put("Key2", 11);
        // 지원안함, 언어 수준에서 인덱서(Indexer) 기능이 있어야 함
        //Integer a = map["Key1"];
        value = map.get("Key1");// 값 접근(삭제안함)
        map.remove("Key1");// 키를 기준으로 값 삭제

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
}
