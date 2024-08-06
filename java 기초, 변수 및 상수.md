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
- Signed : 부호있는 숫자
- Unsigned : 부호없는 숫자
- 정수형
  - byte : 1 byte
  - short : 4 byte
  - int : 8 byte
  - long : 16 byte

- 실수형
  - float : 8 byte
  - double : 16 byte

- 문자열형
  - String : 문자열
  - char : ASCII용 글자하나

- 판별형
  - boolean : true/false