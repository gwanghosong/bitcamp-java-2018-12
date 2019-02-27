-- PMS
DROP TABLE IF EXISTS pms RESTRICT;

-- 프로젝트팀원
DROP TABLE IF EXISTS mbr RESTRICT;

-- 프로젝트팀
DROP TABLE IF EXISTS pjtm RESTRICT;

-- 프로젝트기간
DROP TABLE IF EXISTS date RESTRICT;

-- 프로젝트장소
DROP TABLE IF EXISTS loc RESTRICT;

-- 운영체제호환
DROP TABLE IF EXISTS os RESTRICT;

-- 사용기술
DROP TABLE IF EXISTS tch RESTRICT;

-- 프로젝트고객
DROP TABLE IF EXISTS clnt RESTRICT;

-- 프로젝트순손익
DROP TABLE IF EXISTS npl RESTRICT;

-- PMS운영체제호환
DROP TABLE IF EXISTS pms_os RESTRICT;

-- PMS사용기술
DROP TABLE IF EXISTS pms_tch RESTRICT;

-- PMS프로젝트팀
DROP TABLE IF EXISTS pms_pjtm RESTRICT;

-- 주소
DROP TABLE IF EXISTS addr RESTRICT;

-- 프로젝트팀프로젝트팀원
DROP TABLE IF EXISTS pjtm_mbr RESTRICT;

-- 결제유형
DROP TABLE IF EXISTS pay_type RESTRICT;

-- 인적정보
DROP TABLE IF EXISTS hmr RESTRICT;

-- 자료
DROP TABLE IF EXISTS data RESTRICT;

-- 자료유형
DROP TABLE IF EXISTS data_type RESTRICT;

-- PMS자료
DROP TABLE IF EXISTS pms_data RESTRICT;

-- 자료자료유형
DROP TABLE IF EXISTS data_data_type RESTRICT;

-- 프로젝트등급
DROP TABLE IF EXISTS grad RESTRICT;

-- 프로젝트업무
DROP TABLE IF EXISTS work RESTRICT;

-- 프로젝트업무등급
DROP TABLE IF EXISTS work_grad RESTRICT;

-- PMS프로젝트업무
DROP TABLE IF EXISTS pms_work RESTRICT;

-- 개발자등급
DROP TABLE IF EXISTS dvlp_grad RESTRICT;

-- PMS
CREATE TABLE pms (
  pms_id  INTEGER      NOT NULL COMMENT '프로젝트번호', -- 프로젝트번호
  name    VARCHAR(50)  NOT NULL COMMENT '프로젝트제목', -- 프로젝트제목
  prps    VARCHAR(255) NOT NULL COMMENT '프로젝트목적', -- 프로젝트목적
  plan    VARCHAR(255) NULL     COMMENT '프로젝트계획', -- 프로젝트계획
  cont    VARCHAR(255) NULL     COMMENT '프로젝트내용', -- 프로젝트내용
  sum     VARCHAR(255) NULL     COMMENT '프로젝트요약', -- 프로젝트요약
  schm    VARCHAR(255) NULL     COMMENT '프로젝트스키마', -- 프로젝트스키마
  prrs    VARCHAR(255) NULL     COMMENT '프로젝트예상결과', -- 프로젝트예상결과
  date_id INTEGER      NULL     COMMENT '프로젝트총기간번호', -- 프로젝트총기간번호
  npl_id  INTEGER      NULL     COMMENT '프로젝트순손익번호', -- 프로젝트순손익번호
  clnt_id INTEGER      NULL     COMMENT '프로젝트고객번호', -- 프로젝트고객번호
  loc_id  INTEGER      NULL     COMMENT '프로젝트장소번호', -- 프로젝트장소번호
  grad_id INTEGER      NULL     COMMENT '프로젝트등급번호' -- 프로젝트등급번호
)
COMMENT 'PMS';

-- PMS
ALTER TABLE pms
  ADD CONSTRAINT PK_pms -- PMS 기본키
    PRIMARY KEY (
      pms_id -- 프로젝트번호
    );

-- PMS 유니크 인덱스
CREATE UNIQUE INDEX UIX_pms
  ON pms ( -- PMS
    name ASC -- 프로젝트제목
  );

ALTER TABLE pms
  MODIFY COLUMN pms_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '프로젝트번호';

