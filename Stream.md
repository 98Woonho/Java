# Stream
- 스트림(`Stream`) : 컬렉션, 배열 등의 데이터 소스를 처리하고 변환 하기 위한 강력한 기능

## 스트림의 구성
1. 데이터 소스(Source)
    - 스트림은 컬렉션, 배열, I/O 채널 등 다양한 데이터 소스에서 생성
> ```java
> List<String> list = Arrays.asList("a", "b", "c");
> Stream<String> stream = list.stream();
> ```

2. 중간 연산
    - 스트림을 변환하거나 필터링
    - `filter()`, `map()`, `sorted()`, `distinct()`, `limit()`, `skip()` 등이 있음
    - 중간 연산은 지연 연산으로, 최종 연산이 호출되기 전까지 실제로 실행되지 않음
> ```java
> Stream<String> filteredStream = stream.filter(s -> s.startsWith("a"));
> ```

3. 최종 연산
    - 최종 연산은 스트림의 데이터를 소비하여 결과를 도출. 최종 연산을 수행하면 스트림은 더 이상 사용할 수 없음
    - `forEach()`, `collect()`, `reduce()`, `count()`, `findFirst()` 등이 있음
> ```java
> List<String> result = filteredStream.collect(Collectors.toList());
> ```

## 스트림의 장점
- 코드 가독성 : 스트림을 사용하면 반복문, 조건문 등 많은 코드를 줄일 수 있음
- 유연성 : 스트림을 사용하면 다양한 데이터 소스를 일관된 방식으로 처리 할 수 있음
- 병렬 처리 : 스트림의 병렬 처리는 멀티코어 CPU에서 데이터 처리 속도를 크게 향상시킬 수 있음


## 스트림 메서드
- `stream()` : 배열 및 컬렉션을 스트림으로 변환
> ```java
> int[] arr = {1, 2, 3, 4, 5};
> IntStream stream = Arrays.stream(arr);
> 
> List<String> list = Arrays.asList("apple", "banana", "cherry");
> Stream<String> stream = list.stream();
> ```

- `filter()` : 스트림의 요소 중 주어진 조건을 만족하는 요소만 필터링
> ```java
> int[] arr = {1, 2, 3, 4, 5};
> int[] evens = Arrays.stream(arr).filter(x -> x % 2 == 0).toArray(); // 2로 나눈 나머지가 0인 요소들만 필터링 [2, 4] 
> ```

- `map()` : 스트림의 각 요소에 함수를 적용하여 변환된 요소로 이루어진 새로운 스트림 생성
> ```java
> int[] arr = {1, 2, 3, 4, 5};
> int[] squares = Arrays.stream(arr).map(x -> x * x).toArray(); // [1, 4, 9, 16, 25]
> ```

- `flatMap()` : 각 요소를 스트림으로 변환한 후, 그 스트림들을 하나의 스트림으로 평탄화함. 주로 다차원 배열을 처리할 때 사용
> ```java
> int[][] arr = {{1, 2}, {3, 4}, {5, 6}};
> int[] flatArray = Arrays.stream(arr).flatMapToInt(Arrays::stream).toArray(); // [1, 2, 3, 4, 5, 6]
> ```

- `sorted()` : 스트림의 요소들을 정렬. 기본적으로 오름차순 정렬되며, `Comparator`를 사용하여 사용자 정의 정렬도 가능
> ```java
> int[] arr = {5, 3, 1, 4, 2};
> int[] sortedArr1 = Arrays.stream(arr).sorted().toArray(); // [1, 2, 3, 4, 5]
> int[] sortedArr2 = Arrays.stream(arr).sorted(Comparator.reverseOrder).toArray(); // [5, 4, 3, 2 ,1]
> ```

- `distinct()` : 스트림에서 중복된 요소를 제거
> ```java
> int[] arr = {1, 2, 2, 3, 4, 4, 5};
> int[] distinctArr = Arrays.stream(arr).distinct().toArray(); // [1, 2, 3, 4, 5]
> ```

- `limit()` : 스트림의 요소 중 지정한 개수를 반환
> ```java
> int[] arr = {1, 2, 3, 4, 5};
> int[] firstThree = Arrays.stream(arr).limit(3).toArray(); // [1, 2, 3]
> ```

- `skip()` : 스트림의 요소 중 지정한 개수만큼의 요소를 건너뛴 후 나머지 요소를 반환
> ```java
> int[] arr = {1, 2, 3, 4, 5};
> int[] skippedTwo = Arrays.stream(arr).skip(2).toArray(); // [3, 4, 5]
> ```

- `reduce()` : 스트림의 요소들을 결합하여 단일 결과를 생성. 주로 합계나 곱셈 등의 집계 작업에 사용
> ```java
> int[] arr = {1, 2, 3, 4, 5};
> int sum = Arrays.stream(arr).reduce(0, Integer::sum); // 15
> ```

- `collect()` : 스트림의 요소들을 컬렉션으로 수집
> ```java
> String[] arr = {"apple", "banana", "cherry"};
> List<String> list = Arrays.stream(arr).collect(Collectors.toList()); // [apple, banana, cherry]
> ```

- `anyMatch()`, `allMatch()`, `noneMatch()` : 스트림의 요소들이 주어진 조건을 만족하는지 확인. `anyMatch()`는 하나라도 만족하면 `true`, `allMatch()`는 모두 만족하면 `true`, `noneMatch()`는 모두 불만족하면 `true`를 반환
> ```java
> int[] arr = {1, 2, 3, 4, 5};
> boolean hasEven = Arrays.stream(arr).anyMatch(x -> x % 2 == 0); // true
> boolean allPositive = Arrays.stream(arr).allMatch(x -> x > 0); // true
> boolean noneNegative = Arrays.stream(arr).noneMatch(x -> x < 0); // true
> ```

- `findFirst()`, `findAny()` : 스트림에서 첫 번째 또는 임의의 요소를 탐색. 결과는 `Optional`로 반환
> ```java
> int[] arr = {1, 2, 3, 4, 5};
> OptionalInt first = Arrays.stream(arr).findFirst(); // OptionalInt[1]
> OptionalInt any = Arrays.stream(arr).findAny();    // OptionalInt[1] (순차 스트림에서)
> ```

- `toArray()` : 스트림의 요소들을 배열로 변환
> ```java
> int[] arr = {1, 2, 3, 4, 5};
> int[] array = Arrays.stream(arr).toArray(); // [1, 2, 3, 4, 5]
> ```

- `peek()` : 스트림의 각 요소에 대해 동작을 수행하고, 스트림을 그대로 반환. 주로 디버깅에 사용
> ```java
> int[] arr = {1, 2, 3, 4, 5};
> Arrays.stream(arr)
> .peek(x -> System.out.println("Element: " + x)) // 디버깅 출력
> .map(x -> x * 2)
> .toArray(); // [2, 4, 6, 8, 10]
> ```