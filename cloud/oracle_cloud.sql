
/*

    [오라클 클라우드 서비스]
    - Oracle Cloud Free Tier
    - VM(Virtual Machine)
    
    
    [가상 서버]
    - 운영체제 > Ubuntu 20.04 LTS
    - 접속 계정 > "ubuntu" + ""
    
    [리눅스 명령어]
    - pwd
        - Print Working Directory
        - 현재 작업중인 폴더의 경로
        ex) /home/ubuntu
    
    - ls <옵션>
        - List Directory Contents
        - '-a' : all, 모든 파일과 디렉토리를 출력 (숨긴 파일/디렉토리)
        - '-l' : long, 상세 정보
        ex) ls -a -l
        ex) ls -al
        ex) ls -la
    
    - clear
        - Clear Screen
    
    - 방향키(위,아래)
        - 여태 실행했던 명령어의 이력 탐색
    
    - man <명령어>
        - User's Manual
    
    - cd
        - Change Directory
        ex) cd ..
        ex) cd 자식폴더
        ex) cd /
        ex) cd ~ : 홈 디렉토리로 이동
        ex) cd : 홈 디렉토리로 이동
        ex) cd - : 이전 디렉토리로 이동
        
    - 홈디렉토리(~)   
        - ubuntu@ubuntu:/home$ (계정명@서버이름:현재폴더$)
    
    - free
        - 현재 시스템의 메모리 사용량, 남은 메모리 양 및 메모리 상태를 나타낸다.
    
    - date
        - 현재 시각 출력(영국 그리니치)
    
    ------------------------------------------------------------------------------
    
    쉘
    1. bash
    2. zsh
    
    
    - Swap
        - 메모리 부족을 보완하기 위해 하드 디스크의 일부를 메모리처럼 사용하게 해준다.
            1. $ sudo fallocate -l 4G /swapfile
            2. $ sudo chmod 600 /swapfile
            3. $ sudo mkswap /swapfile
            4. $ sudo swapon /swapfile
            5. free
            6. 위 설정을 서버 재시작 시에도 유지하고 싶다
                - /etc/fstab 파일 수정 필요
                
            
    파일 열기 > 보기 or 편집
    1. cat <파일>
        - 파일의 내용을 보여준다. (읽기)
        - $ cat /etc/fstab
        
    2. vi, vim
        
    
    루트 사용자 > root > 모든 권한을 가진 관리자
    현재 로그인 계정 > ubuntu > 일반 사용자
    
    - 현재 시각 설정
        1. $ sudo dpkg-reconfigure tzdata
        2. ASIA
        3. Seoul
        4. date
        
    ------------------------------------------------------------------------------
    
    리눅스에서 패키지(프로그램) 설치하기
    - apt
    - apt-get
    
    1. $ sudo apt-get update > 현재 시스템의 패키지 상태를 최신 버전으로 업데이트
    2. $ sudo apt-get install nginx
    3. $ sudo systemctl status nginx > 현재 패키지의 상태를 보여준다. active(running)
    4. $ sudo systemcctl stop nginx > 실행중인 패키지를 중단한다. inactive(dead)
    5. $ sudo systemcctl start nginx
    
    6. $ sudo systemctl enable nginx > 서버 시작시 같이 시작
    
    
    - 오라클 클라우드 방화벽 열기
    - 우분투에서 방화벽 열기
        - $ sudo iptables -I INPUT 1 -p tcp --dport 80 -j ACCEPT
        - $ sudo iptables -I INPUT 1 -p tcp --dport 443 -j ACCEPT
        
        
    - 파일을 호스트간에 전송 > FTP > SFTP
    - Ngninx 기본 홈 디렉토리 > /var/www/html > 파일을 전송할 폴더
    
    
    권한 부여
    - $ sudo chmod -R 777 /var/www/html
        
*/