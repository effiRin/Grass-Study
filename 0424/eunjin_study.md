# Scope
scope는 우리말로 번역하면 '범위'라는 뜻이다.

2가지 타입이 있는데 
Global(전역)scope - 전역에 선언되어 있어 어느 곳에서든지 해당 변수에 접근할 수 있다는 의미
local(지역)scope  - 해당 지역에서만 접근할 수 있어 지역을 벗어난 곳에선 접근할 수 없다는 의미

자바스크립트는 함수를 선언하면서 함수를 선언할 때마다 새로운 스코프를 생성하게 된다.
함수 몸체에 선언한 변수는 함수 안에서만 접근가능 > 함수 스코프 = 지역 스코프

# Scope Chain은???
현재 자신의 scope에서 사용하고자 하는 변수가 없다면 Scope Chain을 통해 해당 변수를 찾게 된다.

# 블록스코프?????
Let/const 키워드 추가 되면서 

```java
{
	const a =‘1’; 
}
```

함수가 아닌 일반 블록에서도 지역변수를 선언할 수 있음!!(ES6)


# var,let,const
	var 는 버그 발생/ 메모리 누수의 위험이 있음!!let, const사용!

  var 로 선언한 변수는 선언전에 사용해도 에러가 나지 않지만,
  
  let, const는 에러 발생

  var의 경우 호스팅이되면서 초기값이 없으면 자동으로 undefined를 초기값으로 하여 메모리를 할당한다.

  그래서 var의 경우 선언 전에 해당 변수를 사용하려고 해도 메모리에 해당 변수가 존재하기 때문에 에러가 발생하지 않는다.
  
  근데 let,const는 호스팅이 되면서 초기값이 없다면 var처럼 자동으로 초기값을 할당하지 않는다. 
  (const는 선언시 초기값이 없으면 에러발생)
  
  let,const는 값이 할당되기 전까지 메모리를 할당하지 않기 때문에 선언전(값이 할당되기 전)에 사용하면 메모리에 해당 변수가 존재하지 않아서 에러를 발생한다.

  변수가 선언되고 해당변수에 값이 할당되기 전까지를 TDZ(Temporal Dead Zone)이라고 한다.

```java
console.log(num);  //undefined
var num;
```

```java
console.log(num);
Let num =1;
console.log(num);
```

```java
//호스팅 됐을 때
Let num;
console.log(num);   //값이 할당되기 전이기 때문에 아직 num은 메모리에 존재하지 않음.TDZ
Num =1;
console.log(num);   //1
```

  var는 이미 선언되어 있는 이름과 같은 이름으로 변수를 또 선언해도 에러나지 않음

  let, const는 이미 존재하는 변수와 같은 이름의 변수를 또 선언하면 에러

  var,let은 변수 선언시 초기값을 주지 않아도 됨 / const는 반드시 초기값을 할당해야 함
 

 var,let은 값을 다시 할당할 수 있지만 const는 한번 할당한 값을 변경할 수 없음(단, 객체안에 프로퍼티가 변경되는 것까지 막지는 못한다)
 
```java
Const obj = {first : 1};
```

```java
//error
Obj = 1;

//no error
Obj.first = 2;
obj.second = 2;
Delete obj.first;
```


위처럼 const변수가 가리키는 값 자체를 변경하려고 하면 에러가 발생하지만 객체 내의 프로퍼티의 추가,변경,삭제를 하는 것은 문제가 안됨
만약 객체의 프로퍼티도 변경되지 않게 객체를 선언하고 싶으면 Object.freeze()메소드 사용
