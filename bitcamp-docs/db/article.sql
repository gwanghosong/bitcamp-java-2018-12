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


CREATE TABLE atc_file (
  atc_file_id INTEGER(30) NOT NULL,
  atc_id INTEGER(30) NULL,
  fn VARCHAR(255) NOT NULL,
  sfn VARCHAR(255) NOT NULL,
  fp VARCHAR(255) NOT NULL,
  cont_type VARCHAR(255) NOT NULL,
  size BIGINT NOT NULL,
  rdt     DATETIME    NULL     DEFAULT now(),
  constraint fk_atc_file_to_atc foreign key (atc_id) 
  references atc (atc_id)
);

ALTER TABLE atc_file
  ADD CONSTRAINT PK_atc_file
    PRIMARY KEY (
      atc_file_id
    );
    
ALTER TABLE atc_file
  MODIFY COLUMN atc_file_id INTEGER(30) NOT NULL AUTO_INCREMENT;
  

-- 임시폴더
CREATE TABLE img_tmp (
  img_tmp_id INTEGER(30) NOT NULL,
  fn VARCHAR(255) NOT NULL,
  sfn VARCHAR(255) NOT NULL,
  fp VARCHAR(255) NOT NULL,
  cont_type VARCHAR(255) NOT NULL,
  size BIGINT NOT NULL,
  rdt     DATETIME    NULL     DEFAULT now());
  
  ALTER TABLE img_tmp
  ADD CONSTRAINT PK_img_tmp
    PRIMARY KEY (
      img_tmp_id
    );
    
ALTER TABLE img_tmp
  MODIFY COLUMN img_tmp_id INTEGER(30) NOT NULL AUTO_INCREMENT;


insert into atc(subj,cont)
values('안녕하세요','반갑습니다.');


insert into upf(atc_id,fn,sfn,sfp,cont_type,size)
values (1,'a','aaaa','images/aa','png','21690000');
  
  
  