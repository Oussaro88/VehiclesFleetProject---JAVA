--SQL VehiclesFleetDB --Oussama Arouch



--CONNECTION TO DATABASE AND USER CREATION 
CONNECT sys/sys as sysdba;
DROP USER vehiclesfleetdb CASCADE;
create user vehiclesfleetdb identified by 123;
GRANT connect, resource TO vehiclesfleetdb;
GRANT all privileges to vehiclesfleetdb;
CONNECT vehiclesfleetdb/123;


--TABLE CREATION + TABLE CONSTRAINTS
CREATE TABLE gasvehicle(gvserialnumber VARCHAR2(4), gvmade VARCHAR2(20), gvmodel VARCHAR2(20), gvdate NUMBER(8), gvtripcounter NUMBER(10), gvmaxspeed VARCHAR(6), gvbrakepower VARCHAR2(6), gvfuelconsumed VARCHAR2(10));
CREATE TABLE electricvehicle(evserialnumber VARCHAR2(4), evmade VARCHAR2(20), evmodel VARCHAR2(20), evdate NUMBER(8), evtripcounter NUMBER(10), evmaxspeed VARCHAR(6), evbrakepower VARCHAR2(6), evkwpowerconsumed VARCHAR2(10));
ALTER TABLE gasvehicle ADD CONSTRAINT gasvehicle_gvserialnumber_PK PRIMARY KEY (gvserialnumber);
ALTER TABLE electricvehicle ADD CONSTRAINT elecvehicle_evserialnumber_PK PRIMARY KEY (evserialnumber);

SELECT table_name FROM user_tables;
desc gasvehicle;
desc electricvehicle

 
--DOMAIN CONSTRAINTS ALTERATION
alter table gasvehicle modify gvmaxspeed NOT NULL;
alter table gasvehicle modify gvbrakepower NOT NULL;
alter table gasvehicle add constraint ck_gvmaxspeed check (gvmaxspeed <= 350);
alter table gasvehicle add constraint ck_gvbrakepower check (gvbrakepower > 20);
alter table gasvehicle MODIFY gvmade DEFAULT 'unknown';
alter table gasvehicle MODIFY gvmodel DEFAULT 'unknown';
alter table gasvehicle MODIFY gvdate DEFAULT '00000000';

alter table electricvehicle modify evmaxspeed NOT NULL;
alter table electricvehicle modify evbrakepower NOT NULL;
alter table electricvehicle add constraint ck_evmaxspeed check (evmaxspeed <= 350);
alter table electricvehicle add constraint ck_evbrakepower check (evbrakepower > 20);
alter table electricvehicle MODIFY evmade DEFAULT 'unknown';
alter table electricvehicle MODIFY evmodel DEFAULT 'unknown';
alter table electricvehicle MODIFY evdate DEFAULT '00000000';


--DATA INSERTION TO GASVEHICLE TABLE
INSERT INTO gasvehicle values('0001', 'japan', 'mazda', 20050313, 0, '150', '60', '0');
INSERT INTO gasvehicle values('0002', 'japan', 'nissan', 20150313, 240, '250', '60', '7.7');
INSERT INTO gasvehicle values('0003', 'france', 'renault',20200313 , 500, '250', '80', '14.2');
INSERT INTO gasvehicle values('0004', 'germany', 'bmw',20090713 , 420, '180', '30', '10.2');
INSERT INTO gasvehicle values('0005', 'germany', 'mercedes',20210717 , 320, '320', '90', '18.2');
INSERT INTO gasvehicle values('0006', 'USA', 'ford',20110717 , 280, '280', '65', '20.2');
INSERT INTO gasvehicle values('0007', 'USA', 'cadillac',20150417 , 580, '300', '80', '20.2');
INSERT INTO gasvehicle values('0008', 'germany', 'audi',20150417 , 370, '290', '60', '10.2');
INSERT INTO gasvehicle values('0009', 'italy', 'alfaromeo',20170420 , 310, '280', '70', '11.7');
INSERT INTO gasvehicle values('0010', 'france', 'citroen',20070528 , 410, '220', '65', '25.4');
INSERT INTO gasvehicle values('0011', 'japan', 'subaru',20120502 , 610, '250', '75', '20.6');
INSERT INTO gasvehicle values('0012', 'usa', 'gmc',20180502 , 510, '280', '75', '17.9');
INSERT INTO gasvehicle values('0013', 'japan', 'honda',20190701 , 310, '270', '55', '15.1');
INSERT INTO gasvehicle values('0014', 'italy', 'opel',20140420 , 210, '180', '40', '19.5');
INSERT INTO gasvehicle values('0015', 'japan', 'toyota',20150101 , 490, '240', '70', '18.3');


--DATA INSERTION TO ELECTRICVEHICLETABLE
INSERT INTO electricvehicle values('0001', 'Japan', 'Mazda', 20150101, 400, '250', '50', '9.7');
INSERT INTO electricvehicle values('0002', 'France', 'Renault', 20180122, 500, '200', '65', '11.2');
INSERT INTO electricvehicle values('0003', 'USA', 'Tesla', 20210101, 480, '300', '80', '12.7');
INSERT INTO electricvehicle values('0004', 'USA', 'ford', 20180701, 390, '280', '70', '10.8');
INSERT INTO electricvehicle values('0005', 'germany', 'bmw', 20150507, 610, '300', '80', '13.1');
INSERT INTO electricvehicle values('0006', 'japan', 'nissan', 20170107, 510,'260', '50', '14.1');
INSERT INTO electricvehicle values('0007', 'japan', 'toyota', 20160123, 450, '260','55','12.4');
INSERT INTO electricvehicle values('0008', 'USA', 'minicooper', 20211001, 370,'280','60','12.8');
INSERT INTO electricvehicle values('0009', 'germany', 'audi', 20200507, 610,'270','90', '9.1');
INSERT INTO electricvehicle values('0010', 'SKorea', 'kia', 20210917, 580,'270','95', '11.6');
INSERT INTO electricvehicle values('0011', 'england', 'jaguar', 20201218, 670,'340','95','14.5');
INSERT INTO electricvehicle values('0012', 'germany', 'porsche', 20180510,700,'350','85','15.1');
INSERT INTO electricvehicle values('0013', 'germany', 'volks', 20171010, 300,'240','75','14.3');
INSERT INTO electricvehicle values('0014', 'USA', 'ford', 20160101, 340,'300','65','8.8');
INSERT INTO electricvehicle values('0015', 'USA', 'tesla', 20190731, 400,'290','85','9.2');

--PRINTING DATA
SELECT table_name FROM user_tables;
desc gasvehicle;
select * from gasvehicle;
desc electricvehicle;
select * from electricvehicle;

-- COMMIT
COMMIT;