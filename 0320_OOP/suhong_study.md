# 객체 지향 프로그래밍

## 객체 지향 프로그래밍이란?

 객체 지향 프로그래밍(Object Oriented Programming)은 객체들 간의 상호 작용을 통해 시스템을 구축하는 프로그래밍 패러다임이다. 시스템이 실행해야할 복잡한 작업들을 작은 기능으로 쪼개고 어떤 역할의 객체가 어떤 기능(책임)을 수행할지를 결정하는 것이 객체 지향 설계의 핵심이다.


## 객체 지향 프로그래밍의 특징(장점)  

### 1. 유지 보수가 용이하다.
> 시스템이 여러개의 객체들로 이루어져 있기 때문에 문제가 되는 부분만 수정 혹은 교체하면 되기 떄문에 유지 보수가 용이하다. 

### 2. 여러명이 함께 작업할 떄에 적합하다.
> 절차형 프로그램의 경우 앞의 과정이 완성되어야 뒷부분의 작업에 착수할 수 있지만 객체 지향의 경우엔 어떤 객체가 어떤 책임을 수행할지만 결정한다면 여러명이 동시에 작업하는 것이 가능하다. 거대한 프로젝트일 수록 이 장점은 극대화 된다.(유지 보수가 용이한 것도 큰 프로젝트에서 특히 더 유용함)

### 3. 코드의 재사용성이 뛰어나다.
> Java의 경우 객체들의 추상화(일반화)를 통해 클래스를 만들어내고 클래스를 통한 객체의 생성 및 클래스의 상속 등을 통해 같은 코드를 여러번 작성하는 경우가 줄어든다.


## 객체 지향 설계
[객체지향의 사실과 오해](http://www.kyobobook.co.kr/product/detailViewKor.laf?ejkGb=KOR&mallGb=KOR&barcode=9788998139766&orderClick=LEa&Kc=)를 (반쯤)읽고 느끼는 바가 커서 그중 인상 깊었던 내용을 중심으로 객체지향 설계에 대해서 몇가지 소개하고자 한다.

### 1. 객체지향은 객체가 중심이다.
당연한 얘기 같지만 거의 모든 파일에서 class를 정의하는 Java의 특성상 객체지향의 중심이 클래스라고 오인하기 쉽다. 클래스는 수많은 객체들을 인식하기 쉽게 분류하고 손쉽게 생성하기 위한 도구다. 객체와 깊은 연관이 있어 중요하긴 하지만 객체보다 우선시 되어서는 안된다. 시스템이 수행해야할 복잡한 작업들을 각각의 역할과 책임을 지닌 객체들의 협력을 통해 수행하는 것이 객체 지향의 핵심이다. 

### 2. 객체는 역할과 책임을 먼저 설계해야한다.
객체가 지니는 변수는 객체의 기능을 수행하기 위해 유지해야하는 정보들이다. 즉, 기능을 먼저 설계하고 기능의 실현을 위해 필요한 정보를 변수로서 지정하는 것이 올바른 순서다.

 