-- 수강신청
DROP TABLE TABLE;

-- PMS
DROP TABLE pms;

-- 프로젝트팀원
DROP TABLE mbr;

-- 프로젝트팀
DROP TABLE pjtm;

-- 프로젝트기간
DROP TABLE date;

-- 임시 테이블2
DROP TABLE Temporary4;

-- 프로젝트순손익
DROP TABLE Temporary5;

-- 임시 테이블4
DROP TABLE Temporary6;

-- 임시 테이블5
DROP TABLE Temporary7;

-- 임시 테이블6
DROP TABLE Temporary8;

-- 임시 테이블7
DROP TABLE Temporary9;

-- PMS프로젝트순손익
DROP TABLE TABLE3;

-- 임시 테이블3
DROP TABLE Temporary10;

-- 임시 테이블8
DROP TABLE Temporary11;

-- 프로젝트순수익
DROP TABLE Temporary12;

-- 임시 테이블10
DROP TABLE Temporary13;

-- 임시 테이블11
DROP TABLE Temporary14;

-- 임시 테이블12
DROP TABLE Temporary15;

-- 임시 테이블13
DROP TABLE Temporary16;

-- 임시 테이블14
DROP TABLE Temporary17;

-- 임시 테이블15
DROP TABLE Temporary18;

-- 임시 테이블16
DROP TABLE Temporary19;

-- 프로젝트장소
DROP TABLE loc;

-- 운영체제호환
DROP TABLE os;

-- 장점
DROP TABLE TABLE6;

-- 단점
DROP TABLE TABLE7;

-- 사용기술
DROP TABLE tch;

-- 프로젝트고객
DROP TABLE clnt;

-- 프로젝트손익
DROP TABLE TABLE10;

-- 프로젝트비용
DROP TABLE TABLE11;

-- 프로젝트순손익
DROP TABLE npl;

-- 운영체ㅈ
DROP TABLE TABLE12;

-- PMS운영체제호환
DROP TABLE TABLE13;

-- PMS사용기술
DROP TABLE pms_tch;

-- 사용자
DROP TABLE TABLE15;

-- PMS프로젝트팀
DROP TABLE pms_pjtm;

-- 주소
DROP TABLE addr;

-- 프로젝트팀프로젝트팀원
DROP TABLE pjtm_mbr;

-- 결제유형
DROP TABLE pay_type;

-- 인적정보
DROP TABLE hmr;

-- 자료
DROP TABLE data;

-- 자료유형
DROP TABLE data_type;

-- PMS자료
DROP TABLE pms_data;

-- 자료자료유형
DROP TABLE data_data_type;

-- 프로젝트등급
DROP TABLE TABLE25;

-- 프로젝트등급
DROP TABLE grad;

-- 프로젝트업무
DROP TABLE work;

-- 프로젝트업무등급
DROP TABLE work_grad;

-- PMS프로젝트업무
DROP TABLE pms_work;

-- 프로젝트내용
DROP TABLE TABLE29;

-- 프로젝트산출물
DROP TABLE TABLE30;

-- 프로젝트프로토타입
DROP TABLE TABLE31;

-- 개발자등급
DROP TABLE dvlp_grad;

-- 개발자단가
DROP TABLE TABLE33;

-- 수강신청
CREATE TABLE TABLE (
  COL   <데이터 타입 없음> NULL, -- 이름
  COL2  <데이터 타입 없음> NULL, -- 이메일
  COL3  <데이터 타입 없음> NULL, -- 전화
  COL4  <데이터 타입 없음> NULL, -- 우편번호
  COL5  <데이터 타입 없음> NULL, -- 기본주소
  COL6  <데이터 타입 없음> NULL, -- 상세주소
  COL7  <데이터 타입 없음> NULL, -- 은행명
  COL8  <데이터 타입 없음> NULL, -- 계좌번호
  COL9  <데이터 타입 없음> NULL, -- 최종학력
  COL10 <데이터 타입 없음> NULL, -- 전공
  COL11 <데이터 타입 없음> NULL, -- 과목명
  COL12 <데이터 타입 없음> NULL, -- 시작일
  COL13 <데이터 타입 없음> NULL, -- 종료일
  COL14 <데이터 타입 없음> NULL, -- 총강의시간
  COL15 <데이터 타입 없음> NULL, -- 일강의시간
  COL42 <데이터 타입 없음> NULL, -- 수강료
  COL39 <데이터 타입 없음> NULL, -- 결제상태
  COL40 <데이터 타입 없음> NULL, -- 결제유형
  COL41 <데이터 타입 없음> NULL, -- 결제일
  COL16 <데이터 타입 없음> NULL, -- 강사1이름
  COL17 <데이터 타입 없음> NULL, -- 강사1전화
  COL18 <데이터 타입 없음> NULL, -- 강사1이메일
  COL19 <데이터 타입 없음> NULL, -- 강사1사진
  COL20 <데이터 타입 없음> NULL, -- 강사2이름
  COL21 <데이터 타입 없음> NULL, -- 강사2전화
  COL22 <데이터 타입 없음> NULL, -- 강사2이메일
  COL23 <데이터 타입 없음> NULL, -- 강사2사진
  COL24 <데이터 타입 없음> NULL, -- 강사3이름
  COL25 <데이터 타입 없음> NULL, -- 강사3전화
  COL26 <데이터 타입 없음> NULL, -- 강사3이메일
  COL27 <데이터 타입 없음> NULL, -- 강사3사진
  COL28 <데이터 타입 없음> NULL, -- 센터지점
  COL29 <데이터 타입 없음> NULL, -- 교실명
  COL30 <데이터 타입 없음> NULL, -- 최대수용인원
  COL31 <데이터 타입 없음> NULL, -- 교실사진1
  COL32 <데이터 타입 없음> NULL, -- 교실사진2
  COL33 <데이터 타입 없음> NULL, -- 교실사진3
  COL34 <데이터 타입 없음> NULL, -- 매니저이름
  COL35 <데이터 타입 없음> NULL, -- 매니저전화
  COL36 <데이터 타입 없음> NULL, -- 매니저이메일
  COL37 <데이터 타입 없음> NULL, -- 매니저직위
  COL38 <데이터 타입 없음> NULL  -- 매니저사진
);

-- 수강신청
COMMENT ON TABLE TABLE IS '수강신청';

-- 이름
COMMENT ON COLUMN TABLE.COL IS '이름';

-- 이메일
COMMENT ON COLUMN TABLE.COL2 IS '이메일';

-- 전화
COMMENT ON COLUMN TABLE.COL3 IS '전화';

-- 우편번호
COMMENT ON COLUMN TABLE.COL4 IS '우편번호';

-- 기본주소
COMMENT ON COLUMN TABLE.COL5 IS '기본주소';

-- 상세주소
COMMENT ON COLUMN TABLE.COL6 IS '상세주소';

-- 은행명
COMMENT ON COLUMN TABLE.COL7 IS '은행명';

-- 계좌번호
COMMENT ON COLUMN TABLE.COL8 IS '계좌번호';

-- 최종학력
COMMENT ON COLUMN TABLE.COL9 IS '최종학력';

-- 전공
COMMENT ON COLUMN TABLE.COL10 IS '전공';

-- 과목명
COMMENT ON COLUMN TABLE.COL11 IS '과목명';

-- 시작일
COMMENT ON COLUMN TABLE.COL12 IS '시작일';

-- 종료일
COMMENT ON COLUMN TABLE.COL13 IS '종료일';

-- 총강의시간
COMMENT ON COLUMN TABLE.COL14 IS '총강의시간';

-- 일강의시간
COMMENT ON COLUMN TABLE.COL15 IS '일강의시간';

-- 수강료
COMMENT ON COLUMN TABLE.COL42 IS '수강료';

-- 결제상태
COMMENT ON COLUMN TABLE.COL39 IS '결제상태';

-- 결제유형
COMMENT ON COLUMN TABLE.COL40 IS '결제유형';

-- 결제일
COMMENT ON COLUMN TABLE.COL41 IS '결제일';

-- 강사1이름
COMMENT ON COLUMN TABLE.COL16 IS '강사1이름';

-- 강사1전화
COMMENT ON COLUMN TABLE.COL17 IS '강사1전화';

-- 강사1이메일
COMMENT ON COLUMN TABLE.COL18 IS '강사1이메일';

-- 강사1사진
COMMENT ON COLUMN TABLE.COL19 IS '강사1사진';

-- 강사2이름
COMMENT ON COLUMN TABLE.COL20 IS '강사2이름';

-- 강사2전화
COMMENT ON COLUMN TABLE.COL21 IS '강사2전화';

-- 강사2이메일
COMMENT ON COLUMN TABLE.COL22 IS '강사2이메일';

-- 강사2사진
COMMENT ON COLUMN TABLE.COL23 IS '강사2사진';

-- 강사3이름
COMMENT ON COLUMN TABLE.COL24 IS '강사3이름';

-- 강사3전화
COMMENT ON COLUMN TABLE.COL25 IS '강사3전화';

-- 강사3이메일
COMMENT ON COLUMN TABLE.COL26 IS '강사3이메일';

-- 강사3사진
COMMENT ON COLUMN TABLE.COL27 IS '강사3사진';

-- 센터지점
COMMENT ON COLUMN TABLE.COL28 IS '센터지점';

-- 교실명
COMMENT ON COLUMN TABLE.COL29 IS '교실명';

-- 최대수용인원
COMMENT ON COLUMN TABLE.COL30 IS '최대수용인원';

-- 교실사진1
COMMENT ON COLUMN TABLE.COL31 IS '교실사진1';

-- 교실사진2
COMMENT ON COLUMN TABLE.COL32 IS '교실사진2';

-- 교실사진3
COMMENT ON COLUMN TABLE.COL33 IS '교실사진3';

-- 매니저이름
COMMENT ON COLUMN TABLE.COL34 IS '매니저이름';

-- 매니저전화
COMMENT ON COLUMN TABLE.COL35 IS '매니저전화';

-- 매니저이메일
COMMENT ON COLUMN TABLE.COL36 IS '매니저이메일';

-- 매니저직위
COMMENT ON COLUMN TABLE.COL37 IS '매니저직위';

-- 매니저사진
COMMENT ON COLUMN TABLE.COL38 IS '매니저사진';

-- PMS
CREATE TABLE pms (
  pms_id  INTEGER      NOT NULL, -- 프로젝트번호
  name    VARCHAR(50)  NOT NULL, -- 프로젝트제목
  prps    VARCHAR(255) NOT NULL, -- 프로젝트목적
  plan    VARCHAR(255) NULL,     -- 프로젝트계획
  cont    VARCHAR(255) NULL,     -- 프로젝트내용
  sum     VARCHAR(255) NULL,     -- 프로젝트요약
  schm    VARCHAR(255) NULL,     -- 프로젝트스키마
  prrs    VARCHAR(255) NULL,     -- 프로젝트예상결과
  date_id INTEGER      NULL,     -- 프로젝트총기간번호
  npl_id  INTEGER      NULL,     -- 프로젝트순손익번호
  clnt_id INTEGER      NULL,     -- 프로젝트고객번호
  loc_id  INTEGER      NULL,     -- 프로젝트장소번호
  grad_id INTEGER      NULL      -- 프로젝트등급번호
);

