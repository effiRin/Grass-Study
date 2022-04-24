# Java Reflection
> 2022.04.24 스터디용 자료1

## Reflection API란?
Reflection API는 프로그램 실행중(Run time) 클래스의 정보를 읽고 활용할 수 있는 API이다.

이로 인하여 클래스의 이름, 메소드, 속성 등을 프로그램 실행중 확인하고 사용할 수 있는데, 여기서 중요한 점은 실행중(Runtime)에 활용할 수 있다는 점이다.  

인터페이스 등의 활용으로 사용될 Type은 명시되어 있는데 실제 객체는 아직 정해지지 않은 상황에서 Reflection을 이용한다면 코드에서는 명시되지 않은 객체가 실행중 생성되거나 명시되어 활용될 수 있는 것을 의미한다.

## 왜 Reflextion을 사용하는지?
[stack overflow 참고 글](https://stackoverflow.com/questions/37628/what-is-reflection-and-why-is-it-useful)

**Reflection** 라는 이름은 같은 시스템 안의 코드를 참조하기 위한 기능이라는 뜻을 내포하고 있다.(reflection = 반사 -> 거울을 보듯 자기 자신을 봄)

예를 들어 `com.suhong` 패키지 안에 `ExampleClass` 가 정의되어 있고, 다른 곳에서 `ExampleClass`가 가진 정보를 보고 싶다면 Reflection을 이용하면 된다.

```java
// 시스템 안에서 정의되어 있는 클래스 확인
Class clazz = Class.forName("com.suhong.ExampleClass");
// 클래스에 정의된 메소드들
Method[] methods = clazz.getDeclaredMethods();
// 클래스의 속성들
Field[] fields = clazz.getDeclaredFields();

Class service = Class.forName("org.zerock.service.BoardService");
Method serviceConstructer = service.getConstructer();
Object serviceObj = serviceConstructer.invoke();

Class controller = Class.forName("org.zerock.controller.BoardController");
Method controllerConstructer = controller.getConstructer();
Object controllerObj = serviceConstructer.invoke(serviceObj);
```

## Reflection의 활용
 
Spring은 Bean으로 사용할 클래스를 xml파일이나 annotation 등에서 명시해 두기만하면 new 키워드로 직접 객체를 생성하지 않아도 알아서 객체를 생성, 주입 시켜준다.

이때 사용되는 기술이 바로 Reflection이다.

게시판 만들기의 BoardControll를 보자.

```java
@Controller
@RequestMapping("/board/")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService service;

    ...

}
```

BoardController는 BoardService를 사용하는데, 실제로 new BoardService()를 사용한 적이 없다. Spring에서 BoardService 클래스의 객체를 생성해서 주입시켜준 것이다.

또 BoardServiceImpl에서도 사용되었다.
```java
@Override
    public ListResponseDTO<BoardDTO> getList(ListDTO listDTO) {
        List<Board> boardList = boardMapper.selectList(listDTO);

        List<BoardDTO> dtoList =
                boardList.stream()
                        .map(board -> modelMapper.map(board, BoardDTO.class))
                        .collect(Collectors.toList());

        return ListResponseDTO.<BoardDTO>builder()
                .dtoList(dtoList)
                .total(boardMapper.getTotal(listDTO))
                .build();
    }
```

`List<Board>`를 `List<BoardDTO>`로 변환하는 과정에서 Reflection이 쓰였다.

`Board` 타입의 `board`를 `BoardDTO.class`를 이용해 `BoardDTO` 타입으로 변환하고 있다.

## 급 마무리

Reflection은 객체의 생성을 compile time이 아닌 run time 으로 미룰 수 있다는 점에서 프로그램의 자유도(?)를 높일 수 있는 기술이라고 생각한다.

특히 Spring 같이 객체를 자동 생성해주는 프레임 워크를 사용할 떄 reflection의 유용성을 체감할 수 있었다.

compile time에서 왠만한 오류는 미리 탐지해주는 java의 특성상 reflection으로 run time의 영역을 늘리게 되면 오류가 날 가능성도 커지고 복잡성도 커지기 때문에 compile time 코딩으로 해결 가능한 문제라면 굳이 reflection을 쓸 필요는 없다고 본다.



```java
asdfadsfdsaf
dsfadsfadsfdasf
sdafdsafdasf
```

```java
adsfadsfadsfadsfdsaf
asdfadsfasdfadsf
```

하나의 시스템 형성

시스템 실행 -> 

js

```1
import 2

asdfadsf
asdfadsfd

if () {
    2()
}

asdfasdf
```

```2
asdfadsf
sdfjhf!!!!
adsfadsf
```