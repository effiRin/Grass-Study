# 0410 스터디 자료 by Su Hong

쿠키와 세션은 브라우저의 활동이나 정보를 저장하기 위해 활용되는 방법이다.  
쿠키와 세션은 어떤 용도로 사용되고 왜 필요한지에 대해 알아보려고 한다.

## 1\. HTTP의 특성과 쿠키/세션

HTTP는 response/request를 여러 사용자와 원활히 주고 받기 위해서 **stateless** 그리고 **connectionless** 라는 특성을 갖고 있다.

> ### Stateless(무상태)

HTTP가 stateless 하다는 말의 의미는 프로그래밍에서의 변수가 없는 상황에 비유하면 이해하기 쉬운 것 같다.

어떤 작업이나 계산을 실행한 후 그 결과를 나중에 다시 사용하기 위해선 변수에 저장해 두어야만 한다.

그렇지 않으면 작업을 실행할 때 잠깐 메모리 상에 존재하고 사라지는 정보가 되어버릴 것이다.

HTTP의 stateless 는 프로그래밍에서의 변수와 같이 브라우저가 서버에 접속해 어떤 행동을 하고 다음에 다시 들어왔을 떄 이전 접속에서의 행동을 알지 못하는 것을 의미한다.

언뜻 보기에 매우 불편한 방식인 것 같지만 웹이라는 환경의 특성상 stateless는 중요한 의미를 가진다.

여러 사용자가 접속하는 웹서버가 stateless한 방식으로 운영되지 않는다면 접속하는 모든 사용자의 state를 저장하게 되고 이는 서버에게 큰 부담을 지도록 한다.

또한, 한명의 사용자가 새로운 사용자인 것처럼 의도적으로 서버를 속인 후 접속을 시도한다면 그때마다 새로운 state를 서버가 저장하게 되기 때문에 여러모로 서버가 갖는 위험이 커지게 된다.

이런 상황의 발생을 방지하기 위해서 HTTP는 stateless 방식을 선택하게 되었다.

> ### Connectionless

HTTP는 기본적(default)으로 request/response를 주고받고나면 연결을 끊는다.

다수의 사용자의 request에 대해 연결을 유지한다면 사용자 수가 증가함에 따라 연결 유지에 들어가는 자원 또한 사용자 수에 비례해서 증가하기 때문에 서버가 지는 부담이 크다.

반면에 connecrtionless 는 한명의 사용자에게 들어가는 연결 비용 또한 낮아지지만, 10명의 사용자가 동시에 서버를 이용한다고 해도 10명이 동시에 새로고침을 눌러 request를 보내지 않는 한 10개의 연결을 위한 비용이 아닌 request를 받는 수 많큼만 대응해주면 그만이기 때문에 사용자가 수가 늘수록 connectionless의 이점 또한 커진다.

> ### 쿠키/세션 이 필요한 이유

**stateless**, **connectionless**가 가지는 장점은 물론 크지만 자원을 아끼기 위한 이 방식들 때문에 기능적으로 제한이 생겨 버린다.  
예를 들어 웹사이트에 로그인해서 작업을 하다가 새로고침을 누르거나 다른 페이지로 이동하면 로그인 정보가 사라져 새로 로그인을 해야하는 일이 발생해버린다. 

<p>한번 로그인한 사용자가 새로고침이나 페이지 이동 후에도 로그인된 사용자임을 서버가 인식하기 위해서 등장한 것이 쿠키/세션이다.  
사용자가 로그인할 때에 로그인 했다는 사실을 쿠키/세션에 저장해두었다면 다음에는 다시 로그인할 필요 없이 저장된 정보만 확인 후 로그인한 것과 동일한 작업을 할 수 있도록 하면 된다.</p>

## 2\. 쿠키, 세션

### 쿠키

쿠키는 브라우저 쪽에서 관리하는 정보다. 쿠키에도 여러가지 종류가 있는데 브라우저에 파일로 저장되는 지속적인 쿠키(Persistent Cookie), 세션의 존속 시간 동안만 유지되는 세션 쿠키(Session Cookie), 웹 사이트에 기생(?)하고 있는 광고 서버 등에 의해 발행되는 제3자 쿠키(Third-party Cookie)가 있다.

브라우저가 웹서버에 request를 보낼 때 웹서버에서 발행한 쿠키를 같이 보내면 서버 쪽에서 쿠키를 활용해 사용자에게 더 다영한 response를 보낼 수 있게 된다.  
로그인한 내역, 살펴본 상품 목록 등 과거의 활동을 기록한 쿠키가 전달되면 사용자에게 보다 편리한 기능을 제공할 수 있을 것이다.

> #### 쿠키(1) - 지속적인 쿠키(일반적인 쿠키)

브라우저의 기록 삭제 항목에서 보이는 '쿠키 삭제'를 선택한다면 이 쿠키를 삭제하는 선택이 될 것이다. 이 쿠키는 웹서버에서 사용자가 원활히 사이트를 이용하기 위해서 사용자의 행동을 기록해서 파일로 저장해둔다. 파일로 저장했기 때문에 다른 페이지로 이동하거나 브라우저를 종료했다가 다시 켜도 이 정보는 유지된다.

> #### 쿠키(2) - 세션 쿠키

세션 쿠키는 세션의 종료와 함꼐 사라지는 일시적인 쿠키이다. 일시적으로 존재한다는 점에서 세션과 유사하지만 브라우저에서 관리하기 때문에 서버에서 관리하는 세션과는 다른 것이다. 세션 쿠키는 한 웹사이트 내의 여러 페이지를 이동할때도 유지되는 정보로 유저의 행동을 기록하는 점은 지속적인 쿠키와 같지만 브라우저를 종료하거나 새로운 탭을 키는 등 새로운 세션에서는 적용되지 못한다.

> #### 쿠키(3) - 제3자 쿠키

제3자 쿠키는 브라우저가 방문한 웹사이트에서 발행한 쿠키가 아닌 다른 웹사이트에서 발행한 쿠키이다. 주로 사용자의 활동을 기록해 사용자에 맞는 광고를 표시하는 기능에 많이 활용되어 맞춤 광고를 표시하는데 도움을 주는 쿠키이다. 반대로 이는 개인의 관심사, 방문 웹사이트 등이 기록되고 활용된다는 의미이기 때문에 개인 정보 노출의 위험이 크다.

### 세션

세션은 서버에서 관리하는 정보로 세션 쿠키처럼 세션의 종료와 함께 저장된 정보도 사라진다.

서버가 정보를 관리하기 때문에 서버가 지는 부담이 늘어나고 세션 종료 시 정보도 사라지는 단점이 있지만, 브라우저를 통해서 서버에 전달되는 것이 아닌 서버 내부에서 정보가 생성, 사용되기 때문에 상대적으로 보안이 좋은 방식이다.


## Big O notation
