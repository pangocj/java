package xyz.itwill.dto;

//create table review(num number primary key, id varchar2(30), subject varchar2(500)
//    , content varchar2(4000), regdate date, readcount number, ref number(4)
//	  , restep number(4), relevel number(4), ip varchar2(20), status number(1));
//create sequence review_seq; 

/* 
이름        널?       유형             
--------- -------- -------------- 
NUM       NOT NULL NUMBER         - 글번호
ID                 VARCHAR2(30)   - 작성자(아이디)
SUBJECT            VARCHAR2(500)  - 제목
CONTENT            VARCHAR2(4000) - 내용
REGDATE            DATE           - 작성날짜
READCOUNT          NUMBER         - 조회수
REF                NUMBER(4)      - 글그룹(답글)
RESTEP             NUMBER(4)      - 글그룹 내부의 글순서(답글)
RELEVEL            NUMBER(4)      - 게시글의 깊이(답글)
IP                 VARCHAR2(20)   - 작성자 컴퓨터의 IP 주소
STATUS             NUMBER(1)      - 게시글 상태 : 0(삭제글), 1(일반글), 2(비밀글)
*/

public class ReviewDTO {
	private int num;
	private String id;
	private String name;//MEMBER 테이블의 회원이름을 저장하기 위한 필드
	private String subject;
	private String content;
	private String regdate;
	private int readcount;
	private int ref;
	private int restep;
	private int relevel;
	private String ip;
	private int status;
	
	public ReviewDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public int getRestep() {
		return restep;
	}

	public void setRestep(int restep) {
		this.restep = restep;
	}

	public int getRelevel() {
		return relevel;
	}

	public void setRelevel(int relevel) {
		this.relevel = relevel;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
