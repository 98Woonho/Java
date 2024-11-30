# 너비 우선 탐색(BFS)

## 너비 우선 탐색이란?
그래프 또는 트리를 탐색할 때, 시작 노드에서 가까운 노드부터 탐색하는 알고리즘

## 너비 우선 탐색의 기본 원리
![BFS](https://github.com/user-attachments/assets/7616ceba-8a59-42ec-96ba-7238cc94ed90)

BFS는 재귀적으로 동작하지 않고 방문한 노드들을 차례로 저장한 후 꺼낼 수 있는 큐(Queue)를 사용한다. 시작 정점으로부터 가까운 정점을 먼저 방문하고 멀리 떨어져 있는 정점을 나중에 방문한다.

정리하면 아래와 같다.

1. `시작 노드 선택` : 탐색을 시작할 노드를 선택합니다.
2. `큐 사용` : 방문할 노드를 저장하기 위해 큐(Queue)를 사용합니다.
3. `방문 처리` : 현재 노드를 방문하고, 이 노드를 방문한 것으로 표시합니다.
4. `인접 노드 탐색` : 현재 노드와 연결된 인접 노드를 큐에 추가합니다.
5. `반복` : 큐에서 노드를 하나씩 꺼내어 위의 과정을 반복합니다. 큐가 비어있을 때까지 계속합니다.

## BFS 구현

> ```java
> public class BFS {
>     public final static int N = 5;
>     public static boolean[] visited = new boolean[N + 1];
>     public static List<List<Integer>> graph = new ArrayList<>();
> 
>     public static void main(String[] args) {
> 
>         for (int i = 0; i <= N; i++) {
>             graph.add(new ArrayList<>());
>         }
> 
>         graph.get(1).add(2);
>         graph.get(1).add(3);
>         graph.get(1).add(4);
> 
>         graph.get(2).add(4);
> 
>         graph.get(3).add(4);
> 
>         bfs(1);
>     }
> 
>     public static void bfs(int node) {
>         Queue<Integer> q = new LinkedList<>();
> 
>         q.offer(node);
>         visited[node] = true;
> 
>         while (!q.isEmpty()) {
>             int target = q.poll();
>             System.out.print(target + " ");
> 
>             for (int next : graph.get(target)) {
>                 if (!visited[next]) {
>                     q.offer(next);
>                     visited[next] = true;
>                 }
>             }
>         }
>     }
> }
> ```
> ### 실행결과
> ```
> 1 2 3 4
> ```


## 레퍼런스
- https://binco.tistory.com/entry/Java-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-DFS%EC%99%80BFS-%EC%99%84%EB%B2%BD%EC%A0%95%EB%A6%AC
- https://jellili.tistory.com/26
