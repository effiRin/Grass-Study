## 프로젝트 가져오기
프로젝트를 위치할 폴더 안에서 (ex: ......../IdeaProjects)  
`git clone https://github.com/WebtoonRecommendationService/WebtoonRecommendationService.git`  
위 코드로 프로젝트가 자신의 컴퓨터에 옮겨진다.  

## 자신이 변경한 내용 github에 적용 시키는 법
프로젝트 폴더 안에서

```bash
git add .
git commit -m "<변경 사항에 대한 간략한 설명>"
git push origin main
```

`git add .` : github에 올릴 변경 사항을 정한다.  
.은 변경 사항 전부를 지칭한다.  
. 대신 <변경할 파일명>을 입력하면 특정 파일만 변경 사항을 git에 적용시킨다.(ex: `git add myFile.txt`)  

`git commit -m "<변경 사항에 대한 간략한 설명>"` : `git add`로 정한 변경 사항을 확정하고 메모를 남긴다.  
이 변경들이 무엇을 변경한 것인지 어떤 의미를 가지는지 간략하게 적어서 기록한다.  

`git push origin main` : 확정한 변경 사항을 본인 컴퓨터 뿐만 아니라 github에도 올려 팀원들과 공유한다.  

## 내 컴퓨터의 git을 github에 올라가 있는 최신 상태로 업데이트 하는 방법
`git pull origin main`
