# 탐욕법(Greedy)

## 탐욕법이란?
현재 단계에서 가장 최적이라고 생각되는 선택을 반복적으로 수행하여 전체 문제를 해결하는 알고리즘

## 탐욕법 기본 원리
1. `문제의 구조를 이해하기` : 문제를 해결하기 위해 필요한 요소와 조건을 파악한다.
2. `탐욕적 선택 속성` : 현재 상황에서 가장 좋은 선택을 한다. 이 선택은 이후 단계에서의 최적해를 보장하지 않지만, 그 순간에 최선의 선택이다.
3. `최적 부분 구조` : 문제의 최적해가 부분 문제의 최적해로 구성될 수 있어야 한다. 즉, 큰 문제의 최적해는 작은 문제의 최적해로부터 유도될 수 있어야 한다.

## 탐욕법 구현

> ### 예제 1) 거스름돈
> 마트에서 계산을 하는 점원이 되었다. 손님에게 거슬러줘야할 돈이 N원일 때 거슬러줘야 할 동전의 최소 개수를 구하라. 이때 거스름돈으로 사용할 동전은 500원, 100원, 50원, 10원으로 무한히 존재하고, N은 10의 배수로 가정
> ```java
> public class Main {
>     public static void main(String[] args) {
>         Scanner scan = new Scanner(System.in);
>         int total = scan.nextInt();
>         int minCoinCnt = 0;
>         int coins[] = {500, 100, 50, 10};
> 
> 	      for (int coin : coins){
> 	          minCoinCnt += (total/coin);
> 	          total %= coin;
> 	      }
> 		
> 		  System.out.println("result = " + minCoinCnt);
> 	  }
> }
> ```
> 최소 개수를 구하기 위해서는 `가장 큰 화폐 단위부터` 돈을 거슬러 준다.

> ### 예제 2) 큰 수의 법칙
> 다양한 수로 이루어진 배열이 있을 때 주어진 수들을 M번 더하여 가장 큰 수를 만드는 법칙 단, 배열의 특정한 인덱스(번호)에 해당하는 수가 연속해서 K번을 초과하여 더해질 수 없는 것이 이 법칙의 특징이다.
> <br/>
> 배열의 크기 N, 숫자가 더해지는 횟수 M, 그리고 K가 주어질 때 큰 수의 법칙에 따른 결과를 출력하시오.
> ```java
> public class Main {
>     public static void main(String[] args) {
>         Scanner scan = new Scanner(System.in);  
>        
>         // 조건 값들 입력 받기
>         int n = scan.nextInt();
>         int m = scan.nextInt();
>         int k = scan.nextInt();
>         int numArr[] = new int[n];  
>      
>         for(int i = 0; i < n; i++){
>             numArr[i] = scan.nextInt();
>         }
>         // 배열 내림차순 정렬
>         numArr = Arrays.stream(numArr)
>                  	    .boxed()
>                  	    .sorted(Comparator.reverseOrder())
>                 	    .mapToInt(i -> i)
>                  	    .toArray();
>       
>         //첫번재 값이 더해지는 횟수 계산
>         int first = (m / (k+1) * k) + (m % (k+1));
>         int second = m - first;
>         int result = (numArr[0] * first) + (numArr[1] * second);
> 
>         System.out.println("result =" + result);
>     }
> }
> ```
> 최소 개수를 구하기 위해서는 `가장 큰 화폐 단위부터` 돈을 거슬러 준다.