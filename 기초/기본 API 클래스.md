# 기본 API 클래스

## 목차
1. [java.lang 패키지](#1-javalang-패키지)
2. [java.util 패키지](#2-javautil-패키지)

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
String 클래스는 문자열을 처리하는 객체형 데이터 타입이다. 문자열을 처리하기 위한 다양한 기능들을 가지고 있다.

String 클래스가 지닌 대표적인 메서드는 다음과 같다.

|                      메서드                      |설명|
|:---------------------------------------------:|-|
|                  int length()                 |문자열의 길이를 반환|
|             char charAt(int index)            |문자열을 하나의 단어 단위로 출력<br/>파라미터로는 추출할 문자열의 위치를 받음|
| int indexOf(String ch)<br/>int indexOf(int ch)|문자열에 포함된 단어 또는 문자열의 위치를 앞에서부터 검색했을 때 일치하는 위치의 인덱스 값을 반환 (없을 경우에는 -1을 반환)
|String replace(변경할 문자, 변경 문자)|단어 또는 문장에 있는 특정 단어를 변경|
|String substring(int beginIndex)|문자열을 원하는 위치에서 자를 때 사용<br/>입력된 시작 위치부터 문자열의 마지막까지 반환|
|String substring(int beginIndex, int endIndex)|문자열을 입력된 시작 위치부터 마지막 위치 전까지의 값을 리턴|

각 메서드를 예제와 함께 알아보자.

> ### charAt() 메서드
> ```java
> public class Practice {
>     public static void main(String[] args) {
>         String str = "Hello";
>         char ch = str.charAt(2);
>         System.out.println(ch);
>     } 
> }
> ```
> ### 실행 결과
> ```
> l
> ```


> ### indexOf() 메서드
> ```java
> public class Practice {
>     public static void main(String[] args) {
>         String str = "HelloWorld_MyWorld";
>         // 처음 위치에서 검색
>         System.out.println("World 단어 위치 : " + str.indexOf("World"));
>         // 10번째 위치부터 시작하여 검색
>         System.out.println("Workd 단어 위치 : " + str.indexOf("World", 10));
>     } 
> }
> ```
> ### 실행 결과
> ```
> World 단어 위치 : 5
> Workd 단어 위치 : 13
> ```

> ### replace 메서드
> ```java
> public class Practice {
>     public static void main(String[] args) {
>         String str = "자바 프로그래밍은 어렵지만 자바를 배울수록 재미있습니다.";
>         // 모든 단어 '자바'를 'Java'로 변경
>         String newStr = str.replaceAll("자바", "Java");
> 
>         System.out.println(str);
>         System.out.println(newStr);
>     } 
> }
> ```
> ### 실행 결과
> ```
> 자바 프로그래밍은 어렵지만 자바를 배울수록 재미있습니다.
> Java 프로그래밍은 어렵지만 Java를 배울수록 재미있습니다.
> ```
> replace()보다 기능상의 이점이 있어서 replaceAll()을 주로 사용한다.


> ### substring() 메서드
> ```java
> public class Practice {
>     public static void main(String[] args) {
>         String str = "1234-5678";
>         String subStr = str.substring(5);
> 
>         System.out.println("4번째 위치부터 추출 : " + subStr);
> 
>         String rangeStr = str.substring(0, 4);
>         System.out.println("범위 내에서 추출 : " + rangeStr);
>     } 
> }
> ```
> ### 실행 결과
> ```
> 4번째 위치부터 추출 : 5678
> 범위 내에서 추출 : 1234
> ```

### 1-3. StringBuffer와 StringBuilder
자바에서 문자열을 처리하는 변수는 String 객체이다. String 클래스는 최초 지정된 문자열 이후에 값이 추가되면 내부적으로 새로운 메모리를 할당해 새롭게 문자열을 등록한다. 따라서 문자열을 많이 사용할수록 메모리 사용이 늘어나 메모리가 낭비될 수 있다. 이런 문제점을 해결하기 위해 `StringBuffer` 또는 `StringBuilder` 클래스를 사용한다. `StringBuffer`와 `StringBuilder`는 내부에 여유 공간을 두기 때문에 문자열을 합칠 때 메모리에 새롭게 생성하는 과정을 생략할 수 있다.

`StringBuffer`와 `StringBuilder`는 사용하는 기능에서는 차이가 없으나 `StringBuffer`의 경우 스레드 환경에서 안정성 기능을 추가로 가지고 있다.

`StringBuilder` 클래스가 지닌 대표적인 메서드는 다음과 같다.

|메서드 명|설명|
|-|-|
|append(String str)|기존 문자열 뒤에 더하여 반환|
|delete(int start, int end)|시작 위치부터 끝 위치 전까지 삭제|
|insert(int offset, String str)|시작 위치부터 문자열을 삽입|
|reverse()|문자열을 반대로 출력|

> ### StringBuilder 클래스
> ```java
> public class Practice {
>     public static void main(String[] args) {
>         StringBuilder str = new StringBuilder("Hello");
> 
>         // 기존 문자열 뒤에 삽입
>         str.append(" World");
>         System.out.println(str);
>         System.out.println();
> 
>         // 문자열 삭제
>         str.delete(0, 6);
>         System.out.println(str);
>         System.out.println();
> 
>         // 원하는 위치에 문자열 삽입
>         str.insert(0, "Hello");
>         System.out.println(str);
>         System.out.println();
> 
>         // 문자를 반대로 출력
>         str.reverse();
>         System.out.println(str);
>     } 
> }
> ```
> ### 실행 결과
> ```
> Hello World
> 
> World
> 
> HelloWorld
> 
> dlroWolleH
> ```


### 1-4. Math 클래스
`Math` 클래스는 수학에서 자주 사용하는 상수들과 함수들을 미리 구현해 놓은 클래스로 자바에서 수학 계산이 필요할 때 주로 사용된다. 객체를 선언하지 않고 바로 사용할 수 있도록 해당 클래스가 제공하는 모든 메서드는 모두 정적 메서드로 이루어져 있다.

`Math` 클래스가 지닌 대표적인 메서드는 다음과 같다.

|메서드|설명|
|:-:|-|
|int abs(int a)<br/>double abs(double a)|절대값 계산|
|double ceil(double a)|올림 계산|
|double floor(double a)|버림 계산|
|double round(double a)|반올림 계산|
|int max()<br/>double max()|최대값을 구하는 계산|
|int min(int a, int b)<br/>double max(double a, double b)|최소값을 구하는 계산|
|double random()|랜덤값을 반환|

> ### Math 클래스
> ```java
> public class Practice {
>     public static void main(String[] args) {
>         // 올림
>         System.out.println("3.51 올림 : " + Math.ceil(3.51));
>         // 내림
>         System.out.println("13.61 버림 : " + Math.floor(13.61));
>         // 반올림
>         System.out.println("12.8 반올림 : " + Math.round(12.8));
>         // 절대값 구하기
>         System.out.println("절대값 1 : " + Math.abs(-4.55));
>         System.out.println("절대값 2 : " + Math.abs(-50));
>         // 최대값 구하기
>         System.out.println("40, 70 최대값 : " + Math.max(40, 70));
>         // 최소값 구하기
>         System.out.println("30, 60 최소값 : " + Math.min(30, 60));
>         // 랜덤값 반환
>         System.out.println("random() : " + Math.random());
>     } 
> }
> ```
> ### 실행 결과
> ```
> 3.51 올림 : 4.0
> 13.61 버림 : 13.0
> 12.8 반올림 : 13
> 절대값 1 : 4.55
> 절대값 2 : 50
> 40, 70 최대값 : 70
> 30, 60 최소값 : 30
> random() : 0.0269817499583902
> ```
> `Math.random()` 메서드는 0부터 1 미만 사이에 존재하는 실수값중 하나를 반환해준다.


### 1-5. Wrapper 클래스
자바에서는 기본 자료형을 객체로 다루기 위한 클래스를 제공하는데, 이러한 클래스를 `Wrapper` 클래스라고 한다. 

자바의 기본 자료형에 대응하여 제공되는 Wrapper 클래스의 종류는 다음과 같다.

|기본 데이터 타입|Wrapper 클래스|
|:-:|-|
|byte|Byte|
|short|Short|
|int|Integer|
|long|Long|
|float|Float|
|double|Double|
|char|Character|
|boolean|Boolean|

> ### Wrapper 클래스
> ```java
> public class Practice {
>     public static void main(String[] args) {
>         // 정수형 타입 선언
>         Integer num01 = Integer.valueOf(10);
> 
>         // 실수형 타입 선언
>         Double doubleNum01 = Double.valueOf(30.11);
> 
>         // 문자형 타입 선언
>         Character ch = Character.valueOf('A');
> 
>         System.out.println("정수형1 : " + num01);
>         System.out.println("실수형 : " + doubleNum01);
>         System.out.println("문자형 : " + ch);
>     } 
> }
> ```
> ### 실행 결과
> ```
> 정수형1 : 10
> 실수형 : 30.11
> 문자형 : A
> ```

<br/>

프로그램을 개발하다 보면 외부로부터 데이터를 받는 경우가 있다. 이러한 데이터 중에는 숫자로 표기되어 있지만 전송의 편의상 모든 데이터를 문자 또는 문자열 타입으로 전송하는 경우들이 있다. 이런 경우, 받는 쪽에서는 데이터 타입을 변경하여 사용해야 한다. `Wrapper` 클래스에는 문자 타입의 데이터를 숫자 타입의 데이터로 변경할 수 있는 기능이 있다.

다음과 같이 문자 타입을 숫자 타입으로 변환한다.

| 데이터 타입 |문자형 -> 숫자형|
|:------:|-|
| byte형  |Byte.parseByte("10");|
| short형 |Short.parseShort("10");|
|  int형  |Integer.parseInt("100");|
|long형|Long.parseLong("100");|
|float형|Float.parseFloat("10.33");|
|double형|Double.parseDouble("30.23");|
|boolean형|Boolean.parseBoolean("true");|

> ### 문자 타입 변환
> ```java
> public class Practice {
>     public static void main(String[] args) {
>         String intStr = "70";
>         String doubleStr = "60.5";
>
>         int myScore = Integer.parseInt(intStr); // 정수형 문자열을 정수로 변경
>         double cutLineScore = Double.parseDouble(doubleStr); // 실수형 문자열을 실수로 변경
> 
>         if (myScore >= cutLineScore) {
>             System.out.println("합격입니다.");
>         } else {
>             System.out.println("불합격입니다.");
>         }
>     } 
> }
> ```
> ### 실행 결과
> ```
> 합격입니다.
> ```

## 2. java.util 패키지
`java.util` 날짜와 시간 정보를 제공해 주는 `Date` 클래스와 `Calendar` 클래스가 있다. 최근에는 날짜를 표현할 때 `Date` 클래스보다는 `Calendar` 클래스를 사용하는 것을 권장하고 있으며, `Date` 클래스는 많은 기능이 종료를 기다리고 있다. 따라서 우리는 `Calendar` 클래스의 사용 방법에 대해 알아보자.

### 2-1. Calendar 클래스 선언
`Calendar` 클래스는 추상 클래스이다. 따라서 다른 객체 선언처럼 new 키워드를 이용하여 선언하지 않고, 생성된 인스턴스를 받아오는 형식으로 선언된다.

```java
Calendar cal = new Calendar(); // 오류 발생!
Calendar cal = Calendar.getInstance();
```

### 2-2. Calendar 클래스 속성
`Calendar` 클래스에는 여러 가지 상수 필드들이 존재한다. 대표적으로 사용하는 상수값은 다음과 같다.

|상수 필드|설명|
|:-:|-|
|YEAR, MONTH, DATE|연도, 월(0-11), 일(1-31)을 나타내는 상수|
|DAY_OF_MONTH|현재 달의 몇 번째 날인지를 나타내는 상수(1-31)|
|DAY_OF_WEEK|현재 주의 몇 번째 날인지를 나타내는 상수(1-7), 1은 일요일을 의미|
|HOUR, MINUTE|시(0-110, 분(0-59)을 나타내는 상수|
|SECOND, MILLISECOND|초(0-59)와 1/1000초를 나타내는 상수|
|HOUR_OF_DAY|현재 날의 시각을 의미하는 상수(0-23)|
|AM_PM|HOUR가 정오보다 이전이면 0을, 이후이면 1의 값을 가지는 상수|
|WEEK_OF_MONTH|현재 달의 몇 번째 주인지를 나타내는 상수|
|WEEK_OF_YEAR|현재 해의 몇 번째 주인지를 나타내는 상수|

> ### Calendar 클래스
> ```java
> public class Practice {
>     public static void main(String[] args) {
>         Calendar cal = Calendar.getInstance();
>         
>         int year = cal.get(Calendar.YEAR);
>         int month = cal.get(Calendar.MONTH) + 1;
>         int day = cal.get(Calendar.DAY_OF_MONTH);
> 
>         System.out.println("오늘 날짜는 " + year + "년 " + month + "월 " + day + "일 입니다.");
>     } 
> }
> ```
> ### 실행 결과
> ```
> 오늘 날짜는 2023년 3월 2일 입니다.
> ```
