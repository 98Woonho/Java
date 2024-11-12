# 기본 API 클래스

## 목차

## 1. java.lang 패키지
java.lang 패키지는 자바 프로그램의 기본적인 클래스를 담고 있는 패키지이다. 가령 우리가 Scanner를 사용하려 한다면 스캐너를 import해줘야 사용할 수 있다. 그러나 System. String 등과 같은 클래스는 따로 선언 없이 사용이 가능했다. 그 이유는 기본으로 제공해 주는 java.lang 패키지에 속해 있었기 때문이다.

java.lang 패키지에는 아래와 같은 클래스가 존재한다.

|클래스|용도|
|:-:|-|
|Object|자바 클래스의 최상위 클래스로 사용|
|System|시스템의 표준 입력/출력 장치로부터 데이터를 입력받거나 출력하기 위해 사용<br/>자바 가상 기계를 종료할 때 사용|
|String|문자열을 저장하고 여러 가지 정보를 얻을 때 사용|
|StringBuffer / StringBuilder|문자열을 저장하고 내부 문자열을 조작할 때 사용|
|Math|수학 함수를 이용할 때 사용|

### 1-1. Object 클래스
Object 클래스는 자바의 최상위 클래스이다. 자바에서 생성되는 모든 클래스는 생성될 때 상속을 하지 않아도 Object를 자동으로 상속받게 되어있다. 따라서 클래스를 생성하면 Object가 가지고 있는 여러 메서드를 그대로 사용하거나 override하여 사용할 수 있게 된다.

Object 클래스가 지닌 대표적인 메서드는 다음과 같다.

|메서드|설명|
|:-:|-|
|protected Object clone()|객체 자신을 복사한 후 반환|
|boolean equals(Object obj)|다른 객체와 자신이 가진 실제 값을 비교|
|int hashCode()|객체의 hashCode 값을 반환|
|String toString()|객체 자신의 정보를 반환|

각 메서드를 예제와 함께 알아보자.

> ### equals 객체 비교
> ```java
> public class Practice {
>     public static void main(String[] args) {
>         String str1 = "hello";
>         String str2 = "hello";
>         String str3 = new String("hello");
> 
>         System.out.println("str1 vs str2 : " + (str1.equals(str2)));
>         System.out.println("str2 vs str3 : " + (str2.equals(str3)));
>     } 
> }
> ```
> ### 실행 결과
> ```
> str1 vs str2 : true
> str2 vs str3 : true
> ```
> 객체를 동등 비교할 경우, 해당 객체의 값을 비교하는 것이 아니라, 객체가 메모리에 있는 위치를 비교하게 된다. 따라서 객체의 데이터를 비교할 때는 equals() 메서드를 override하여 사용한다. 대표적인 예로 우리가 사용하는 String 클래스가 있다.

> ### hashCode() 객체 비교
> ```java
> public class Practice {
>     public static void main(String[] args) {
>         String str1 = "hello";
>         String str2 = "hello";
>         String str3 = "hello";
> 
>         System.out.println("str1 hashCode : " + str1.hashCode());
>         System.out.println("str2 hashCode : " + str2.hashCode());
>         System.out.println("str3 hashCode : " + str3.hashCode()); 
>     } 
> }
> ```
> ### 실행 결과
> ```
> str1 hashCode : 99162322
> str2 hashCode : 99162322
> str3 hashCode : 93029210
> ```
> 자바 프로그래밍에서 new 키워드를 사용해 인스턴스를 만들 경우, 주민등록번호처럼 객체마다 고유한 값인 `hashCode`를 가지게 된다. `str1`과 `str2`는 같은 값이기 때문에 `hashCode`가 같고, str3은 다르게 출력이 된다.


> ###  toString() 메서드를 재정의하여 객체의 정보를 반환
> ```java
> class Car {
>     private String carName;
>     private String company;
> 
>     public Car(String carName, String company) {
>         this.carName = carName;
>         this.company = company;
>     }
> 
>     @Override
>     public String toString() {
>         String str = "차량 이름 : " + this.carName + ", 제조사 : " + this.company;
>         return str;
>     }
> }
> 
> public class Practice {
>     public static void main(String[] args) {
>         Car car = new Car("소나타", "현대");
>         System.out.println(car);
>     }
> }
> ```
> ### 실행 결과
> ```
> 차량 이름 : 소나타, 제조사 : 현대
> ```
> toString()을 Override 하지 않고 print 문으로 객체를 그대로 출력하면 `java.lang.Object@7ad041f3` 같은 형태로 출력이 된다. 하지만 toString()을 Override하여 반환값을 작성하면, 객체를 출력할 때 toString()의 반환값을 출력하게 된다.

### 1-2. String 클래스