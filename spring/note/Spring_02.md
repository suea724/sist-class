# ๐ Spring Framework ์ด๋ธํ์ด์

### โ @Bean
- ๊ฐ๋ฐ์๊ฐ ์ง์  ์ ์ด๊ฐ ๋ถ๊ฐ๋ฅํ ์ธ๋ถ ๋ผ์ด๋ธ๋ฌ๋ฆฌ ๋ฑ์ Bean์ผ๋ก ๋ง๋ค๋ ค๊ณ  ํ  ๋ ์ฌ์ฉ๋๋ ์ด๋ธํ์ด์ 

<br>

### โ @Component
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
- ๊ฐ๋ฐ์๊ฐ ์ง์  ์์ฑํ ํด๋์ค๋ฅผ Bean์ผ๋ก ๋ฑ๋กํ๊ธฐ ์ํ ์ด๋ธํ์ด์
- value๋ฅผ ์ง์ ํ์ง ์์ผ๋ฉด ํด๋์ค์ ์ด๋ฆ์ ์บ๋ฉ ์ผ์ด์ค ํ๊ธฐ๋ฒ์ผ๋ก ๋ณ๊ฒฝํ ์ด๋ฆ์ Bean์ ์ด๋ฆ์ผ๋ก ์ค์ ํ๋ค.


<br>

### โ @ComponentScan
- Spring Framework๋ `@Component`, `@Service`, `@Repository`, `@Controller`, `@Configuration` ์ค 1๊ฐ๋ผ๋ ๋ฑ๋ก๋ ํด๋์ค๋ฅผ ์ฐพ์ผ๋ฉด ์ปจํ์ด๋์ Bean์ผ๋ก ๋ฑ๋กํจ
- `@ComponentScan`์ด ์๋ ํด๋์ค์ ๋ํด Bean ์ธ์คํด์ค๋ฅผ ์์ฑํ๋ค.
- `@Component`๋ณด๋ค `@Service`, `@Repository`, `@Controller` ๋ฑ์ ์ฌ์ฉํ๋ ์ด์ ๋ ๊ฐ ์ ๋ธํ์ด์์ ๋ํด ์ฑ๊ฒฉ์ ๋ง๋ ์์ธ์ฒ๋ฆฌ๋ฅผ ์ํํ  ์ ์๊ณ , ๊ฐ๋์ฑ ์ธก๋ฉด์์๋ ํด๋น ์ด๋ธํ์ด์์ ๊ฐ์ง๋ ํด๋์ค์ ์ญํ ์ ์ฝ๊ฒ ์ ์ ์๊ธฐ ๋๋ฌธ์ด๋ค.
- Bean์ ์ด๋ฆ์ ํด๋์ค์ ์ฒซ๋ฌธ์๊ฐ ์๋ฌธ์๋ก ๋ฐ๋ ์ด๋ฆ์ด ์ ์ฉ๋๋ค.

<br>

### โ @Controller
- ํด๋น ํด๋์ค๊ฐ Controller์ ์ญํ ์ ํ๋ค๊ณ  ๋ช์ํ๊ธฐ ์ํด ์ฌ์ฉ
- URL ๋งคํ ๋ฐ ํด๋น URL์ ์์ฒญ์ ์ฒ๋ฆฌ๋ ์๋น์ค ํด๋์ค์ ์์ํ๊ณ  ๊ทธ ๊ฒฐ๊ณผ๋ฅผ View๋ก ์ ๋ฌํ๋ ์ญํ ๋ง ํ๋ ๊ฒ์ด ์ข๋ค. (์ญํ  ๋ถ๋ฆฌ)

<br>

### โ @Repository
- DAO ํด๋์ค์์ ์ฌ์ฉ
- Database์ ์ ๊ทผํ๋ ๋ฉ์๋๋ฅผ ๊ฐ์ง๊ณ  ์๋ ํด๋์ค์์ ์ฌ์ฉ

<br>


