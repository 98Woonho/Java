# 맵(Map)
- `맵(Map)` : 키(Key)와 값(Value)의 쌍으로 저장되어 있는 자료구조. 각 키는 고유하며, 하나의 키는 하나의 값만 매핑될 수 있음

## 주요 구현 클래스
### 1. HashMap
- 특징 : 가장 널리 사용되는 Map 구현체. 해시 테이블 기반
- 순서 : 키-값 쌍의 순서를 보장하지 않음
- 성능 : 평균적으로 `O(1)`의 시간 복잡도로 키를 검색하고 삽입할 수 있음
- Null 허용 : `null`키와 `null`값을 허용
```java
import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        // 키-값 쌍 추가
        map.put("사과", 1);
        map.put("바나나", 2);
        map.put("체리", 3);

        // 값 가져오기
        System.out.println("사과의 값: " + map.get("사과"));  // 출력: 사과의 값: 1

        // 키-값 쌍 제거
        map.remove("바나나");

        // Map의 모든 키-값 쌍 출력
        System.out.println("HashMap 내용: " + map);
    }
}
```


### 2. LinkedHashMap
- 특징 : `HashMap`과 유사하지만, 삽입 순서를 유지
- 순서 : 요소들이 삽입된 순서대로 저장됨
- 성능 : `HashMap`보다 약간 느리지만, 순서를 유지하는 것이 필요할 때 유용함
- Null 허용 : `null`키와 `null`값을 허용
```java
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new LinkedHashMap<>();

        // 키-값 쌍 추가
        map.put("사과", 1);
        map.put("바나나", 2);
        map.put("체리", 3);

        // LinkedHashMap 내용 출력 (삽입 순서 유지)
        System.out.println("LinkedHashMap 내용: " + map);
    }
}

```


### 3. TreeMap
- 특징 : 정렬된 순서로 키-값 쌍을 저장하는 Map. 내부적으로 `레드-블랙트리(Red-Black Tree)` 구조를 사용
- 순서 : 키의 자연 순서 또는 사용자 정의 비교자에 따라 정렬됨
- 성능 : 삽입, 삭제, 조회 연산이 `O(log n)`의 시간 복잡도를 가짐
- Null 허용 : `null`키를 허용하지 않음. `null`값을 허용하지만, 비교자가 `null`을 처리할 수 있어야 함
```java
import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>();

        // 키-값 쌍 추가 (정렬된 순서로 저장)
        map.put("사과", 1);
        map.put("바나나", 2);
        map.put("체리", 3);

        // TreeMap 내용 출력 (키의 자연 순서로 정렬)
        System.out.println("TreeMap 내용: " + map);
    }
}
```

### 4. Hashtable
- 특징 : 동기화된 `HashMap`의 초기 구현체. 멀티스레드 환경에서 안전하지만, 성능이 떨어질 수 있음
- 순서 : 순서를 유지하지 않음
- 성능 : 동기화로 인해 다른 Map 구현체보다 느림
- Null 허용 : `null`키와 `null`값을 허용하지 않음
```java
import java.util.Hashtable;
import java.util.Map;

public class HashtableExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new Hashtable<>();

        // 키-값 쌍 추가
        map.put("사과", 1);
        map.put("바나나", 2);
        map.put("체리", 3);

        // Hashtable 내용 출력
        System.out.println("Hashtable 내용: " + map);
    }
}

```

## 주요 메서드
- `put(key, value)` : 키에 해당하는 값을 Map에 추가. 키가 이미 존재하면 기본 값을 덮어쓰고, 기존 값을 반환
```java
map.put("사과", 1);
```
<br>

- `get(key)` : 키에 해당하는 값을 반환. 키가 존재하지 않으면 `null`을 반환
```java
Integer value = map.get("사과");
```
<br>

- `remove(key)` : 키에 해당하는 값을 제거하고, 제거된 값을 반환. 키가 존재하지 않으면 `null` 반환
```java
Integer removedValue = map.remove("바나나");
```
<br>

- `containsKey(key)` : Map에 특정 키가 존재하는지 확인
```java
boolean hasKey = map.containsKey("사과");
```
<br>

- `containsValue(value)` : Map에 특정 값이 존재하는지 확인
```java
boolean hasValue = map.containsValue(1);
```
<br>

- `keySet()` : Map에 포함된 모든 키를 Set으로 반환
```java
Set<String> keys = map.keySet();
```
<br>

- `values()` : Map에 포함된 모든 값을 Collection으로 반환
```java
Collection<Integer> values = map.values();
```
<br>

- `entrySet()` : Map에 포함된 모든 키-값 쌍을 `Set<Map.Entry<K, V>>` 형태로 반환
```java
Set<Map.Entry<String, Integer>> entries = map.entrySet();
```