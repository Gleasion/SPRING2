package kr.or.ddit.controller.database;

public class MybatisController {
	
	/*
		12장 마이바티스
		
			# What?
				
				마이바티스는 자바 퍼시스턴스 프레임워크의 약자로 XML 서술자나 어노테이션을 사용하여 저장 프로시저나 SQL문으로 객체들을 연결시킨다.
				마이바티스는 Apache 라이선스 2.0으로 배포되는 자유 소프트웨어이다.
				
			# 마이바티스르 사용함으로써 얻을 수 있는 이점
				
				- SQL의 체계적인 관리
				- 자바 객체와 SQL 입출력 값의 투명한 바인딩
				- 동적 SQL 조합
			
			# 마이바티스 설정
			
				- 의존관계 정의 (pom.xml)
					> mybatis
					> mybatis-spring
					> spring-jdbc
					> commons-dbcp2
					> log4jdbc-log4j2-jdbc4
					> ojdbc 6 or 8
					
				- 스프링과 마이바티스 연결 설정 (root-context.xml 설정)
					> dataSource
					> sqlSessionFactory
					> sqlSessionTemplate
					> basePackage
					
				- 마이바티스 설정(mybatisAlias.xml 설정)
					> 마이바티스의 위치 설정은 root-context.xml의 sqlSessionFactory 설정 할 때 proeperty 요소로 적용
					
			# 테이블 생성
			
				- board, member, member_auth 테이블 생성
				
		2. Mapper 인터페이스
		- 인터페이스의 구현을 mybatis-spring에서 자동으로 생성할 수 있다.
		
			# 마이바티스 구현
			
				- Mapper 인터페이스
					> BoardMapper.java 생성
				
				- Mapper 인터페이스와 매핑할 Mapper
					> sqlmap/boardMapper.xml 생성
					
				- 게시판 구현 설명
				
					> 게시판 컨트롤러 만들기 (board/CrudBoardController)
					> 게시판 등록 화면 컨트롤러 메소드 만들기(crudRegister:get)
					> 게시판 등록 화면 만들기(crud/register.jsp)
					
					> 게시판 등록 기능 컨트롤러 메소드 만들기(crudRegister:post)
					> 게시판 등록 기능 서비스 인터페이스 메소드 만들기
					> 게시판 등록 기능 서비스 클래스 메소드 만들기
					> 게시판 등록 기능 Mapper 인터페이스 메소드 만들기
					> 게시판 등록 기능 Mapper xml 쿼리 만들기
					> 게시판 등록 완료 페이지 만들기
					
					> 게시판 목록 화면 컨트롤러 메소드 만들기(CrudList:get)
					> 게시판 목록 화면 서비스 인터페이스 메소드 만들기
					> 게시판 목록 화면 서비스 클래스 메소드 만들기
					> 게시판 목록 화면 Mapper 인터페이스 메소드 만들기
					> 게시판 목록 화면 Mapper xml 쿼리 만들기
					> 게시판 목록 화면 만들기 (crud/list.jsp)
				
					> 게시판 상세 화면 컨트롤러 메소드 만들기(crudRead:get)
					> 게시판 상세 화면 서비스 인터페이스 메소드 만들기
					> 게시판 상세 화면 서비스 클래스 메소드 만들기
					> 게시판 상세 화면 Mapper 인터페이스 메소드 만들기
					> 게시판 상세 화면 Mapper xml 쿼리 만들기
					> 게시판 상세 화면 만들기 (crud/read.jsp)
					
					> 게시판 수정 화면 컨트롤러 메소드 만들기 (crudModify:get)
					> 게시판 수정 화면 서비스 인터페이스 메소드 만들기
					> 게시판 수정 화면 Mapper 인터페이스 메소드 만들기
					> 게시판 수정 화면 Mapper xml 쿼리 만들기
					> 게시판 수정 화면 만들기 (crud/register.jsp)
					
					> 게시판 수정 기능 컨트롤러 메소드 만들기 (crudModify:post)
					> 게시판 수정 기능 서비스 인터페이스 메소드 만들기
					> 게시판 수정 기능 서비스 클래스 메소드 만들기
					> 게시판 수정 기능 Mapper 인터페이스 메소드 만들기
					> 게시판 수정 기능 Mapper xml 쿼리 만들기
					
					> 게시판 삭제 기능 컨트롤러 메소드 만들기 (crudRemove:post)
					> 게시판 삭제 기능 서비스 인터페이스 메소드 만들기
					> 게시판 삭제 기능 서비스 클래스 메소드 만들기
					> 게시판 삭제 기능 Mapper 인터페이스 메소드 만들기
					> 게시판 삭제 기능 Mapper xml 쿼리 만들기
					
					> 게시판 검색 기능 컨트롤러 메소드 만들기 (crudSearch:post)
					> 게시판 검색 기능 서비스 인터페이스 메소드 만들기
					> 게시판 검색 기능 서비스 클래스 메소드 만들기
					> 게시판 검색 기능 Mapper 인터페이스 메소드 만들기
					> 게시판 검색 기능 Mapper xml 쿼리 만들기
					> 게시판 검색 기능 화면 수정(list)
					
					> 기본적인 crud 끝!
					
		3. 별칭 적용
		- TypeAlias로 맵핑 파일에서 반복적으로 사용될 패키지의 이름을 정의한다.
		
			# 마이바티스 설정
			
				- mybatisAlias.xml 설정
					> typeAlias 설정을 한다.
					
				- boardMapper_SQL.xml 수정
					> 쿼리 태그에 각각 세팅한 패키지명 대신 alias로 설정한 별칭으로 대체한다.
					> 기존엔 kr.or.ddit.vo.Board와 같은 패키지명 + 클래스명으로 되어있는 type설정을 alias로 설정된 별칭을 사용한다.
					
		4. '_'로 구분된 컬럼명 재동 매핑
		- 마이바티스 설정의 mapUnderscoreToCamelCase 프로퍼티 값을 true로 지정하면 '_'로 구분된 컬럼명을
		소문자 낙타 표기법의 프로퍼티명으로 자동 매핑할 수 있다.
		
			'_' 포함되어있는 데이터베이스 컬럼명을 카멜기법 셋팅으로 인해서 bo_no가 boNo로 처리된다.
			
			# 마이바티스 설정(mybatisAlias.xml 설정)
				
				<settings>
					<setting name="mapUnderscoreToCamelCase" value="true"/> 설정 추가
				</settings>
				
				매핑 파일 수정(boardMapper_SQL.xml)
				- read, list로 되어 있는 실행 xml에서 select 절 내에서 조회되고 있는 '_'가 포함되어 있는
				컬럼들은 예로 as boardNo or as regDate와 같이 설정되어 있다면 삭제
				카멜 케이스에 의해서 '_'로 되어 있는 컬럼은 자동 변환되므로
				
		5. 기본키 취득
		- 마이바티스 useGeneratedKeys 속성을 이용하여 insert 할 때 데이터베이스 측에서 채번된 기본키를 취득할 수 있다.
		
			# 마이바티스 설정
				
				- 매핑 파일 수정(boardMapper_SQL.xml)
				- create 메소드 실행 xml 내 selectKey 태그 활용
				
					<insert id="create" parameterType="board" userGeneratedKeys="true">
						<selectKey order="BEFORE" resultType="int" keyProperty="boardNo">
							select seq_board.nextval from dual
						</selectKey>
						insert into board(
							board_no, title, content, writer, reg_date
						) values (
							#{boardNo}, #{title}, #{content}, #{writer}, #{reg_date}
						)
					</insert>
					
				insert 쿼리가 실행 되기 전 selectKey 태그 내에 있는 쿼리가 먼저 실행되어 최신 boardNo를 생성하고 생성된 boardNo를
				insert 하기 위해 넘어오면서 받아왔던 파라미터(board)의 property인 boardNo에 셋팅한다.
				셋팅된 boardNo를 insert 시, 등록 값으로 사용하고 board인 자바빈즈 클래스 객체에 담겨 최종 컨트롤러로 넘어간다.
				
				*** currval 사용 시 주의사항
					- select seq_board.currval from dual
					
					위 select 쿼리를 사용 시, currval를 사용하는데 있어서 사용 불가에 대한 에러가 발생할 수 있다.
					currval를 사용할 때는 select seq_board.nextval from dual로 최초 실행 후,
					select seq_board.currval from dual로 사용하면 에러가 발생하지 않는다.
					같은 세션 내에서의 실행이 이뤄지지 않았기 때문에 currval로 데이터를 가져오는데 에러가 발생한다.
					
					** 대체 할 수 있는 쿼리 (그럼에도 가져오려고 할 경우): 비추
					>>> select last_number from user_sequences where sequence_name = 'seq_board';
					>>> (select last_number from user_sequences where sequence_name = '시퀀스명';)
					
		6. 동적 SQL
		- 마이바티스는 동적 SQL을 조립하는 구조를 지원하고 있으며, SQL 조립 규칙을 매핑 파일에 정의할 수 있다.
		
			# 동적으로 SQL을 조립하기 위한 SQL 요소
				
				- <where>
					> where 절 앞 뒤에 내용을 더 추가하거나 삭제할 때 사용하는 요소
				
				- <if>
					> 조건을 만족할 때만 SQL을 조립할 수 있게 만드는 요소
				
				- <choose>
					> 여러 선택 항목에서 조건에 만족할 때만 SQL을 조립할 수 있게 만드는 요소
				
				- <foreach>
					> 컬렉션이나 배열에 대해 반복 처리를 하기 위한 요소
					
				- <set>
					> set 절 앞뒤에 내용을 더 추가하거나 삭제할 때 사용하는 요소
					
		7. 일대다 관계 테이블 매핑
		- 마이 바티스 기능을 활용하여 매핑 파일을 적절하게 정의하면 일대다 관계 테이블 매핑을 쉽게 처리할 수 있다.
		
			# 게시판 구현 설명
			
				- 회원 등록 화면 컨트롤러 만들기 (member/CrudMemberController)
				- 회원 등록 화면 컨트롤러 메소드 만들기 (crudMemberRegisterForm:get)
				- 회원 등록 화면 만들기 (crud/member/register.jsp)
				
				- 회원 등록 기능 컨트롤러 메소드 만들기 (crudMemberRegister:post)
				- 회원 등록 기능 인터페이스 메소드 만들기
				- 회원 등록 기능 클래스 메소드 만들기
				- 회원 등록 기능 Mapper 인터페이스 메소드 만들기
				- 회원 등록 기능 Mapper xml 쿼리 만들기
				- 회원 등록 완료 페이지 만들기 (crud/member/success.jsp)
				
				- 회원 목록 화면 컨트롤러 메소드 만들기 (crudMemberList:get)
				- 회원 목록 화면 서비스 인터페이스 메소드 만들기
				- 회원 목록 화면 서비스 클래스 메소드 만들기
				- 회원 목록 화면 Mapper 인터페이스 메소드 만들기
				- 회원 목록 화면 Mapper xml 쿼리 만들기
				- 회원 목록 화면 페이지 만들기 (crud/member/list.jsp)
				
				- 회원 상세 화면 컨트롤러 메소드 만들기 (crudMemberRead:get)
				- 회원 상세 화면 서비스 인터페이스 메소드 만들기
				- 회원 상세 화면 서비스 클래스 메소드 만들기
				- 회원 상세 화면 Mapper 인터페이스 메소드 만들기
				- 회원 상세 화면 Mapper xml 쿼리 만들기
				- 회원 상세 화면 만들기 (crud/member/read)
				
				- 회원 수정 화면 컨트롤러 메소드 만들기 (crudMemberModify:get)
				- 회원 수정 화면 서비스 인터페이스 메소드 만들기
				- 회원 수정 화면 서비스 클래스 메소드 만들기
				- 회원 수정 화면 Mapper 인터페이스 메소드 만들기
				- 회원 수정 화면 Mapper xml 쿼리 만들기
				- 회원 수정 화면 페이지 만들기 (crud/member/modify.jsp)
			
			
			
			
			
			
	===========================< 부트 스트랩을 이용한 CRUD >================================
			
		┌───────────────────────────────────────────┐
		│	페이지 모듈화를 위한 Tiles를 함께 사용하여 CRUD 진행	│
		└───────────────────────────────────────────┘
		
		1. Tiles란?
		
			- 어떤 jsp를 템플릿으로 사용하고 탬플릿의 각 영역을 어떤 내용으로 채울지에 대한 정보를 설정한다.
			- 하나의 화면들을 만들다보면 공통적이고 반복적으로 생성해야하는 header, footer와 같은 영역들이 존재합니다.
				우리는 그러한 공통 부분들을 분리하여 반복적으로 컴포넌트들을 사용하는게 아닌 공통적인 부분은 한번만 가져다 쓰고
				변화하는 부분에 대해서만 동적으로 변환해 페이지를 관리할 수 있어야합니다.
				이렇게, header/footer/menu 등 공통적인 소스를 분리하여 한 화면에서 동적으로 레이아웃을 한곳에 배치하여 설정하고
				관리할 수 있도록 도와주는 페이지 모듈화를 돕는 프레임 워크
			
			- 아래 jsp들을 이용하여 페이지 모듈화를 진행합니다.
				> template.jsp
					: header.jsp
					: content.jsp
					: footer.jsp
					
				** 그 외에 다양한 영역의 페이지는 구현하고자하는 시나리오를 바탕으로 페이지가 구성될 때 추가적으로
					레이아웃 영역을 분리하여 작성하면 됩니다.
					
		2. Tiles Layout 구현 설명
		
			1) Tiles 의존 관계 등록
				- tiles-core
				- tiles-api
				- tiles-servlet
				- titles-jsp
				
				** 의존 관계 등록 후 Mavean > Update Project
			
			2) servlet-context.xml 수정
				- ViewResolver order 순서 2순위로 지정
				- tilesViewResolver Bean 등록 진행
				
			3) tiles 설정 위한 xml 설정
				- /WEB-INF/spring/tiles-config.xml
				
			4) tiles xml에 설정한 layout 설정대로 페이지 생성(jsp)
			
		3. 공지사항 게시판(부트스트랩 및 Tiles를 활용)
		
			3-1) 데이터 베이스 준비
			
				create table dditboard(
					bo_no number(8) not null,
					bo_title varchar2(300) not null,
					bo_content varchar2(4000) not null,
					b_writer varchar2(300) not null,
					bo_date date not null,
					bo_hit number(8) not null,
					constraint pk_dditboard primary key(bo_no)
				);
				
				create sequence seq_dditboard increment by 1 start with 1 nocache;
		
		4. 회원 (부트스트랩 및 Tiles 활용)
		
			4-1) 데이터 베이스 준비
			
				create table dditmember(
					mem_no number(8) not null,
					mem_id varchar2(100) not null,
					mem_pw varchar2(100) not null,
					mem_name varchar2(100) not null,
					mem_gender varchar2(30) not null,
					mem_email varchar2(150) not null,
					mem_phone varchar2(150) not null,
					mem_postcode varchar2(30) not null,
					mem_address1 varchar2(300) not null,
					mem_address2 varchar2(300) not null,
					mem_agree varchar2(30) not null,
					mem_profileimg varchar2(500) null,
					mem_regdate date not null,
					constraint pk_dditmember primary key(mem_no)
				);
				
				create sequence seq_dditmember increment by 1 start with 1 nocache;
	 */
}
















