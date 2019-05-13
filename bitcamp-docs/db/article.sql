DROP TABLE upf;
DROP TABLE atc;

CREATE TABLE atc (
  atc_id INTEGER(30) NOT NULL,
  subj VARCHAR(255) NOT NULL,
  cont TEXT NULL,
  rdt     DATETIME    NULL     DEFAULT now(),
  udt     DATETIME    NULL     DEFAULT now()
);

ALTER TABLE atc
  ADD CONSTRAINT PK_atc
    PRIMARY KEY (
      atc_id
    );

ALTER TABLE atc
  MODIFY COLUMN atc_id INTEGER(30) NOT NULL AUTO_INCREMENT;


CREATE TABLE upf (
  upf_id INTEGER(30) NOT NULL,
  fn VARCHAR(255) NOT NULL,
  sfn VARCHAR(255) NOT NULL,
  sfp VARCHAR(255) NOT NULL,
  cont_type VARCHAR(255) NOT NULL,
  size BIGINT NOT NULL,
  rdt     DATETIME    NULL     DEFAULT now()
);

ALTER TABLE upf
  ADD CONSTRAINT PK_upf
    PRIMARY KEY (
      upf_id
    );


ALTER TABLE upf
  MODIFY COLUMN upf_id INTEGER(30) NOT NULL AUTO_INCREMENT;


insert into atc(subj,cont)
values('안녕하세요','반갑습니다.');


insert into upf(fn,sfn,sfp,cont_type,size)
values ('a','aaaa','images/aa','png','21690000');
  
  
  