-- 프로젝트팀원
CREATE TABLE mbr (
  mbr_id       INTEGER      NOT NULL COMMENT '프로젝트팀원번호', -- 프로젝트팀원번호
  pwd          VARCHAR(255) NOT NULL COMMENT '암호', -- 암호
  outin        INTEGER      NOT NULL COMMENT '외부인원', -- 외부인원
  inpdt        DATE         NULL     COMMENT '투입기간', -- 투입기간
  pms_id       INTEGER      NOT NULL COMMENT '프로젝트번호', -- 프로젝트번호
  hmr_id       INTEGER      NOT NULL COMMENT '팀원정보', -- 팀원정보
  dvlp_grad_id INTEGER      NOT NULL COMMENT '개발자등급번호' -- 개발자등급번호
)
COMMENT '프로젝트팀원';

-- 프로젝트팀원
ALTER TABLE mbr
  ADD CONSTRAINT PK_mbr -- 프로젝트팀원 기본키
    PRIMARY KEY (
      mbr_id -- 프로젝트팀원번호
    );

ALTER TABLE mbr
  MODIFY COLUMN mbr_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '프로젝트팀원번호';

-- 프로젝트팀
CREATE TABLE pjtm (
  team_id INTEGER     NOT NULL COMMENT '프로젝트팀번호', -- 프로젝트팀번호
  name    VARCHAR(50) NOT NULL COMMENT '팀이름' -- 팀이름
)
COMMENT '프로젝트팀';

-- 프로젝트팀
ALTER TABLE pjtm
  ADD CONSTRAINT PK_pjtm -- 프로젝트팀 기본키
    PRIMARY KEY (
      team_id -- 프로젝트팀번호
    );

-- 프로젝트팀 유니크 인덱스
CREATE UNIQUE INDEX UIX_pjtm
  ON pjtm ( -- 프로젝트팀
    name ASC -- 팀이름
  );

ALTER TABLE pjtm
  MODIFY COLUMN team_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '프로젝트팀번호';

-- 프로젝트기간
CREATE TABLE date (
  date_id INTEGER NOT NULL COMMENT '프로젝트총기간번호', -- 프로젝트총기간번호
  tot_dt  DATE    NOT NULL COMMENT '프로젝트총기간', -- 프로젝트총기간
  sdt     DATE    NOT NULL COMMENT '프로젝트시작일', -- 프로젝트시작일
  predt   DATE    NOT NULL COMMENT '프로젝트종료예상일', -- 프로젝트종료예상일
  ofrdt   DATE    NULL     COMMENT '프로젝트제안기간', -- 프로젝트제안기간
  alsdt   DATE    NULL     COMMENT '프로젝트요구사항/분석기간', -- 프로젝트요구사항/분석기간
  dsgdt   DATE    NULL     COMMENT '프로젝트설계기간', -- 프로젝트설계기간
  mkdt    DATE    NULL     COMMENT '프로젝트구현기간', -- 프로젝트구현기간
  tesdt   DATE    NULL     COMMENT '프로젝트테스트기간', -- 프로젝트테스트기간
  lchdt   DATE    NULL     COMMENT '프로젝트런칭기간' -- 프로젝트런칭기간
)
COMMENT '프로젝트기간';

-- 프로젝트기간
ALTER TABLE date
  ADD CONSTRAINT PK_date -- 프로젝트기간 기본키
    PRIMARY KEY (
      date_id -- 프로젝트총기간번호
    );

ALTER TABLE date
  MODIFY COLUMN date_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '프로젝트총기간번호';

-- 프로젝트장소
CREATE TABLE loc (
  loc_id  INTEGER     NOT NULL COMMENT '프로젝트장소번호', -- 프로젝트장소번호
  name    VARCHAR(50) NOT NULL COMMENT '장소명', -- 장소명
  addr_id INTEGER     NULL     COMMENT '주소번호' -- 주소번호
)
COMMENT '프로젝트장소';

-- 프로젝트장소
ALTER TABLE loc
  ADD CONSTRAINT PK_loc -- 프로젝트장소 기본키
    PRIMARY KEY (
      loc_id -- 프로젝트장소번호
    );

-- 프로젝트장소 인덱스
CREATE INDEX IX_loc
  ON loc( -- 프로젝트장소
    name ASC -- 장소명
  );

ALTER TABLE loc
  MODIFY COLUMN loc_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '프로젝트장소번호';

