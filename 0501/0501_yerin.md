
# **[면접 질문 공부]**  

[출처]

https://m.blog.naver.com/goddlaek/220901890910

[https://m.blog.naver.com/acornedu/221128616501](https://m.blog.naver.com/acornedu/221128616501)

[https://mangkyu.tistory.com/14](https://mangkyu.tistory.com/14)

[https://ko.wikipedia.org/wiki/공용_게이트웨이_인터페이스](https://ko.wikipedia.org/wiki/%EA%B3%B5%EC%9A%A9_%EA%B2%8C%EC%9D%B4%ED%8A%B8%EC%9B%A8%EC%9D%B4_%EC%9D%B8%ED%84%B0%ED%8E%98%EC%9D%B4%EC%8A%A4)

[https://ko.wikipedia.org/wiki/아파치_톰캣](https://ko.wikipedia.org/wiki/%EC%95%84%ED%8C%8C%EC%B9%98_%ED%86%B0%EC%BA%A3)

[https://coding-factory.tistory.com/742](https://coding-factory.tistory.com/742)


<br>
<br>

## 0. 요약 정리

|  | Servlet | JSP |
| --- | --- | --- |
| 정의 및 구조 | 순수 Java 코드로만 이루어진 웹서버용 클래스 <br> 동적 웹페이지를 만들 때 java 코드 안에 HTML 태그가 삽입되는 구조. | HTML 코드 속에 자바 코드가 들어가는 구조의 스크립트 언어 |
| 코드 내 처리방법 | 자바 코드 속에서 HTML 태그로 문자열(””) 로 처리해야 함. | HTML 속에서 자바코드를 <% 소스코드 %> 또는 <%= 소스코드 =%>형태로 처리. <br> (자바 소스코드로 작성된 부분은 웹 브라우저로 보내는 것이 아니라 웹 서버에서 실행됨)  |
| 한계(Servlet)와 보완(JSP) | 1. 화면 인터페이스 구현에 너무 많은 코드를 필요로 하는 비효율성 <br> 2. 테스트할 때 빌드를 항상 다시해야 한다는 한계가 있음 <br> 3. HTML 변경 시 Servlet을 재컴파일해야 하는 단점 | →  이에 따라 서블릿 기반의 서버사이트 스크립트 언어 JSP가 등장 <br> 1. HTML 표준에 따라 작성되므로 서블릿과 달리 웹페이지 작성이 편리하고, <br> 2. WAS에서 자동으로 빌드하고 클라이언트 화면에 동적으로 보여준다. |
| MVC 패턴에서의 역할 | Controller 역할 | View 역할 |

<br>
<br>

## 1. Servlet과 JSP에 대해
  
> Servlet과 JSP 모두 동적 웹페이지(Dynamic Web Page)를 만들거나 데이터 처리를 수행하기 위해 사용되는 웹 어플리케이션 프로그래밍 기술이다.  
<br>
`Servlet`은 Tomcat이 이해할수 있는 순수 Java 코드로만 이루어진 웹서버용 클래스로, 동적 웹페이지를 만들 때 java 코드 안에 HTML 태그가 삽입되는 구조이다.  
<br>
반면 `JSP`는 HTML 코드 속에 자바 코드가 들어가는 구조의 스크립트 언어라고 할 수 있다.

<br>
<br>

## 2. CGI → Servlet → JSP
<br>

- 웹의 역사와 흐름에 따라 각 개념이 등장한 순서 : `CGI → Servlet → JSP`


<br>

* CGI의 등장
    - 일반적으로 웹서버는 `정적인 페이지`만을 제공한다. 그렇기 때문에 사용자의 요청을 받아 정보를 동적으로 생성하고, 이를 클라이언트로 다시 보내주는 것이 불가능했다. 
    - 따라서 서버에서 다른 프로그램을 불러내고, 그 프로그램 
    처리 결과를 보내줄 수 있는 인터페이스가 필요했다. 이것이 `CGI`다.  

<br>

* CGI의 한계와 Servlet의 등장  
    - CGI 프로그램은 서버에서 **프로세스** 단위로 실행이 된다. 따라서 사용자의 요청이 많을때 서버에 부하가 크게 가게 되었고 프로세스 보다 더 작은 단위로 실행하는것이 필요했다.

    - 이에 따라 **스레드** 단위로 실행하여 서버 부하를 줄이고 성능을 개선한 `Servlet`이 등장했다.

<br>

* Servlet의 한계와 JSP의 등장
    - Servlet은 Tomcat이 이해할 수 있는 순수 Java 코드로만 이루어진 웹서버용 클래스이다.  

    - 서블릿을 이용하면 웹 프로그래밍이 가능하지만, 자바에 대한 지식이 필요하고, **화면 인터페이스 구현**에 너무 많은 코드를 필요로 하는 등 비효율적인 측면이 있었다.  
    
    - 예를 들어 서블릿만 사용하여 사용자가 요청한 웹페이지를 보여주려면 out 객체의 print() 메소드를 이용하여 HTML 문서를 작성해야 하는데, 이는 추가/수정을 어렵게 하고 가독성도 떨어지는 등, 다른 서버사이드 언어보다 불편하다. 

    - 또한 Java클래스이기 때문에 테스트하기 위해서는 항상 **빌드를 다시** 하여 확인해야 했고, 이런 한계를 보완하기 위해 등장한 것이 `서블릿 기반의 서버 스크립트 기술 JSP`였다. 
    (스크립트 기술이란 ASP, PHP처럼 미리 약속된 규정에 따라 간단한 키워드를 조합하여 입력하면, 실행 시점에 각각의 키워드에 매핑이 되어 있는 어떤 코드로 변환 후에 실행되는 형태이다.)

<br>

▶ 즉, 일반적으로 정적인 페이지만 제공하는 웹서버가 동적인 페이지를 생성할 수 있도록 하는 것이 CGI이며, 마찬가지로 서블릿과 JSP 모두 동적 페이지 제공을 돕는 어플리케이션으로, CGI의 범주에 든다고 할 수 있다. 

<br>

<참고>
- JSP가 서블릿으로 변환되어 실행되는 과정  

1. 클라이언트에서 서비스가 요청되면 JSP의 실행을 요구한다.  

2. JSP는 웹어플리케이션 서버(Tomcat)의 서블릿 컨테이너에서 서블릿 원시코드로 변환된다.  

3. 서블릿 원시코드는 바로 컴파일된 후 실행되어 결과를 HTML 형태로 클라이언트에 돌려준다.    


<br>
<br>

## 3. MVC 패턴에서 Servlet과 JSP

- MVC 모델은 View는 JSP, Controller는 Servlet으로 사용한다.  

- JSP만 이용한 개발(Model1)방식에서 유지보수 측면의 한계를 느끼면서, 서블릿과 JSP를 각각 Controller와 View의 역할로 나누어 사용하는 개발 방식(Model2) 방식이 등장했다.  

- 보여지는 부분은 HTML이 중심이 되는 JSP, 다른 자바클래스에게 데이터를 넘겨주는 부분은 Java코드가 중심이 되는 Servlet이 담당하며, 이를 통해 유지보수가 용이해졌다.

<br>

## 4. Servlet과 JSP 동작 과정

(출처 : [https://mangkyu.tistory.com/14](https://mangkyu.tistory.com/14))

<br>

### **Servlet 동작 방식**

<img width="600" alt="993A7F335A04179D20" src="https://user-images.githubusercontent.com/101503543/166148838-47bca2da-c281-412b-a028-e4024cfac2ca.png">


1. 사용자(클라이언트)가 URL을 입력하면 HTTP Request가 Servlet Container로 전송한다.
2. 요청을 전송받은 Servlet Container는 HttpServletRequest, HttpServletResponse 객체를 생성한다.
3. web.xml을 기반으로 사용자가 요청한 URL이 어느 서블릿에 대한 요청인지(= 매핑할 서블릿) 찾는다.
4. 해당 서블릿의 인스턴스 존재 유무를 확인하여 없으면 init() 메소드를 호출하여 생성한다.
5. Servlet Container에 스레드를 생성하고, service메소드를 실행한다. 이후 클리아언트의 GET, POST여부에 따라 doGet() 또는 doPost()를 호출한다.
6. doGet() or doPost() 메소드는 동적 페이지를 생성한 후 HttpServletResponse객체에 응답을 보낸다.
7. 응답이 끝나면 distory() 메소드를 이용하여 HttpServletRequest, HttpServletResponse 두 객체를 소멸시킨다.

<br>

- [참고1] Servlet Container
    - 서블릿을 관리해주는 컨테이너
(서블릿은 스스로 작동하는 것이 아니고 Servlet Container에 의해 관리되면서 작동됨)
    - 예를 들어, **Servlet**이 어떠한 역할을 수행하는 **정의서**라고 보면, **Servlet Container**는 **그 정의서를 보고 수행**한다고 볼 수 있다.  

<br>

- [참고2] init() / service() / destory() 메소드
    - init() : **서블릿이 처음으로 요청될 때 초기화를 하는 메서드.** (클래스를 new 해서 사용하듯 서블릿 클래스도 초기화해야 사용이 가능) 이렇게 초기화된 서블릿은 **싱글톤**으로 관리되어 다음에 한번 더 해당 서블릿 클래스를 호출하면 초기화가 다시 일어나는 것이 아니라 **기존에 있던 서블릿 클래스를 호출한다**.
    
    - **service() :** 서블릿 컨테이너가 **요청을 받고 응답을 내려줄 때 필요한 서블릿의 service 메서드**. Servlet interface를 구현한 **HttpServlet 클래스의 doGet, doPost 같은 메서드들이 호출된다**.
    
    - **destroy() :** 더 이상 사용되지 않는 서블릿 클래스는 주기적으로 **서블릿 컨테이너가 destory() 메서드를 호출하여 제거한다**. 이 클래스를 다시 사용하기 위해서는 init()을 다시 해주어야 한다.  

<br>

- [참고3] web.xml (서블릿 설정 파일)  
서블릿을 작성했다면 해당 서블릿을 사용자가 요청한 경로와 맵핑시켜줘야 한다. 그래야 브라우저에서 해당 URL로 HTTP 요청할 때, WAS가 맵핑된 정보를 읽어서 해당 서블릿으로 요청을 전달해 줄 수 있다.

<br>



<br>
<br>

### **JSP 동작 구조**

![4_JSP의동작구조](https://user-images.githubusercontent.com/101503543/166148799-14a384e6-64e3-4640-922a-b6990027e423.jpg)


<br>

1. 웹 서버가 사용자로부터 서블릿에 대한 요청을 받으면 서블릿 컨테이너에 그 요청을 넘긴다. 
2. 요청을 받은 컨테이너는 HTTP Request와 HTTP Response 객체를 만들어, 이들을 통해 서블릿 doPost()나 doGet()메소드 중 하나를 호출한다. 
3. JSP를 사용하여 비지니스 로직과 프레젠테이션 로직을 분리하는데, 여기서 서블릿은 데이터의 입력, 수정 등에 대한 제어를 **JSP에게 넘겨서 프레젠테이션 로직을 수행한 후 컨테이너에게 Response를 전달한다** 
4. 이렇게 만들어진 결과물은 **사용자가 해당 페이지를 요청하면 컴파일이 되어 자바파일을 통해 .class 파일이 만들어지고, 두 로직이 결합되어 클래스화된다**. 

