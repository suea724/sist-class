# 📌 Spring Framework 어노테이션

### ✅ @Bean
- 개발자가 직접 제어가 불가능한 외부 라이브러리 등을 Bean으로 만들려고 할 때 사용되는 어노테이션 

<br>

### ✅ @Component
```java
@Component // student
public class Student { 
    public Student() {
        System.out.println("hi");
    }
}

@Component(value="mystudent") // mystudent
public class Student { 
    public Student() {
        System.out.println("hi");
    }
}
```
- 개발자가 직접 작성한 클래스를 Bean으로 등록하기 위한 어노테이션
- value를 지정하지 않으면 클래스의 이름을 캐멀 케이스 표기법으로 변경한 이름을 Bean의 이름으로 설정한다.


<br>

### ✅ @ComponentScan
- Spring Framework는 `@Component`, `@Service`, `@Repository`, `@Controller`, `@Configuration` 중 1개라도 등록된 클래스를 찾으면 컨테이너에 Bean으로 등록함
- `@ComponentScan`이 있는 클래스에 대해 Bean 인스턴스를 생성한다.
- `@Component`보다 `@Service`, `@Repository`, `@Controller` 등을 사용하는 이유는 각 애노테이션에 대해 성격에 맞는 예외처리를 수행할 수 있고, 가독성 측면에서도 해당 어노테이션을 가지는 클래스의 역할을 쉽게 알 수 있기 때문이다.
- Bean의 이름은 클래스의 첫문자가 소문자로 바뀐 이름이 적용된다.

<br>

### ✅ @Controller
- 해당 클래스가 Controller의 역할을 한다고 명시하기 위해 사용
- URL 매핑 및 해당 URL의 요청의 처리는 서비스 클래스에 위임하고 그 결과를 View로 전달하는 역할만 하는 것이 좋다. (역할 분리)

<br>

### ✅ @Repository
- DAO 클래스에서 사용
- Database에 접근하는 메서드를 가지고 있는 클래스에서 사용

<br>


### ✅ @Service
- 서비스 클래스에서 사용
- 비즈니스 로직을 수행하는 클래스라는 것을 나타내는 용도

<br>


### ✅ @RequestMapping
```java
@Controller
// 1. Class Level
//모든 메서드에 적용되는 경우 "/home"으로 들어오는 모든 요청에 대한 처리를 해당 클래스에서 한다는 것을 의미
@RequestMapping("/home") 
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String getAllEmployees(Model model) {
        ...
    }
    /*
    2. Handler Level
    요청 url에 대해 해당 메서드에서 처리해야 되는 경우
    "/home/employees" POST 요청에 대한 처리를 addEmployee()에서 한다는 것을 의미한다.
    value: 해당 url로 요청이 들어오면 이 메서드가 수행된다.
    method: 요청 method를 명시한다. 없으면 모든 http method 형식에 대해 수행된다.
    */
    @RequestMapping(value = "/employees", method = RequestMethod.POST) 
    public String addEmployee(Employee employee) {
        ...
    }
}
```
- 요청 URL을 처리할 메서드를 지정해주는 어노테이션
- Controller 클래스 또는 Controller 클래스의 메서드에 적용한다.
- 요청을 처리하는 HTTP 메서드 (GET, POST, PATCH, PUT, DELETE)를 지정할 수 있다.
- 지정하지 않는 경우 모든 메서드에 대해 요청을 처리한다.

<br>


### ✅ @RequestParam
```java
@GetMapping("/home")
public String show(@RequestParam("name") String name {
}
```
- URL에 전달되는 파라미터를 메서드의 매개변수와 매칭시켜 처리한다.
- ?name=hong 과 같은 쿼리 파라미터를 파싱해준다.
- 어노테이션의 인자를 생략하면 변수의 이름으로 파싱한다.
- 어노테이션을 생략해도 파싱된다.


<br>


### ✅ @RequestBody
```java
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping(method = RequestMethod.POST)
    public String addUser(@RequestBody User user) {
        String sub_name = user.name;
        String sub_old = user.old;
    }
}
```
- 요청이 온 데이터 (JSON 또는 XML 형식)를 바로 Class나 Model로 매핑하기 위한 어노테이션
- POST, PUT, PATCH로 요청을 받을 때 요청에서 넘어온 body 값을 자바 Object로 파싱


<br>


### ✅ @ModelAttribute
```java
@Getter
@Setter
class Person{
    String id;
}

@Controller
@RequestMapping("/person/*")
public class PersonController{
	@RequestMapping(value = "/info", method=RequestMethod.GET)
    //view에서 myMEM으로 던져준 데이터에 담긴 id 변수를 Person타입의 person이라는 객체명으로 바인딩.
	public void show(@ModelAttribute("myMEM") Person person, Model model) {
         model.addAttribute(service.read(person.getId())); 
    }
}
```
- View에서 전달하는 파라미터를 객체 형태로 바인딩해주는 어노테이션
- 폼 컨트롤의 name값이 해당 클래스의 멤버 변수명과 일치해야 하고, setter명도 일치해야 한다.


<br>


### ✅ @Autowired
- 의존성 주입 어노테이션
- 속성(field), Setter, 생성자(권장)에서 사용하며 스프링은 컨테이너에서 해당 빈을 찾아 주입한다.
- Spring Framework가 클래스를 보고 Type에 맞게 (Type을 먼저 확인 후 없으면 Name을 확인) Bean을 주입한다.


<br>

### ✅ @Qualifier()
- `@Autowired`와 같이 쓰이며 같은 타입의 Bean이 두 개 이상이 존재하는 경우 어떤 Bean을 사용할지 지정한다.


<br>



### ✅ @RequestMapping
```java
@Controller                   // 이 Class는 Controller 역할을 합니다
@RequestMapping("/user")      // 이 Class는 /user로 들어오는 요청을 모두 처리합니다.
public class UserController {
    @RequestMapping(method = RequestMethod.GET)
    public String getUser(Model model) {
        //  GET method, /user 요청을 처리
    }
    @RequestMapping(method = RequestMethod.POST)
    public String addUser(Model model) {
        //  POST method, /user 요청을 처리
    }
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String addUser(Model model) {
        //  GET method, /user/info 요청을 처리
    }
}
```

<br>


### ✅ @GetMapping
- `@RequestMapping(Method=RequestMethod.GET)`과 동일

<br>


### ✅ @PostMapping
- `@RequestMapping(Method=RequestMethod.POST)`과 동일


<br>




[참조 - 스프링에서 자주 사용하는 Annotation 개념 및 예제 정리](https://melonicedlatte.com/2021/07/18/182600.html)<br>
[참조 - Spring Annotation 정리](https://velog.io/@gillog/Spring-Annotation-%EC%A0%95%EB%A6%AC#service)

