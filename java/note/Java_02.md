# 컴퓨터 주요 장치 구조
- **CPU** : 모든 연산이 일어남. <br>
   ↑↓
- **RAM** : 주기억장치. CPU가 처리하는 데이터가 저장되는 장소 <br>
   ↑↓
- **HDD(SDD)** : 보조 기억 장치 (전원 공급과 무관)

<br>

# 운영체제에 독립적인 자바 프로그램
- Winform에서 동작하는 프로그램의 공통적인 기능은 Win32 API를 사용함
- 하지만 이렇게 만들어진 프로그램은 MacOS에서는 돌아가지 않음
- 이처럼 <u>일반 프로그램은 운영체제에 종속적임</u>
- 프로그램 제작사, 개발자 -> 같은 프로그램을 Window, Mac 2개를 만들어야 함
- 이를 해결하기 위해 Java는 프로그램과 운영체제 사이에 하나의 프로그램을 추가함 -> **Java Virtual Machine**
- 프로그램은 먼저 중간언어로 번역되고 JVM에 의해 운영체제에 맞는 기계어로 번역됨
- 하지만 현실적으로 여러 운영체제에서 Virtual Machine을 완전하게 똑같이 만들 수 없기 때문에 적용하기는 힘듦

<br>

# Eclipse 단축키
- Ctrl + Alt + 방향키(위, 아래) : 선택한 영역 복사
- Alt + 방향키(위, 아래) : 라인 이동

<br>

---

<br>

# 변수와 자료형
## 변수 (Variable)
 값을 저장할 수 있는 메모리상의 공간


<br>

## 자료형 (Data type)
데이터의 형태에 따라 값이 저장될 공간의 크기와 저장형식을 정의한 것

- 원시형(Primitive Type), 값형(Value Type)

    - 정수
        - byte : 1byte
        - short : 2byte
        - int : 4byte
        - long : 8byte
    - 실수
        - double : 8byte
        - float : 4byte
    - 문자
        - char : 2byte
    - 논리형
        - boolean : 1byte
    
    <br>

- 참조형(Reference Type)

<br>