-- 운영체제호환
CREATE TABLE os (
  os_id INTEGER     NOT NULL COMMENT '운영체제번호', -- 운영체제번호
  name  VARCHAR(50) NOT NULL COMMENT '운영체제명' -- 운영체제명
)
COMMENT '운영체제호환';

-- 운영체제호환
ALTER TABLE os
  ADD CONSTRAINT PK_os -- 운영체제호환 기본키
    PRIMARY KEY (
      os_id -- 운영체제번호
    );

-- 운영체제호환 유니크 인덱스
CREATE UNIQUE INDEX UIX_os
  ON os ( -- 운영체제호환
    name ASC -- 운영체제명
  );

ALTER TABLE os
  MODIFY COLUMN os_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '운영체제번호';

-- 사용기술
CREATE TABLE tch (
  tch_id INTEGER     NOT NULL COMMENT '사용기술번호', -- 사용기술번호
  name   VARCHAR(50) NOT NULL COMMENT '기술명' -- 기술명
)
COMMENT '사용기술';

-- 사용기술
ALTER TABLE tch
  ADD CONSTRAINT PK_tch -- 사용기술 기본키
    PRIMARY KEY (
      tch_id -- 사용기술번호
    );

-- 사용기술 유니크 인덱스
CREATE UNIQUE INDEX UIX_tch
  ON tch ( -- 사용기술
    name ASC -- 기술명
  );

ALTER TABLE tch
  MODIFY COLUMN tch_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '사용기술번호';

-- 프로젝트고객
CREATE TABLE clnt (
  clnt_id     INTEGER     NOT NULL COMMENT '프로젝트고객번호', -- 프로젝트고객번호
  name        VARCHAR(50) NOT NULL COMMENT '고객상호', -- 고객상호
  pay_yn      BOOLEAN     NOT NULL COMMENT '결제여부', -- 결제여부
  pay_stat    BOOLEAN     NOT NULL COMMENT '결제상태', -- 결제상태
  pay_dt      DATE        NULL     COMMENT '결제일', -- 결제일
  pay_type_id INTEGER     NULL     COMMENT '결제유형번호', -- 결제유형번호
  hmr_id      INTEGER     NOT NULL COMMENT '담당자정보' -- 담당자정보
)
COMMENT '프로젝트고객';

-- 프로젝트고객
ALTER TABLE clnt
  ADD CONSTRAINT PK_clnt -- 프로젝트고객 기본키
    PRIMARY KEY (
      clnt_id -- 프로젝트고객번호
    );

-- 프로젝트고객 인덱스
CREATE INDEX IX_clnt
  ON clnt( -- 프로젝트고객
    name ASC -- 고객상호
  );

ALTER TABLE clnt
  MODIFY COLUMN clnt_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '프로젝트고객번호';

-- 프로젝트순손익
CREATE TABLE npl (
  npl_id INTEGER NOT NULL COMMENT '프로젝트순손익번호', -- 프로젝트순손익번호
  npl    INTEGER NOT NULL COMMENT '프로젝트순손익', -- 프로젝트순손익
  prft   INTEGER NOT NULL COMMENT '프로젝트수익', -- 프로젝트수익
  pric   INTEGER NULL     COMMENT '프로젝트가격', -- 프로젝트가격
  fund   INTEGER NULL     COMMENT '지원금', -- 지원금
  loss   INTEGER NOT NULL COMMENT '프로젝트비용', -- 프로젝트비용
  lbcs   INTEGER NULL     COMMENT '노무비', -- 노무비
  otcs   INTEGER NULL     COMMENT '경비', -- 경비
  mtcs   INTEGER NULL     COMMENT '재료비' -- 재료비
)
COMMENT '프로젝트순손익';

-- 프로젝트순손익
ALTER TABLE npl
  ADD CONSTRAINT PK_npl -- 프로젝트순손익 기본키2
    PRIMARY KEY (
      npl_id -- 프로젝트순손익번호
    );

ALTER TABLE npl
  MODIFY COLUMN npl_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '프로젝트순손익번호';

-- PMS운영체제호환
CREATE TABLE pms_os (
  pms_id INTEGER NOT NULL COMMENT '프로젝트번호', -- 프로젝트번호
  os_id  INTEGER NOT NULL COMMENT '운영체제번호' -- 운영체제번호
)
COMMENT 'PMS운영체제호환';

