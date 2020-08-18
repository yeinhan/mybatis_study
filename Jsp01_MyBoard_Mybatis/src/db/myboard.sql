DROP SEQUENCE MYSEQ;
DROP TABLE MYBOARD;

CREATE SEQUENCE MYSEQ NOCACHE;

CREATE TABLE MYBOARD(
	MYNO NUMBER PRIMARY KEY,
	MYNAME VARCHAR2(100) NOT NULL,
	MYTITLE VARCHAR2(2000) NOT NULL,
	MYCONTENT VARCHAR2(4000) NOT NULL,
	MYDATE DATE NOT NULL
);

INSERT INTO MYBOARD VALUES(MYSEQ.NEXTVAL, '이창진', '게시판 테스트','2번째 테스트중...누가 나보고 악마래..ㅜㅜ',SYSDATE);

SELECT * FROM MYBOARD;