-- PMS 기본키
CREATE UNIQUE INDEX PK_pms
  ON pms ( -- PMS
    pms_id ASC -- 프로젝트번호
  );

-- PMS 유니크 인덱스
CREATE UNIQUE INDEX UIX_pms
  ON pms ( -- PMS
    name ASC -- 프로젝트제목
  );

-- PMS
ALTER TABLE pms
  ADD
    CONSTRAINT PK_pms -- PMS 기본키
    PRIMARY KEY (
      pms_id -- 프로젝트번호
    );

-- PMS
ALTER TABLE pms
  ADD
    CONSTRAINT UK_pms -- PMS 유니크 제약
    UNIQUE (
      name -- 프로젝트제목
    );

-- PMS
COMMENT ON TABLE pms IS 'PMS';

-- 프로젝트번호
COMMENT ON COLUMN pms.pms_id IS '프로젝트번호';

-- 프로젝트제목
COMMENT ON COLUMN pms.name IS '프로젝트제목';

-- 프로젝트목적
COMMENT ON COLUMN pms.prps IS '프로젝트목적';

-- 프로젝트계획
COMMENT ON COLUMN pms.plan IS '프로젝트계획';

-- 프로젝트내용
COMMENT ON COLUMN pms.cont IS '프로젝트내용';

-- 프로젝트요약
COMMENT ON COLUMN pms.sum IS '프로젝트요약';

-- 프로젝트스키마
COMMENT ON COLUMN pms.schm IS '프로젝트스키마';

-- 프로젝트예상결과
COMMENT ON COLUMN pms.prrs IS '프로젝트예상결과';

-- 프로젝트총기간번호
COMMENT ON COLUMN pms.date_id IS '프로젝트총기간번호';

-- 프로젝트순손익번호
COMMENT ON COLUMN pms.npl_id IS '프로젝트순손익번호';

-- 프로젝트고객번호
COMMENT ON COLUMN pms.clnt_id IS '프로젝트고객번호';

-- 프로젝트장소번호
COMMENT ON COLUMN pms.loc_id IS '프로젝트장소번호';

-- 프로젝트등급번호
COMMENT ON COLUMN pms.grad_id IS '프로젝트등급번호';

-- PMS 기본키
COMMENT ON INDEX PK_pms IS 'PMS 기본키';

-- PMS 유니크 인덱스
COMMENT ON INDEX UIX_pms IS 'PMS 유니크 인덱스';

-- PMS 기본키
COMMENT ON CONSTRAINT pms.PK_pms IS 'PMS 기본키';

-- PMS 유니크 제약
COMMENT ON CONSTRAINT pms.UK_pms IS 'PMS 유니크 제약';

-- 프로젝트팀원
CREATE TABLE mbr (
  mbr_id       INTEGER      NOT NULL, -- 프로젝트팀원번호
  pwd          VARCHAR(255) NOT NULL, -- 암호
  outin        INTEGER      NOT NULL, -- 외부인원
  inpdt        DATE         NULL,     -- 투입기간
  pms_id       INTEGER      NOT NULL, -- 프로젝트번호
  hmr_id       INTEGER      NOT NULL, -- 팀원정보
  dvlp_grad_id INTEGER      NOT NULL  -- 개발자등급번호
);

-- 프로젝트팀원 기본키
CREATE UNIQUE INDEX PK_mbr
  ON mbr ( -- 프로젝트팀원
    mbr_id ASC -- 프로젝트팀원번호
  );

-- 프로젝트팀원
ALTER TABLE mbr
  ADD
    CONSTRAINT PK_mbr -- 프로젝트팀원 기본키
    PRIMARY KEY (
      mbr_id -- 프로젝트팀원번호
    );

-- 프로젝트팀원
COMMENT ON TABLE mbr IS '프로젝트팀원';

-- 프로젝트팀원번호
COMMENT ON COLUMN mbr.mbr_id IS '프로젝트팀원번호';

-- 암호
COMMENT ON COLUMN mbr.pwd IS '암호';

-- 외부인원
COMMENT ON COLUMN mbr.outin IS '외부인원';

-- 투입기간
COMMENT ON COLUMN mbr.inpdt IS '투입기간';

-- 프로젝트번호
COMMENT ON COLUMN mbr.pms_id IS '프로젝트번호';

-- 팀원정보
COMMENT ON COLUMN mbr.hmr_id IS '팀원정보';

-- 개발자등급번호
COMMENT ON COLUMN mbr.dvlp_grad_id IS '개발자등급번호';

-- 프로젝트팀원 기본키
COMMENT ON INDEX PK_mbr IS '프로젝트팀원 기본키';

-- 프로젝트팀원 기본키
COMMENT ON CONSTRAINT mbr.PK_mbr IS '프로젝트팀원 기본키';

-- 프로젝트팀
CREATE TABLE pjtm (
  team_id INTEGER     NOT NULL, -- 프로젝트팀번호
  name    VARCHAR(50) NOT NULL  -- 팀이름
);

-- 프로젝트팀 기본키
CREATE UNIQUE INDEX PK_pjtm
  ON pjtm ( -- 프로젝트팀
    team_id ASC -- 프로젝트팀번호
  );

-- 프로젝트팀 유니크 인덱스
CREATE UNIQUE INDEX UIX_pjtm
  ON pjtm ( -- 프로젝트팀
    name ASC -- 팀이름
  );

-- 프로젝트팀
ALTER TABLE pjtm
  ADD
    CONSTRAINT PK_pjtm -- 프로젝트팀 기본키
    PRIMARY KEY (
      team_id -- 프로젝트팀번호
    );

-- 프로젝트팀
ALTER TABLE pjtm
  ADD
    CONSTRAINT UK_pjtm -- 프로젝트팀 유니크 제약
    UNIQUE (
      name -- 팀이름
    );

-- 프로젝트팀
COMMENT ON TABLE pjtm IS '프로젝트팀';

-- 프로젝트팀번호
COMMENT ON COLUMN pjtm.team_id IS '프로젝트팀번호';

-- 팀이름
COMMENT ON COLUMN pjtm.name IS '팀이름';

-- 프로젝트팀 기본키
COMMENT ON INDEX PK_pjtm IS '프로젝트팀 기본키';

-- 프로젝트팀 유니크 인덱스
COMMENT ON INDEX UIX_pjtm IS '프로젝트팀 유니크 인덱스';

-- 프로젝트팀 기본키
COMMENT ON CONSTRAINT pjtm.PK_pjtm IS '프로젝트팀 기본키';

-- 프로젝트팀 유니크 제약
COMMENT ON CONSTRAINT pjtm.UK_pjtm IS '프로젝트팀 유니크 제약';

-- 프로젝트기간
CREATE TABLE date (
  date_id INTEGER NOT NULL, -- 프로젝트총기간번호
  tot_dt  DATE    NOT NULL, -- 프로젝트총기간
  sdt     DATE    NOT NULL, -- 프로젝트시작일
  predt   DATE    NOT NULL, -- 프로젝트종료예상일
  ofrdt   DATE    NULL,     -- 프로젝트제안기간
  alsdt   DATE    NULL,     -- 프로젝트요구사항/분석기간
  dsgdt   DATE    NULL,     -- 프로젝트설계기간
  mkdt    DATE    NULL,     -- 프로젝트구현기간
  tesdt   DATE    NULL,     -- 프로젝트테스트기간
  lchdt   DATE    NULL      -- 프로젝트런칭기간
);

-- 프로젝트기간 기본키
CREATE UNIQUE INDEX PK_date
  ON date ( -- 프로젝트기간
    date_id ASC -- 프로젝트총기간번호
  );

-- 프로젝트기간
ALTER TABLE date
  ADD
    CONSTRAINT PK_date -- 프로젝트기간 기본키
    PRIMARY KEY (
      date_id -- 프로젝트총기간번호
    );

-- 프로젝트기간
COMMENT ON TABLE date IS '프로젝트기간';

-- 프로젝트총기간번호
COMMENT ON COLUMN date.date_id IS '프로젝트총기간번호';

-- 프로젝트총기간
COMMENT ON COLUMN date.tot_dt IS '프로젝트총기간';

-- 프로젝트시작일
COMMENT ON COLUMN date.sdt IS '프로젝트시작일';

-- 프로젝트종료예상일
COMMENT ON COLUMN date.predt IS '프로젝트종료예상일';

-- 프로젝트제안기간
COMMENT ON COLUMN date.ofrdt IS '프로젝트제안기간';

-- 프로젝트요구사항/분석기간
COMMENT ON COLUMN date.alsdt IS '프로젝트요구사항/분석기간';

-- 프로젝트설계기간
COMMENT ON COLUMN date.dsgdt IS '프로젝트설계기간';

-- 프로젝트구현기간
COMMENT ON COLUMN date.mkdt IS '프로젝트구현기간';

-- 프로젝트테스트기간
COMMENT ON COLUMN date.tesdt IS '프로젝트테스트기간';

-- 프로젝트런칭기간
COMMENT ON COLUMN date.lchdt IS '프로젝트런칭기간';

-- 프로젝트기간 기본키
COMMENT ON INDEX PK_date IS '프로젝트기간 기본키';

-- 프로젝트기간 기본키
COMMENT ON CONSTRAINT date.PK_date IS '프로젝트기간 기본키';

-- 임시 테이블2
CREATE TABLE Temporary4 (
);

-- 임시 테이블2
COMMENT ON TABLE Temporary4 IS '임시 테이블2';

-- 프로젝트순손익
CREATE TABLE Temporary5 (
  COL <데이터 타입 없음> NOT NULL -- 프로젝트순손익
);

-- 프로젝트순손익 기본키
CREATE UNIQUE INDEX PK_Temporary5
  ON Temporary5 ( -- 프로젝트순손익
    COL ASC -- 프로젝트순손익
  );

-- 프로젝트순손익
ALTER TABLE Temporary5
  ADD
    CONSTRAINT PK_Temporary5 -- 프로젝트순손익 기본키
    PRIMARY KEY (
      COL -- 프로젝트순손익
    );

-- 프로젝트순손익
COMMENT ON TABLE Temporary5 IS '프로젝트순손익';

-- 프로젝트순손익
COMMENT ON COLUMN Temporary5.COL IS '프로젝트순손익';

-- 프로젝트순손익 기본키
COMMENT ON INDEX PK_Temporary5 IS '프로젝트순손익 기본키';

-- 프로젝트순손익 기본키
COMMENT ON CONSTRAINT Temporary5.PK_Temporary5 IS '프로젝트순손익 기본키';

-- 임시 테이블4
CREATE TABLE Temporary6 (
  COL2 <데이터 타입 없음> NULL -- 프로젝트순손익
);

-- 임시 테이블4
COMMENT ON TABLE Temporary6 IS '임시 테이블4';

-- 프로젝트순손익
COMMENT ON COLUMN Temporary6.COL2 IS '프로젝트순손익';

-- 임시 테이블5
CREATE TABLE Temporary7 (
  COL2 <데이터 타입 없음> NULL -- 프로젝트순손익
);

