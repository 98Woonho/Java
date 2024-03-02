import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import java.util.*;

public class MyTest {

    public static void main(String[] args) {

/*        정수를 입력 받고, 홀수인지 짝수인지 출력해주는 코드
        Scanner sc = new Scanner(System.in);

        System.out.print("정수를 입력하세요 : ");
        int a = sc.nextInt();

        if(a % 2 == 0) {
            System.out.println("짝수입니다.");
        }
        else {
            System.out.println("홀수입니다.");
        }  */

//        함수 사용
//        int sum = add(5, 3);
//        System.out.println(sum);

//    함수 선언과 정의
//    public static int add(int a, int b) {
//        int sum = a + b;
//        return sum;
//    }

//        배열 생성
//        int[] list = new int[5]; // 크기가 5인 배열 생성
//        double[] scores = {9.5, 10, 7.6}; // 초기값을 가지고 배열 생성
//        System.out.println(scores[0]);
//        list[0] = 5;
//        System.out.println(list[0]);

//        리스트 생성
//        List<Integer> arrayList = new ArrayList<>();
//        List<String> linkedList = new LinkedList<>();

//        arrayList.add(5); // 리스트에 요소 추가
//        arrayList.add(3);
//        arrayList.add(8);
//        linkedList.add("이운호");
//        linkedList.add("김도연");
//        linkedList.add("박해람");
//
//        int a = arrayList.get(0); // 인덱스 0의 요소에 접근
//        System.out.println(a); // 출력 : 5

//        String[] str = new String[5];
//        List<Integer> list1 = new ArrayList<>();
//        List<String> list2 = new LinkedList<>();
//
//        // add(element) : 리스트의 끝에 요소를 추가합니다.
//        list2.add("사과");
//        list2.add("바나나");
//
//        // add(index, element) : 지정된 인덱스에 요소를 추가합니다.
//        list2.add(1, "오렌지");
//        // ["사과", "오렌지", "바나나"]
//
//        // get(index) : 지정된 인덱스의 요소를 반환합니다.
//        String fruit = list2.get(0);
//        // "사과"
//
//        // set(index, element) : 지정된 인덱스의 요소를 새로운 값으로 대체합니다.
//        list2.set(1, "포도");
//        // ["사과", "포도", "바나나"]
//
//        // remove(index) : 지정된 인덱스의 요소를 삭제합니다.
//        list2.remove(1);
//        // ["사과", "바나나"]
//
//        // size() : 리스트의 요소 수를 반환합니다.
//        int size = list2.size();
//
//        // contains(object) : 지정된 요소가 리스트에 포함되어 있는지 여부를 확인합니다.
//        boolean contains = list2.contains("사과");
//        // true
//
//        // indexOf(object) : 지정된 요소의 첫 번째 인덱스를 반환합니다. 요소가 리스트에 없으면 -1을 반환합니다.
//        int index1 = list2.indexOf("바나나"); // 1
//        int index2 = list2.indexOf("포도"); // -1
//
//        // isEmpty() : 리스트가 비어 있는지 여부를 확인합니다.
//        boolean isEmpty = list2.isEmpty(); // false
//
//        // clear() : 리스트의 모든 요소를 삭제합니다.
//        list2.clear(); // []

    }
}



class Person {

//    매개변수 선언
    private String name;
    private int age;

//    매개변수를 받는 생성자
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

//    매개변수를 받지 않는 기본 생성자
    public Person() {
        this.name = "Unknown";
        this.age = 0;
    }

//    출력 메서드
    public void Display() {
        System.out.println("이름 : " + name);
        System.out.println("나이 : " + age);
    }

    public static void main(String[] args) {
        Person person1 = new Person("이운호", 24);
        Person person2 = new Person();

        person1.Display();
        person2.Display();
    }
}