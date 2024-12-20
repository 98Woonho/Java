# 다익스트라(Dijkstra)

## 다익스트라란?
그래프에서 두 노드 간의 최단 경로를 찾기 위해 사용되는 알고리즘. 이 알고리즘은 가중치가 있는 그래프에서 작동하며, `모든 간선의 가중치가 음수가 아닌 경우`에만 적용할 수 있다.

## 다익스트라의 기본 원리
1. `초기화` : 시작 노드의 거리를 0으로 설정하고, 나머지 노드의 거리는 무한대로 설정. 시작 노드를 방문한 것으로 표시한다.
2. `우선순위 큐 사용` : 방문할 노드를 선택하기 위해 우선순위 큐(최소 힙)를 사용. 이 큐는 현재까지의 최단 거리 정보를 기반으로 노드를 선택한다.
3. `거리 업데이트` : 현재 노드와 연결된 모든 이웃 노드에 대해, 현재 노드를 통해 이웃 노드로 가는 경로의 거리를 계산. 만약 이 경로가 기존의 거리보다 짧다면, 이웃 노드의 거리를 업데이트하고 우선순위 큐에 추가한다.
4. `반복` : 모든 노드를 방문할 때까지 2번과 3번의 과정을 반복한다.
5. `결과` : 최종적으로 각 노드까지의 최단 거리를 구할 수 있다.

## 다익스트라의 특징
- `시간 복잡도` : 인접 행렬을 사용할 경우 O(V^2), 우선순위 큐(힙)를 사용할 경우 O(E log V)이다. 여기서 V는 정점의 수, E는 간선의 수이다
- `그래프의 형태` : 가중치가 음수인 간선이 없는 그래프에서만 사용할 수 있다

## 다익스트라 구현

> ### 백준 1753. 최단경로
> ```java
> import java.util.*;
> import java.io.*;
> 
> public class Main {
> 
>     static class Node{
>         int v; //간선
>         int cost; //가중치
> 
>         public Node(int v, int cost) {
>             this.v = v;
>             this.cost = cost;
>         }
>     }
> 
>     //각 노드에 연결되어 있는 노드에 대한 정보를 담는 리스트
>     static ArrayList<Node>[] graph;
>     //방문한 적이 있는지 체크하는 목적의 리스트
>     static boolean[] visit;
>     //최단 거리 테이블
>     static int[] dist;
> 
>     public static void main(String[] args) throws IOException {
>         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
>         StringTokenizer st = new StringTokenizer(br.readLine());
> 
>         int v = Integer.parseInt(st.nextToken());
>         int e = Integer.parseInt(st.nextToken());
>         int k = Integer.parseInt(br.readLine());
> 
>         graph = new ArrayList[v + 1];
>         dist = new int[v + 1];
>         visit = new boolean[v + 1];
> 
>         for (int i = 1; i <= v; i++) {
>             graph[i] = new ArrayList<>();
>             dist[i] = Integer.MAX_VALUE; //최대값으로 초기화, 최단거리를 찾기 위함.
>         }
> 
>         for (int i = 0; i < e; i++) {
>             // u -> v 로 가는 가중치 w가 주어진다.
>             st = new StringTokenizer(br.readLine());
>             int inputU = Integer.parseInt(st.nextToken());
>             int inputV = Integer.parseInt(st.nextToken());
>             int inputW = Integer.parseInt(st.nextToken());
> 
>             graph[inputU].add(new Node(inputV, inputW));
>         }
> 
>         //다익스트라 알고리즘 수행
>         dijkstra(k);
> 
>         for (int i = 1; i <= v; i++) {
>             System.out.println(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]);
>         }
>     }
> 
>     static void dijkstra(int start) {
>         //우선 순위 큐 사용, 가중치를 기준으로 오름차순한다.
>         PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
>         //시작 노드에 대해서 초기화
>         q.add(new Node(start, 0));
>         dist[start] = 0;
> 
>         while (!q.isEmpty()) {
>             //현재 최단 거리가 가장 짧은 노드를 꺼내서 방문 처리 한다.
>             Node now = q.poll();
> 
>             if (!visit[now.v]) {
>                 visit[now.v] = true;
>             }
> 
>             for (Node next : graph[now.v]) {
> 
>                 //방문하지 않았고, 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧을 경우
>                 if (!visit[next.v] && dist[next.v] > now.cost + next.cost) {
>                     dist[next.v] = now.cost + next.cost;
>                     q.add(new Node(next.v, dist[next.v]));
>                 }
>             }
>         }
>     }
> }
> ```

## 레퍼런스
- https://dding9code.tistory.com/81