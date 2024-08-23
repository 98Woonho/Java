# 큐
- `큐(Queue)` : 선입선출(FIFO, First In First Out) 방식으로 동작하는 자료구조. 먼저 삽입된 요소가 가장 먼저 제거됨.

## 주요 구현 클래스

### 1. PriorityQueue
- `PriorityQueue` : 요소들이 우선순위에 따라 정렬되는 큐. 큐의 앞에 높은 우선순위를 가진 요소가 위치하며, 내부적으로 힙(Heap) 자료구조를 사용하여 구현됨.
```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
pq.offer(4);
pq.offer(2);
pq.offer(5);

System.out.println(pq.poll()); // 출력: 2 (가장 작은 요소 반환)
```

### 2. ArrayDeque
- `ArrayDeque` : 큐와 덱을 모두 구현하는 클래스. 큐의 앞 뒤에서 모두 요소를 삽입하고 제거 할 수 있음. 또한 더 높은 성능을 제공
```java
ArrayDeque<String> deque = new ArrayDeque<>();
deque.offer("apple");
deque.offer("banana");
deque.offerFirst("cherry");  // 덱의 앞에 요소 추가

System.out.println(deque.poll());  // 출력: cherry (앞에서부터 요소 제거)
```

## 주요 메서드
- `offer(E element)` : 큐의 맨 뒤에 요소를 삽입. 성공하면 `true`, 큐의 용량이 부족하면 `false` 반환
```java
queue.offer("apple");
```
<br>

- `add(E element)` : 큐의 맨 뒤에 요소를 삽입. 큐의 용량이 부족하면 `IllegalStateException` 예외 발생
```java
queue.add("banana");
```
<br>

- `poll()` : 큐의 맨 앞에 있는 요소를 제거하고 반환. 큐가 비어 있으면 `null` 반환
```java
String element = queue.poll(); // 맨 앞의 요소 제거하고 반환
```
<br>

- `remove()` : 큐의 맨 앞에 있는 요소를 제거하고 반환. 큐가 비어 있으면 `NoSuchElementException` 반환
```java
String element = queue.remove(); // 큐가 비어 있으면 예외 발생
```
<br>

- `peek()` : 큐의 맨 앞에 있는 요소를 제거하지 않고 반환. 큐가 비어 있으면 `null` 반환
```java
String element = queue.peek(); // 큐의 맨 앞 요소 확인
```
<br>

- `element()` : 큐의 맨 앞에 있는 요소를 제거하지 않고 반환. 큐가 비어 있으면 `NoSuchElementException` 반환
```java
String element = queue.element(); // 큐가 비어 있으면 예외 발생
```