-- 임시 테이블5
COMMENT ON TABLE Temporary7 IS '임시 테이블5';

-- 프로젝트순손익
COMMENT ON COLUMN Temporary7.COL2 IS '프로젝트순손익';

-- 임시 테이블6
CREATE TABLE Temporary8 (
);

-- 임시 테이블6
COMMENT ON TABLE Temporary8 IS '임시 테이블6';

-- 임시 테이블7
CREATE TABLE Temporary9 (
  COL2 <데이터 타입 없음> NULL -- 임대료
);

-- 임시 테이블7
COMMENT ON TABLE Temporary9 IS '임시 테이블7';

-- 임대료
COMMENT ON COLUMN Temporary9.COL2 IS '임대료';

-- PMS프로젝트순손익
CREATE TABLE TABLE3 (
  pms_id INTEGER            NULL, -- 프로젝트번호
  COL    <데이터 타입 없음> NULL  -- 프로젝트순손익
);

-- PMS프로젝트순손익
COMMENT ON TABLE TABLE3 IS 'PMS프로젝트순손익';

-- 프로젝트번호
COMMENT ON COLUMN TABLE3.pms_id IS '프로젝트번호';

-- 프로젝트순손익
COMMENT ON COLUMN TABLE3.COL IS '프로젝트순손익';

-- 임시 테이블3
CREATE TABLE Temporary10 (
);

-- 임시 테이블3
COMMENT ON TABLE Temporary10 IS '임시 테이블3';

-- 임시 테이블8
CREATE TABLE Temporary11 (
  pms_id INTEGER NULL -- 프로젝트번호
);

-- 임시 테이블8
COMMENT ON TABLE Temporary11 IS '임시 테이블8';

-- 프로젝트번호
COMMENT ON COLUMN Temporary11.pms_id IS '프로젝트번호';

-- 프로젝트순수익
CREATE TABLE Temporary12 (
  COL3 <데이터 타입 없음> NOT NULL -- 프로젝트순손익
);

-- 프로젝트순수익 기본키
CREATE UNIQUE INDEX PK_Temporary12
  ON Temporary12 ( -- 프로젝트순수익
    COL3 ASC -- 프로젝트순손익
  );

-- 프로젝트순수익
ALTER TABLE Temporary12
  ADD
    CONSTRAINT PK_Temporary12 -- 프로젝트순수익 기본키
    PRIMARY KEY (
      COL3 -- 프로젝트순손익
    );

-- 프로젝트순수익
COMMENT ON TABLE Temporary12 IS '프로젝트순수익';

-- 프로젝트순손익
COMMENT ON COLUMN Temporary12.COL3 IS '프로젝트순손익';

-- 프로젝트순수익 기본키
COMMENT ON INDEX PK_Temporary12 IS '프로젝트순수익 기본키';

-- 프로젝트순수익 기본키
COMMENT ON CONSTRAINT Temporary12.PK_Temporary12 IS '프로젝트순수익 기본키';

-- 임시 테이블10
CREATE TABLE Temporary13 (
);

-- 임시 테이블10
COMMENT ON TABLE Temporary13 IS '임시 테이블10';

-- 임시 테이블11
CREATE TABLE Temporary14 (
);

-- 임시 테이블11
COMMENT ON TABLE Temporary14 IS '임시 테이블11';

-- 임시 테이블12
CREATE TABLE Temporary15 (
);

-- 임시 테이블12
COMMENT ON TABLE Temporary15 IS '임시 테이블12';

-- 임시 테이블13
CREATE TABLE Temporary16 (
);

-- 임시 테이블13
COMMENT ON TABLE Temporary16 IS '임시 테이블13';

-- 임시 테이블14
CREATE TABLE Temporary17 (
);

-- 임시 테이블14
COMMENT ON TABLE Temporary17 IS '임시 테이블14';

-- 임시 테이블15
CREATE TABLE Temporary18 (
);

-- 임시 테이블15
COMMENT ON TABLE Temporary18 IS '임시 테이블15';

-- 임시 테이블16
CREATE TABLE Temporary19 (
);

-- 임시 테이블16
COMMENT ON TABLE Temporary19 IS '임시 테이블16';

-- 프로젝트장소
CREATE TABLE loc (
  loc_id  INTEGER     NOT NULL, -- 프로젝트장소번호
  name    VARCHAR(50) NOT NULL, -- 장소명
  addr_id INTEGER     NULL      -- 주소번호
);

-- 프로젝트장소 기본키
CREATE UNIQUE INDEX PK_loc
  ON loc ( -- 프로젝트장소
    loc_id ASC -- 프로젝트장소번호
  );

-- 프로젝트장소 인덱스
CREATE INDEX IX_loc
  ON loc( -- 프로젝트장소
    name ASC -- 장소명
  );

-- 프로젝트장소
ALTER TABLE loc
  ADD
    CONSTRAINT PK_loc -- 프로젝트장소 기본키
    PRIMARY KEY (
      loc_id -- 프로젝트장소번호
    );

-- 프로젝트장소
COMMENT ON TABLE loc IS '프로젝트장소';

-- 프로젝트장소번호
COMMENT ON COLUMN loc.loc_id IS '프로젝트장소번호';

-- 장소명
COMMENT ON COLUMN loc.name IS '장소명';

-- 주소번호
COMMENT ON COLUMN loc.addr_id IS '주소번호';

-- 프로젝트장소 기본키
COMMENT ON INDEX PK_loc IS '프로젝트장소 기본키';

-- 프로젝트장소 인덱스
COMMENT ON INDEX IX_loc IS '프로젝트장소 인덱스';

-- 프로젝트장소 기본키
COMMENT ON CONSTRAINT loc.PK_loc IS '프로젝트장소 기본키';

-- 운영체제호환
CREATE TABLE os (
  os_id INTEGER     NOT NULL, -- 운영체제번호
  name  VARCHAR(50) NOT NULL  -- 운영체제명
);

-- 운영체제호환 기본키
CREATE UNIQUE INDEX PK_os
  ON os ( -- 운영체제호환
    os_id ASC -- 운영체제번호
  );

-- 운영체제호환 유니크 인덱스
CREATE UNIQUE INDEX UIX_os
  ON os ( -- 운영체제호환
    name ASC -- 운영체제명
  );

-- 운영체제호환
ALTER TABLE os
  ADD
    CONSTRAINT PK_os -- 운영체제호환 기본키
    PRIMARY KEY (
      os_id -- 운영체제번호
    );

-- 운영체제호환
ALTER TABLE os
  ADD
    CONSTRAINT UK_os -- 운영체제호환 유니크 제약
    UNIQUE (
      name -- 운영체제명
    );

-- 운영체제호환
COMMENT ON TABLE os IS '운영체제호환';

-- 운영체제번호
COMMENT ON COLUMN os.os_id IS '운영체제번호';

-- 운영체제명
COMMENT ON COLUMN os.name IS '운영체제명';

-- 운영체제호환 기본키
COMMENT ON INDEX PK_os IS '운영체제호환 기본키';

-- 운영체제호환 유니크 인덱스
COMMENT ON INDEX UIX_os IS '운영체제호환 유니크 인덱스';

-- 운영체제호환 기본키
COMMENT ON CONSTRAINT os.PK_os IS '운영체제호환 기본키';

-- 운영체제호환 유니크 제약
COMMENT ON CONSTRAINT os.UK_os IS '운영체제호환 유니크 제약';

-- 장점
CREATE TABLE TABLE6 (
  COL <데이터 타입 없음> NOT NULL -- 장점번호
);

-- 장점 기본키
CREATE UNIQUE INDEX PK_TABLE6
  ON TABLE6 ( -- 장점
    COL ASC -- 장점번호
  );

-- 장점
ALTER TABLE TABLE6
  ADD
    CONSTRAINT PK_TABLE6 -- 장점 기본키
    PRIMARY KEY (
      COL -- 장점번호
    );

-- 장점
COMMENT ON TABLE TABLE6 IS '장점';

-- 장점번호
COMMENT ON COLUMN TABLE6.COL IS '장점번호';

-- 장점 기본키
COMMENT ON INDEX PK_TABLE6 IS '장점 기본키';

-- 장점 기본키
COMMENT ON CONSTRAINT TABLE6.PK_TABLE6 IS '장점 기본키';

-- 단점
CREATE TABLE TABLE7 (
);

-- 단점
COMMENT ON TABLE TABLE7 IS '단점';

-- 사용기술
CREATE TABLE tch (
  tch_id INTEGER     NOT NULL, -- 사용기술번호
  name   VARCHAR(50) NOT NULL  -- 기술명
);

-- 사용기술 기본키
CREATE UNIQUE INDEX PK_tch
  ON tch ( -- 사용기술
    tch_id ASC -- 사용기술번호
  );

-- 사용기술 유니크 인덱스
CREATE UNIQUE INDEX UIX_tch
  ON tch ( -- 사용기술
    name ASC -- 기술명
  );

-- 사용기술
ALTER TABLE tch
  ADD
    CONSTRAINT PK_tch -- 사용기술 기본키
    PRIMARY KEY (
      tch_id -- 사용기술번호
    );

-- 사용기술
ALTER TABLE tch
  ADD
    CONSTRAINT UK_tch -- 사용기술 유니크 제약
    UNIQUE (
      name -- 기술명
    );

-- 사용기술
COMMENT ON TABLE tch IS '사용기술';

-- 사용기술번호
COMMENT ON COLUMN tch.tch_id IS '사용기술번호';

-- 기술명
COMMENT ON COLUMN tch.name IS '기술명';

-- 사용기술 기본키
COMMENT ON INDEX PK_tch IS '사용기술 기본키';

-- 사용기술 유니크 인덱스
COMMENT ON INDEX UIX_tch IS '사용기술 유니크 인덱스';

-- 사용기술 기본키
COMMENT ON CONSTRAINT tch.PK_tch IS '사용기술 기본키';

-- 사용기술 유니크 제약
COMMENT ON CONSTRAINT tch.UK_tch IS '사용기술 유니크 제약';

-- 프로젝트고객
CREATE TABLE clnt (
  clnt_id     INTEGER     NOT NULL, -- 프로젝트고객번호
  name        VARCHAR(50) NOT NULL, -- 고객상호
  pay_yn      BOOLEAN     NULL,     -- 결제여부
  pay_stat    BOOLEAN     NULL,     -- 결제상태
  pay_dt      DATE        NULL,     -- 결제일
  pay_type_id INTEGER     NULL,     -- 결제유형번호
  hmr_id      INTEGER     NOT NULL  -- 담당자정보
);

-- 프로젝트고객 기본키
CREATE UNIQUE INDEX PK_clnt
  ON clnt ( -- 프로젝트고객
    clnt_id ASC -- 프로젝트고객번호
  );

-- 프로젝트고객 인덱스
CREATE INDEX IX_clnt
  ON clnt( -- 프로젝트고객
    name ASC -- 고객상호
  );

-- 프로젝트고객
ALTER TABLE clnt
  ADD
    CONSTRAINT PK_clnt -- 프로젝트고객 기본키
    PRIMARY KEY (
      clnt_id -- 프로젝트고객번호
    );

