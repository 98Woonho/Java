public class DAY10_Main {
    public static void main(String[] args) {
        /**
         * 클래스(Class)
         *    ㄴ 생성자(Constructor)
         *    ㄴ 인스턴스 변수(Instance variable) / 동적 변수(Dynamic) / 속성(Properties/Attribute) / 멤버변수(Member Variable) / 필드(Field)
         *        ㄴ 접근자(Getter)
         *        ㄴ 설정자(Setter)
         *    ㄴ 인스턴스 함수(Instance function) / 동적 함수(Dynamic) / 함수(Function) / 멤버함수(Member Function) / 메소드(Method)  ---- 오버로딩
         *    ㄴ 클래스 변수(Class Variable) / 정적 변수(Static Variable)
         *    ㄴ 클래스 함수(Class Function) / 정적 메소드(Static Method) ---- 오버로딩
         */

        /**
         * 다형성(Polymorphism) : A 클래스 > B, C, D, E, ... 등 형태로 자유롭게 변형될 수 있음
         *                       하나의 객체가 여러 가지 타입을 가질 수 있는 것
         *
         * >> has_a : A 는 B 를 갖는다. == 조합/결합(Composition)
         *
         * class A {
         *     B b;
         *     A(B b) {
         *         this.b = b;
         *     }
         * }
         *
         * >> is_a : A 는 B 다. == 상속(Inheritance)
         *
         * class A { }
         * class B extends A { }
         *
         * - 상속(Inheritance) : 부모/수퍼/베이스 클래스로부터 자식/서브/파생 클래스가 속성/메소드 등을 그대로 물려받는 기능
         *
         *   >> this : 클래스 자기자신을 가리키는 레퍼런스 + super : 부모 클래스 레퍼런스
         *   >> 오버라이드(Override) : 부모 클래스에 정의된 메소드를 재정의하는 것
         *
         * class [CHILD_CLASS_NAME] extends [PARENT_CLASS_NAME] {
         *
         * }
         *
         * - 추상화(abstract class, interface)
         */

        Child object = new Child();

        // 가능 : 상속을 받아왔기 때문, Child > Parent, Child는 Parent에 정의된 멤버를 모두 알고 있음(Child가 메모리 상 크기가 더 큼)
        Parent poly = object;
        // 불가능 : Parent > Child 가 될 수 없음, Parent는 Child에 정의된 멤버를 알 수 없음(Parent가 메모리 상 크기가 더 작음)
        // Parent를 상속받은 다른 객체가 있다면, 경우의 수가 늘어남...
        // object = poly;

        object.parentMethod();
        object.parentMethod(0);
        object.childMethod();

        poly.parentMethod();
        //poly.parentMethod(0);
        //poly.childMethod();


    }
}

class Parent {
    Parent() { /* ... 초기화 ... */ }

    int parentProp;
    int getParentProp() {
        return parentProp;
    }
    void setParentProp(int newValue) {
        this.parentProp = newValue;
    }

    // 메소드
    void parentMethod() { /* ... 코드 ... */ }
}
class Child extends Parent {
    // 생성자
    Child() {
        // ... 초기화 코드 작성 ...

        // 상속받은 자식 클래스 생성자에서의 의무(옵션같은 느낌(?))
        // 부모 클래스의 생성자를 호출해줘야 함
        super(); // Parent() { /* ... 초기화 ... */ } 을 호출함

        // ... 초기화 코드 작성 ...
    }

    // 속성 or 메소드

    @Override
    void parentMethod() {
        /// 여기에 추가적인 코드를 넣든지..

        // 의무 이면서, 옵션(?)이 될 수 있음
        // >> 호출을 해줄 수도, 안 해줄 수도 있다.
        //super.parentMethod();
        // 일반적으로는 약속된 것처럼 호출을 해줌
        // >> 오버라이드 했다는 것은 기존의 코드에 추가적인 코드를 작성하려고 하는게 대부분...
        super.parentMethod();

        /// 여기에 추가적인 코드를 넣든지..
    }

    void childMethod() {
        // 멤버 변수에 한해서 this와 super는 같다.
        // this.parentProp; == super.parentProp;

        // 메소드에서 this와 super는 다를 수 있다.
        // this.parentMethod(); != super.parentMethod();
    }

    // 오버로딩(오버라이딩이라고 하지 않는다!)
    void parentMethod(int a) {

    }
}

class StrategyPattern {
    static void test() {
        new StrategyPattern(new Child1());
        new StrategyPattern(new Child2());
    }

    StrategyPattern(Parent parent) {

    }
}
class Child1 extends Parent { }
class Child2 extends Parent { }