-- PMS운영체제호환
ALTER TABLE pms_os
  ADD CONSTRAINT PK_pms_os -- PMS운영체제호환 기본키
    PRIMARY KEY (
      pms_id, -- 프로젝트번호
      os_id   -- 운영체제번호
    );

ALTER TABLE pms_os
  MODIFY COLUMN pms_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '프로젝트번호';

-- PMS사용기술
CREATE TABLE pms_tch (
  tch_id INTEGER NOT NULL COMMENT '사용기술번호', -- 사용기술번호
  pms_id INTEGER NOT NULL COMMENT '프로젝트번호' -- 프로젝트번호
)
COMMENT 'PMS사용기술';

-- PMS사용기술
ALTER TABLE pms_tch
  ADD CONSTRAINT PK_pms_tch -- PMS사용기술 기본키
    PRIMARY KEY (
      tch_id, -- 사용기술번호
      pms_id  -- 프로젝트번호
    );

ALTER TABLE pms_tch
  MODIFY COLUMN tch_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '사용기술번호';

-- PMS프로젝트팀
CREATE TABLE pms_pjtm (
  pms_id  INTEGER NOT NULL COMMENT '프로젝트번호', -- 프로젝트번호
  team_id INTEGER NOT NULL COMMENT '프로젝트팀번호' -- 프로젝트팀번호
)
COMMENT 'PMS프로젝트팀';

-- PMS프로젝트팀
ALTER TABLE pms_pjtm
  ADD CONSTRAINT PK_pms_pjtm -- PMS프로젝트팀 기본키
    PRIMARY KEY (
      pms_id,  -- 프로젝트번호
      team_id  -- 프로젝트팀번호
    );

ALTER TABLE pms_pjtm
  MODIFY COLUMN pms_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '프로젝트번호';

-- 주소
CREATE TABLE addr (
  addr_id  INTEGER      NOT NULL COMMENT '주소번호', -- 주소번호
  post     VARCHAR(255) NULL     COMMENT '우편번호', -- 우편번호
  bas_addr VARCHAR(255) NULL     COMMENT '기본주소' -- 기본주소
)
COMMENT '주소';

-- 주소
ALTER TABLE addr
  ADD CONSTRAINT PK_addr -- 주소 기본키
    PRIMARY KEY (
      addr_id -- 주소번호
    );

ALTER TABLE addr
  MODIFY COLUMN addr_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '주소번호';

-- 프로젝트팀프로젝트팀원
CREATE TABLE pjtm_mbr (
  team_id INTEGER NOT NULL COMMENT '프로젝트팀번호', -- 프로젝트팀번호
  mbr_id  INTEGER NOT NULL COMMENT '프로젝트팀원번호' -- 프로젝트팀원번호
)
COMMENT '프로젝트팀프로젝트팀원';

-- 프로젝트팀프로젝트팀원
ALTER TABLE pjtm_mbr
  ADD CONSTRAINT PK_pjtm_mbr -- 프로젝트팀프로젝트팀원 기본키
    PRIMARY KEY (
      team_id, -- 프로젝트팀번호
      mbr_id   -- 프로젝트팀원번호
    );

ALTER TABLE pjtm_mbr
  MODIFY COLUMN team_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '프로젝트팀번호';

-- 결제유형
CREATE TABLE pay_type (
  pay_type_id INTEGER      NOT NULL COMMENT '결제유형번호', -- 결제유형번호
  pay_type    VARCHAR(255) NOT NULL COMMENT '결제유형명' -- 결제유형명
)
COMMENT '결제유형';

-- 결제유형
ALTER TABLE pay_type
  ADD CONSTRAINT PK_pay_type -- 결제유형 기본키
    PRIMARY KEY (
      pay_type_id -- 결제유형번호
    );

-- 결제유형 유니크 인덱스
CREATE UNIQUE INDEX UIX_pay_type
  ON pay_type ( -- 결제유형
    pay_type ASC -- 결제유형명
  );

ALTER TABLE pay_type
  MODIFY COLUMN pay_type_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '결제유형번호';

