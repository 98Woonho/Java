# 동적 계획법(Dynamic Programming)

## 동적 계획법이란?
문제를 작은 하위 문제로 나누고, 그 결과를 저장하여 동일한 하위 문제를 여러 번 계산하지 않도록 최적화하는 기법. 일반적으로 재귀적으로 구현되며 [메모이제이션(Memoization)](#메모이제이션memoization) 기법을 사용하여 중복 계산을 피함

## 동적 계획법의 조건
1. `최적 부분 구조 (Optimal Substructure)` : 큰 문제의 최적해가 작은 문제의 최적해를 포함하는 성질. 즉, 작은 문제의 최적해를 구한 후 그것을 이용하여 큰 문제의 최적해를 구할 수 있음
2. `중복 부분 문제 (Overlapping Subproblems)` : 동일한 작은 문제를 반복적으로 해결해야 하는 성질. 즉, 작은 문제를 해결할 때 반복적으로 같은 문제를 해결해야 함

## 동적 계획법의 종류
|종류|특징|장점|단점|
|:-:|-|-|-|
|탑다운(Top-Down) 방식|큰 문제를 해결하기 위해 작은 문제를 호출하는 방식|작은 문제들의 결과값을 저장함으로써 동일한 계산을 반복하지 않아 시간 복잡도가 감소함|스택 오버플로우 발생 가능성이 있음|
|바텀업(Bottom-Up) 방식|작은 문제부터 차례대로 해결해 나가는 방식|부분 문제의 해를 저장하고 이를 활용하여 다음 문제를 해결함으로써 시간 복잡도가 감소|초기값을 설정해주어야 하고, 작은 문제들의 결과값을 임시적으로 저장해 둘 공간이 필요함|

## 동적 계획법 구현

> ### 피보나치 수열 (탑다운(Top-Down) 방식)
> ```java
> public class TopDownDP {
>     static int[] dp = new int[100];
> 
>     public static int fib(int n) {
>         if (n <= 1) {
>             return n;
>         }
>         if (dp[n] != 0) { // 메모이제이션
>             return dp[n];
>         }
>         dp[n] = fib(n - 1) + fib(n - 2);
>         return dp[n];
>     }
> 
>     public static void main(String[] args) {
>         int n = 10;
>         System.out.println("fibonacci(" + n + ") = " + fib(n));
>     }
> }
> ```

> ### 피보나치 수열 (바텀업(Bottom-Up) 방식)
> ```java
> public int fibonacci(int n) {
>     if (n <= 1) {
>         return n;
>     }
>     int[] memo = new int[n+1];
>     memo[0] = 0;
>     memo[1] = 1;
>     for (int i = 2; i <= n; i++) {
>         memo[i] = memo[i-1] + memo[i-2];
>     }
>     return memo[n];
> }
> ```

## 레퍼런스
- https://adjh54.tistory.com/201
- https://loosie.tistory.com/150#h3

<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>

### 메모이제이션(Memoization)
이전에 계산한 값을 저장하여 다시 계산하지 않도록 하여 속도를 빠르게 하는 방법