
# 객체 생성 시, T 메모리 변화 과정

### 들어가며

자바를 더 잘 활용하기 위해서는 '프로그램이 메모리를 사용하는 방식'을 아는 것이 좋다.  
자바 기초 서적에서 흔히 나오는 '변수의 초기화', 'new 연산자를 이용한 객체 생성', '가비지 컬렉터를 이용한 메모리 관리' 등...   
모두 중요하다고 말하는 지식들이지만 처음 접한다면 영 이해하기 쉽지 않다.  
그러나 해당 개념들이 JVM의 메모리에서 어떻게 할당되고, 어떻게 관리되는지 그 변화 과정을 안다면 보다 깊은 이해가 가능하다.  
따라서 자바 프로그램이 실행될 때 메모리가 어떤 과정을 거쳐 실행하는지, 'T 메모리'라는 영역에서는 어떤 변화가 일어나는지 살펴보고자 한다.  
그중에서도 이번 주제인 '객체'에 맞춰, 객체 생성 시 T 메모리에서 어떤 과정을 거쳐 실행하는지 알아본다.  
<br>

### 자바 프로그램의 개발과 구동
메모리 영역을 설명하기에 앞서, 자바 프로그램의 개발과 구동을 돕는 것들(JDK, JRE, JVM)에 대해 살펴본다.

|현실 세계|가상세계(자바 월드)|  
|---|---|
|소프트웨어 개발 도구|JVM용 소프트웨어 개발 도구|  
|운영체제|JVM OS = JRE(자바 실행 환경)|  
|하드웨어-물리적 컴퓨터|가상의 컴퓨터=JVM(자바 가상 기계)|  

- 현실 세계에서 소프트웨어, 즉 프로그램은 개발자가 개발 도구를 이용해 개발하고 운영체제를 통해 물리적 컴퓨터인 하드웨어 상에서 구동된다.
- 자바가 만들어 주는 가상 세계도 이와 마찬가지다. 자바 개발 도구인 JDK를 이용해 개발된 프로그램은 JRE에 의해 가상의 컴퓨터인 JVM 상에서 구동된다.
- 다만, 배포되는 JDK, JRE, JVM은 편의를 위해 JDK가 JRE를 포함하고, 다시 JRE는 JVM을 포함하는 형태로 배포된다.
- JDK는 자바 소스 컴파일러인 javac.exe를 포함하고 있고, JRE는 자바 프로그램 실행기인 java.exe를 포함하고 있다.
<br>

### 프로그램이 메모리를 사용하는 방식

> 프로그램이 실행되면 JVM은 OS로부터 메모리를 할당받고,  
> 그 메모리 용도에 따라 여러 영역으로 나누어 관리한다.
<br>

**1. 하나의 프로그램이 실행될 때 프로그램이 메모리를 사용하는 방식**  
<img src="https://user-images.githubusercontent.com/101503543/159174079-a6704dad-6d5f-48c4-bfeb-71e7b56a29fb.PNG" width="500" height="300"/>

기계어를 포함한 모든 프로그래밍 언어에서 공통적으로 사용하는 방식으로,  
코드 실행 영역과 데이터 저장 영역, 두 가지로 나눠서 메모리를 사용하는 방식이다. 
<br>
<br>

**2. 객체 지향 프로그램은 데이터 저장 영역을 세 개의 영역으로 분할해서 이용한다.**

<img src="https://user-images.githubusercontent.com/101503543/159174080-c3569a4e-6329-4f48-bbf3-395feb7a83ef.PNG" width="800" height="500"/>

분할한 모양이 마치 'T'자를 닮아, 이 메모리 구조를 'T 메모리'라고 간략하게 지칭한다.
<br>
<br>

### main() 메서드 : 메서드 스택 프라임

객체 생성에 따른 메모리 변화를 살펴보기 앞서,  프로그램의 시작이자 끝인 main()메서드가 T메모리 구조에서 어떻게 사용되는지 살펴본다.
<br>

**[예제1]**
```java
public class Start {
	public static void main(String[] args) {
		System.out.println("Hello OOP!!!");	
	}
}
```

**1. main() 메서드가 실행되기 전 JVM에서 수행하는 전처리 작업들**
> 1) java.lang 패키지를 T 메모리의 스태틱 영역에 배치한다.
> 2) import 패키지를 T 메모리의 스태틱 영역에 배치한다.
> 3) 프로그램 상의 모든 클래스를 T 메모리의 스태틱 영역에 배치한다.

<img src="https://user-images.githubusercontent.com/101503543/159174081-748d2622-b61e-4500-af68-60d3ccec63fd.PNG" width="600" height="700"/>
<br>

프로그램이 실행되면 JRE는 프로그램 안에 main() 메서드가 있는지 확인한다. [예제1]에선 Start라는 클래스에서 main()메서드를 발견할 수 있다.  
이후 JRE는 JVM을 부팅하고, JVM은 목적 파일을 받아 실행하는데 이때 JVM이 메모리상에서 가장 먼저 하는 일은 **'전처리'** 과정이다.  
우선, 모든 자바 프로그램이 반드시 포함하게 되는 패키지 java.lang 패키지를 T메모리의 stack 영역에 둔다.  
그 다음, 개발자가 작성한 모든 클래스와 import 패키지 또한 static 영역에 둔다.  
[예제1]에선 import 패키지는 없고, Start 클래스만 있으니 위의 그림처럼 표현된다.
<br>
<br>

**2. main()은 프로그램의 시작이자 끝**

<img src="https://user-images.githubusercontent.com/101503543/159174082-b4f03c3d-a601-43c8-a72f-ad5cd2538ff6.PNG" width="600" height="700"/>