-- 프로젝트고객
COMMENT ON TABLE clnt IS '프로젝트고객';

-- 프로젝트고객번호
COMMENT ON COLUMN clnt.clnt_id IS '프로젝트고객번호';

-- 고객상호
COMMENT ON COLUMN clnt.name IS '고객상호';

-- 결제여부
COMMENT ON COLUMN clnt.pay_yn IS '결제여부';

-- 결제상태
COMMENT ON COLUMN clnt.pay_stat IS '결제상태';

-- 결제일
COMMENT ON COLUMN clnt.pay_dt IS '결제일';

-- 결제유형번호
COMMENT ON COLUMN clnt.pay_type_id IS '결제유형번호';

-- 담당자정보
COMMENT ON COLUMN clnt.hmr_id IS '담당자정보';

-- 프로젝트고객 기본키
COMMENT ON INDEX PK_clnt IS '프로젝트고객 기본키';

-- 프로젝트고객 인덱스
COMMENT ON INDEX IX_clnt IS '프로젝트고객 인덱스';

-- 프로젝트고객 기본키
COMMENT ON CONSTRAINT clnt.PK_clnt IS '프로젝트고객 기본키';

-- 프로젝트손익
CREATE TABLE TABLE10 (
  pms_id INTEGER            NOT NULL, -- 프로젝트번호
  COL    <데이터 타입 없음> NULL,     -- 프로젝트수익
  COL2   <데이터 타입 없음> NULL,     -- 프로젝트비용
  COL3   <데이터 타입 없음> NULL      -- 프로젝트순손익
);

-- 프로젝트손익 기본키
CREATE UNIQUE INDEX PK_TABLE10
  ON TABLE10 ( -- 프로젝트손익
    pms_id ASC -- 프로젝트번호
  );

-- 프로젝트손익
ALTER TABLE TABLE10
  ADD
    CONSTRAINT PK_TABLE10 -- 프로젝트손익 기본키
    PRIMARY KEY (
      pms_id -- 프로젝트번호
    );

-- 프로젝트손익
COMMENT ON TABLE TABLE10 IS '프로젝트손익';

-- 프로젝트번호
COMMENT ON COLUMN TABLE10.pms_id IS '프로젝트번호';

-- 프로젝트수익
COMMENT ON COLUMN TABLE10.COL IS '프로젝트수익';

-- 프로젝트비용
COMMENT ON COLUMN TABLE10.COL2 IS '프로젝트비용';

-- 프로젝트순손익
COMMENT ON COLUMN TABLE10.COL3 IS '프로젝트순손익';

-- 프로젝트손익 기본키
COMMENT ON INDEX PK_TABLE10 IS '프로젝트손익 기본키';

-- 프로젝트손익 기본키
COMMENT ON CONSTRAINT TABLE10.PK_TABLE10 IS '프로젝트손익 기본키';

-- 프로젝트비용
CREATE TABLE TABLE11 (
  id     <데이터 타입 없음> NOT NULL, -- 프로젝트비용
  pms_id INTEGER            NULL      -- 프로젝트번호
);

-- 프로젝트비용 기본키
CREATE UNIQUE INDEX PK_TABLE11
  ON TABLE11 ( -- 프로젝트비용
    id ASC -- 프로젝트비용
  );

-- 프로젝트비용
ALTER TABLE TABLE11
  ADD
    CONSTRAINT PK_TABLE11 -- 프로젝트비용 기본키
    PRIMARY KEY (
      id -- 프로젝트비용
    );

-- 프로젝트비용
COMMENT ON TABLE TABLE11 IS '프로젝트비용';

-- 프로젝트비용
COMMENT ON COLUMN TABLE11.id IS '프로젝트비용';

-- 프로젝트번호
COMMENT ON COLUMN TABLE11.pms_id IS '프로젝트번호';

-- 프로젝트비용 기본키
COMMENT ON INDEX PK_TABLE11 IS '프로젝트비용 기본키';

-- 프로젝트비용 기본키
COMMENT ON CONSTRAINT TABLE11.PK_TABLE11 IS '프로젝트비용 기본키';

-- 프로젝트순손익
CREATE TABLE npl (
  npl_id INTEGER NOT NULL, -- 프로젝트순손익번호
  npl    INTEGER NOT NULL, -- 프로젝트순손익
  prft   INTEGER NOT NULL, -- 프로젝트수익
  pric   INTEGER NULL,     -- 프로젝트가격
  fund   INTEGER NULL,     -- 지원금
  loss   INTEGER NOT NULL, -- 프로젝트비용
  lbcs   INTEGER NULL,     -- 노무비
  otcs   INTEGER NULL,     -- 경비
  mtcs   INTEGER NULL      -- 재료비
);

-- 프로젝트순손익 기본키2
CREATE UNIQUE INDEX PK_npl
  ON npl ( -- 프로젝트순손익
    npl_id ASC -- 프로젝트순손익번호
  );

-- 프로젝트순손익
ALTER TABLE npl
  ADD
    CONSTRAINT PK_npl -- 프로젝트순손익 기본키2
    PRIMARY KEY (
      npl_id -- 프로젝트순손익번호
    );

-- 프로젝트순손익
COMMENT ON TABLE npl IS '프로젝트순손익';

-- 프로젝트순손익번호
COMMENT ON COLUMN npl.npl_id IS '프로젝트순손익번호';

-- 프로젝트순손익
COMMENT ON COLUMN npl.npl IS '프로젝트순손익';

-- 프로젝트수익
COMMENT ON COLUMN npl.prft IS '프로젝트수익';

-- 프로젝트가격
COMMENT ON COLUMN npl.pric IS '프로젝트가격';

-- 지원금
COMMENT ON COLUMN npl.fund IS '지원금';

-- 프로젝트비용
COMMENT ON COLUMN npl.loss IS '프로젝트비용';

-- 노무비
COMMENT ON COLUMN npl.lbcs IS '노무비';

-- 경비
COMMENT ON COLUMN npl.otcs IS '경비';

-- 재료비
COMMENT ON COLUMN npl.mtcs IS '재료비';

-- 프로젝트순손익 기본키2
COMMENT ON INDEX PK_npl IS '프로젝트순손익 기본키2';

-- 프로젝트순손익 기본키2
COMMENT ON CONSTRAINT npl.PK_npl IS '프로젝트순손익 기본키2';

-- 운영체ㅈ
CREATE TABLE TABLE12 (
);

-- 운영체ㅈ
COMMENT ON TABLE TABLE12 IS '운영체ㅈ';

-- PMS운영체제호환
CREATE TABLE TABLE13 (
  pms_id INTEGER NOT NULL, -- 프로젝트번호
  os_id  INTEGER NOT NULL  -- 운영체제번호
);

-- PMS운영체제호환 기본키
CREATE UNIQUE INDEX PK_TABLE13
  ON TABLE13 ( -- PMS운영체제호환
    pms_id ASC, -- 프로젝트번호
    os_id  ASC  -- 운영체제번호
  );

-- PMS운영체제호환
ALTER TABLE TABLE13
  ADD
    CONSTRAINT PK_TABLE13 -- PMS운영체제호환 기본키
    PRIMARY KEY (
      pms_id, -- 프로젝트번호
      os_id   -- 운영체제번호
    );

-- PMS운영체제호환
COMMENT ON TABLE TABLE13 IS 'PMS운영체제호환';

-- 프로젝트번호
COMMENT ON COLUMN TABLE13.pms_id IS '프로젝트번호';

-- 운영체제번호
COMMENT ON COLUMN TABLE13.os_id IS '운영체제번호';

-- PMS운영체제호환 기본키
COMMENT ON INDEX PK_TABLE13 IS 'PMS운영체제호환 기본키';

-- PMS운영체제호환 기본키
COMMENT ON CONSTRAINT TABLE13.PK_TABLE13 IS 'PMS운영체제호환 기본키';

-- PMS사용기술
CREATE TABLE pms_tch (
  tch_id INTEGER NOT NULL, -- 사용기술번호
  pms_id INTEGER NOT NULL  -- 프로젝트번호
);

-- PMS사용기술 기본키
CREATE UNIQUE INDEX PK_pms_tch
  ON pms_tch ( -- PMS사용기술
    tch_id ASC, -- 사용기술번호
    pms_id ASC  -- 프로젝트번호
  );

-- PMS사용기술
ALTER TABLE pms_tch
  ADD
    CONSTRAINT PK_pms_tch -- PMS사용기술 기본키
    PRIMARY KEY (
      tch_id, -- 사용기술번호
      pms_id  -- 프로젝트번호
    );

-- PMS사용기술
COMMENT ON TABLE pms_tch IS 'PMS사용기술';

-- 사용기술번호
COMMENT ON COLUMN pms_tch.tch_id IS '사용기술번호';

-- 프로젝트번호
COMMENT ON COLUMN pms_tch.pms_id IS '프로젝트번호';

-- PMS사용기술 기본키
COMMENT ON INDEX PK_pms_tch IS 'PMS사용기술 기본키';

-- PMS사용기술 기본키
COMMENT ON CONSTRAINT pms_tch.PK_pms_tch IS 'PMS사용기술 기본키';

-- 사용자
CREATE TABLE TABLE15 (
);

-- 사용자
COMMENT ON TABLE TABLE15 IS '사용자';

-- PMS프로젝트팀
CREATE TABLE pms_pjtm (
  pms_id  INTEGER NOT NULL, -- 프로젝트번호
  team_id INTEGER NOT NULL  -- 프로젝트팀번호
);

-- PMS프로젝트팀 기본키
CREATE UNIQUE INDEX PK_pms_pjtm
  ON pms_pjtm ( -- PMS프로젝트팀
    pms_id  ASC, -- 프로젝트번호
    team_id ASC  -- 프로젝트팀번호
  );

-- PMS프로젝트팀
ALTER TABLE pms_pjtm
  ADD
    CONSTRAINT PK_pms_pjtm -- PMS프로젝트팀 기본키
    PRIMARY KEY (
      pms_id,  -- 프로젝트번호
      team_id  -- 프로젝트팀번호
    );

-- PMS프로젝트팀
COMMENT ON TABLE pms_pjtm IS 'PMS프로젝트팀';

-- 프로젝트번호
COMMENT ON COLUMN pms_pjtm.pms_id IS '프로젝트번호';

-- 프로젝트팀번호
COMMENT ON COLUMN pms_pjtm.team_id IS '프로젝트팀번호';

-- PMS프로젝트팀 기본키
COMMENT ON INDEX PK_pms_pjtm IS 'PMS프로젝트팀 기본키';

-- PMS프로젝트팀 기본키
COMMENT ON CONSTRAINT pms_pjtm.PK_pms_pjtm IS 'PMS프로젝트팀 기본키';

-- 주소
CREATE TABLE addr (
  addr_id  INTEGER      NOT NULL, -- 주소번호
  post     VARCHAR(255) NULL,     -- 우편번호
  bas_addr VARCHAR(255) NULL      -- 기본주소
);

-- 주소 기본키
CREATE UNIQUE INDEX PK_addr
  ON addr ( -- 주소
    addr_id ASC -- 주소번호
  );

