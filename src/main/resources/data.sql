
INSERT  INTO DEPARTMENT(department_id,department_name)VALUES(100,'IT Dept');

INSERT  INTO DEPARTMENT(department_id,department_name)VALUES(101,'HR Dept');




INSERT  INTO EMPLOYEE(employee_id,first_name,last_name,email,phone_number,hire_date,salary,manager_id,department_id )VALUES(10001,'Kamran','Majeed','kamran.student@gmail.com','+923135189421',sysdate(),986.00,null,100);
INSERT  INTO EMPLOYEE(employee_id,first_name,last_name,email,phone_number,hire_date,salary, manager_id,department_id )VALUES(10002,'Ali','Khan','ali@gmail.com','+923135189421',sysdate(),2000.56,10001,101);
INSERT  INTO EMPLOYEE(employee_id,first_name,last_name,email,phone_number,hire_date,salary, manager_id,department_id )VALUES(10003,'Muhammad','Zahid','zahid@gmail.com','+923135189421',sysdate(),60000.00,10001,100);
INSERT  INTO EMPLOYEE(employee_id,first_name,last_name,email,phone_number,hire_date,salary, manager_id,department_id )VALUES(10004,'Mehmooad','Abbass','abbass@gmail.com','+923135189421',sysdate(),69200.50,10001,100);

