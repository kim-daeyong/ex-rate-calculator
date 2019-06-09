환율 계산기
---

사용 기술 

Java, Springboot, Thymeleaf

---

구동 방법
~~~
git clone https://github.com/kim-daeyong/ex-rate-calculator.git
cd ex-rate-calculator
mvn package
java -jar target\ex-rate-calculator-0.0.1-SNAPSHOT.jar
http://localhost:8000/ 접속
~~~

---

설계

1. 환율정보는 변동의 폭은 작지만 정확하게 요구되고 생각보다 자주 바뀌기에 매 요청 시마다 데이터를 가져오도록 했습니다. 

2. 하지만 Free Plan 특성 상 1시간마다 갱신되기에 API 정보가 있다면 그 정보를 이용하도록하여 API를 한번만 호출하도록 했고
   1시간에 한번씩 스케쥴러를 통해 API 정보가 갱신되도록 했습니다.

3. API 키의 경우 민감한 문제가 될 수 있기에 APIKey.properties를 따로 만들어주어 key정보를 담아주었습니다.
    (이 프로젝트의 경우 확인이 용이하게 올려두었습니다.)

4. Controller에선 Service 호출만 담당하고 계산 및 변환, 호출등은 Service에서 담당하도록 했습니다.

5. API 호출과 계산 클래스를 따로 두어 API 변동에 용이하도록 하였습니다.

---

개선점

1. 현재 사용중인 건 RestTemplate인 이는 앞으로 deprecated 될 것 이라고 합니다.  
   WebClient가 RestTemplate의 기능을 모두 사용할 수 있을분더러 추가기능이 있기 때문에 수정하는 것이 좋을 것 같습니다.
   
2. 현재 페이지는 HTML과 Thymeleaf로 이루어져있는데 Vue나 React를 이용해서 구현해주고 싶습니다.

3. 메소드나 클래스, 변수명을 좀 더 직관적으로 바꿔주면 좋을 것 같습니다.

4. 최대한 한 메소드에 하나씩, 계산등의 로직은 Service 단에서 하도록 했는데 좀 난잡한 것 같기도합니다.  
   리팩토링에 대해 알아보고 클린코드로 바꿀 수 있도록 노력해보겠습니다.

---

시연 사진

![a](/docs/a.png)

![b](/docs/b.png)

![c](docs/c.png)

---