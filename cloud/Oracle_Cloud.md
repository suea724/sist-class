# ๐ ์ค๋ผํด ํด๋ผ์ฐ๋ ์๋น์ค
- Oracle Cloud Free Tier
- VM(Virtual Machine)

### โ ๊ฐ์ ์๋ฒ
- ์ด์์ฒด์  : Ubuntu 20.04 LTS
- ์ ์๊ณ์  : "ubuntu"

### โ ์ค๋ผํด ํด๋ผ์ฐ๋ ๋ฐฉํ๋ฒฝ ์ด๊ธฐ
- `sudo iptables -I INPUT 1 -p tcp --dport 80 -j ACCEPT`
- `sudo iptables -I INPUT 1 -p tcp --dport 443 -j ACCEPT`

<br>

# ๐ ์
- bash : ๊ธฐ๋ณธ ์
- zsh : bash๋ณด๋ค ์กฐ๊ธ ๋ ํธ๋ฆฌํ ๊ธฐ๋ฅ์ ์ ๊ณตํ๋ค.

### โ ๋ฆฌ๋์ค ๋ช๋ น์ด
- **pwd**
    - Print Working Directory
    - ํ์ฌ ์์์ค์ธ ํด๋์ ๊ฒฝ๋ก <br>
    ex) /home/ubuntu

- **ls <์ต์>**
    - List Directory Contents
    - '-a' : all, ๋ชจ๋  ํ์ผ๊ณผ ๋๋ ํ ๋ฆฌ๋ฅผ ์ถ๋ ฅ (์จ๊ธด ํ์ผ/๋๋ ํ ๋ฆฌ)
    - '-l' : long, ์์ธ ์ ๋ณด <br>
    ex) ls -a -l <br>
    ex) ls -al <br>
    ex) ls -la

- **clear**
    - Clear Screen

- **๋ฐฉํฅํค**
    - ์คํํ๋ ๋ช๋ น์ด์ ์ด๋ ฅ ํ์

- **man <๋ช๋ น์ด>**
    - User's Manual
    - ๋ช๋ น์ด์ ๋ฉ๋ด์ผ ์ถ๋ ฅ

- **cd**
    - Change Directory <br>
    ex) `cd ..` <br>
    ex) `cd ์์ํด๋` <br>
    ex) `cd /` <br>
    ex) `cd ~` : ํ ๋๋ ํ ๋ฆฌ๋ก ์ด๋ <br>
    ex) `cd` : ํ ๋๋ ํ ๋ฆฌ๋ก ์ด๋ <br>
    ex) `cd -` : ์ด์  ๋๋ ํ ๋ฆฌ๋ก ์ด๋ <br>
    
- **free**
    - ํ์ฌ ์์คํ์ ๋ฉ๋ชจ๋ฆฌ ์ฌ์ฉ๋, ๋จ์ ๋ฉ๋ชจ๋ฆฌ ์ ๋ฐ ๋ฉ๋ชจ๋ฆฌ ์ํ๋ฅผ ๋ํ๋ธ๋ค. 

- **date**
    - ํ์ฌ ์๊ฐ ์ถ๋ ฅ(์๊ตญ ๊ทธ๋ฆฌ๋์น ๊ธฐ์ค)
    - ํ๊ตญ ๊ธฐ์ค์ผ๋ก ์ค์ ํ๋ ค๋ฉด `sudo dpkg-reconfigure tzdata`์์ ๋ณ๊ฒฝํด์ค๋ค.

- **cat <ํ์ผ>**
    - ํ์ผ์ ๋ด์ฉ์ ์ฝ์ ์ ์๋ค. 
- **vim <ํ์ผ>**
    - ํ์ผ์ ๋ด์ฉ์ ์์ ํ  ์ ์๋ค.

