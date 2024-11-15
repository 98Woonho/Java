# 주석
- 단일줄 주석 : // (내용)
- 여러줄 주석 : /* (내용) */
- 문서화 주석 : /** (문서화 내용) **/

# 메인 함수 호출
> ```java
> public class Main   { 
>     public static void main(String[] args) {
>         // 원하는 코드 작성
>     }
> }
> ```

# 출력문
- `System.out.print()` : 괄호 안의 내용을 출력함
- `System.out.println()` : 괄호 안의 내용을 출력하고 행을 바꿈
- `System.out.printf()` : 문자열을 서식 문자를 이용해 형식화된 내용으로 출력함

## 서식문자
| 서식 문자 | 출력 형태                     |
|-------|---------------------------|
| %d    | 정수(10진수)                  |
| %o    | 정수(8진수)                   |
| %x    | 정수(16진수)                  |
| %f    | 실수                        |
| %e    | 지수(e표기 기반)                |
| %g    | 출력 대상에 따라 %e 또는 %f 형태로 출력 |
| %s    | 문자열                       |
| %c    | 문자                        |

# 변수 및 상수
- 변수 : **변하는 값**이 담기는 메모리 공간
- 상수 : **고정된 값**이 담기는 메모리 공간

## 변수 작성법
> ```java
> int a = 5;
> ```
> - [TYPE] [이름] = [값];

## 상수 작성법
> ```java
> final int b = 8;
> ```
> - final [TYPE] [이름] = [값];

## 부호 및 크기
- `Signed` : 부호있는 숫자
- `Unsigned` : 부호없는 숫자
- 정수형
  - `byte` : 1 byte
  - `short` : 4 byte
  - `int` : 8 byte
  - `long` : 16 byte

- 실수형
  - `float` : 8 byte
  - `double` : 16 byte

- 문자열형
  - `String` : 문자열
  - `char` : ASCII용 글자하나

- 판별형
  - `boolean` : true/false