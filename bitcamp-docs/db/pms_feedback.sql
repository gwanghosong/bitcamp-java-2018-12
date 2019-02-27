-- PMS
DROP TABLE IF EXISTS pms RESTRICT;

-- 프로젝트팀원
DROP TABLE IF EXISTS tmmt RESTRICT;

-- 운영체제호환
DROP TABLE IF EXISTS os RESTRICT;

-- 사용기술
DROP TABLE IF EXISTS tch RESTRICT;

-- PMS운영체제호환
DROP TABLE IF EXISTS pms_os RESTRICT;

-- PMS사용기술
DROP TABLE IF EXISTS pms_tch RESTRICT;

-- 사용자
DROP TABLE IF EXISTS user RESTRICT;

-- 자료
DROP TABLE IF EXISTS data RESTRICT;

-- 자료유형
DROP TABLE IF EXISTS data_type RESTRICT;

-- 개발자등급
DROP TABLE IF EXISTS user_tmmt RESTRICT;

-- 프로젝트일정
DROP TABLE IF EXISTS schd RESTRICT;

-- PMS
CREATE TABLE pms (
  pms_id INTEGER      NOT NULL COMMENT '프로젝트번호', -- 프로젝트번호
  name   VARCHAR(50)  NOT NULL COMMENT '프로젝트제목', -- 프로젝트제목
  prps   VARCHAR(255) NOT NULL COMMENT '프로젝트목적', -- 프로젝트목적
  plan   VARCHAR(255) NULL     COMMENT '프로젝트계획', -- 프로젝트계획
  cont   VARCHAR(255) NULL     COMMENT '프로젝트내용', -- 프로젝트내용
  sum    VARCHAR(255) NULL     COMMENT '프로젝트요약', -- 프로젝트요약
  schm   VARCHAR(255) NULL     COMMENT '프로젝트스키마', -- 프로젝트스키마
  prrs   VARCHAR(255) NULL     COMMENT '프로젝트예상결과', -- 프로젝트예상결과
  COL2   VARCHAR(255) NULL     COMMENT '우편번호', -- 우편번호
  COL3   VARCHAR(255) NULL     COMMENT '기본주소', -- 기본주소
  COL    VARCHAR(255) NULL     COMMENT '상세주소' -- 상세주소
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
CREATE TABLE tmmt (
  tmmt_id      INTEGER NOT NULL COMMENT '프로젝트팀원번호', -- 프로젝트팀원번호
  pms_id       INTEGER NOT NULL COMMENT '프로젝트번호', -- 프로젝트번호
  user_id      INTEGER NULL     COMMENT '사용자번호', -- 사용자번호
  COL          DATE    NULL     COMMENT '투입일', -- 투입일
  COL2         DATE    NULL     COMMENT '종료일', -- 종료일
  user_tmmt_id INTEGER NULL     COMMENT '개발자등급번호' -- 개발자등급번호
)
COMMENT '프로젝트팀원';

-- 프로젝트팀원
ALTER TABLE tmmt
  ADD CONSTRAINT PK_tmmt -- 프로젝트팀원 기본키
    PRIMARY KEY (
      tmmt_id -- 프로젝트팀원번호
    );

ALTER TABLE tmmt
  MODIFY COLUMN tmmt_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '프로젝트팀원번호';

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

-- 사용자
CREATE TABLE user (
  user_id      INTEGER      NOT NULL COMMENT '사용자번호', -- 사용자번호
  name         VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
  pwd          VARCHAR(255) NOT NULL COMMENT '암호', -- 암호
  email        VARCHAR(40)  NOT NULL COMMENT '이메일', -- 이메일
  pos          VARCHAR(255) NULL     COMMENT '직위', -- 직위
  tel          VARCHAR(30)  NULL     COMMENT '전화번호', -- 전화번호
  phot         VARCHAR(255) NULL     COMMENT '사진', -- 사진
  COL          VARCHAR(255) NULL     COMMENT '우편번호', -- 우편번호
  COL2         VARCHAR(255) NULL     COMMENT '기본주소', -- 기본주소
  COL3         VARCHAR(255) NULL     COMMENT '상세주소', -- 상세주소
  user_tmmt_id INTEGER      NULL     COMMENT '개발자등급번호' -- 개발자등급번호
)
COMMENT '사용자';

-- 사용자
ALTER TABLE user
  ADD CONSTRAINT PK_user -- 사용자 기본키
    PRIMARY KEY (
      user_id -- 사용자번호
    );

-- 사용자 인덱스
CREATE INDEX IX_user
  ON user( -- 사용자
    name ASC -- 이름
  );

ALTER TABLE user
  MODIFY COLUMN user_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '사용자번호';

-- 자료
CREATE TABLE data (
  data_id      INTEGER     NOT NULL COMMENT '자료번호', -- 자료번호
  pms_id       INTEGER     NULL     COMMENT '프로젝트번호', -- 프로젝트번호
  data_type_id INTEGER     NULL     COMMENT '자료유형번호', -- 자료유형번호
  user_id      INTEGER     NULL     COMMENT '사용자번호', -- 사용자번호
  name         VARCHAR(50) NOT NULL COMMENT '자료명', -- 자료명
  COL          DATE        NULL     COMMENT '등록일' -- 등록일
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

-- 개발자등급
CREATE TABLE user_tmmt (
  user_tmmt_id INTEGER      NOT NULL COMMENT '개발자등급번호', -- 개발자등급번호
  grad         VARCHAR(255) NOT NULL COMMENT '개발자등급명', -- 개발자등급명
  pric         INTEGER      NOT NULL COMMENT '개발자단가' -- 개발자단가
)
COMMENT '개발자등급';

-- 개발자등급
ALTER TABLE user_tmmt
  ADD CONSTRAINT PK_user_tmmt -- 개발자등급 기본키
    PRIMARY KEY (
      user_tmmt_id -- 개발자등급번호
    );

-- 개발자등급 인덱스
CREATE INDEX IX_user_tmmt
  ON user_tmmt( -- 개발자등급
    grad ASC -- 개발자등급명
  );

ALTER TABLE user_tmmt
  MODIFY COLUMN user_tmmt_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '개발자등급번호';

-- 프로젝트일정
CREATE TABLE schd (
  schd_id INTEGER NOT NULL COMMENT '프로젝트일정식별번호', -- 프로젝트일정식별번호
  pms_id  INTEGER NOT NULL COMMENT '프로젝트번호', -- 프로젝트번호
  COL2    DATE    NULL     COMMENT '일정명', -- 일정명
  COL3    DATE    NULL     COMMENT '시작일', -- 시작일
  COL4    DATE    NULL     COMMENT '종료일' -- 종료일
)
COMMENT '프로젝트일정';

-- 프로젝트일정
ALTER TABLE schd
  ADD CONSTRAINT PK_schd -- 프로젝트일정 기본키
    PRIMARY KEY (
      schd_id -- 프로젝트일정식별번호
    );

-- 프로젝트팀원
ALTER TABLE tmmt
  ADD CONSTRAINT FK_pms_TO_tmmt -- PMS -> 프로젝트팀원
    FOREIGN KEY (
      pms_id -- 프로젝트번호
    )
    REFERENCES pms ( -- PMS
      pms_id -- 프로젝트번호
    );

-- 프로젝트팀원
ALTER TABLE tmmt
  ADD CONSTRAINT FK_user_TO_tmmt -- 사용자 -> 프로젝트팀원
    FOREIGN KEY (
      user_id -- 사용자번호
    )
    REFERENCES user ( -- 사용자
      user_id -- 사용자번호
    );

-- 프로젝트팀원
ALTER TABLE tmmt
  ADD CONSTRAINT FK_user_tmmt_TO_tmmt -- 개발자등급 -> 프로젝트팀원
    FOREIGN KEY (
      user_tmmt_id -- 개발자등급번호
    )
    REFERENCES user_tmmt ( -- 개발자등급
      user_tmmt_id -- 개발자등급번호
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

-- 사용자
ALTER TABLE user
  ADD CONSTRAINT FK_user_tmmt_TO_user -- 개발자등급 -> 사용자
    FOREIGN KEY (
      user_tmmt_id -- 개발자등급번호
    )
    REFERENCES user_tmmt ( -- 개발자등급
      user_tmmt_id -- 개발자등급번호
    );

-- 자료
ALTER TABLE data
  ADD CONSTRAINT FK_pms_TO_data -- PMS -> 자료
    FOREIGN KEY (
      pms_id -- 프로젝트번호
    )
    REFERENCES pms ( -- PMS
      pms_id -- 프로젝트번호
    );

-- 자료
ALTER TABLE data
  ADD CONSTRAINT FK_data_type_TO_data -- 자료유형 -> 자료
    FOREIGN KEY (
      data_type_id -- 자료유형번호
    )
    REFERENCES data_type ( -- 자료유형
      data_type_id -- 자료유형번호
    );

-- 자료
ALTER TABLE data
  ADD CONSTRAINT FK_user_TO_data -- 사용자 -> 자료
    FOREIGN KEY (
      user_id -- 사용자번호
    )
    REFERENCES user ( -- 사용자
      user_id -- 사용자번호
    );

-- 프로젝트일정
ALTER TABLE schd
  ADD CONSTRAINT FK_pms_TO_schd -- PMS -> 프로젝트일정
    FOREIGN KEY (
      pms_id -- 프로젝트번호
    )
    REFERENCES pms ( -- PMS
      pms_id -- 프로젝트번호
    );