# 컬렉션 프레임워크란??

컬렉션 프레임워크는 크게 3가지 타입이 존재한다고 생각하고 <br/>
각각의 컬렌션을 다루는데 필요한 기능을 가진 3개의 인터페이스를 정의한다.


|인터페이스|특징|
|------|---|
|List |순서가 있는 데이터으 집합, 데이 중보 허용 <br/> (ArrayList, LinkedList,Stack, Vector 등)|
|Set |순서르 유지하지 않는 데이터으 집합, 데이터 중보 허용하지 않음 <br/> (HashSet, TreeSet 등)|
|Map |키(key),값(value)의 쌍으로 이루어진 데이터의 집합 <br/> 순서 유지되지 않으며, 키 중복 허용하지 않고, 값 중복은 허용 <br/> (HashMap, TreeMap, Hashtable, Properties 등)|

Hashtable, Properties,Stack, Vector 와 같은 클래스들으 컬렉셔 프레임워크가 만들어지기 이전부터 존재했기 때문에 <br/> 컬렉션 프레임워크의 명명법으 따르지 않는다.
Vector, Hashtable 과 같은 기존의 컬렉션 클래슫르은 호환으 위해 설계를 변경해서 남겨두었지만, 최대한 사용하지 않는게 좋다!!
대신 ArrayList,HashMap 사용!!

# ArrayList

ArrayList는 Object배열을 이용햇 데이터를 순차적으로 저장한다.

```java
class ArrayListEx1{
  public static void main(String[] args){
    	ArrayList list1 = new ArrayList(10);
        list1.add(new Integer(5));
        list1.add(new Integer(4));
        list1.add(new Integer(2));
        list1.add(new Integer(0));
        
        ArrayList list2 = new ArrayList(list1.subList(1,4));
        print(list1, list2);       
        
        //출력
        //list1: [5,4,2,0]
        //list2: [4,2,0]
        
        Collections.sort(list1);   //정렬
        Collections.sort(list2);
        print(list1, list2);
        
    }
}
```

ArrayList 같이 배열을 이용한 자료구조는 데이터를 읽어오고 저장하는 데는 효율이 좋지만, <br/>
용량을 변경해야할 때는 새로운 배열을 생성한 후 기존의 배열로부터 새로 생성된 배열로 데이터를 복사하기 때문에 효율이 떨어진다는 단점을 가지고 있다.<br/>
그래서 처음 인스턴스를 생성할 때, 저장할 데이터의 개수를 잘 고려하여 충분한 용량의 인스턴스를 생성하는게 좋다!

# LinkedList

배열은 가장 기본적인 형태의 자료구조이다. <br/>
구조가 간단하며 사용하기 쉽고 데이터를 읽어 오는데 걸리는 시간이 가장 짧다는 장점을 가지고 있지만 단점도 있다.<br/>
단점으로는 배열의 크기를 변경할 수 없는데 크리르 변경 할 수 없기 때문에 새로운 배열을 생성해서 데이터를 복사해줘야한다.<br/>
비순차적인 데이터의 추가와 삭제에 시간이 많이걸린다. 차례대로 데이터를 추가,삭제하는 것은 빠르지만 중간에 데이터를 추가하려면 <br/>
빈자리를 만들기 위해 다른 데이터들을 복사해서 이동해야 한다.<br/>
 
이러한 배열의 단점을 보완하기 위해 LinkedList라는 자료구조가 나왔다!<br/>
LinkedList는 불연속적으로 존재하는 데이터를 서로 연결한 형태로 구성되어 있다.

|컬렉션|읽기(접근시간)|추가/삭제|비고|
|------|---|---|---|
|ArrayList| 빠르다| 느리다| 순차적인 추가삭제는 빠르나 <br/> 비효율적이 메모리 사용|
|LinkedList| 느리다| 빠르다|데이터가 많을수록<br/> 접근성이 떨어진다.|

# HashMap

  
