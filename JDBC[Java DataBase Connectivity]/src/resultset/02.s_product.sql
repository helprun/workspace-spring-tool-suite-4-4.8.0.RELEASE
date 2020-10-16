drop table s_product;

CREATE TABLE s_product
(
 no                         NUMBER(7) primary key,
 name                       VARCHAR2(50),
 short_desc                 VARCHAR2(255),
 price 			            NUMBER(10,3),
 ipgo_date		            DATE
 );
 
INSERT INTO s_product VALUES (
   10011, '명품플러스원',
   '한글자막 안내기능',4000.123,to_date('17/12/24','YY/MM/DD'));
INSERT INTO s_product VALUES (
   10012, '장수명브라운관',
   '브라운관 수명3배',3000.1234,to_date('2017/12/24','YYYY/MM/DD'));
INSERT INTO s_product VALUES (
   10021, '액정와이드프로젝션',
   '고화질시네마비젼',3000,to_date('2017/12/24','yyyy/mm/dd'));
INSERT INTO s_product VALUES (
   10022, '액정와이드프로젝션2',
   '고화질시네마비젼2',4000.5,sysdate);
  
commit;

insert into s_product(no,name,short_desc,price,ipgo_date)
values(10023,'GALAXYS9','아주좋아요',90000,sysdate);

insert into s_product(no,name,short_desc,price,ipgo_date)
values(10024,'GALAXYS9+','아주아주좋아요',100000,to_date('2018/05/22','YYYY/MM/DD'));

DROP SEQUENCE PRODUCT_NO_SEQ;
CREATE SEQUENCE  "SCOTT"."PRODUCT_NO_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 20000 NOCACHE  NOORDER  NOCYCLE ;

insert into s_product(no,name,short_desc,price,ipgo_date)
values(product_no_seq.nextval,'GALAXYS NOTE8','진짜좋아요',99999.99,sysdate);
/******************java***********************************
insert into s_product(no,name,short_desc,price,ipgo_date)
values(?,?,?,?,sysdate);

insert into s_product(no,name,short_desc,price,ipgo_date)
values(?,?,?,?,?);

insert into s_product(no,name,short_desc,price,ipgo_date)
values(?,?,?,?,to_date(?,'YYYY/MM/DD'));

insert into s_product(no,name,short_desc,price,ipgo_date)
values(?,?,?,?,to_date(?,?));
**********************************************************/
commit;

desc s_product;

select no,name,short_desc,ipgo_date from s_product;
select no,name,short_desc,to_char(ipgo_date,'YYYY/MM/DD SS') from s_product;
 
 
 
 
 
 
 
 
 
 
 
