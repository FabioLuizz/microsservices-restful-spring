CREATE SEQUENCE SQ_COLLECT
   START WITH 1
   INCREMENT BY 1
   NOCACHE
   NOCYCLE;

CREATE TABLE TB_SCHEDULE (
    ID INTEGER DEFAULT SQ_COLLECT.NEXTVAL NOT NULL,
    NM_CITY VARCHAR(50) NOT NULL,
    NM_ADDRESS VARCHAR2(100) NOT NULL,
    DS_COLLECTION_DATE DATE NOT NULL,
    DS_TRASH_TYPE VARCHAR(100) NOT NULL,
    ST_STATUS VARCHAR(10) DEFAULT 'NOT DONE' NOT NULL,
    PRIMARY KEY (ID)
)