<br>
여는 중괄호를 만나면 main() 메서드의 스택 프레임이 스택 영역에 생긴다.  
메서드의 인자 args를 저장할 변수 공간이 main() 메서드의 스택 프레임 밑에 할당된다.  
System.out.println을 만나면, 코드 실행 영역에서 실행되고 GPU(그래픽 처리 장치)에 화면 출력을 의뢰한다. (이때, T 메모리상에선 변화가 없다)  
<br>

main() 메서드의 닫는 중괄호를 만나면 main() 메서드의 스택 프레임 소멸되고,  
JRE는 JVM을 종료, JRE도 운영체제의 자원(메모리)를 반납하면서(동시에 T 메모리도 사라짐), 프로그램 끝이 난다.
<br>
<br>

### 객체 생성과 T 메모리 변화 과정
이번엔 객체를 생성할 때 T 메모리에선 어떤 변화가 일어나는지 그 과정을 살펴본다.
<br>

**[예제2]**
```java
public class Mouse {
	public String name;
	public int age;
	public int CountOfTail;

	public void sing() {
	System.out.println(name + "찍찍!!!");
}
}
```

```java
public class MouseDriver{
	public static void main(String[] args){
		Mouse mickey = new Mouse();
		mickey.name = "미키";
		mickey.age = 85; 
		mickey.countOfTail = 1;

		mickey.sing();

		mickey = null;
		
		Mouse jerry = new Mouse();

		jerry.name = "제리";
		jerry.age = 73;
		jerry.countOfTail = 1;

		jerry.sing();
  }
}
```
<br>

**1. 마찬가지로 전처리 과정을 거치면서, Mouse와 MouseDriver 클래스를 static 영역에 배치한다.**  
이 static 영역에서는 Mouse 클래스의 name, age, countOfTail의 변수 저장 공간이 할당되지 않는다.  
이 3개의 변수는 Mouse 클래스에 속한 속성이 아니라, Mouse 객체에 속한 속성이기 때문이다. (즉, 이름만 존재할 뿐이다)  
따라서 객체가 생성되어야 속성의 값을 저장하기 위한 메모리 공간이 static이 아닌, Heap 영역에 할당된다.  
하지만 아직 객체는 생성되지 않았다. 우선 프로그램의 시작을 맡는 main()메서드부터 실행해줘야 한다.   
<img src="https://user-images.githubusercontent.com/101503543/159174083-563a952e-06b5-48d7-8d94-6ad3fc8652fd.PNG" width="600" height="700"/>

<br>

**2. MouseDriver 클래스 main()메서드부터 프로그램이 실행된다.**  
main메서드의 여는 중괄호를 만나면 main메서드의 스택 프레임이 stack 영역에 발생하며, args 인자의 변수 공간이 스택 프레임 안에 할당된다.  
객체가 생성되는 시점은 ```Mouse mickey = new Mouse();``` 구문을 만나면서다.  
그런데 이 구문에는 다음과 같은 3개의 명령문이 녹아있다.  

> **1) Mouse mickey**   // Mouse 객체에 대한 참조 변수 mickey를 만든다.  
> **2) new Mouse()**  // Mouse 클래스의 인스턴스를 하나 만들어 힙에 배치한다.  
> **3) 대입문**  // Mouse 객체에 대한 주소를 참조 변수 mickey에 할당한다.  
<br>
따라서 T 메모리 구조는 다음과 같이 변화한다.  
<img src="https://user-images.githubusercontent.com/101503543/159174084-23a3a8ee-263d-417e-9fd4-06d5d79029b0.PNG" width="600" height="700"/>

<br>

```mickey.name = "미키";
mickey.age = 85;
mickey.countOfTail = 1;
```
이후 위의 구문을 거치면, 참조 변수 mickey에 있는 주소값을 통해 Mouse 객체의 속성값 "미키", 85, 1 을 주게 된다.  
  
<img src="https://user-images.githubusercontent.com/101503543/159174086-507777cf-8f4c-4d8a-93e4-665e8c3bf63e.PNG" width="600" height="700"/>

<br>

```mickey.sing();``` 는 Mouse 객체의 sing 메서드가 코드 실행 영역에서 실행되어서 "미키 찍찍"을 화면에 출력할 것이다.  
[예제1]과 마찬가지로, T 메모리 상의 변화는 없다.  

```mickey = null;``` 은 객체 참조 변수 mickey에 null을 주어서, mickey가 더 이상 힙 영역에 존재하는 Mouse 객체를 참조하지 않는다.  
이때, 자동으로 메모리를 관리해주는 **'가비지 컬렉터'** 가 등장한다.  
정확한 등장 시기는 알 수 없지만 아무도 참조하지 않는 Mouse 객체를 쓰레기로 인지하고 수거해 간다.  
그러면 Mouse 객체는 메모리 상에서 완전히 사라지게 된다.

<img src="https://user-images.githubusercontent.com/101503543/159174087-0d45d3be-27a9-4f18-909b-c045990c9d99.PNG" width="800" height="700"/>

<br>

이후, 만나게 되는 ```Mouse jerry = new Mouse();``` 라는 구문은 새로운 Mouse 객체를 만들게 된다.  
참조 변수 jerry에 새로 생긴 객체의 주소값을 할당하고, 주솟값을 통해 속성값 "제리", 73, 1을 주게 된다.  
명심할 것은, 앞서 만든 참조 변수 mickey가 가리키는 객체와는 전혀 다른 새로운 객체라는 점이다.

<img src="https://user-images.githubusercontent.com/101503543/159174088-c534adea-8e30-4bc2-8581-6b0dfc66511c.PNG" width="600" height="700"/>