-- 주소
ALTER TABLE addr
  ADD
    CONSTRAINT PK_addr -- 주소 기본키
    PRIMARY KEY (
      addr_id -- 주소번호
    );

-- 주소
COMMENT ON TABLE addr IS '주소';

-- 주소번호
COMMENT ON COLUMN addr.addr_id IS '주소번호';

-- 우편번호
COMMENT ON COLUMN addr.post IS '우편번호';

-- 기본주소
COMMENT ON COLUMN addr.bas_addr IS '기본주소';

-- 주소 기본키
COMMENT ON INDEX PK_addr IS '주소 기본키';

-- 주소 기본키
COMMENT ON CONSTRAINT addr.PK_addr IS '주소 기본키';

-- 프로젝트팀프로젝트팀원
CREATE TABLE pjtm_mbr (
  team_id INTEGER NOT NULL, -- 프로젝트팀번호
  mbr_id  INTEGER NOT NULL  -- 프로젝트팀원번호
);

-- 프로젝트팀프로젝트팀원 기본키
CREATE UNIQUE INDEX PK_pjtm_mbr
  ON pjtm_mbr ( -- 프로젝트팀프로젝트팀원
    team_id ASC, -- 프로젝트팀번호
    mbr_id  ASC  -- 프로젝트팀원번호
  );

-- 프로젝트팀프로젝트팀원
ALTER TABLE pjtm_mbr
  ADD
    CONSTRAINT PK_pjtm_mbr -- 프로젝트팀프로젝트팀원 기본키
    PRIMARY KEY (
      team_id, -- 프로젝트팀번호
      mbr_id   -- 프로젝트팀원번호
    );

-- 프로젝트팀프로젝트팀원
COMMENT ON TABLE pjtm_mbr IS '프로젝트팀프로젝트팀원';

-- 프로젝트팀번호
COMMENT ON COLUMN pjtm_mbr.team_id IS '프로젝트팀번호';

-- 프로젝트팀원번호
COMMENT ON COLUMN pjtm_mbr.mbr_id IS '프로젝트팀원번호';

-- 프로젝트팀프로젝트팀원 기본키
COMMENT ON INDEX PK_pjtm_mbr IS '프로젝트팀프로젝트팀원 기본키';

-- 프로젝트팀프로젝트팀원 기본키
COMMENT ON CONSTRAINT pjtm_mbr.PK_pjtm_mbr IS '프로젝트팀프로젝트팀원 기본키';

-- 결제유형
CREATE TABLE pay_type (
  pay_type_id INTEGER      NOT NULL, -- 결제유형번호
  pay_type    VARCHAR(255) NOT NULL  -- 결제유형명
);

-- 결제유형 기본키
CREATE UNIQUE INDEX PK_pay_type
  ON pay_type ( -- 결제유형
    pay_type_id ASC -- 결제유형번호
  );

-- 결제유형 유니크 인덱스
CREATE UNIQUE INDEX UIX_pay_type
  ON pay_type ( -- 결제유형
    pay_type ASC -- 결제유형명
  );

-- 결제유형
ALTER TABLE pay_type
  ADD
    CONSTRAINT PK_pay_type -- 결제유형 기본키
    PRIMARY KEY (
      pay_type_id -- 결제유형번호
    );

-- 결제유형
ALTER TABLE pay_type
  ADD
    CONSTRAINT UK_pay_type -- 결제유형 유니크 제약
    UNIQUE (
      pay_type -- 결제유형명
    );

-- 결제유형
COMMENT ON TABLE pay_type IS '결제유형';

-- 결제유형번호
COMMENT ON COLUMN pay_type.pay_type_id IS '결제유형번호';

-- 결제유형명
COMMENT ON COLUMN pay_type.pay_type IS '결제유형명';

-- 결제유형 기본키
COMMENT ON INDEX PK_pay_type IS '결제유형 기본키';

-- 결제유형 유니크 인덱스
COMMENT ON INDEX UIX_pay_type IS '결제유형 유니크 인덱스';

-- 결제유형 기본키
COMMENT ON CONSTRAINT pay_type.PK_pay_type IS '결제유형 기본키';

-- 결제유형 유니크 제약
COMMENT ON CONSTRAINT pay_type.UK_pay_type IS '결제유형 유니크 제약';

-- 인적정보
CREATE TABLE hmr (
  hmr_id  INTEGER      NOT NULL, -- 인적정보번호
  name    VARCHAR(50)  NOT NULL, -- 이름
  email   VARCHAR(40)  NOT NULL, -- 이메일
  pos     VARCHAR(255) NULL,     -- 직위
  tel     VARCHAR(30)  NULL,     -- 전화번호
  phot    VARCHAR(255) NULL,     -- 사진
  acc     VARCHAR(255) NULL,     -- 계좌번호
  addr_id INTEGER      NULL      -- 주소번호
);

-- 인적정보 기본키
CREATE UNIQUE INDEX PK_hmr
  ON hmr ( -- 인적정보
    hmr_id ASC -- 인적정보번호
  );

-- 인적정보 인덱스
CREATE INDEX IX_hmr
  ON hmr( -- 인적정보
    name ASC -- 이름
  );

-- 인적정보
ALTER TABLE hmr
  ADD
    CONSTRAINT PK_hmr -- 인적정보 기본키
    PRIMARY KEY (
      hmr_id -- 인적정보번호
    );

-- 인적정보
COMMENT ON TABLE hmr IS '인적정보';

-- 인적정보번호
COMMENT ON COLUMN hmr.hmr_id IS '인적정보번호';

-- 이름
COMMENT ON COLUMN hmr.name IS '이름';

-- 이메일
COMMENT ON COLUMN hmr.email IS '이메일';

-- 직위
COMMENT ON COLUMN hmr.pos IS '직위';

-- 전화번호
COMMENT ON COLUMN hmr.tel IS '전화번호';

-- 사진
COMMENT ON COLUMN hmr.phot IS '사진';

-- 계좌번호
COMMENT ON COLUMN hmr.acc IS '계좌번호';

-- 주소번호
COMMENT ON COLUMN hmr.addr_id IS '주소번호';

-- 인적정보 기본키
COMMENT ON INDEX PK_hmr IS '인적정보 기본키';

-- 인적정보 인덱스
COMMENT ON INDEX IX_hmr IS '인적정보 인덱스';

-- 인적정보 기본키
COMMENT ON CONSTRAINT hmr.PK_hmr IS '인적정보 기본키';

-- 자료
CREATE TABLE data (
  data_id INTEGER     NOT NULL, -- 자료번호
  name    VARCHAR(50) NOT NULL  -- 자료명
);

-- 자료 기본키
CREATE UNIQUE INDEX PK_data
  ON data ( -- 자료
    data_id ASC -- 자료번호
  );

-- 자료 인덱스
CREATE INDEX IX_data
  ON data( -- 자료
    name ASC -- 자료명
  );

-- 자료
ALTER TABLE data
  ADD
    CONSTRAINT PK_data -- 자료 기본키
    PRIMARY KEY (
      data_id -- 자료번호
    );

-- 자료
COMMENT ON TABLE data IS '자료';

-- 자료번호
COMMENT ON COLUMN data.data_id IS '자료번호';

-- 자료명
COMMENT ON COLUMN data.name IS '자료명';

-- 자료 기본키
COMMENT ON INDEX PK_data IS '자료 기본키';

-- 자료 인덱스
COMMENT ON INDEX IX_data IS '자료 인덱스';

-- 자료 기본키
COMMENT ON CONSTRAINT data.PK_data IS '자료 기본키';

-- 자료유형
CREATE TABLE data_type (
  data_type_id INTEGER     NOT NULL, -- 자료유형번호
  name         VARCHAR(50) NOT NULL  -- 자료유형명
);

-- 자료유형 기본키
CREATE UNIQUE INDEX PK_data_type
  ON data_type ( -- 자료유형
    data_type_id ASC -- 자료유형번호
  );

-- 자료유형 유니크 인덱스
CREATE UNIQUE INDEX UIX_data_type
  ON data_type ( -- 자료유형
    name ASC -- 자료유형명
  );

-- 자료유형
ALTER TABLE data_type
  ADD
    CONSTRAINT PK_data_type -- 자료유형 기본키
    PRIMARY KEY (
      data_type_id -- 자료유형번호
    );

-- 자료유형
ALTER TABLE data_type
  ADD
    CONSTRAINT UK_data_type -- 자료유형 유니크 제약
    UNIQUE (
      name -- 자료유형명
    );

-- 자료유형
COMMENT ON TABLE data_type IS '자료유형';

-- 자료유형번호
COMMENT ON COLUMN data_type.data_type_id IS '자료유형번호';

-- 자료유형명
COMMENT ON COLUMN data_type.name IS '자료유형명';

-- 자료유형 기본키
COMMENT ON INDEX PK_data_type IS '자료유형 기본키';

-- 자료유형 유니크 인덱스
COMMENT ON INDEX UIX_data_type IS '자료유형 유니크 인덱스';

-- 자료유형 기본키
COMMENT ON CONSTRAINT data_type.PK_data_type IS '자료유형 기본키';

-- 자료유형 유니크 제약
COMMENT ON CONSTRAINT data_type.UK_data_type IS '자료유형 유니크 제약';

-- PMS자료
CREATE TABLE pms_data (
  pms_id  INTEGER NOT NULL, -- 프로젝트번호
  data_id INTEGER NOT NULL  -- 자료번호
);

-- PMS자료 기본키
CREATE UNIQUE INDEX PK_pms_data
  ON pms_data ( -- PMS자료
    pms_id  ASC, -- 프로젝트번호
    data_id ASC  -- 자료번호
  );

-- PMS자료
ALTER TABLE pms_data
  ADD
    CONSTRAINT PK_pms_data -- PMS자료 기본키
    PRIMARY KEY (
      pms_id,  -- 프로젝트번호
      data_id  -- 자료번호
    );

-- PMS자료
COMMENT ON TABLE pms_data IS 'PMS자료';

-- 프로젝트번호
COMMENT ON COLUMN pms_data.pms_id IS '프로젝트번호';

-- 자료번호
COMMENT ON COLUMN pms_data.data_id IS '자료번호';

-- PMS자료 기본키
COMMENT ON INDEX PK_pms_data IS 'PMS자료 기본키';

-- PMS자료 기본키
COMMENT ON CONSTRAINT pms_data.PK_pms_data IS 'PMS자료 기본키';

-- 자료자료유형
CREATE TABLE data_data_type (
  data_id      INTEGER NOT NULL, -- 자료번호
  data_type_id INTEGER NOT NULL  -- 자료유형번호
);

-- 자료자료유형 기본키
CREATE UNIQUE INDEX PK_data_data_type
  ON data_data_type ( -- 자료자료유형
    data_id      ASC, -- 자료번호
    data_type_id ASC  -- 자료유형번호
  );

-- 자료자료유형
ALTER TABLE data_data_type
  ADD
    CONSTRAINT PK_data_data_type -- 자료자료유형 기본키
    PRIMARY KEY (
      data_id,      -- 자료번호
      data_type_id  -- 자료유형번호
    );