-- 인적정보
CREATE TABLE hmr (
  hmr_id  INTEGER      NOT NULL COMMENT '인적정보번호', -- 인적정보번호
  name    VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
  email   VARCHAR(40)  NOT NULL COMMENT '이메일', -- 이메일
  pos     VARCHAR(255) NULL     COMMENT '직위', -- 직위
  tel     VARCHAR(30)  NULL     COMMENT '전화번호', -- 전화번호
  phot    VARCHAR(255) NULL     COMMENT '사진', -- 사진
  acc     VARCHAR(255) NULL     COMMENT '계좌번호', -- 계좌번호
  addr_id INTEGER      NULL     COMMENT '주소번호' -- 주소번호
)
COMMENT '인적정보';

-- 인적정보
ALTER TABLE hmr
  ADD CONSTRAINT PK_hmr -- 인적정보 기본키
    PRIMARY KEY (
      hmr_id -- 인적정보번호
    );

-- 인적정보 인덱스
CREATE INDEX IX_hmr
  ON hmr( -- 인적정보
    name ASC -- 이름
  );

ALTER TABLE hmr
  MODIFY COLUMN hmr_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '인적정보번호';

-- 자료
CREATE TABLE data (
  data_id INTEGER     NOT NULL COMMENT '자료번호', -- 자료번호
  name    VARCHAR(50) NOT NULL COMMENT '자료명' -- 자료명
)
COMMENT '자료';

-- 자료
ALTER TABLE data
  ADD CONSTRAINT PK_data -- 자료 기본키
    PRIMARY KEY (
      data_id -- 자료번호
    );

-- 자료 인덱스
CREATE INDEX IX_data
  ON data( -- 자료
    name ASC -- 자료명
  );

ALTER TABLE data
  MODIFY COLUMN data_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '자료번호';

-- 자료유형
CREATE TABLE data_type (
  data_type_id INTEGER     NOT NULL COMMENT '자료유형번호', -- 자료유형번호
  name         VARCHAR(50) NOT NULL COMMENT '자료유형명' -- 자료유형명
)
COMMENT '자료유형';

-- 자료유형
ALTER TABLE data_type
  ADD CONSTRAINT PK_data_type -- 자료유형 기본키
    PRIMARY KEY (
      data_type_id -- 자료유형번호
    );

-- 자료유형 유니크 인덱스
CREATE UNIQUE INDEX UIX_data_type
  ON data_type ( -- 자료유형
    name ASC -- 자료유형명
  );

ALTER TABLE data_type
  MODIFY COLUMN data_type_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '자료유형번호';

-- PMS자료
CREATE TABLE pms_data (
  pms_id  INTEGER NOT NULL COMMENT '프로젝트번호', -- 프로젝트번호
  data_id INTEGER NOT NULL COMMENT '자료번호' -- 자료번호
)
COMMENT 'PMS자료';

-- PMS자료
ALTER TABLE pms_data
  ADD CONSTRAINT PK_pms_data -- PMS자료 기본키
    PRIMARY KEY (
      pms_id,  -- 프로젝트번호
      data_id  -- 자료번호
    );

ALTER TABLE pms_data
  MODIFY COLUMN pms_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '프로젝트번호';

-- 자료자료유형
CREATE TABLE data_data_type (
  data_id      INTEGER NOT NULL COMMENT '자료번호', -- 자료번호
  data_type_id INTEGER NOT NULL COMMENT '자료유형번호' -- 자료유형번호
)
COMMENT '자료자료유형';

-- 자료자료유형
ALTER TABLE data_data_type
  ADD CONSTRAINT PK_data_data_type -- 자료자료유형 기본키
    PRIMARY KEY (
      data_id,      -- 자료번호
      data_type_id  -- 자료유형번호
    );

ALTER TABLE data_data_type
  MODIFY COLUMN data_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '자료번호';

-- 프로젝트등급
CREATE TABLE grad (
  grad_id INTEGER     NOT NULL COMMENT '프로젝트등급번호', -- 프로젝트등급번호
  grad    VARCHAR(50) NOT NULL COMMENT '프로젝트등급명' -- 프로젝트등급명
)
COMMENT '프로젝트등급';

-- 프로젝트등급
ALTER TABLE grad
  ADD CONSTRAINT PK_grad -- 프로젝트등급 기본키2
    PRIMARY KEY (
      grad_id -- 프로젝트등급번호
    );

-- 프로젝트등급 유니크 인덱스
CREATE UNIQUE INDEX UIX_grad
  ON grad ( -- 프로젝트등급
    grad ASC -- 프로젝트등급명
  );

ALTER TABLE grad
  MODIFY COLUMN grad_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '프로젝트등급번호';

