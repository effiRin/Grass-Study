Java 프로그래밍을 공부하면서 JDK, JRE, JVM 이 세가지 비슷하면서도 다른 알파벳의 조합을 많이 접했다.

각각의 풀네임(?)은 아래와 같다

JDK: Java Development Kit

JRE: Java Runtime Environment

JVM: Java Virtual Machine



먼저 이 셋은 전혀 다른 개념이 아니라 하나가 다른 하나를 포함하는 개념이다.

JVM 은 JRE 안에 포함되어 있고 JRE는 JDK 안에 들어있다.



먼저 가장 작은(?) JVM부터 알아보자

JVM
JVM(Java Virtual Machine)은 자바 프로그램을 실행하기 위한 프로그램이다.

일반적인 다른 컴파일 언어(C / C++)들은 어떤 시스템내에서 컴파일 하면 그 OS에서 실행할 수 있는 프로그램이 만들어지고 만들어진 프로그램을 실행하면 그만인데, 자바는 왜 한단계를 더 거쳐서 실행하는 방식을 선택한 것일까?



 JVM이 만들어진 주 목적 중 하나는 바로 "Write once, run anywhere"이다. C / C++ 같은 언어는 특정 OS에서 컴파일 되면 그 OS에서 밖에 실행할 수 없는 프로그램이 만들어지는 데에 반해, Java 프로그램은 JVM에서 실행할 수 있게 만들어졌기 때문에 JVM이 있다면 다른 OS에서도 실행할 수 있게 된다(물론 각 OS에 맞는 JVM이 필요하지만 이건 프로그래머가 신경쓸 문제는 아니다). 

 JVM의 또 다른 장점은 메모리 관리를 자동으로 해준다는 점인데 이것에 관한 내용은 나중에 다시 다루고 싶다(지나가는 내용으로 쓰기엔 너무 내용이 많다). 아무튼 메모리를 관리해주는 GC(Garbage Collector)라는 것이 있어서 프로그래머가 메모리에 대한 부분까지 신경쓰지 않아도 된다고 한다.

JRE
 JRE(Java Runtime Environment)는 이름 그대로 Java가 실행되는데 필요한 환경이다. 위에서는 JVM이 있으면 Java 프로그램을 실행할 수 있는 것 처럼 서술했지만 사실은 JRE가 Java 실행의 최소 조건이다. JRE는 JVM을 포함하고 있으며 그 외에도 java.lang 같은 기본 라이브러리들을 갖고 있다. 



JDK
JRE가 Java 프로그램을 실행하는데 필요한 최소 조건이라면 JDK는 Java 프로그램을 만드는데 필요한 최소 조건이다. 프로그램을 만들기 위해서는 당연히 실제로 실행하고 디버깅해야하기 때문에 JDK는 JRE를 포함하고 있다. 



JDK, JRE, JVM 흐름 정리
우리가 실제로 Java 프로그래밍을 할때 어떤 식으로 이용되는지 시나리오를 통해 

프로그래머는 Java 코드를 ~~~.java 파일에 작성한다.(JDK, JRE, JVM 과 무관)



JDK의 Java 컴파일러로 ~~~.java 파일을 ~~~.class 파일로 컴파일 한다.(JDK - javac)







참고 - InfoWorld - What is JVM?