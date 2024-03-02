package Java;

public class test {
    public static void main(String[] args) {
        // 변수 참조
//        System.out.println(Car.wheel); // 클래스 변수는 객체를 생성하지 않아도 참조 가능
        // System.out.println(Car.speed); // 인스턴스 변수는 객체를 생성해야 참조 가능 (오류 발생)

        /* ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ */
        // 클래스 변수, 인스턴스 변수

//        Car myCar1 = new Car();
//        Car myCar2 = new Car();
//
//        System.out.println("<변경 전>");
//        System.out.println("myCar1.speed:"+myCar1.speed);
//        System.out.println("myCar2.speed:"+myCar2.speed);
//        System.out.println("myCar1.wheel:"+myCar1.wheel);
//        System.out.println("myCar2.wheel:"+myCar2.wheel);
//
//        myCar2.speed=100;
//        myCar2.wheel=5;
//
//        System.out.println("<변경 후>");
//        System.out.println("myCar1.speed:"+myCar1.speed);
//        System.out.println("myCar2.speed:"+myCar2.speed);
//        System.out.println("myCar1.wheel:"+myCar1.wheel);
//        System.out.println("myCar2.wheel:"+myCar2.wheel);

        // myCar2의 wheel을 5로 바꾸었지만, myCar1의 wheel도 5로 바뀜. why?
        // 클래스 변수(static 변수)는 여러 객체가 생성이 되어도 동일한 주소값을 가지고 있음. 그래서 클래스 변수(static 변수)를 '클래스명.클래스 변수' 로 참조할 수 있는 이유임.

        /* ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ */
        // 객체 배열
//        Aclass ar[] = new Aclass[3];
//        // ar[0].x = 100;
//        // ar[0].f1(); // NullPointerException 오류 발생. 객체 배열을 만들었지만, 각각의 index의 객체화를 하지 않았기 때문.
//
//        ar[0] = new Aclass(); // 0 index 객체화
//        ar[0].x = 100;
//        ar[0].f1();
//
//
//        Animal animals[] = new Animal[3];
//        for (int i = 0; i < animals.length; i++) {
//            animals[i] = new Animal();
//        }
//
//        animals[0].kind = "고양이";
//        animals[0].name = "나르";
//        animals[0].age = 1;
//
//        animals[1].kind = "강아지";
//        animals[1].name = "초코";
//        animals[1].age = 3;
//
//        animals[2].kind = "고양이";
//        animals[2].name = "니코";
//        animals[2].age = 1;
//
//        for (int i = 0; i < animals.length; i++) {
//            animals[i].info();
//        }

        /* ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ */
        // 생성자
//        new Bclass(); // 생성자 호출
//        new Bclass(5);

        /* ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ */
        // 상속
//        Student student = new Student();
//        student.eat();
//        student.say(); // 오버라이드 해서 Student class에 있는 say() 호출

        // 클래스 앞 final 키워드가 있으면 다른 클래스가 상속 불가능

        // 자식 클래스에서 생성자 호출 시, 부모클래스의 디폴트 생성자가 자동으로 호출되기 때문에, 부모의 디폴트 생성자가 존재해야 한다.

        /* ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ */
//        // 다형성 : 한 가지의 타입이 여러 가지 형태의 인스턴스를 가질 수 있는 것
//        // 업 캐스팅 : 자식 클래스의 객체가 부모 클래스의 참조 변수로 형 변환 되는 것
//        Human h1 = new Student2("이운호", 26, "코딩", 3);
//        h1.info();
//        // h1.study(); // 부모 클래스에는 study 메서드가 없으므로 호출 불가능. 그럼 왜 info()는 자식 클래스에서 호출이 되었나?
//        // 동적 바인딩 : 컴파일 시점에서는 부모 객체로 인식 하다가 런타임에서 자식 객체로 인식을 하기 때문에 자식의 info()가 호출 됨.


        /* ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ */
        // 추상 메서드 : 선언부만 정의하고 구체적인 내용은 비워 놓는 메서드. 구현은 자식 클래스가!


        /* ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ */
        /**
         * 인터페이스 : 여러 클래스간에 공통되는 조건이나 규격이 존재할 때 그러한 조건과 규격을 명시해 놓은 것
         * 인터페이스로 객체 생성 불가능
         * 인터페이스 내 멤버 메서드는 abstract (생략 가능)
         * 인터페이스 내 멤버 변수는 final (생략 가능)
         * implement로 상속 가능
         */
    }
}

class Car {
    static int wheel = 4; // 클래스 변수
    int speed; // 인스턴스 변수
}

class Aclass {
    int x;
    void f1() {
        System.out.println("f1() : " + x);
    }
}

class Animal {
    String kind;
    String name;
    int age;
    void info() {
        System.out.println("kind : " + kind);
        System.out.println("name : " + name);
        System.out.println("age : " + age);
    }
}

class Bclass {
    public Bclass() {
        System.out.println("Bclass 기본생성자");
    }

    // 생성자 오버로딩
    public Bclass(int a) {
        System.out.println(a);
    }
}

class Person {
    void breath() {
        System.out.println("숨쉬기");
    }
    void eat() {
        System.out.println("밥먹기");
    }
    void say() {
        System.out.println("말하기");
    }
}

class Student extends Person { // 상속
    void learn() {
        System.out.println("배우기");
    }
    @Override
    void say() {
        System.out.println("발표하기");
    }
}

class Teacher extends Person { // 상속
    void teach() {
        System.out.println("가르치기");
    }
}

/* 부모와 자식의 생성자 관련 오류
class Car2 {
    int wheel;
    int speed;
    String color;

    Car2(String color) {
        this.color = color;
    }
}

class SportsCar extends Car2 {
    int speedLimit;
//    SportsCar(String color, int speedLimit) { // 부모의 디폴트 생성자가 없기 때문에 오류 발생
//        this.color = color;
//        this.speedLimit = speedLimit;
//    }

    // 위 오류 해결 방법
    SportsCar(String color, int speedLimit) {
        super(color); // 부모 클래스 생성자 호출
        this.speedLimit = speedLimit;
}
*/

class Human {
    String name;
    int age;
    String hobby;
    public Human(String name, int age, String hobby) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
    }
    void info() {
        System.out.println("name : " + name);
        System.out.println("age : " + age);
        System.out.println("hobby : " + hobby);
    }
}

class Student2 extends Human {
    int grade;

    public Student2(String name, int age, String hobby, int grade) {
        super(name, age, hobby);
        this.grade = grade;
    }
    void info() {
        super.info();
        System.out.println("grade : " + grade);
    }

    void study() {
        System.out.println("공부하는 중 입니다.");
    }
}