-- 프로젝트업무
CREATE TABLE work (
  work_id      INTEGER      NOT NULL COMMENT '프로젝트업무번호', -- 프로젝트업무번호
  work_type    VARCHAR(255) NOT NULL COMMENT '프로젝트업무유형', -- 프로젝트업무유형
  work_grad_id INTEGER      NOT NULL COMMENT '프로젝트업무등급번호' -- 프로젝트업무등급번호
)
COMMENT '프로젝트업무';

-- 프로젝트업무
ALTER TABLE work
  ADD CONSTRAINT PK_work -- 프로젝트업무 기본키
    PRIMARY KEY (
      work_id -- 프로젝트업무번호
    );

-- 프로젝트업무 유니크 인덱스
CREATE UNIQUE INDEX UIX_work
  ON work ( -- 프로젝트업무
    work_type ASC -- 프로젝트업무유형
  );

ALTER TABLE work
  MODIFY COLUMN work_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '프로젝트업무번호';

-- 프로젝트업무등급
CREATE TABLE work_grad (
  work_grad_id INTEGER      NOT NULL COMMENT '프로젝트업무등급번호', -- 프로젝트업무등급번호
  grad         VARCHAR(255) NOT NULL COMMENT '프로젝트업무등급명' -- 프로젝트업무등급명
)
COMMENT '프로젝트업무등급';

-- 프로젝트업무등급
ALTER TABLE work_grad
  ADD CONSTRAINT PK_work_grad -- 프로젝트업무등급 기본키
    PRIMARY KEY (
      work_grad_id -- 프로젝트업무등급번호
    );

-- 프로젝트업무등급 유니크 인덱스
CREATE UNIQUE INDEX UIX_work_grad
  ON work_grad ( -- 프로젝트업무등급
    grad ASC -- 프로젝트업무등급명
  );

ALTER TABLE work_grad
  MODIFY COLUMN work_grad_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '프로젝트업무등급번호';

-- PMS프로젝트업무
CREATE TABLE pms_work (
  pms_id  INTEGER NOT NULL COMMENT '프로젝트번호', -- 프로젝트번호
  work_id INTEGER NOT NULL COMMENT '프로젝트업무번호' -- 프로젝트업무번호
)
COMMENT 'PMS프로젝트업무';

-- PMS프로젝트업무
ALTER TABLE pms_work
  ADD CONSTRAINT PK_pms_work -- PMS프로젝트업무 기본키
    PRIMARY KEY (
      pms_id,  -- 프로젝트번호
      work_id  -- 프로젝트업무번호
    );

ALTER TABLE pms_work
  MODIFY COLUMN pms_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '프로젝트번호';

-- 개발자등급
CREATE TABLE dvlp_grad (
  dvlp_grad_id INTEGER      NOT NULL COMMENT '개발자등급번호', -- 개발자등급번호
  grad         VARCHAR(255) NOT NULL COMMENT '개발자등급명', -- 개발자등급명
  pric         INTEGER      NOT NULL COMMENT '개발자단가' -- 개발자단가
)
COMMENT '개발자등급';

-- 개발자등급
ALTER TABLE dvlp_grad
  ADD CONSTRAINT PK_dvlp_grad -- 개발자등급 기본키
    PRIMARY KEY (
      dvlp_grad_id -- 개발자등급번호
    );

-- 개발자등급 인덱스
CREATE INDEX IX_dvlp_grad
  ON dvlp_grad( -- 개발자등급
    grad ASC -- 개발자등급명
  );

ALTER TABLE dvlp_grad
  MODIFY COLUMN dvlp_grad_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '개발자등급번호';

-- PMS
ALTER TABLE pms
  ADD CONSTRAINT FK_date_TO_pms -- 프로젝트기간 -> PMS
    FOREIGN KEY (
      date_id -- 프로젝트총기간번호
    )
    REFERENCES date ( -- 프로젝트기간
      date_id -- 프로젝트총기간번호
    );

-- PMS
ALTER TABLE pms
  ADD CONSTRAINT FK_npl_TO_pms -- 프로젝트순손익 -> PMS
    FOREIGN KEY (
      npl_id -- 프로젝트순손익번호
    )
    REFERENCES npl ( -- 프로젝트순손익
      npl_id -- 프로젝트순손익번호
    );