-- 자료자료유형
COMMENT ON TABLE data_data_type IS '자료자료유형';

-- 자료번호
COMMENT ON COLUMN data_data_type.data_id IS '자료번호';

-- 자료유형번호
COMMENT ON COLUMN data_data_type.data_type_id IS '자료유형번호';

-- 자료자료유형 기본키
COMMENT ON INDEX PK_data_data_type IS '자료자료유형 기본키';

-- 자료자료유형 기본키
COMMENT ON CONSTRAINT data_data_type.PK_data_data_type IS '자료자료유형 기본키';

-- 프로젝트등급
CREATE TABLE TABLE25 (
  COL  <데이터 타입 없음> NOT NULL, -- 프로젝트등급번호
  COL2 <데이터 타입 없음> NULL      -- 프로젝트등급
);

-- 프로젝트등급 기본키
CREATE UNIQUE INDEX PK_TABLE25
  ON TABLE25 ( -- 프로젝트등급
    COL ASC -- 프로젝트등급번호
  );

-- 프로젝트등급
ALTER TABLE TABLE25
  ADD
    CONSTRAINT PK_TABLE25 -- 프로젝트등급 기본키
    PRIMARY KEY (
      COL -- 프로젝트등급번호
    );

-- 프로젝트등급
COMMENT ON TABLE TABLE25 IS '프로젝트등급';

-- 프로젝트등급번호
COMMENT ON COLUMN TABLE25.COL IS '프로젝트등급번호';

-- 프로젝트등급
COMMENT ON COLUMN TABLE25.COL2 IS '프로젝트등급';

-- 프로젝트등급 기본키
COMMENT ON INDEX PK_TABLE25 IS '프로젝트등급 기본키';

-- 프로젝트등급 기본키
COMMENT ON CONSTRAINT TABLE25.PK_TABLE25 IS '프로젝트등급 기본키';

-- 프로젝트등급
CREATE TABLE grad (
  grad_id INTEGER     NOT NULL, -- 프로젝트등급번호
  grad    VARCHAR(50) NOT NULL  -- 프로젝트등급명
);

-- 프로젝트등급 기본키2
CREATE UNIQUE INDEX PK_grad
  ON grad ( -- 프로젝트등급
    grad_id ASC -- 프로젝트등급번호
  );

-- 프로젝트등급 유니크 인덱스
CREATE UNIQUE INDEX UIX_grad
  ON grad ( -- 프로젝트등급
    grad ASC -- 프로젝트등급명
  );

-- 프로젝트등급
ALTER TABLE grad
  ADD
    CONSTRAINT PK_grad -- 프로젝트등급 기본키2
    PRIMARY KEY (
      grad_id -- 프로젝트등급번호
    );

-- 프로젝트등급
ALTER TABLE grad
  ADD
    CONSTRAINT UK_grad -- 프로젝트등급 유니크 제약
    UNIQUE (
      grad -- 프로젝트등급명
    );

-- 프로젝트등급
COMMENT ON TABLE grad IS '프로젝트등급';

-- 프로젝트등급번호
COMMENT ON COLUMN grad.grad_id IS '프로젝트등급번호';

-- 프로젝트등급명
COMMENT ON COLUMN grad.grad IS '프로젝트등급명';

-- 프로젝트등급 기본키2
COMMENT ON INDEX PK_grad IS '프로젝트등급 기본키2';

-- 프로젝트등급 유니크 인덱스
COMMENT ON INDEX UIX_grad IS '프로젝트등급 유니크 인덱스';

-- 프로젝트등급 기본키2
COMMENT ON CONSTRAINT grad.PK_grad IS '프로젝트등급 기본키2';

-- 프로젝트등급 유니크 제약
COMMENT ON CONSTRAINT grad.UK_grad IS '프로젝트등급 유니크 제약';

-- 프로젝트업무
CREATE TABLE work (
  work_id      INTEGER      NOT NULL, -- 프로젝트업무번호
  work_type    VARCHAR(255) NOT NULL, -- 프로젝트업무유형
  work_grad_id INTEGER      NOT NULL  -- 프로젝트업무등급번호
);

-- 프로젝트업무 기본키
CREATE UNIQUE INDEX PK_work
  ON work ( -- 프로젝트업무
    work_id ASC -- 프로젝트업무번호
  );

-- 프로젝트업무 유니크 인덱스
CREATE UNIQUE INDEX UIX_work
  ON work ( -- 프로젝트업무
    work_type ASC -- 프로젝트업무유형
  );

-- 프로젝트업무
ALTER TABLE work
  ADD
    CONSTRAINT PK_work -- 프로젝트업무 기본키
    PRIMARY KEY (
      work_id -- 프로젝트업무번호
    );

-- 프로젝트업무
ALTER TABLE work
  ADD
    CONSTRAINT UK_work -- 프로젝트업무 유니크 제약
    UNIQUE (
      work_type -- 프로젝트업무유형
    );

-- 프로젝트업무
COMMENT ON TABLE work IS '프로젝트업무';

-- 프로젝트업무번호
COMMENT ON COLUMN work.work_id IS '프로젝트업무번호';

-- 프로젝트업무유형
COMMENT ON COLUMN work.work_type IS '프로젝트업무유형';

-- 프로젝트업무등급번호
COMMENT ON COLUMN work.work_grad_id IS '프로젝트업무등급번호';

-- 프로젝트업무 기본키
COMMENT ON INDEX PK_work IS '프로젝트업무 기본키';

-- 프로젝트업무 유니크 인덱스
COMMENT ON INDEX UIX_work IS '프로젝트업무 유니크 인덱스';

-- 프로젝트업무 기본키
COMMENT ON CONSTRAINT work.PK_work IS '프로젝트업무 기본키';

-- 프로젝트업무 유니크 제약
COMMENT ON CONSTRAINT work.UK_work IS '프로젝트업무 유니크 제약';

-- 프로젝트업무등급
CREATE TABLE work_grad (
  work_grad_id INTEGER      NOT NULL, -- 프로젝트업무등급번호
  grad         VARCHAR(255) NOT NULL  -- 프로젝트업무등급명
);

-- 프로젝트업무등급 기본키
CREATE UNIQUE INDEX PK_work_grad
  ON work_grad ( -- 프로젝트업무등급
    work_grad_id ASC -- 프로젝트업무등급번호
  );

-- 프로젝트업무등급 유니크 인덱스
CREATE UNIQUE INDEX UIX_work_grad
  ON work_grad ( -- 프로젝트업무등급
    grad ASC -- 프로젝트업무등급명
  );

-- 프로젝트업무등급
ALTER TABLE work_grad
  ADD
    CONSTRAINT PK_work_grad -- 프로젝트업무등급 기본키
    PRIMARY KEY (
      work_grad_id -- 프로젝트업무등급번호
    );

-- 프로젝트업무등급
ALTER TABLE work_grad
  ADD
    CONSTRAINT UK_work_grad -- 프로젝트업무등급 유니크 제약
    UNIQUE (
      grad -- 프로젝트업무등급명
    );

-- 프로젝트업무등급
COMMENT ON TABLE work_grad IS '프로젝트업무등급';

-- 프로젝트업무등급번호
COMMENT ON COLUMN work_grad.work_grad_id IS '프로젝트업무등급번호';

-- 프로젝트업무등급명
COMMENT ON COLUMN work_grad.grad IS '프로젝트업무등급명';

-- 프로젝트업무등급 기본키
COMMENT ON INDEX PK_work_grad IS '프로젝트업무등급 기본키';

-- 프로젝트업무등급 유니크 인덱스
COMMENT ON INDEX UIX_work_grad IS '프로젝트업무등급 유니크 인덱스';

-- 프로젝트업무등급 기본키
COMMENT ON CONSTRAINT work_grad.PK_work_grad IS '프로젝트업무등급 기본키';

-- 프로젝트업무등급 유니크 제약
COMMENT ON CONSTRAINT work_grad.UK_work_grad IS '프로젝트업무등급 유니크 제약';

-- PMS프로젝트업무
CREATE TABLE pms_work (
  pms_id  INTEGER NOT NULL, -- 프로젝트번호
  work_id INTEGER NOT NULL  -- 프로젝트업무번호
);

-- PMS프로젝트업무 기본키
CREATE UNIQUE INDEX PK_pms_work
  ON pms_work ( -- PMS프로젝트업무
    pms_id  ASC, -- 프로젝트번호
    work_id ASC  -- 프로젝트업무번호
  );

-- PMS프로젝트업무
ALTER TABLE pms_work
  ADD
    CONSTRAINT PK_pms_work -- PMS프로젝트업무 기본키
    PRIMARY KEY (
      pms_id,  -- 프로젝트번호
      work_id  -- 프로젝트업무번호
    );

-- PMS프로젝트업무
COMMENT ON TABLE pms_work IS 'PMS프로젝트업무';

-- 프로젝트번호
COMMENT ON COLUMN pms_work.pms_id IS '프로젝트번호';

-- 프로젝트업무번호
COMMENT ON COLUMN pms_work.work_id IS '프로젝트업무번호';

-- PMS프로젝트업무 기본키
COMMENT ON INDEX PK_pms_work IS 'PMS프로젝트업무 기본키';

-- PMS프로젝트업무 기본키
COMMENT ON CONSTRAINT pms_work.PK_pms_work IS 'PMS프로젝트업무 기본키';

-- 프로젝트내용
CREATE TABLE TABLE29 (
);

-- 프로젝트내용
COMMENT ON TABLE TABLE29 IS '프로젝트내용';

-- 프로젝트산출물
CREATE TABLE TABLE30 (
  COL  <데이터 타입 없음> NOT NULL, -- 프로젝트산출물번호
  COL2 <데이터 타입 없음> NULL,     -- 산출물유형
  COL3 <데이터 타입 없음> NULL      -- 산출물적용기술
);

-- 프로젝트산출물 기본키
CREATE UNIQUE INDEX PK_TABLE30
  ON TABLE30 ( -- 프로젝트산출물
    COL ASC -- 프로젝트산출물번호
  );

-- 프로젝트산출물
ALTER TABLE TABLE30
  ADD
    CONSTRAINT PK_TABLE30 -- 프로젝트산출물 기본키
    PRIMARY KEY (
      COL -- 프로젝트산출물번호
    );

-- 프로젝트산출물
COMMENT ON TABLE TABLE30 IS '프로젝트산출물';

-- 프로젝트산출물번호
COMMENT ON COLUMN TABLE30.COL IS '프로젝트산출물번호';

-- 산출물유형
COMMENT ON COLUMN TABLE30.COL2 IS '산출물유형';

-- 산출물적용기술
COMMENT ON COLUMN TABLE30.COL3 IS '산출물적용기술';

-- 프로젝트산출물 기본키
COMMENT ON INDEX PK_TABLE30 IS '프로젝트산출물 기본키';

-- 프로젝트산출물 기본키
COMMENT ON CONSTRAINT TABLE30.PK_TABLE30 IS '프로젝트산출물 기본키';