### โ @Service
- ์๋น์ค ํด๋์ค์์ ์ฌ์ฉ
- ๋น์ฆ๋์ค ๋ก์ง์ ์ํํ๋ ํด๋์ค๋ผ๋ ๊ฒ์ ๋ํ๋ด๋ ์ฉ๋

<br>


### โ @RequestMapping
```java
@Controller
// 1. Class Level
//๋ชจ๋  ๋ฉ์๋์ ์ ์ฉ๋๋ ๊ฒฝ์ฐ "/home"์ผ๋ก ๋ค์ด์ค๋ ๋ชจ๋  ์์ฒญ์ ๋ํ ์ฒ๋ฆฌ๋ฅผ ํด๋น ํด๋์ค์์ ํ๋ค๋ ๊ฒ์ ์๋ฏธ
@RequestMapping("/home") 
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String getAllEmployees(Model model) {
        ...
    }
    /*
    2. Handler Level
    ์์ฒญ url์ ๋ํด ํด๋น ๋ฉ์๋์์ ์ฒ๋ฆฌํด์ผ ๋๋ ๊ฒฝ์ฐ
    "/home/employees" POST ์์ฒญ์ ๋ํ ์ฒ๋ฆฌ๋ฅผ addEmployee()์์ ํ๋ค๋ ๊ฒ์ ์๋ฏธํ๋ค.
    value: ํด๋น url๋ก ์์ฒญ์ด ๋ค์ด์ค๋ฉด ์ด ๋ฉ์๋๊ฐ ์ํ๋๋ค.
    method: ์์ฒญ method๋ฅผ ๋ช์ํ๋ค. ์์ผ๋ฉด ๋ชจ๋  http method ํ์์ ๋ํด ์ํ๋๋ค.
    */
    @RequestMapping(value = "/employees", method = RequestMethod.POST) 
    public String addEmployee(Employee employee) {
        ...
    }
}
```
- ์์ฒญ URL์ ์ฒ๋ฆฌํ  ๋ฉ์๋๋ฅผ ์ง์ ํด์ฃผ๋ ์ด๋ธํ์ด์
- Controller ํด๋์ค ๋๋ Controller ํด๋์ค์ ๋ฉ์๋์ ์ ์ฉํ๋ค.
- ์์ฒญ์ ์ฒ๋ฆฌํ๋ HTTP ๋ฉ์๋ (GET, POST, PATCH, PUT, DELETE)๋ฅผ ์ง์ ํ  ์ ์๋ค.
- ์ง์ ํ์ง ์๋ ๊ฒฝ์ฐ ๋ชจ๋  ๋ฉ์๋์ ๋ํด ์์ฒญ์ ์ฒ๋ฆฌํ๋ค.

<br>


### โ @RequestParam
```java
@GetMapping("/home")
public String show(@RequestParam("name") String name {
}
```
- URL์ ์ ๋ฌ๋๋ ํ๋ผ๋ฏธํฐ๋ฅผ ๋ฉ์๋์ ๋งค๊ฐ๋ณ์์ ๋งค์นญ์์ผ ์ฒ๋ฆฌํ๋ค.
- ?name=hong ๊ณผ ๊ฐ์ ์ฟผ๋ฆฌ ํ๋ผ๋ฏธํฐ๋ฅผ ํ์ฑํด์ค๋ค.
- ์ด๋ธํ์ด์์ ์ธ์๋ฅผ ์๋ตํ๋ฉด ๋ณ์์ ์ด๋ฆ์ผ๋ก ํ์ฑํ๋ค.
- ์ด๋ธํ์ด์์ ์๋ตํด๋ ํ์ฑ๋๋ค.


<br>


### โ @RequestBody
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
- ์์ฒญ์ด ์จ ๋ฐ์ดํฐ (JSON ๋๋ XML ํ์)๋ฅผ ๋ฐ๋ก Class๋ Model๋ก ๋งคํํ๊ธฐ ์ํ ์ด๋ธํ์ด์
- POST, PUT, PATCH๋ก ์์ฒญ์ ๋ฐ์ ๋ ์์ฒญ์์ ๋์ด์จ body ๊ฐ์ ์๋ฐ Object๋ก ํ์ฑ


