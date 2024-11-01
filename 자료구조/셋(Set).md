# 셋(Set)
- `셋(Set)` : 중복을 허용하지 않는 집합 데이터를 저장하는 자료구조. 각 요소가 유일하게 유지되며, 특정 순서를 보장하지 않음

## 주요 구현 클래스
### 1. HashSet
- 특징 : 가장 일반적으로 사용되는 Set 구현체로, 해시 테이블을 기반으로 함
- 순서 : 요소들이 해시 코드에 따라 저장되므로, 요소의 순서를 보장하지 않음
- 성능 : 기본적으로 삽입, 삭제, 조회 연산이 상수 시간(`O(1)`)에 수행됨

```java
import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();

        // 요소 추가
        hashSet.add("사과");
        hashSet.add("바나나");
        hashSet.add("체리");
        hashSet.add("사과"); // 중복 요소 추가 시도

        // 출력
        System.out.println("HashSet 내용: " + hashSet);
    }
}

```

<br>

### 2. LinkedHashSet
- 특징 : `HashSet`과 유사하지만, 요소의 삽입 순서를 유지함
- 순서 : 요소가 추가된 순서대로 저장됨
- 성능 : `HashSet`에 비해 약간의 추가 메모리와 시간이 소요될 수 있으나, 순서 유지의 장점이 있음

```java
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetExample {
    public static void main(String[] args) {
        Set<String> linkedHashSet = new LinkedHashSet<>();

        // 요소 추가
        linkedHashSet.add("사과");
        linkedHashSet.add("바나나");
        linkedHashSet.add("체리");
        linkedHashSet.add("사과"); // 중복 요소 추가 시도

        // 출력
        System.out.println("LinkedHashSet 내용: " + linkedHashSet);
    }
}

```

<br>

### 2. TreeSet
- 특징 : `NavigableSet` 인터페이스를 구현한 클래스이며, 정렬된 순서로 요소를 저장
- 순서 : 요소들이 자연 순서(Comparable) 또는 사용자 정의 비교자(Comparator) 에 따라 정렬
- 성능 : 삽입, 삭제, 조회 연산이 로그 시간(`O(log n)`)에 수행됨

```java
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        Set<String> treeSet = new TreeSet<>();

        // 요소 추가
        treeSet.add("사과");
        treeSet.add("바나나");
        treeSet.add("체리");
        treeSet.add("사과"); // 중복 요소 추가 시도

        // 출력
        System.out.println("TreeSet 내용: " + treeSet);
    }
}

```

## 주요 메서드
- `add(E element)` : Set에 요소를 추가. 요소가 이미 존재하면 추가되지 않고 `false` 반환
```java
boolean added = set.add("사과");
```
<br>

- `remove(E element)` : Set에서 특정 요소를 제거. 요소가 존재하면 제거하고 `true` 반환, 그렇지 않으면 `false` 반환
```java
boolean removed = set.remove("바나나");
```
<br>

- `contains(E element)` : Set에 특정 요소가 포함되어 있는지 확인
```java
boolean hasCherry = set.contains("체리");
```
<br>

- `size()` : Set에 저장된 요소의 개수를 반환
```java
int size = set.size();
```
<br>

- `isEmpty()` : Set이 비어 있는지 확인
```java
boolean empty = set.isEmpty();
```
<br>

- `clear()` : Set의 모든 요소를 제거
```java
set.clear();
```
<br>

- `Iterator<E> iterator()` : Set의 모든 요소를 순회할 수 있는 이터레이터를 반환
```java
Iterator<String> iterator = set.iterator();
while (iterator.hasNext()) {
    System.out.println(iterator.next());
}
```
<br>

- `toArray()` : Set의 모든 요소를 배열로 변환
```java
Object[] array = set.toArray();
```
<br>

- `toArray(T[] a)` : Set의 요소를 지정된 타입의 배열로 변환
```java
String[] array = set.toArray(new String[0]);
```