-- 프로젝트프로토타입
CREATE TABLE TABLE31 (
  COL  <데이터 타입 없음> NOT NULL, -- 프로젝트프로토타입번호
  COL2 <데이터 타입 없음> NULL      -- 프로젝트프로토타입명
);

-- 프로젝트프로토타입 기본키
CREATE UNIQUE INDEX PK_TABLE31
  ON TABLE31 ( -- 프로젝트프로토타입
    COL ASC -- 프로젝트프로토타입번호
  );

-- 프로젝트프로토타입
ALTER TABLE TABLE31
  ADD
    CONSTRAINT PK_TABLE31 -- 프로젝트프로토타입 기본키
    PRIMARY KEY (
      COL -- 프로젝트프로토타입번호
    );

-- 프로젝트프로토타입
COMMENT ON TABLE TABLE31 IS '프로젝트프로토타입';

-- 프로젝트프로토타입번호
COMMENT ON COLUMN TABLE31.COL IS '프로젝트프로토타입번호';

-- 프로젝트프로토타입명
COMMENT ON COLUMN TABLE31.COL2 IS '프로젝트프로토타입명';

-- 프로젝트프로토타입 기본키
COMMENT ON INDEX PK_TABLE31 IS '프로젝트프로토타입 기본키';

-- 프로젝트프로토타입 기본키
COMMENT ON CONSTRAINT TABLE31.PK_TABLE31 IS '프로젝트프로토타입 기본키';

-- 개발자등급
CREATE TABLE dvlp_grad (
  dvlp_grad_id INTEGER      NOT NULL, -- 개발자등급번호
  grad         VARCHAR(255) NOT NULL, -- 개발자등급명
  pric         INTEGER      NOT NULL  -- 개발자단가
);

-- 개발자등급 기본키
CREATE UNIQUE INDEX PK_dvlp_grad
  ON dvlp_grad ( -- 개발자등급
    dvlp_grad_id ASC -- 개발자등급번호
  );

-- 개발자등급 인덱스
CREATE INDEX IX_dvlp_grad
  ON dvlp_grad( -- 개발자등급
    grad ASC -- 개발자등급명
  );

-- 개발자등급
ALTER TABLE dvlp_grad
  ADD
    CONSTRAINT PK_dvlp_grad -- 개발자등급 기본키
    PRIMARY KEY (
      dvlp_grad_id -- 개발자등급번호
    );

-- 개발자등급
COMMENT ON TABLE dvlp_grad IS '개발자등급';

-- 개발자등급번호
COMMENT ON COLUMN dvlp_grad.dvlp_grad_id IS '개발자등급번호';

-- 개발자등급명
COMMENT ON COLUMN dvlp_grad.grad IS '개발자등급명';

-- 개발자단가
COMMENT ON COLUMN dvlp_grad.pric IS '개발자단가';

-- 개발자등급 기본키
COMMENT ON INDEX PK_dvlp_grad IS '개발자등급 기본키';

-- 개발자등급 인덱스
COMMENT ON INDEX IX_dvlp_grad IS '개발자등급 인덱스';

-- 개발자등급 기본키
COMMENT ON CONSTRAINT dvlp_grad.PK_dvlp_grad IS '개발자등급 기본키';

-- 개발자단가
CREATE TABLE TABLE33 (
  COL <데이터 타입 없음> NOT NULL -- 개발자단가번호
);

-- 개발자단가 기본키
CREATE UNIQUE INDEX PK_TABLE33
  ON TABLE33 ( -- 개발자단가
    COL ASC -- 개발자단가번호
  );

-- 개발자단가
ALTER TABLE TABLE33
  ADD
    CONSTRAINT PK_TABLE33 -- 개발자단가 기본키
    PRIMARY KEY (
      COL -- 개발자단가번호
    );

-- 개발자단가
COMMENT ON TABLE TABLE33 IS '개발자단가';

-- 개발자단가번호
COMMENT ON COLUMN TABLE33.COL IS '개발자단가번호';

-- 개발자단가 기본키
COMMENT ON INDEX PK_TABLE33 IS '개발자단가 기본키';

-- 개발자단가 기본키
COMMENT ON CONSTRAINT TABLE33.PK_TABLE33 IS '개발자단가 기본키';

-- PMS
ALTER TABLE pms
  ADD
    CONSTRAINT FK_date_TO_pms -- 프로젝트기간 -> PMS
    FOREIGN KEY (
      date_id -- 프로젝트총기간번호
    )
    REFERENCES date ( -- 프로젝트기간
      date_id -- 프로젝트총기간번호
    );

-- 프로젝트기간 -> PMS
COMMENT ON CONSTRAINT pms.FK_date_TO_pms IS '프로젝트기간 -> PMS';

-- PMS
ALTER TABLE pms
  ADD
    CONSTRAINT FK_npl_TO_pms -- 프로젝트순손익 -> PMS
    FOREIGN KEY (
      npl_id -- 프로젝트순손익번호
    )
    REFERENCES npl ( -- 프로젝트순손익
      npl_id -- 프로젝트순손익번호
    );

-- 프로젝트순손익 -> PMS
COMMENT ON CONSTRAINT pms.FK_npl_TO_pms IS '프로젝트순손익 -> PMS';

-- PMS
ALTER TABLE pms
  ADD
    CONSTRAINT FK_clnt_TO_pms -- 프로젝트고객 -> PMS
    FOREIGN KEY (
      clnt_id -- 프로젝트고객번호
    )
    REFERENCES clnt ( -- 프로젝트고객
      clnt_id -- 프로젝트고객번호
    );

-- 프로젝트고객 -> PMS
COMMENT ON CONSTRAINT pms.FK_clnt_TO_pms IS '프로젝트고객 -> PMS';

-- PMS
ALTER TABLE pms
  ADD
    CONSTRAINT FK_loc_TO_pms -- 프로젝트장소 -> PMS
    FOREIGN KEY (
      loc_id -- 프로젝트장소번호
    )
    REFERENCES loc ( -- 프로젝트장소
      loc_id -- 프로젝트장소번호
    );

-- 프로젝트장소 -> PMS
COMMENT ON CONSTRAINT pms.FK_loc_TO_pms IS '프로젝트장소 -> PMS';

-- PMS
ALTER TABLE pms
  ADD
    CONSTRAINT FK_grad_TO_pms -- 프로젝트등급 -> PMS
    FOREIGN KEY (
      grad_id -- 프로젝트등급번호
    )
    REFERENCES grad ( -- 프로젝트등급
      grad_id -- 프로젝트등급번호
    );

-- 프로젝트등급 -> PMS
COMMENT ON CONSTRAINT pms.FK_grad_TO_pms IS '프로젝트등급 -> PMS';

-- 프로젝트팀원
ALTER TABLE mbr
  ADD
    CONSTRAINT FK_pms_TO_mbr -- PMS -> 프로젝트팀원
    FOREIGN KEY (
      pms_id -- 프로젝트번호
    )
    REFERENCES pms ( -- PMS
      pms_id -- 프로젝트번호
    );

-- PMS -> 프로젝트팀원
COMMENT ON CONSTRAINT mbr.FK_pms_TO_mbr IS 'PMS -> 프로젝트팀원';

-- 프로젝트팀원
ALTER TABLE mbr
  ADD
    CONSTRAINT FK_hmr_TO_mbr -- 인적정보 -> 프로젝트팀원
    FOREIGN KEY (
      hmr_id -- 팀원정보
    )
    REFERENCES hmr ( -- 인적정보
      hmr_id -- 인적정보번호
    );

-- 인적정보 -> 프로젝트팀원
COMMENT ON CONSTRAINT mbr.FK_hmr_TO_mbr IS '인적정보 -> 프로젝트팀원';

-- 프로젝트팀원
ALTER TABLE mbr
  ADD
    CONSTRAINT FK_dvlp_grad_TO_mbr -- 개발자등급 -> 프로젝트팀원
    FOREIGN KEY (
      dvlp_grad_id -- 개발자등급번호
    )
    REFERENCES dvlp_grad ( -- 개발자등급
      dvlp_grad_id -- 개발자등급번호
    );

-- 개발자등급 -> 프로젝트팀원
COMMENT ON CONSTRAINT mbr.FK_dvlp_grad_TO_mbr IS '개발자등급 -> 프로젝트팀원';

-- 임시 테이블4
ALTER TABLE Temporary6
  ADD
    CONSTRAINT FK_Temporary5_TO_Temporary6 -- 프로젝트순손익 -> 임시 테이블4
    FOREIGN KEY (
      COL2 -- 프로젝트순손익
    )
    REFERENCES Temporary5 ( -- 프로젝트순손익
      COL -- 프로젝트순손익
    );

-- 프로젝트순손익 -> 임시 테이블4
COMMENT ON CONSTRAINT Temporary6.FK_Temporary5_TO_Temporary6 IS '프로젝트순손익 -> 임시 테이블4';

-- 임시 테이블5
ALTER TABLE Temporary7
  ADD
    CONSTRAINT FK_Temporary5_TO_Temporary7 -- 프로젝트순손익 -> 임시 테이블5
    FOREIGN KEY (
      COL2 -- 프로젝트순손익
    )
    REFERENCES Temporary5 ( -- 프로젝트순손익
      COL -- 프로젝트순손익
    );

-- 프로젝트순손익 -> 임시 테이블5
COMMENT ON CONSTRAINT Temporary7.FK_Temporary5_TO_Temporary7 IS '프로젝트순손익 -> 임시 테이블5';

-- PMS프로젝트순손익
ALTER TABLE TABLE3
  ADD
    CONSTRAINT FK_pms_TO_TABLE3 -- PMS -> PMS프로젝트순손익
    FOREIGN KEY (
      pms_id -- 프로젝트번호
    )
    REFERENCES pms ( -- PMS
      pms_id -- 프로젝트번호
    );

-- PMS -> PMS프로젝트순손익
COMMENT ON CONSTRAINT TABLE3.FK_pms_TO_TABLE3 IS 'PMS -> PMS프로젝트순손익';

-- PMS프로젝트순손익
ALTER TABLE TABLE3
  ADD
    CONSTRAINT FK_Temporary5_TO_TABLE3 -- 프로젝트순손익 -> PMS프로젝트순손익
    FOREIGN KEY (
      COL -- 프로젝트순손익
    )
    REFERENCES Temporary5 ( -- 프로젝트순손익
      COL -- 프로젝트순손익
    );

-- 프로젝트순손익 -> PMS프로젝트순손익
COMMENT ON CONSTRAINT TABLE3.FK_Temporary5_TO_TABLE3 IS '프로젝트순손익 -> PMS프로젝트순손익';

-- 임시 테이블8
ALTER TABLE Temporary11
  ADD
    CONSTRAINT FK_pms_TO_Temporary11 -- PMS -> 임시 테이블8
    FOREIGN KEY (
      pms_id -- 프로젝트번호
    )
    REFERENCES pms ( -- PMS
      pms_id -- 프로젝트번호
    );

-- PMS -> 임시 테이블8
COMMENT ON CONSTRAINT Temporary11.FK_pms_TO_Temporary11 IS 'PMS -> 임시 테이블8';

