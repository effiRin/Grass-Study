# github 이용하기

## 1. github 프로젝트 가져오기

프로젝트를 위치할 폴더 안에서 (ex: ......../IdeaProjects)  
```
git clone https://github.com/Grass-Coders/Grass-Study.git
```  
위 코드로 프로젝트가 자신의 컴퓨터에 옮겨진다.  
(잘 안될 경우 아마도 git config나 authentication 문제일 가능성이 크다)

## 2. 자신이 변경한 내용 github에 적용 시키는 법

프로젝트 폴더 안에서

```bash
$ git add <파일명>
$ git commit -m "변경 사항에 대한 간략한 설명"
$ git push origin main
```

> `$ git add <파일명>` : github에 올릴 변경 사항을 정한다.  

`<파일명>`을 입력하면 특정 파일만 변경 사항을 git에 적용시킨다.(ex: `git add myFile.txt`)  
`<파일명>` 대신 `.`을 입력하면 변경 사항 전부를 지칭한다.  

> `$ git commit -m "<변경 사항에 대한 간략한 설명>"` : `git add`로 정한 변경 사항을 확정하고 메모를 남긴다.  

이 변경들이 무엇을 변경한 것인지 어떤 의미를 가지는지 간략하게 적어서 기록한다.  

> `$ git push origin main` : 확정한 변경 사항을 본인 컴퓨터 뿐만 아니라 github에도 올려 팀원들과 공유한다.  


## 3. 내 컴퓨터의 git을 github에 올라가 있는 최신 상태로 업데이트 하는 방법
```
$ git pull origin main
```

## 4. main 이나 master 외의 개인 branch에서의 작업

최종 결과물이 되어야하는 `main`이나 `master` branch에서 작업을 하다가 실수를 할 경우 복구하는 데에 애먹을 수 있다(git을 사용하고 있기 때문에 복구할 수는 있다!).  
그렇기 때문에 잘 못되어도 크게 문제되지 않을 branch를 만들어 그곳에서 작업을 하는 것이 안전하다.  

### 4-1. 개인 git branch 만들기

현재 작업 중이던 branch에서 아래와 같이 입력한다.
```
$ git checkout -b <branch이름>
```
이렇게 하면 현재 branch에서 파생된 새로운 branch를 작성할 수 있다.  
여기서 `$ git branch`라고 입력하면 존재하는 branch의 목록을 볼 수 있다.  
```
$ git checkout <branch명>
```
위 command를 통해 현재 작업 중인 branch를 이동할 수 있다.

github에 push(업로드)할땐 아래와 같이 입력한다.(`$ git push origin main`이랑 사실상 같은 의미다.)
```
$ git push origin <branch명>
```

### 4-2. branch merge(합치기)

작업 중이던 부분이 마무리 되어 `main`, `master`에 합칠 준비가 되었다면 아래 command를 통해 합칠 수 있다.
```
$ git merge <합칠 branch명>
```
여기서 주의할 점은 이 커맨드를 어떤 branch에서 입력하는지 이다.  
예를 들어 `main`에 `test`을 합칠 때는 `main`으로 이동해서 merge해야 한다.
```
$ git checkout main // main branch로 이동
$ git merge test // main 에 test를 merge한다
```

> 때로는 파생된 branch에 `main` branch를 합쳐야할 때도 있다.  

내가 `test`에서 작업 중이였는데 다른 팀원이 하던 작업이 마무리되어 `main`에 변경사항이 생겼다. 새로운 변경 사항을 내가 작업 중인 `test`에 적용 시키고 싶다면 아래와 같이 입력하면 된다.
```
$ git checkout main // main으로 이동
$ git pull origin main // 팀원이 적용시킨 변경 사항 불러오기
$ git chekcout test // test로 이동
$ git merge main // test에 main을 합친다
```