-- PMS
ALTER TABLE pms
  ADD CONSTRAINT FK_clnt_TO_pms -- 프로젝트고객 -> PMS
    FOREIGN KEY (
      clnt_id -- 프로젝트고객번호
    )
    REFERENCES clnt ( -- 프로젝트고객
      clnt_id -- 프로젝트고객번호
    );

-- PMS
ALTER TABLE pms
  ADD CONSTRAINT FK_loc_TO_pms -- 프로젝트장소 -> PMS
    FOREIGN KEY (
      loc_id -- 프로젝트장소번호
    )
    REFERENCES loc ( -- 프로젝트장소
      loc_id -- 프로젝트장소번호
    );

-- PMS
ALTER TABLE pms
  ADD CONSTRAINT FK_grad_TO_pms -- 프로젝트등급 -> PMS
    FOREIGN KEY (
      grad_id -- 프로젝트등급번호
    )
    REFERENCES grad ( -- 프로젝트등급
      grad_id -- 프로젝트등급번호
    );

-- 프로젝트팀원
ALTER TABLE mbr
  ADD CONSTRAINT FK_pms_TO_mbr -- PMS -> 프로젝트팀원
    FOREIGN KEY (
      pms_id -- 프로젝트번호
    )
    REFERENCES pms ( -- PMS
      pms_id -- 프로젝트번호
    );

-- 프로젝트팀원
ALTER TABLE mbr
  ADD CONSTRAINT FK_hmr_TO_mbr -- 인적정보 -> 프로젝트팀원
    FOREIGN KEY (
      hmr_id -- 팀원정보
    )
    REFERENCES hmr ( -- 인적정보
      hmr_id -- 인적정보번호
    );

-- 프로젝트팀원
ALTER TABLE mbr
  ADD CONSTRAINT FK_dvlp_grad_TO_mbr -- 개발자등급 -> 프로젝트팀원
    FOREIGN KEY (
      dvlp_grad_id -- 개발자등급번호
    )
    REFERENCES dvlp_grad ( -- 개발자등급
      dvlp_grad_id -- 개발자등급번호
    );

-- 프로젝트장소
ALTER TABLE loc
  ADD CONSTRAINT FK_addr_TO_loc -- 주소 -> 프로젝트장소
    FOREIGN KEY (
      addr_id -- 주소번호
    )
    REFERENCES addr ( -- 주소
      addr_id -- 주소번호
    );

-- 프로젝트고객
ALTER TABLE clnt
  ADD CONSTRAINT FK_pay_type_TO_clnt -- 결제유형 -> 프로젝트고객
    FOREIGN KEY (
      pay_type_id -- 결제유형번호
    )
    REFERENCES pay_type ( -- 결제유형
      pay_type_id -- 결제유형번호
    );

-- 프로젝트고객
ALTER TABLE clnt
  ADD CONSTRAINT FK_hmr_TO_clnt -- 인적정보 -> 프로젝트고객
    FOREIGN KEY (
      hmr_id -- 담당자정보
    )
    REFERENCES hmr ( -- 인적정보
      hmr_id -- 인적정보번호
    );

-- PMS운영체제호환
ALTER TABLE pms_os
  ADD CONSTRAINT FK_pms_TO_pms_os -- PMS -> PMS운영체제호환
    FOREIGN KEY (
      pms_id -- 프로젝트번호
    )
    REFERENCES pms ( -- PMS
      pms_id -- 프로젝트번호
    );

-- PMS운영체제호환
ALTER TABLE pms_os
  ADD CONSTRAINT FK_os_TO_pms_os -- 운영체제호환 -> PMS운영체제호환
    FOREIGN KEY (
      os_id -- 운영체제번호
    )
    REFERENCES os ( -- 운영체제호환
      os_id -- 운영체제번호
    );

-- PMS사용기술
ALTER TABLE pms_tch
  ADD CONSTRAINT FK_pms_TO_pms_tch -- PMS -> PMS사용기술
    FOREIGN KEY (
      pms_id -- 프로젝트번호
    )
    REFERENCES pms ( -- PMS
      pms_id -- 프로젝트번호
    );

-- PMS사용기술
ALTER TABLE pms_tch
  ADD CONSTRAINT FK_tch_TO_pms_tch -- 사용기술 -> PMS사용기술
    FOREIGN KEY (
      tch_id -- 사용기술번호
    )
    REFERENCES tch ( -- 사용기술
      tch_id -- 사용기술번호
    );

