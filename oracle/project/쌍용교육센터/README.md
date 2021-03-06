#  교육센터 운영 DB 프로젝트

### 💡 시스템 목표
- 교육센터 운영 시 필요한 데이터를 효율적으로 관리하기 위해 데이터베이스를 설계하고 구축한다.
- 관리자, 교사, 교육생 계정 별로 다른 권한을 부여하여 데이터 보안성 및 무결성을 유지한다.

<br>

### 🛠 개발환경
- **프로젝트 기간** : 2022.05.11 ~ 2022.05.20 (10일간)
- **프로젝트 인원** : 6명
- **OS** : Window 10
- **Database** : Oracle 11g Express Edition
- **IDE** : SQL Developer
- **ERD** : eXERD


<br>

### 🌍 ERD
![ERD](./03.%20ERD/4%EC%A1%B0%20erd.png)

<br>

### 📌 핵심업무
|구분|상세|
|-|-|
|관리자|**기초 정보 관리** : 기초 정보(과정명, 과목명, 강의실명, 교재명)에 대한 입력, 출력, 수정, 삭제 <br> **교사 계정 관리** : 교사 계정에 대한 입력, 출력, 수정, 삭제 <br> **개설 과정 관리** : 개설 과정에 대한 입력, 출력, 수정, 삭제 <br> **개설 과목 관리** : 개설 과정에 종속적인 개설 과목 입력, 출력, 수정, 삭제 <br> **교육생 관리** : 교육생에 대한 입력, 출력, 수정, 삭제 및 조회 <br> **시험 관리 및 성적 조회** : 개설 과목 정보를 출력 및 개설 과목 별로 성적 등록 여부, 시험 문제 파일 등록 여부를 확인 <br> **출결 관리 및 조회** : 특정 개설 과정 선택 시 해당 과정 수강생의 출결 조회|
|교사|**강의 스케줄 조회** : 교사 본인의 강의 스케줄 조회 <br> **배점 입출력** : 강의를 마친 과목에 대해 배점 입출력 <br> **성적 입출력** : 강의를 마친 과목에 대해 성적 입출력<br> **출결 관리 및 조회** : 교육생의 출결 현황 조회|
|교육생|**성적 조회** : 수강 과정의 과목별 성적 조회 <br> **출결 관리 및  조회** : 교육생 본인의 출결 현황 조회 및 출결 기록|
|추가사항|**대면/비대면 등록 및 조회** : 진행 중인 수업에 대해 대면/비대면 선택 여부 등록 및 조회 <br> **프로젝트 참여 모집** : 프로젝트 모집글 및 댓글 등록, 수정, 삭제 <br> **QnA게시판** : 질문글 등록, 수정, 삭제(교육생), 댓글 등록, 수정, 삭제(교사) <br> **취업연계** : 구인기업 조회(교육생), 취업연계 등록(관리자) <br> **교재 수령방법 선택** : 택배/직접 수령 중 선택(교육생), 수령 여부 등록(관리자)|

<br>

### 📑 담당업무
|팀원명|업무 상세|
|-|-|
|안수아(조장)|**[교육생]** 로그인, 출결 기록 및 관리, 성적 조회  **[관리자]** 삭제 프로시저|
|김승연|**[교사]** 로그인, 강의 스케줄 조회, 배점 입출력, 시험 등록 및 수정 **[추가사항]** 게시판 수정 및 삭제|
|김찬진|**[관리자]** 출결 관리 및 출결 조회, 수정 프로시저 **[교사]** 성적 입출력, 출결 관리 및 출결 조회 **[교육생]** 출결 관리 및 출결 조회|
|남건희|**[관리자]** 교육생 관리, 시험 관리 및 성적 조회, 출결 관리 및 출결 조회|
|박선미|**[추가사항]** 대면/비대면 여부 조회 , 게시판 조회/입력, 채용모집, 교재 수령여부 |
|백서영|**[관리자]** 로그인, 기초정보 관리, 교사계정 관리, 개설 과정 관리, 개설 과목 관리|

<br>

### ✨ 후기 및 보완할 점
#### 🤗 후기
하나의 시스템을 운영하기 위해 데이터베이스를 설계하는 것부터 업무 SQL을 작성하는 과정까지 경험해보면서 데이터베이스가 어떻게 동작하는지 더 잘 이해할 수 있었던 프로젝트였다. DDL 또는 DML을 바로 작성하는 것보다 발생할 수 있는 여러가지 상황을 고려해서 ERD를 제대로 작성하는 것이 중요함을 느꼈다.

<br>

#### 🤔 보완할 점
데이터를 삭제할 때 그 데이터를 참조하는 데이터가 있을 때 삭제에 대한 처리를 하지 않아 삭제가 진행되지 않았다. DDL 작성 시 참조키에 `ON DELETE CASCADE` 옵션을 걸어주면 문제를 해결할 수 있다!

