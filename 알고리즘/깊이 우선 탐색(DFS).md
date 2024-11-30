# 깊이 우선 탐색(DFS)

## 깊이 우선 탐색이란?
그래프나 트리에서 탐색을 수행할 때 한 노드에서 시작하여 인접한 노드로 계속 깊게 들어가며 탐색한 후, 더 이상 탐색할 노드가 없으면 마지막으로 방문한 노드로 돌아가서 다른 경로를 탐색하는 알고리즘

## 깊이 우선 탐색의 기본 원리
![DFS](https://github.com/user-attachments/assets/3a71e6e7-8105-42fb-8506-a8ca5e59fd33)

위 그림처럼 0에서 1로, 1에서 3으로 갔을 때 더 이상 갈 곳이 없으면 `백트래킹`을 해서 다시 1로 간다. 이후에 방문하지 않은 4를 방문하는 원리이다.

정리하면 아래와 같다.
1. `시작 노드 선택` : 탐색을 시작할 노드를 선택합니다.
2. `방문 처리` : 현재 노드를 방문하고, 이 노드를 방문한 것으로 표시합니다.
3. `인접 노드 탐색` : 현재 노드와 연결된 인접 노드 중 방문하지 않은 노드를 선택하여 재귀적으로 DFS를 수행합니다.
4. `백트래킹` : 더 이상 방문할 노드가 없으면, 이전 노드로 돌아가서 다른 인접 노드를 탐색합니다.

## DFS 구현

> ```java
> public class DFS {
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
>         // 간선 입력(만약 양방향 그래프이면 반대 방향 연결도 입력하면 됨)
>         graph.get(1).add(2);
>         graph.get(1).add(3);
>         graph.get(1).add(4);
> 
>         graph.get(2).add(4);
> 
>         graph.get(3).add(4);
> 
>         dfs(1);
>     }
> 
>     public static void dfs(int node) {
>         visited[node] = true;
>         System.out.print(node + " ");
> 
>         for (int next : graph.get(node)) {
>             if (!visited[next]) {
>                 dfs(next);
>             }
>         }
>     }
> }
> ```
> ### 실행결과
> ```
> 1 2 4 3
> ```

## 레퍼런스
- https://binco.tistory.com/entry/Java-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-DFS%EC%99%80BFS-%EC%99%84%EB%B2%BD%EC%A0%95%EB%A6%AC
- https://jellili.tistory.com/26
