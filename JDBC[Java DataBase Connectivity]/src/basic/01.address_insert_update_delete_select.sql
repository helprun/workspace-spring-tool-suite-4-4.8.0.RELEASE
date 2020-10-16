--delete
delete from address;
--insert
insert into address values(address_no_seq.nextval,'guard','김경호','123-4568','경기도 성남시');
insert into address values(address_no_seq.nextval,'abcdf','박경호','123-4568','경기도 구리시');
insert into address values(address_no_seq.nextval,'starts','최경호','123-4568','경기도 포천시');
insert into address values(address_no_seq.nextval,'beauty','구경호','123-4568','경기도 이천시');
insert into address values(address_no_seq.nextval,'bishop','정경호','123-4568','경기도 군포시');
insert into address values(address_no_seq.nextval,'xyzzx','이경호','123-4568','경기도 안양시');
insert into address values(address_no_seq.nextval,'yyyyy','주경호','123-4568','경기도 안산시');
insert into address values(address_no_seq.nextval,'super','양경호','123-4568','경기도 인천시');
insert into address values(address_no_seq.nextval,'strong','인경호','123-4568','경기도 시흥시');
--update(pk update)
update address set id = 'xxx', name = '김경호', phone = '888-8888', address = '서울시 강남구'
where no = 1;
--delete(pk delete)
delete address where no = 1;

--select(pk select)
select * from address where no = 2;
--select(all select)
select * from address;

commit;
