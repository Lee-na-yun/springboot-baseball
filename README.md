# MyBatis DB연결 세팅

### 페이징 개수 변경법
- boards.xml 에 id=paging 부분에 ceil(count(*)/5) totalPage
- boards.xml 에 id=findAll 부분에 FETCH NEXT 5 ROWS ONLY
- BoardsService 에 게시글목록보기() 메서드에 int startNum = page * 5;

### 설정방법
- MyBatisConfig 파일 필요
- resources/mapper/*.xml 파일 필요
- Users 엔티티 필요
- UsersDao 인터페이스 생성 필요

### MariaDB 사용자 생성 및 권한 주기
```sql
CREATE USER 'green'@'%' IDENTIFIED BY 'green1234';
CREATE DATABASE greendb;
GRANT ALL PRIVILEGES ON greendb.* TO 'green'@'%';
```

### 테이블 생성
```sql
USE greendb;

SELECT * FROM stadiums;

DROP table stadiums;
DROP table teams;
DROP table players;
DROP table expulsion;

##야구장
CREATE TABLE stadiums(
	id int auto_increment primary key,
    name varchar(100) unique not null,
    createDate timestamp
) engine=InnoDB default charset=utf8;

##팀
CREATE TABLE teams(
	id int auto_increment primary key,
    stadiumId int,
    name varchar(100) unique not null,
    createDate timestamp
) engine=InnoDB default charset=utf8;

##선수
CREATE TABLE players(
	id int auto_increment primary key,
    name varchar(100) unique not null,
    teamId int,
    position varchar(100) not null,
    playerNum INT,
    createDate timestamp
) engine=InnoDB default charset=utf8;


#퇴출
CREATE TABLE expulsions(
	id int auto_increment primary key,
    reason varchar(100) unique not null,
    playerId int,
    createDate timestamp
) engine=InnoDB default charset=UTF8;
```

### 더미데이터 추가
```sql
INSERT into stadiums(name,createDate)
VALUES("사직야구장",now());
INSERT into stadiums(name,createDate)
VALUES("잠실야구장",now());
INSERT into stadiums(name,createDate)
VALUES("고척스카이돔",NOW());

INSERT into teams(stadiumId,name,createDate)
VALUES("1","롯데",now());
INSERT into teams(stadiumId,name,createDate)
VALUES("2","LG트윈스",now());
INSERT into teams(stadiumId,name,createDate)
VALUES("3","키움히어로즈",now());

INSERT into players(name,teamId,position,playerNum,createDate)
VALUES("반즈",1,"투수",28,now());
INSERT into players(name,teamId,position,playerNum,createDate)
VALUES("전준우",1,"외야수",8,now());
INSERT into players(name,teamId,position,playerNum,createDate)
VALUES("이대호",1,"내야수",10,now());


INSERT into players(name,teamId,position,playerNum,createDate)
VALUES("고우석",2,"투수",19,now());
INSERT into players(name,teamId,position,playerNum,createDate)
VALUES("박해민",2,"외야수",17,now());
INSERT into players(name,teamId,position,playerNum,createDate)
VALUES("문보경",2,"내야수",35,now());

DELETE FROM players WHERE NAME="김혜성";
SELECT * FROM players;

INSERT into players(name,teamId,position,playerNum,createDate)
VALUES("안우진",3,"투수",41,now());
INSERT into players(name,teamId,position,playerNum,createDate)
VALUES("이정후",3,"외야수",51,now());
INSERT into players(name,teamId,position,playerNum,createDate)
VALUES("김혜성",3,"내야수",3,now());
COMMIT;
```

### 좋아요 + 상세보기 쿼리
```sql
SELECT bo.*,
lo.id lovesId,
if(lo.id IS NULL, 0, 1) isLoved,
(SELECT COUNT(*) FROM loves WHERE boardsId = 3) loveCount
FROM boards bo
LEFT OUTER JOIN (SELECT * FROM loves WHERE usersId = 3) lo
ON bo.id = lo.boardsId
WHERE bo.id = 3

SELECT
b.*,
(SELECT id FROM loves WHERE usersId = 1 AND boardsId = 3) lovesId,
(SELECT 1 FROM loves WHERE usersId = 1 AND boardsId = 3) isLoved,
(SELECT COUNT(*) FROM loves WHERE boardsId = 3) loveCount
FROM boards b
WHERE b.id = 3
```