<br>


### โ @ModelAttribute
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
    //view์์ myMEM์ผ๋ก ๋์ ธ์ค ๋ฐ์ดํฐ์ ๋ด๊ธด id ๋ณ์๋ฅผ Personํ์์ person์ด๋ผ๋ ๊ฐ์ฒด๋ช์ผ๋ก ๋ฐ์ธ๋ฉ.
	public void show(@ModelAttribute("myMEM") Person person, Model model) {
         model.addAttribute(service.read(person.getId())); 
    }
}
```
- View์์ ์ ๋ฌํ๋ ํ๋ผ๋ฏธํฐ๋ฅผ ๊ฐ์ฒด ํํ๋ก ๋ฐ์ธ๋ฉํด์ฃผ๋ ์ด๋ธํ์ด์
- ํผ ์ปจํธ๋กค์ name๊ฐ์ด ํด๋น ํด๋์ค์ ๋ฉค๋ฒ ๋ณ์๋ช๊ณผ ์ผ์นํด์ผ ํ๊ณ , setter๋ช๋ ์ผ์นํด์ผ ํ๋ค.


<br>


### โ @Autowired
- ์์กด์ฑ ์ฃผ์ ์ด๋ธํ์ด์
- ์์ฑ(field), Setter, ์์ฑ์(๊ถ์ฅ)์์ ์ฌ์ฉํ๋ฉฐ ์คํ๋ง์ ์ปจํ์ด๋์์ ํด๋น ๋น์ ์ฐพ์ ์ฃผ์ํ๋ค.
- Spring Framework๊ฐ ํด๋์ค๋ฅผ ๋ณด๊ณ  Type์ ๋ง๊ฒ (Type์ ๋จผ์  ํ์ธ ํ ์์ผ๋ฉด Name์ ํ์ธ) Bean์ ์ฃผ์ํ๋ค.


<br>

### โ @Qualifier()
- `@Autowired`์ ๊ฐ์ด ์ฐ์ด๋ฉฐ ๊ฐ์ ํ์์ Bean์ด ๋ ๊ฐ ์ด์์ด ์กด์ฌํ๋ ๊ฒฝ์ฐ ์ด๋ค Bean์ ์ฌ์ฉํ ์ง ์ง์ ํ๋ค.


<br>



### โ @RequestMapping
```java
@Controller                   // ์ด Class๋ Controller ์ญํ ์ ํฉ๋๋ค
@RequestMapping("/user")      // ์ด Class๋ /user๋ก ๋ค์ด์ค๋ ์์ฒญ์ ๋ชจ๋ ์ฒ๋ฆฌํฉ๋๋ค.
public class UserController {
    @RequestMapping(method = RequestMethod.GET)
    public String getUser(Model model) {
        //  GET method, /user ์์ฒญ์ ์ฒ๋ฆฌ
    }
    @RequestMapping(method = RequestMethod.POST)
    public String addUser(Model model) {
        //  POST method, /user ์์ฒญ์ ์ฒ๋ฆฌ
    }
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String addUser(Model model) {
        //  GET method, /user/info ์์ฒญ์ ์ฒ๋ฆฌ
    }
}
```

<br>


### โ @GetMapping
- `@RequestMapping(Method=RequestMethod.GET)`๊ณผ ๋์ผ

<br>


### โ @PostMapping
- `@RequestMapping(Method=RequestMethod.POST)`๊ณผ ๋์ผ


<br>




[์ฐธ์กฐ - ์คํ๋ง์์ ์์ฃผ ์ฌ์ฉํ๋ Annotation ๊ฐ๋ ๋ฐ ์์  ์ ๋ฆฌ](https://melonicedlatte.com/2021/07/18/182600.html)<br>
[์ฐธ์กฐ - Spring Annotation ์ ๋ฆฌ](https://velog.io/@gillog/Spring-Annotation-%EC%A0%95%EB%A6%AC#service)

