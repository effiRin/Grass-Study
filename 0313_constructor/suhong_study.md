# 생성자와 overloading 그리고 generic에 대한 소개

## 생성자란?
생성자(Constructor)는 객체를 생성하는 함수다. new 키워드와 생성하고자 하는 객체가 속한 클래스 명을 통해 호출하며 인수(parameter)를 받도록 할 수 있다. 생성자는 받는 인수의 갯수와 종류에 따라 여러개가 동시에 존재할 수 있으며, 각각 다른 방식으로 객체를 초기화하도록 설정할 수 있다.(overloading)

### 생성자 overloading
생성자에 대한 개념은 다들 알고 계신다는 생각이 들어 생성자를 overloading하는 것을 보여드려 생성자에 대한 내용의 복습 및 overloading을 소개하기로 했다.

```java
package org.suhong.constructor;

import lombok.Getter;

@Getter
public class Class2 {
    private int a;
    private double b;

    public Class2(int a) {
        this.a = a;
    }

    public Class2(double b) {
        this.b = b;
    }

    public Class2(int a, double b) {
        this.a = a;
        this.b = b;
    }

    public Class2(double b, int a) {
        this.a = a + 1;
        this.b = b + 1;
    }

    public void hello() {
        System.out.println("hello");
    }

    public void hello(int a) {
        System.out.println("hello2");
    }
}
```

`int`형 변수 `a`, `double`형 변수 `b`를 상태로 갖는 클래스 Class2를 작성했다. Class2는 받는 인수가 서로 다른 4개의 생성자를 만들어 똑같이 `new Class2()`로 호출해도 넣는 인수에 따라 다른 생성자가 호출되는 것을 확인 할 수 있다.

```java
package org.suhong.constructor;

public class Class2Main {
    public static void main(String[] args) {
        Class2 obj1 = new Class2(1);
        Class2 obj2 = new Class2(1.0);
        Class2 obj3 = new Class2(5,100.0);
        Class2 obj4 = new Class2(5.0,100);
        System.out.println(obj1);
        System.out.println(obj2);
        System.out.println(obj3);
        System.out.println(obj4);
        obj1.hello();
        obj1.hello(1);
    }
}
```

> 출력 결과
```bash
Class2(a=1, b=0.0)
Class2(a=0, b=1.0)
Class2(a=5, b=100.0)
Class2(a=101, b=6.0)
hello
hello2
```
생성자가 아닌 일반 메소드에서도 overloading을 보여주기 위해 `hello`라는 메소드를 두개 만들었다. 하나는 받는 변수가 없고 다른 하나는 `int`형 변수를 인수로 받도록 하여 인수에 따라 다른 메소드가 호출되는 것을 확인했다.

## Generic(제너릭)
강의에서 ArrayList가 등장하기 시작했는데 `ArrayList<Integer>` 같은 표현이 처음 등장하여 `<>`가 무엇인지에 대하여 설명하고자 한다.

`<>`와 같은 표현은 클래스 내에서 사용하는 변수를 특정 타입으로 제한하지 않고 여러가지 변수에 모두 대응 가능하도록 하기 위하여 만들어진 표현이다. ArrayList의 등장과 함께 등장했기 때문에 직접 ArrayList의 기능을 일부 구현하면서 설명하고자 한다.

```java
package org.suhong.constructor;

import java.util.Arrays;

public class ArrayListSuhong<T> {

    private T[] arr;
    private int size;
    
    public ArrayListSuhong() {
        this.size = 0;
        this.arr = (T[]) new Object[1];
    }

    public void add(T t) {
        if (size >= arr.length) {
            expand();
        }
        arr[size++] = t;
    }

    private void expand() {
        T[] copy = (T[]) new Object[arr.length * 2];
        for (int i = 0 ; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        this.arr = copy;
    }

    public String toString() {
        return Arrays.toString(arr);
    }
    
}
```

 `ArrayListSuhong`이라는 클래스를 만들었다. 클래스를 정의하는 맨 위 줄에서`<T>`라는 표현을 클래스명 뒤에 이어서 썻는데 이 표현은 이 클래스 내에서 아직 정해지지 않은 `T`라는 타입의 변수(객체)를 사용할 것이라는걸 의미한다. 클래스명을 정의할때 `<T>`를 적어둠으로써 이제 클래스의 변수나 메소드에 대해 정의할때 미지의 타입 `T`를 사용할 수 있게 된다. 위 코드에서는 T형 배열 arr를 상태 변수로 가지도록 했다.

 `ArrayList`와 배열의 가장 큰 차이는 역시 배열의 크기를 미리 정하지 않아도 상황에 맞춰 유동적으로 크기를 변경 할 수 있다는 점이다. `ArrayList`의 `add`기능을 배열의 크기를 늘리는 `expand` 함수를 만들어 구현해보았다.

 `add()`는 기존 배열의 마지막에 새로운 값을 추가하는 메소드인데 이때 만약 배열의 빈 공간이 꽉 찼다면 더 큰 배열을 위한 공간을 마련해고 기존의 내용물을 복사해 넣어야한다. 그 기능을 하는것이 `expand()`메소드다. 

 위와 같이 `ArrayList`의 대표적인 기능을 구현해봄으로써 Generic 표현이 어떻게 쓰일 수 있는지 예시를 들어보았다.


#### 참고할만한 이야기
 [배열의 크기를 두배씩 늘리는 이유](https://ece.uwaterloo.ca/~dwharder/aads/Algorithms/Array_resizing/)
 > 위 링크에 의하면 매번 1보다 큰 숫자 r배씩 배열을 늘리거나 줄이는것이 가장 효율적이라고 한다.

 [ArrayList의 동작 방식](https://stackoverflow.com/questions/3467965/how-does-arraylist-work#:~:text=ArrayList%20uses%20an%20Array%20of,parameter%20while%20initializing%20the%20ArrayList.)
> `ArrayList`의 동작 방식에 대한 설명이다. 내부적으로 일반적인 배열을 사용하며 배열이 꽉차면 더 큰 배열을 새로 만들어 사용한다고 한다.