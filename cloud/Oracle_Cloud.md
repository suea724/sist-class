# 📌 오라클 클라우드 서비스
- Oracle Cloud Free Tier
- VM(Virtual Machine)

### ✅ 가상 서버
- 운영체제 : Ubuntu 20.04 LTS
- 접속계정 : "ubuntu"

### ✅ 오라클 클라우드 방화벽 열기
- `sudo iptables -I INPUT 1 -p tcp --dport 80 -j ACCEPT`
- `sudo iptables -I INPUT 1 -p tcp --dport 443 -j ACCEPT`

<br>

# 📌 쉘
- bash : 기본 쉘
- zsh : bash보다 조금 더 편리한 기능을 제공한다.

### ✅ 리눅스 명령어
- **pwd**
    - Print Working Directory
    - 현재 작업중인 폴더의 경로 <br>
    ex) /home/ubuntu

- **ls <옵션>**
    - List Directory Contents
    - '-a' : all, 모든 파일과 디렉토리를 출력 (숨긴 파일/디렉토리)
    - '-l' : long, 상세 정보 <br>
    ex) ls -a -l <br>
    ex) ls -al <br>
    ex) ls -la

- **clear**
    - Clear Screen

- **방향키**
    - 실행했던 명령어의 이력 탐색

- **man <명령어>**
    - User's Manual
    - 명령어의 메뉴얼 출력

- **cd**
    - Change Directory <br>
    ex) `cd ..` <br>
    ex) `cd 자식폴더` <br>
    ex) `cd /` <br>
    ex) `cd ~` : 홈 디렉토리로 이동 <br>
    ex) `cd` : 홈 디렉토리로 이동 <br>
    ex) `cd -` : 이전 디렉토리로 이동 <br>
    
- **free**
    - 현재 시스템의 메모리 사용량, 남은 메모리 양 및 메모리 상태를 나타낸다. 

- **date**
    - 현재 시각 출력(영국 그리니치 기준)
    - 한국 기준으로 설정하려면 `sudo dpkg-reconfigure tzdata`에서 변경해준다.

- **cat <파일>**
    - 파일의 내용을 읽을 수 있다. 
- **vim <파일>**
    - 파일의 내용을 수정할 수 있다.

- **swap**
    - 메모리 부족을 보완하기 위해 하드디스크의 일부를 메모리처럼 사용할 수 있도록 해준다.
    - 1️⃣  `$ sudo fallocate -l 4G /swapfile`
    - 2️⃣ `$ sudo chmod 600 /swapfile`
    - 3️⃣ `$ sudo mkswap /swapfile`
    - 4️⃣ `$ sudo swapon /swapfile`
    - 5️⃣ `free`
    - 6️⃣ 위 설정을 서버 재시작 시에도 유지하려면 /etc/fstab 파일 수정 필요
- **mkdir**
    - Make Directory
    - `$ mkdir 폴더명 [폴더명 폴더명]`
- **tree**
    - 기본 명령어가 아님. 설치 필요 `$ sudo apt-get install tree`
    - 폴더의 계층구조를 보여준다.
   
- **rmdir**
    - Remove Directory
    - 비어있는 디렉토리만 삭제 가능
- **touch**
    - $ touch 파일명
    - 빈 파일을 생성한다.

<br>

### ✅ zsh 설치
- `$ sudo apt-get install zsh`
- `$ sudo chsh -s $(which zsh)` : 기본 쉘을 zsh로 바꾼다.

<br>

### ✅ oh-my-zsh
 쉘 관련 플러그인을 제공한다.
- 설치: `sh -c "$(wget -O- https://raw.githubusercontent.com/ohmyzsh/ohmyzsh/master/tools/install.sh)"`
- 테마 적용 `vim ~/.zshrc` : zsh_theme = "agnoster"로 설정

<br>

### ✅ 리눅스에서 프로그램(패키지) 설치
apt 또는 apt-get 명령어를 사용한다.

#### 👉 nginix 설치
1. `sudo apt-get update` : 현재 시스템의 패키지 상태를 최신 버전으로 업데이트
2. `sudo apt-get install nginx` : nginx 설치
3. `sudo systemctl status nginx` : 현재 패키지의 상태를 보여준다. 
4. `sudo systemcctl stop nginx` : 실행중인 패키지를 중단한다. inactive(dead)
5. `sudo systemcctl start nginx` : 패키지를 실행한다. active(running)
6. `sudo systemctl enable nginx` : 서버 시작시 같이 시작하도록 설정한다.

### 👉 nginix에 웹페이지 올리기
파일을 호스트간에 전송하기 위해서는 SFTP를 사용한다.
- /var/www/html : Nginix 기본 홈 디렉토리
- 권한 부여 : `sudo chmod -R 777 /var/www/html`