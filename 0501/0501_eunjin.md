## mvc 패턴

mvc은 소프트웨어 디자인 패턴이다.

# M (Model)<br/>
 Model은 내부 비지니스 로직에 해당한다.<br/>
 backgroud 로직으로 처리되는 알고리즘, 데이터, DB와의 상호작용을 담당한다.
# V (View)<br>
View는 사용자가 볼 수 있는 UI화면을 의미한다.<br/>
처리결과를 View를 통해 클라이언트에게 화면을 보여준다.<br/>

# C (Controller)<br>
Controller는 Model과 View 사이에 중계자 역할을 하며, 클라이언트 요청을 처리하고 흐름제어를 한다.<br/>


# Model1 패턴
view와 controller의 역할이 합쳐져 있다.<br/>
JSP가 view역할을 하는데 model1방식에서는 jsp가 view,controller 역할을 모두한다. jsp가 view,controller 역할을 모두 수행하면 자바코드(<%%>),hmlt,css코드가 섞이게 되어 소스가 복잡해지고, 읽기 어려워지기 때문에 유지보수가 힘들어진다. 설계가 간단한 프로젝트에 알맞다.

# Model2 패턴
Model1 패턴이 유지보수가 힘들다는 단점을 보완하기 위해 나온 모델이다.<br/>
view,controller를 분리해서 사용한다.<br/>
쿨라이언트의 요청을 처리하고 흐름제어를 하면서 필요시 model과 상호작용을 하는 controller는 servlet에서 담당하고, 사용자 인터페이스를 보여주는 view는 jsp에서 담당한다. 즉! jsp는 뷰역할만 하고, 컨트롤러 역할은 servlet이 수행한다. <Br/>
뷰와 컨트롤러를 분리함을써 클라이언트의 요청처리 부분과 응답처리 부분을 독립적으로 수행할 수 있다. <Br/>
유지보수하기 좋고, 디자이너,개발자 사이에 협력이 수월하다. 흐름이 복잡하고 개발난이도가 있으며, 설계가 어려운 단점이 있다.

# model1, model2의 차이점은
model1은 요청/응답처리를 모두 하나의 jsp에서 이루어지는 것이고, <Br/>
model2는 요청처리는 servlet에서 담당하고 응답처리는 jsp에서 이루어진다.

# model1, model2 접근방식
model1은 뷰,컨트롤러가 하나의 jsp에 존재하기 때문에 클라이언트가 직접적으로 뷰에 접근할 수 있다.<br/>
model2은 클라이언트는 뷰에 직접적으로 접근할 수 없고, 반드시 컨트롤러를 통해서 접근해야한다.

