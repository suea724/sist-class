# 📌 MVC 패턴
**Model, View, Controller**의 약자로, 소프트웨어  공학에서 사용되는 소프트웨어 디자인 패턴이다. 소프트웨어의 비즈니스 로직과 화면을 구분하여 **관심사 분리**를 통해 더 나은 업무의 분리와 향상된 관리를 제공한다.
- Model : 데이터와 비즈니스 로직을 관리한다.
- View : 사용자가 보게될 결과 화면을 출력한다.
- Controller : 사용자의 입력 처리와 흐름 제어를 담당한다.

<br>

# 📌 JSP에서의 MVC 패턴
JSP 웹사이트 구조는 크게 Model 1 방식과 Model 2 방식으로 나뉜다.

### ✅ Model 1
![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Ft1.daumcdn.net%2Fcfile%2Ftistory%2F99A907335A1BAF5810)
- JSP는 웹 브라우저의 요청을 받아 자바 빈이나 서비스 클래스를 사용하여 요청을 처리하고 결과를 출력한다.
- 비즈니스 로직을 처리하는 코드와 결과 화면을 출력하는 코드가 함께 존재한다.
- 각 역할을 분리를 하지 않아 코드가 복잡해지며, 규모가 커질 수록 유지보수가 힘들다는 단점이 있다.

<br>

### ✅ Model 2
![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Ft1.daumcdn.net%2Fcfile%2Ftistory%2F995D11335A1BB0C603)
- 웹 브라우저의 요청을 서블릿(Controller)이 받고, 웹 브라우저의 요청을 받아 처리 후 View로 보낼 것인지 Model로 보낼 것인지 정하여 전송한다.
- JSP(View)는 사용자에게 보여주는 화면을 출력하는 역할만 담당한다.
- Model 1 방식에 비해 개발을 확장시키기도 쉽고, 유지보수하기도 쉽다.


[참고](https://coding-factory.tistory.com/69)