# 생성자에 대하여

# 1. ****생성자(Constructor)****

생성자는 **new 연산자를 통해서 인스턴스를 생성할 때 반드시 호출이 되고 제일 먼저 실행되는 일종의** 메소드이며, **인스턴스 변수**(필드 값 등)**를 초기화 시키는 역할**을 한다.
<br>
<br>
# 2. ‘기본 생성자’와 ‘사용자 정의 생성자’

- **기본 생성자** : 클래스를 만들면 객체를 생성할 수 있도록 컴파일러가 자동으로 만들어 줌.

- **사용자 정의 생성자 : 객체를 생성할 때 필수적인 데이터가 있도록 제약하는 것.**

— 생성자 함수를 이용하여 반드시 특정 조건, 데이터를 만족해야 객체를 만들 수 있게 함.

— 사용자 정의 생성자를 작성하면, **컴파일러 입장에선** 개발자의 의도를 반영하고 **기본 생성자 함수를 더는 작성하지 않는다.** 개발자가 원하는 대로만 객체를 생성할 수 있게 한다.
— 이런 의미에서 사용자 정의 생성자 함수는 객체를 생성하는 데 제약 조건처럼 동작한다.

- **역컴파일러 비교**

```java
public SampleObj {         

// 클래스만 선언하면 기본생성자가 만들어짐
// 역컴파일러 : public SampleObj()   → 클래스에 쓰지 않아도 저절로 생긴 기본 생성자

public SampleObj(int value){         

// 기존의 SampleObj 클래스에 사용자 정의 생성자를 추가함
// 역컴파일러 : public SampleObj(int)    → 사용자 정의 생성자
```
<br>
<br>

# 3. 생성자로 안전한 설계하기

1. **제약**

객체 생성 시 절대적으로 필요한 데이터를 넣도록 하는 강제성을 이용.

2. **준비**

객체 생성 시 자동으로 데이터 준비 또는 필요 메소드 실행.
<br>
<br>
## 3-1. 제약의 기능

```java
public class Shape{
	private char type;
	private int width;
	private int height;

public Shape(char type, int width, int height){
	this.type = type;
	this.width = width;
	this.height = hegith;
}
}
```

Shape 클래스의 인스턴스를 만들 때 char, int, int 타입의 데이터를 주어야만 인스턴스를 생성할 수 있게 한다.

즉, 반드시 필요한 데이터를 넣어야만 객체를 생성할 수 있게끔 제약을 주어, 보다 안전한 설계를 할 수 있게 돕는다.
<br>
<br>
## 3-2. ‘준비’의 기능

### 1) 데이터 준비

```java
public class ReviewService {

    private ReviewDTO[] arr;
    private int idx;

    public ReviewService() {            // 생성자 만들기
        this.arr = new ReviewDTO[10];   // arr의 내용물은 ReviewDTO의 내용물
        this.idx = 0;                   // 없어도 상관없지만 여기서 시작을 명확하게
    }
```

```java
public class StoreLoader {

    private StoreDTO[] stores;  // 가게 데이터를 한번만 로딩하여 음식점의 목록 계속 유지

    public StoreLoader() throws FileNotFoundException {      // 가게 목록 준비의 생성자

        stores = new StoreDTO[5];

        File storeFile = new File("C:\\ccc\\store.txt");
        Scanner scanner = new Scanner(storeFile);

        for(int i = 0;i < stores.length; i++){

            String line = scanner.nextLine();
            String[] arr = line.split(",");
            int sno = Integer.parseInt(arr[0]);
            String name = arr[1];
            double lat = Double.parseDouble(arr[2]);
            double lng = Double.parseDouble(arr[3]);

            StoreDTO storeDTO = new StoreDTO(sno,name,lat,lng);

            stores[i] = storeDTO;
        }//end for
}

//        stores[0] = new StoreDTO(1,"AAA",37.111,127.111);
//        stores[1] = new StoreDTO(2,"BBB",37.111,127.111);
//        stores[2] = new StoreDTO(3,"CCC",37.111,127.111);
//        stores[3] = new StoreDTO(4,"DDD",37.111,127.111);
//        stores[4] = new StoreDTO(5,"EEE",37.111,127.111);
```

- **storefile과 scanner는 왜 생성자 안의 변수로 선언했는가?**

→ **file 이나 scanner는 로딩할 때만 사용되고 사용될 일이 없기 때문.**

→ 즉, ‘가게 목록 데이터’ **StoreDTO[] stores** 는 계속 유지할 데이터이기 때문에 **‘인스턴스 변수**’로 선언했다.

반면, storefile과 scanner는 **배열을 채우는 로직을 수행하기 위한 데이터**이기 때문에 

따라서 **‘생성자 안의 변수’**로 선언했다.
<br>
<br>
### 2) 객체가 만들어진 직후 어떤 메소드를 실행할 때도 ‘생성자’

- **생성자 가장 빈번하게 사용되는 경우 : '객체가 만들어진 직후 어떤 메소드를 실행하고 싶을 때'**

클래스에서 객체가 만들어지면서 처리되는 메소드가 있다면, 
**이런 메소드들은 외부에서 호출되기 전에 생성자에 호출될 수 있다.**

**예) 생성자에서 객체 생성시 필요한 메소드를 바로 실행**

```
public class InternetData{
		private String domain;

public InternetData(String domain){
	this.domain = domain;
	checkInternet();
}

private void checkInternet() {
	System.out.println("인터넷부터 확인합니다.");
}
}
```

→ 수정된 코드는 생성자 내에서 바로 checkInternet() 메소드를 실행한다.

이로써 외부에서는 매번 객체를 만들 때마다 checkInternet() 메소드를 실행하는 불편함을 없앨 수 있다. 

또한 checkInternet() 메소드 역시 public에서 private로 접근 제한이 변경되었다. 외부에서 호출할 필요가 없어지면서 보다 안전한 설계가 되었다.
