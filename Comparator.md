# Comparator

## Comparator란?
Java에서 객체의 순서를 정의하기 위한 함수형 인터페이스. 두 객체를 비교하는 메서드를 제공하여, 객체의 정렬 순서를 지정 할 수 있게 해줌. 기본 정렬과는 다른 정렬을 하고 싶을 때 유용함

> ```java
> import java.util.*;
> import java.util.function.*;
> 
> class Person {
>     String name;
>     int age;
>     double salary;
> 
>     public Person(String name, int age, double salary) {
>         this.name = name;
>         this.age = age;
>         this.salary = salary;
>     }
> 
>     @Override
>     public String toString() {
>         return name + ": " + age + ", Salary: $" + salary;
>     }
> }
> 
> public class Main {
>     public static void main(String[] args) {
>         List<Person> people = Arrays.asList(
>                 new Person("Alice", 30, 60000),
>                 new Person("Bob", 25, 50000),
>                 new Person("Charlie", 25, 55000),
>                 new Person("David", 30, 70000)
>         );
> 
>         // 1. 기본 비교 메서드 compare(T o1, T o2): 나이를 기준으로 오름차순 정렬
>         people.sort(new Comparator<Person>() {
>             @Override
>             public int compare(Person p1, Person p2) {
>                 return p1.age - p2.age;
>             }
>         });
>         System.out.println("1. 나이로 오름차순 정렬:");
>         System.out.println(people);
> 
>         // 2. reversed(): 나이를 기준으로 내림차순 정렬
>         people.sort(Comparator.comparingInt(person -> person.age).reversed());
>         System.out.println("\n2. 나이로 내림차순 정렬:");
>         System.out.println(people);
> 
>         // 3. comparing()을 사용해 이름 기준 오름차순 정렬
>         people.sort(Comparator.comparing(person -> person.name));
>         System.out.println("\n3. 이름으로 오름차순 정렬:");
>         System.out.println(people);
> 
>         // 4. thenComparing()을 사용해 나이가 같으면 급여로 정렬
>         people.sort(Comparator.comparingInt(Person::age)
>                 .thenComparingDouble(Person::salary));
>         System.out.println("\n4. 나이로 정렬하고, 나이가 같으면 급여로 오름차순 정렬:");
>         System.out.println(people);
> 
>         // 5. comparingInt()를 사용해 급여로 정렬
>         people.sort(Comparator.comparingDouble(Person::salary));
>         System.out.println("\n5. 급여로 오름차순 정렬:");
>         System.out.println(people);
> 
>         // 6. thenComparing()과 reversed()를 조합하여 급여를 내림차순 정렬하고, 급여가 같으면 이름으로 정렬
>         people.sort(Comparator.comparingDouble(Person::salary).reversed()
>                 .thenComparing(Person::name));
>         System.out.println("\n6. 급여로 내림차순 정렬하고, 급여가 같으면 이름으로 오름차순 정렬:");
>         System.out.println(people);
>     }
> }
> ```
> - `compare(T o1, T o2)`
>   - `Person` 객체의 나이를 기준으로 오름차순으로 정렬
>   - `p1.age - p2.age`는 나이가 작은 사람부터 정렬
> 
>
> - `reversed()`
>   - `Comparator`를 반전하여 나이를 내림차순으로 정렬
> 
> 
> - `comparing()`
>   - 이름을 기준으로 오름차순 정렬. 특정 필드(`name`)에 대해 간단하기 정렬하는 `Comparator`를 생성
> 
> 
> - `thenComparing()`
>   - 이전 정렬에서 값이 같은 경우에 추가적으로 기준을 정해 정렬
> 
> 
> - `comparingInt()` 또는 `comparingDouble()`
>   - 숫자 값을 기준으로 정렬할 때 사용하는 메서드