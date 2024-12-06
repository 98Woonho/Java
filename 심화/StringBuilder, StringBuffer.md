# StringBuilder, StringBuffer

## StringBuilder, StringBuffer란?
Java에서 문자열을 조작하고 수정하기 위해 사용되는 클래스. `String`과 달리 `StringBuilder`, `StringBuffer`는 가변적인 문자열을 처리하기 때문에 메모리와 성능 면에서 더 효율적임

## StringBuilder와 StringBuffer의 차이
두 클래스는 비슷한 기능을 제공하지만, 주요 차이점은 스레드 안전성이다.

|특징|	StringBuilder|	StringBuffer|
|-|-|-|
|스레드 안전성|	❌ (비동기적)|	✅ (동기화 지원)|
|속도|	빠름|	느림 (동기화로 인한 오버헤드)|
|사용 환경|	싱글스레드 환경|	멀티스레드 환경|

## 주요 메서드
1. `append(E element)`
   - 요소를 `StringBuilder` 객체의 끝에 추가함
   - 여러 번 호출하면 해당 문자열이 뒤에 연결됨
```java
StringBuilder sb = new StringBuilder("Hello");
sb.append(" World");
System.out.println(sb);  // 출력: Hello World
```

2. `insert(int offset, E element)`
   - 지정한 위치(`offset`)에 문자열을 삽입
```java
StringBuilder sb = new StringBuilder("Hello World");
sb.insert(6, "Java ");
System.out.println(sb);  // 출력: Hello Java World
```

3. `delete(int start, int end)`
   - 지정된 범위(`start`부터 `end` 전까지)의 문자열을 삭제
```java
StringBuilder sb = new StringBuilder("Hello Java World");
sb.delete(5, 10);
System.out.println(sb);  // 출력: Hello World
```

4. `deleteCharAt(int index)`
   - 지정한 인덱스에 있는 문자를 삭제
```java
StringBuilder sb = new StringBuilder("Hello World");
sb.deleteCharAt(5);
System.out.println(sb);  // 출력: HelloWorld
```

5. `replace(int start, int end, String str)`
   - 지정된 범위(`start`부터 `end` 전까지)의 문자열을 주어진 문자열로 대체
```java
StringBuilder sb = new StringBuilder("Hello World");
sb.replace(6, 11, "Java");
System.out.println(sb);  // 출력: Hello Java
```

6. `reverse()`
   - 문자열을 역순으로 변환
```java
StringBuilder sb = new StringBuilder("Hello World");
sb.reverse();
System.out.println(sb);  // 출력: dlroW olleH
```

7. `charAt(int index)`
   - 지정한 인덱스에 있는 문자를 반환
```java
StringBuilder sb = new StringBuilder("Hello World");
char ch = sb.charAt(6);
System.out.println(ch);  // 출력: W
```

8. `setCharAt(int index, char ch)`
   - 지정한 인덱스에 있는 문자를 주어진 문자로 설정
```java
StringBuilder sb = new StringBuilder("Hello World");
sb.setCharAt(6, 'J');
System.out.println(sb);  // 출력: Hello Jorld
```

9. `substring(int start)` 및 `substring(int start, int end)`
   - 지정된 범위의 문자열을 추출함. `String`과 동일하게 사용되며, 반환 타입은 `String`
```java
StringBuilder sb = new StringBuilder("Hello World");
String sub = sb.substring(6);  // 부분 문자열: "World"
System.out.println(sub);  // 출력: World
```

10. `length()`
    - `StringBuilder` 객체의 현재 길이를 반환
```java
StringBuilder sb = new StringBuilder("Hello World");
int len = sb.length();
System.out.println(len);  // 출력: 11
```