-- 프로젝트장소
ALTER TABLE loc
  ADD
    CONSTRAINT FK_addr_TO_loc -- 주소 -> 프로젝트장소
    FOREIGN KEY (
      addr_id -- 주소번호
    )
    REFERENCES addr ( -- 주소
      addr_id -- 주소번호
    );

-- 주소 -> 프로젝트장소
COMMENT ON CONSTRAINT loc.FK_addr_TO_loc IS '주소 -> 프로젝트장소';

-- 프로젝트고객
ALTER TABLE clnt
  ADD
    CONSTRAINT FK_pay_type_TO_clnt -- 결제유형 -> 프로젝트고객
    FOREIGN KEY (
      pay_type_id -- 결제유형번호
    )
    REFERENCES pay_type ( -- 결제유형
      pay_type_id -- 결제유형번호
    );

-- 결제유형 -> 프로젝트고객
COMMENT ON CONSTRAINT clnt.FK_pay_type_TO_clnt IS '결제유형 -> 프로젝트고객';

-- 프로젝트고객
ALTER TABLE clnt
  ADD
    CONSTRAINT FK_hmr_TO_clnt -- 인적정보 -> 프로젝트고객
    FOREIGN KEY (
      hmr_id -- 담당자정보
    )
    REFERENCES hmr ( -- 인적정보
      hmr_id -- 인적정보번호
    );

-- 인적정보 -> 프로젝트고객
COMMENT ON CONSTRAINT clnt.FK_hmr_TO_clnt IS '인적정보 -> 프로젝트고객';

-- 프로젝트손익
ALTER TABLE TABLE10
  ADD
    CONSTRAINT FK_pms_TO_TABLE10 -- PMS -> 프로젝트손익
    FOREIGN KEY (
      pms_id -- 프로젝트번호
    )
    REFERENCES pms ( -- PMS
      pms_id -- 프로젝트번호
    );

-- PMS -> 프로젝트손익
COMMENT ON CONSTRAINT TABLE10.FK_pms_TO_TABLE10 IS 'PMS -> 프로젝트손익';

-- 프로젝트비용
ALTER TABLE TABLE11
  ADD
    CONSTRAINT FK_pms_TO_TABLE11 -- PMS -> 프로젝트비용
    FOREIGN KEY (
      pms_id -- 프로젝트번호
    )
    REFERENCES pms ( -- PMS
      pms_id -- 프로젝트번호
    );

-- PMS -> 프로젝트비용
COMMENT ON CONSTRAINT TABLE11.FK_pms_TO_TABLE11 IS 'PMS -> 프로젝트비용';

-- PMS운영체제호환
ALTER TABLE TABLE13
  ADD
    CONSTRAINT FK_pms_TO_TABLE13 -- PMS -> PMS운영체제호환
    FOREIGN KEY (
      pms_id -- 프로젝트번호
    )
    REFERENCES pms ( -- PMS
      pms_id -- 프로젝트번호
    );

-- PMS -> PMS운영체제호환
COMMENT ON CONSTRAINT TABLE13.FK_pms_TO_TABLE13 IS 'PMS -> PMS운영체제호환';

-- PMS운영체제호환
ALTER TABLE TABLE13
  ADD
    CONSTRAINT FK_os_TO_TABLE13 -- 운영체제호환 -> PMS운영체제호환
    FOREIGN KEY (
      os_id -- 운영체제번호
    )
    REFERENCES os ( -- 운영체제호환
      os_id -- 운영체제번호
    );

-- 운영체제호환 -> PMS운영체제호환
COMMENT ON CONSTRAINT TABLE13.FK_os_TO_TABLE13 IS '운영체제호환 -> PMS운영체제호환';

-- PMS사용기술
ALTER TABLE pms_tch
  ADD
    CONSTRAINT FK_pms_TO_pms_tch -- PMS -> PMS사용기술
    FOREIGN KEY (
      pms_id -- 프로젝트번호
    )
    REFERENCES pms ( -- PMS
      pms_id -- 프로젝트번호
    );

-- PMS -> PMS사용기술
COMMENT ON CONSTRAINT pms_tch.FK_pms_TO_pms_tch IS 'PMS -> PMS사용기술';

-- PMS사용기술
ALTER TABLE pms_tch
  ADD
    CONSTRAINT FK_tch_TO_pms_tch -- 사용기술 -> PMS사용기술
    FOREIGN KEY (
      tch_id -- 사용기술번호
    )
    REFERENCES tch ( -- 사용기술
      tch_id -- 사용기술번호
    );

-- 사용기술 -> PMS사용기술
COMMENT ON CONSTRAINT pms_tch.FK_tch_TO_pms_tch IS '사용기술 -> PMS사용기술';

-- PMS프로젝트팀
ALTER TABLE pms_pjtm
  ADD
    CONSTRAINT FK_pjtm_TO_pms_pjtm -- 프로젝트팀 -> PMS프로젝트팀
    FOREIGN KEY (
      team_id -- 프로젝트팀번호
    )
    REFERENCES pjtm ( -- 프로젝트팀
      team_id -- 프로젝트팀번호
    );

-- 프로젝트팀 -> PMS프로젝트팀
COMMENT ON CONSTRAINT pms_pjtm.FK_pjtm_TO_pms_pjtm IS '프로젝트팀 -> PMS프로젝트팀';

-- PMS프로젝트팀
ALTER TABLE pms_pjtm
  ADD
    CONSTRAINT FK_pms_TO_pms_pjtm -- PMS -> PMS프로젝트팀
    FOREIGN KEY (
      pms_id -- 프로젝트번호
    )
    REFERENCES pms ( -- PMS
      pms_id -- 프로젝트번호
    );

-- PMS -> PMS프로젝트팀
COMMENT ON CONSTRAINT pms_pjtm.FK_pms_TO_pms_pjtm IS 'PMS -> PMS프로젝트팀';

-- 프로젝트팀프로젝트팀원
ALTER TABLE pjtm_mbr
  ADD
    CONSTRAINT FK_pjtm_TO_pjtm_mbr -- 프로젝트팀 -> 프로젝트팀프로젝트팀원
    FOREIGN KEY (
      team_id -- 프로젝트팀번호
    )
    REFERENCES pjtm ( -- 프로젝트팀
      team_id -- 프로젝트팀번호
    );

-- 프로젝트팀 -> 프로젝트팀프로젝트팀원
COMMENT ON CONSTRAINT pjtm_mbr.FK_pjtm_TO_pjtm_mbr IS '프로젝트팀 -> 프로젝트팀프로젝트팀원';

-- 프로젝트팀프로젝트팀원
ALTER TABLE pjtm_mbr
  ADD
    CONSTRAINT FK_mbr_TO_pjtm_mbr -- 프로젝트팀원 -> 프로젝트팀프로젝트팀원
    FOREIGN KEY (
      mbr_id -- 프로젝트팀원번호
    )
    REFERENCES mbr ( -- 프로젝트팀원
      mbr_id -- 프로젝트팀원번호
    );

-- 프로젝트팀원 -> 프로젝트팀프로젝트팀원
COMMENT ON CONSTRAINT pjtm_mbr.FK_mbr_TO_pjtm_mbr IS '프로젝트팀원 -> 프로젝트팀프로젝트팀원';

-- 인적정보
ALTER TABLE hmr
  ADD
    CONSTRAINT FK_addr_TO_hmr -- 주소 -> 인적정보
    FOREIGN KEY (
      addr_id -- 주소번호
    )
    REFERENCES addr ( -- 주소
      addr_id -- 주소번호
    );

-- 주소 -> 인적정보
COMMENT ON CONSTRAINT hmr.FK_addr_TO_hmr IS '주소 -> 인적정보';

-- PMS자료
ALTER TABLE pms_data
  ADD
    CONSTRAINT FK_data_TO_pms_data -- 자료 -> PMS자료
    FOREIGN KEY (
      data_id -- 자료번호
    )
    REFERENCES data ( -- 자료
      data_id -- 자료번호
    );

-- 자료 -> PMS자료
COMMENT ON CONSTRAINT pms_data.FK_data_TO_pms_data IS '자료 -> PMS자료';

-- PMS자료
ALTER TABLE pms_data
  ADD
    CONSTRAINT FK_pms_TO_pms_data -- PMS -> PMS자료
    FOREIGN KEY (
      pms_id -- 프로젝트번호
    )
    REFERENCES pms ( -- PMS
      pms_id -- 프로젝트번호
    );

-- PMS -> PMS자료
COMMENT ON CONSTRAINT pms_data.FK_pms_TO_pms_data IS 'PMS -> PMS자료';

-- 자료자료유형
ALTER TABLE data_data_type
  ADD
    CONSTRAINT FK_data_TO_data_data_type -- 자료 -> 자료자료유형
    FOREIGN KEY (
      data_id -- 자료번호
    )
    REFERENCES data ( -- 자료
      data_id -- 자료번호
    );

-- 자료 -> 자료자료유형
COMMENT ON CONSTRAINT data_data_type.FK_data_TO_data_data_type IS '자료 -> 자료자료유형';

-- 자료자료유형
ALTER TABLE data_data_type
  ADD
    CONSTRAINT FK_data_type_TO_data_data_type -- 자료유형 -> 자료자료유형
    FOREIGN KEY (
      data_type_id -- 자료유형번호
    )
    REFERENCES data_type ( -- 자료유형
      data_type_id -- 자료유형번호
    );

-- 자료유형 -> 자료자료유형
COMMENT ON CONSTRAINT data_data_type.FK_data_type_TO_data_data_type IS '자료유형 -> 자료자료유형';

-- 프로젝트업무
ALTER TABLE work
  ADD
    CONSTRAINT FK_work_grad_TO_work -- 프로젝트업무등급 -> 프로젝트업무
    FOREIGN KEY (
      work_grad_id -- 프로젝트업무등급번호
    )
    REFERENCES work_grad ( -- 프로젝트업무등급
      work_grad_id -- 프로젝트업무등급번호
    );

-- 프로젝트업무등급 -> 프로젝트업무
COMMENT ON CONSTRAINT work.FK_work_grad_TO_work IS '프로젝트업무등급 -> 프로젝트업무';

-- PMS프로젝트업무
ALTER TABLE pms_work
  ADD
    CONSTRAINT FK_pms_TO_pms_work -- PMS -> PMS프로젝트업무
    FOREIGN KEY (
      pms_id -- 프로젝트번호
    )
    REFERENCES pms ( -- PMS
      pms_id -- 프로젝트번호
    );

-- PMS -> PMS프로젝트업무
COMMENT ON CONSTRAINT pms_work.FK_pms_TO_pms_work IS 'PMS -> PMS프로젝트업무';

-- PMS프로젝트업무
ALTER TABLE pms_work
  ADD
    CONSTRAINT FK_work_TO_pms_work -- 프로젝트업무 -> PMS프로젝트업무
    FOREIGN KEY (
      work_id -- 프로젝트업무번호
    )
    REFERENCES work ( -- 프로젝트업무
      work_id -- 프로젝트업무번호
    );

-- 프로젝트업무 -> PMS프로젝트업무
COMMENT ON CONSTRAINT pms_work.FK_work_TO_pms_work IS '프로젝트업무 -> PMS프로젝트업무';