- **swap**
    - ๋ฉ๋ชจ๋ฆฌ ๋ถ์กฑ์ ๋ณด์ํ๊ธฐ ์ํด ํ๋๋์คํฌ์ ์ผ๋ถ๋ฅผ ๋ฉ๋ชจ๋ฆฌ์ฒ๋ผ ์ฌ์ฉํ  ์ ์๋๋ก ํด์ค๋ค.
    - 1๏ธโฃ  `$ sudo fallocate -l 4G /swapfile`
    - 2๏ธโฃ `$ sudo chmod 600 /swapfile`
    - 3๏ธโฃ `$ sudo mkswap /swapfile`
    - 4๏ธโฃ `$ sudo swapon /swapfile`
    - 5๏ธโฃ `free`
    - 6๏ธโฃ ์ ์ค์ ์ ์๋ฒ ์ฌ์์ ์์๋ ์ ์งํ๋ ค๋ฉด /etc/fstab ํ์ผ ์์  ํ์
- **mkdir**
    - Make Directory
    - `$ mkdir ํด๋๋ช [ํด๋๋ช ํด๋๋ช]`
- **tree**
    - ๊ธฐ๋ณธ ๋ช๋ น์ด๊ฐ ์๋. ์ค์น ํ์ `$ sudo apt-get install tree`
    - ํด๋์ ๊ณ์ธต๊ตฌ์กฐ๋ฅผ ๋ณด์ฌ์ค๋ค.
   
- **rmdir**
    - Remove Directory
    - ๋น์ด์๋ ๋๋ ํ ๋ฆฌ๋ง ์ญ์  ๊ฐ๋ฅ
- **touch**
    - $ touch ํ์ผ๋ช
    - ๋น ํ์ผ์ ์์ฑํ๋ค.

<br>

### โ zsh ์ค์น
- `$ sudo apt-get install zsh`
- `$ sudo chsh -s $(which zsh)` : ๊ธฐ๋ณธ ์์ zsh๋ก ๋ฐ๊พผ๋ค.

<br>

### โ oh-my-zsh
 ์ ๊ด๋ จ ํ๋ฌ๊ทธ์ธ์ ์ ๊ณตํ๋ค.
- ์ค์น: `sh -c "$(wget -O- https://raw.githubusercontent.com/ohmyzsh/ohmyzsh/master/tools/install.sh)"`
- ํ๋ง ์ ์ฉ `vim ~/.zshrc` : zsh_theme = "agnoster"๋ก ์ค์ 

<br>

### โ ๋ฆฌ๋์ค์์ ํ๋ก๊ทธ๋จ(ํจํค์ง) ์ค์น
apt ๋๋ apt-get ๋ช๋ น์ด๋ฅผ ์ฌ์ฉํ๋ค.

#### ๐ nginix ์ค์น
1. `sudo apt-get update` : ํ์ฌ ์์คํ์ ํจํค์ง ์ํ๋ฅผ ์ต์  ๋ฒ์ ์ผ๋ก ์๋ฐ์ดํธ
2. `sudo apt-get install nginx` : nginx ์ค์น
3. `sudo systemctl status nginx` : ํ์ฌ ํจํค์ง์ ์ํ๋ฅผ ๋ณด์ฌ์ค๋ค. 
4. `sudo systemcctl stop nginx` : ์คํ์ค์ธ ํจํค์ง๋ฅผ ์ค๋จํ๋ค. inactive(dead)
5. `sudo systemcctl start nginx` : ํจํค์ง๋ฅผ ์คํํ๋ค. active(running)
6. `sudo systemctl enable nginx` : ์๋ฒ ์์์ ๊ฐ์ด ์์ํ๋๋ก ์ค์ ํ๋ค.

### ๐ nginix์ ์นํ์ด์ง ์ฌ๋ฆฌ๊ธฐ
ํ์ผ์ ํธ์คํธ๊ฐ์ ์ ์กํ๊ธฐ ์ํด์๋ SFTP๋ฅผ ์ฌ์ฉํ๋ค.
- /var/www/html : Nginix ๊ธฐ๋ณธ ํ ๋๋ ํ ๋ฆฌ
- ๊ถํ ๋ถ์ฌ : `sudo chmod -R 777 /var/www/html`