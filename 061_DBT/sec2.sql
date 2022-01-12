/*section 2

Q1 Write a procedure the print all employee details using cursors.*/


DROP PROCEDURE IF EXISTS getemp;
delimiter $$
CREATE PROCEDURE getemp()
begin
    declare empID INT;
    declare ename ,job VARCHAR(45);
    declare mgr,hiredate,sal,comm, deptno,bonusid INT;
	declare user_name,pwd VARCHAR(50);
    declare phone INT;
	declare isActive INT;
    declare c1 PROCEDURE FOR SELECT * FROM emp;
    
    OPEN c1;
         lbl: loop
              FETCH c1 empID ,ename ,job ,mgr ,hiredate ,sal ,comm ,deptno ,bonusid ,pwd ,phone ,isActive;
              SELECT empID ,ename ,job ,mgr ,hiredate ,sal ,comm ,deptno ,bonusid,pwd ,phone ,isActive;
         end loop lbl;
    CLOSE c1;
end $$
delimiter ;


/*
Q2•	Create a new table called STUDENT having following columns (studentID, namefirst, namelast, DOB, and emailID). Write a function names myAutoNumber to return auto generate number and use that number as studentID and insert the value in studentID column. Check if namefirst and namelast is already present in the table, then display a message “Student exists”.



create table STUDENT(studentID int , firstname varchar(20) ,lastname varchar(20),DOB date,emailID varchar(30));

->Function : 
Drop function if exists myAutoNumber;
delimiter $
CREATE FUNCTION myAutoNumber() returns int
deterministic 
begin
	declare x int ;
	SET x := (select round(rand()*100));
	return x;
end $
delimiter ;

->Procedure : 
drop procedure if exists P1;
delimiter $
create procedure P1( X int , Fname varchar(20) , Lname varchar(20), d date , mail varchar(30))
begin 
	IF (select firstname from student)=Fname && (select lasname from student)=Lname then
		select “Student already exists” as “Message”;
	ELSE 
		insert into table Student(x , fname , lname, d ,mail);
		select “Value Inserted into table” as “Message”;
	END IF
end $
delimiter ; 
*/