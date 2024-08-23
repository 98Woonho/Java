# 스택
- `스택(Stack)` : 후입선출(LIFO, Last In First Out) 방식으로 동작하는 자료구조. 마지막에 추가된 요소가 가장 먼저 제거됨.

## 주요 메서드
- `push(E element)` : 스택의 맨 위에 요소를 추가
```java
Stack<Integer> stack = new Stack<>();
stack.push(10);
stack.push(20);
```
<br>

- `pop()` : 스택의 맨 위에 있는 요소를 제거하고, 그 요소를 반환. 스택이 비어 있으면 `EmptyStackException`이 발생
```java
int topElement = stack.pop(); // 스택에서 20 제거하고 반환
```
<br>

- `peek()` : 스택의 맨 위에 있는 요소를 제거하지 않고 반환. 스택이 비어 있으면 `EmptyStackException`이 발생
```java
int topElement = stack.peek(); // 스택의 최상위 요소 반환 (20)
```
<br>

- `search(E element)` : 스택에서 특정 요소가 위치한 1-based 인덱스를 반환. 요소가 없으면 `-1`을 반환
```java
int position = stack.search(10); // 10이 스택의 2번째 위치에 있음
```

## 사용 예시
```java
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // 스택에 요소 추가
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // 스택의 최상위 요소 확인
        System.out.println("Top element: " + stack.peek());  // 출력: Top element: 30

        // 스택에서 요소 제거
        System.out.println("Popped element: " + stack.pop());  // 출력: Popped element: 30

        // 스택이 비어 있는지 확인
        System.out.println("Is stack empty? " + stack.isEmpty());  // 출력: Is stack empty? false

        // 스택의 특정 요소 위치 확인
        System.out.println("Position of 10: " + stack.search(10));  // 출력: Position of 10: 2
    }
}
```