-- PMS프로젝트팀
ALTER TABLE pms_pjtm
  ADD CONSTRAINT FK_pjtm_TO_pms_pjtm -- 프로젝트팀 -> PMS프로젝트팀
    FOREIGN KEY (
      team_id -- 프로젝트팀번호
    )
    REFERENCES pjtm ( -- 프로젝트팀
      team_id -- 프로젝트팀번호
    );

-- PMS프로젝트팀
ALTER TABLE pms_pjtm
  ADD CONSTRAINT FK_pms_TO_pms_pjtm -- PMS -> PMS프로젝트팀
    FOREIGN KEY (
      pms_id -- 프로젝트번호
    )
    REFERENCES pms ( -- PMS
      pms_id -- 프로젝트번호
    );

-- 프로젝트팀프로젝트팀원
ALTER TABLE pjtm_mbr
  ADD CONSTRAINT FK_pjtm_TO_pjtm_mbr -- 프로젝트팀 -> 프로젝트팀프로젝트팀원
    FOREIGN KEY (
      team_id -- 프로젝트팀번호
    )
    REFERENCES pjtm ( -- 프로젝트팀
      team_id -- 프로젝트팀번호
    );

-- 프로젝트팀프로젝트팀원
ALTER TABLE pjtm_mbr
  ADD CONSTRAINT FK_mbr_TO_pjtm_mbr -- 프로젝트팀원 -> 프로젝트팀프로젝트팀원
    FOREIGN KEY (
      mbr_id -- 프로젝트팀원번호
    )
    REFERENCES mbr ( -- 프로젝트팀원
      mbr_id -- 프로젝트팀원번호
    );

-- 인적정보
ALTER TABLE hmr
  ADD CONSTRAINT FK_addr_TO_hmr -- 주소 -> 인적정보
    FOREIGN KEY (
      addr_id -- 주소번호
    )
    REFERENCES addr ( -- 주소
      addr_id -- 주소번호
    );

-- PMS자료
ALTER TABLE pms_data
  ADD CONSTRAINT FK_data_TO_pms_data -- 자료 -> PMS자료
    FOREIGN KEY (
      data_id -- 자료번호
    )
    REFERENCES data ( -- 자료
      data_id -- 자료번호
    );

-- PMS자료
ALTER TABLE pms_data
  ADD CONSTRAINT FK_pms_TO_pms_data -- PMS -> PMS자료
    FOREIGN KEY (
      pms_id -- 프로젝트번호
    )
    REFERENCES pms ( -- PMS
      pms_id -- 프로젝트번호
    );

-- 자료자료유형
ALTER TABLE data_data_type
  ADD CONSTRAINT FK_data_TO_data_data_type -- 자료 -> 자료자료유형
    FOREIGN KEY (
      data_id -- 자료번호
    )
    REFERENCES data ( -- 자료
      data_id -- 자료번호
    );

-- 자료자료유형
ALTER TABLE data_data_type
  ADD CONSTRAINT FK_data_type_TO_data_data_type -- 자료유형 -> 자료자료유형
    FOREIGN KEY (
      data_type_id -- 자료유형번호
    )
    REFERENCES data_type ( -- 자료유형
      data_type_id -- 자료유형번호
    );

-- 프로젝트업무
ALTER TABLE work
  ADD CONSTRAINT FK_work_grad_TO_work -- 프로젝트업무등급 -> 프로젝트업무
    FOREIGN KEY (
      work_grad_id -- 프로젝트업무등급번호
    )
    REFERENCES work_grad ( -- 프로젝트업무등급
      work_grad_id -- 프로젝트업무등급번호
    );

-- PMS프로젝트업무
ALTER TABLE pms_work
  ADD CONSTRAINT FK_pms_TO_pms_work -- PMS -> PMS프로젝트업무
    FOREIGN KEY (
      pms_id -- 프로젝트번호
    )
    REFERENCES pms ( -- PMS
      pms_id -- 프로젝트번호
    );

-- PMS프로젝트업무
ALTER TABLE pms_work
  ADD CONSTRAINT FK_work_TO_pms_work -- 프로젝트업무 -> PMS프로젝트업무
    FOREIGN KEY (
      work_id -- 프로젝트업무번호
    )
    REFERENCES work ( -- 프로젝트업무
      work_id -- 프로젝트업무번호
    );