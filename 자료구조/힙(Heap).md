# 힙(Heap)
- `힙(Heap)` : 이진 트리 형태의 자료구조. `우선순위 큐(Priority Queue)`를 구현하는 데 사용

## 힙의 유형
- `최대 힙(Max Heap)` : 부모 노드가 자식 노드보다 항상 크거나 같은 값을 가짐. 루트 노드에는 트리에서 가장 큰 값이 위치
- `최소 힙(Min Heap)` : 부모 노드가 자식 노드보다 항상 작거나 같은 값을 가짐. 루트 노드에는 트리에서 가장 작은 값이 위치

## 힙의 특징
- **완전 이진 트리** : 힙은 완전 이진 트리로, 마지막 레벨을 제외한 모든 레벨이 꽉 차 있으며, 마지막 레벨의 노드들은 가능한 한 왼쪽에 위치
- **효율적인 최댓값/최솟값 접근** : 힙은 최댓값이나 최솟값을 빠르게 접근 가능
- **성능** : 삽입과 삭제의 시간 복잡도는 O(log n)

## 예시
- ### 최소 힙 구현
```java
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        // 최소 힙을 구현하는 PriorityQueue
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // 요소 추가
        minHeap.add(10);
        minHeap.add(20);
        minHeap.add(5);

        // 요소를 우선순위에 따라 제거 (최소값부터 제거)
        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll());  // 5, 10, 20 순으로 출력
        }
    }
}
```

- ### 최대 힙 구현
```java
import java.util.PriorityQueue;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        // 최대 힙을 구현하는 PriorityQueue
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // 요소 추가
        maxHeap.add(10);
        maxHeap.add(20);
        maxHeap.add(5);

        // 요소를 우선순위에 따라 제거 (최대값부터 제거)
        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.poll());  // 20, 10, 5 순으로 출력
        }
    }
}
```