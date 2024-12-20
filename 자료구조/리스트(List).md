# 리스트(List)
- `리스트(List)` : 요소들의 순서를 유지하며 저장할 수 있는 자료구조. 순차적으로 데이터를 저장하고, 저장된 데이터에 인덱스를 사용해 접근 가능.

## ArrayList
- `ArrayList` : 동적 배열을 기반으로 한 리스트 구현체. 배열과 유사하지만, 크기가 고정되어 있지 않으며 필요에 따라 크기를 동적으로 조절 할 수 있음.
- ### 특징
  - **인덱스 접근** : 배열과 마찬가지로 인덱스를 통해 빠르게 요소에 접근할 수 있음. `O(1)`의 시간 복잡도를 가짐.
  - **삽입/삭제 성능** : 배열의 중간에 요소를 삽입하거나 삭제할 때는 해당 인덱스 이후의 요소들을 이동시켜야 하므로, 성능이 떨어짐. 이 경우 시간 복잡도는 최악의 경우 `O(n)`.

- ### 예시
```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        // 요소 추가
        list.add("apple");
        list.add("banana");
        list.add("cherry");

        // 인덱스를 통한 접근
        System.out.println(list.get(1));  // 출력: banana

        // 요소 삭제
        list.remove(0);  // "apple" 삭제

        // 요소 확인
        System.out.println(list);  // 출력: [banana, cherry]
    }
}
```

## LinkedList
- `LinkedList` : 노드들이 포인터로 연결된 형태의 리스트. 각 노드는 데이터와 다음 노드를 가리키는 참조를 포함.
- ### 특징
  - **인덱스 접근** : 특정 인덱스에 있는 요소에 접근하려면 처음부터 순차적으로 탐색해야 하므로, `ArrayList`보다 느림. 시간 복잡도는 `O(n)`
  - **삽입/삭제 성능** : 리스트의 앞, 중간, 또는 끝에 요소를 삽입하거나 삭제할 때, 요소 이동이 필요 없기 때문에 빠른 성능을 가짐. 시간 복잡도는 `O(1)` 또는 `O(n)`

- ### 예시
```java
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        // 요소 추가
        list.add("apple");
        list.add("banana");
        list.add("cherry");

        // 리스트의 앞에 요소 추가
        list.addFirst("avocado");

        // 리스트의 끝에 요소 추가
        list.addLast("date");

        // 요소 삭제
        list.remove(1);  // "apple" 삭제

        // 요소 확인
        System.out.println(list);  // 출력: [avocado, banana, cherry, date]
    }
}
```

## 주요 메서드
### 1. 추가
- `add(E element)` : 리스트의 끝에 요소를 추가
```java
list.add("apple");
```
- `add(int index, E element)` : 지정된 위치에 요소를 삽입. 기존 요소들은 오른쪽으로 이동
```java
list.add(1, "banana");
```

### 2. 삭제
- `remove(int index)` : 지정된 위치의 요소를 제거하고, 그 요소를 반환
```java
list.remove(2); // index 2에 있는 요소 제거
```
- `remove(E element)` : 리스트에서 특정 요소를 제거. 동일한 요소가 여러 개 있을 경우, 첫 번째로 발견된 요소가 제거됨
```java
list.remove("apple"); // "apple" 제거
```

### 3. 조회
- `get(int index)` : 지정된 위치에 있는 요소를 반환
```java
String fruit = list.get(0); // index 0에 있는 요소 반환
```
- `indexOf(E element)` : 리스트에서 특정 요소의 첫 번째 발생 위치의 인덱스를 반환. 존재하지 않으면 `-1`을 반환
```java
int index = list.indexOf("banana");
```
- `lastIndexOf(E element)` : 리스트에서 특정 요소의 마지막 발생 위치의 인덱스를 반환. 존재하지 않으면 `-1`을 반환
```java
int lastIndex = list.lastIndexOf("banana");
```

### 4. 수정
- `set(int index, E element)` : 지정된 위치의 요소를 주어진 요소로 대체
```java
list.set(1, "cherry"); // index 1의 요소를 "cherry"로 변경
```

### 5. 크기 확인
- `size()` : 리스트에 저장된 요소의 개수를 반환
```java
int size = list.size();
```

### 6. 비어 있는지 확인
- `isEmpty()` : 리스트가 비어 있으면 `true`, 그렇지 않으면 `false` 반환
```java
boolean isEmpty = list.isEmpty();
```

### 7. 포함 여부 확인
- `contains(E element)` : 리스트에 특정 요소가 포함되어 있는지 확인. 포함되어 있으면 `true` 반환
```java
boolean hasApple = list.contains("apple");
```

### 8. 모든 요소 제거
- `clear()` : 리스트의 모든 요소를 제거
```java
list.clear();
```

### 9. 리스트 일부 추출
- `subList(int fromIndex, int toIndex)` : 리스트의 부분 목록을 반환. `fromIndex`는 포함 되고, `toIndex`는 포함되지 않음
```java
List<String> subList = list.subList(1, 3); // index 1부터 2까지의 부분 리스트 반환
```

### 10. 리스트를 배열로 변환
- `toArray()` : 리스트의 모든 요소를 포함하는 배열을 반환
```java
Object[] array = list.toArray();
```
- `toArray(T[] a)` : 리스트의 요소를 지정된 타입의 배열에 저장하고, 필요한 경우 더 큰 배열을 할당하여 반환
```java
String[] array = list.toArray(new String[0]);
```

### 11. 정렬


- `Comparator`를 이용한 커스텀 정렬
  - `Comparator` : Java에서 객체의 순서를 정의하기 위한 함수형 인터페이스. 두 객체를 비교하는 메서드를 제공하여, 객체의 정렬 순서를 지정 할 수 있게 해줌. 기본 정렬과는 다른 정렬을 하고 싶을 때 유용함