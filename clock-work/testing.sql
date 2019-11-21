select * from employee;
insert into employee (User_id, First_Name, Last_Name, Password, Role_Id ) values (1, 'Shaun','Kolich','test', 1);
insert into employee (User_id, First_Name, Last_Name, Password, Role_Id ) values (2, 'Dan','Pickles','test', 1);
insert into employee (User_id, First_Name, Last_Name, Password, Role_Id ) values (3, 'Bob','Dillon','test', 1);
insert into employee (User_id, First_Name, Last_Name, Password, Role_Id ) values (4, 'Tom','Cruise','test', 1);
insert into employee (User_id, First_Name, Last_Name, Password, Role_Id ) values (5, 'Tommy','Jones','test', 1);

select * from hours;
insert into hours (User_Id, End_Date, Mon_Hours, Tues_Hours, Weds_Hours, Thurs_Hours, Fri_Hours,Total_Hours) values (1,'2019-11-15',8,8,8,8,8,40);
insert into hours (User_Id, End_Date, Mon_Hours, Tues_Hours, Weds_Hours, Thurs_Hours, Fri_Hours,Total_Hours) values (2,'2019-11-15',8,8,8,8,8,40);
insert into hours (User_Id, End_Date, Mon_Hours, Tues_Hours, Weds_Hours, Thurs_Hours, Fri_Hours,Total_Hours) values (3,'2019-11-15',8,8,8,8,8,40);
insert into hours (User_Id, End_Date, Mon_Hours, Tues_Hours, Weds_Hours, Thurs_Hours, Fri_Hours,Total_Hours) values (4,'2019-11-15',8,8,8,8,8,40);
insert into hours (User_Id, End_Date, Mon_Hours, Tues_Hours, Weds_Hours, Thurs_Hours, Fri_Hours,Total_Hours) values (5,'2019-11-15',8,8,8,8,8,40);
insert into role (Role_ID, Role) values(1,'Employee');
insert into role (Role_ID, Role) values(2,'Employee');
insert into role (Role_ID, Role) values(3,'Employee');
insert into role (Role_ID, Role) values(4,'Employee');
insert into role (Role_ID, Role) values(5,'Employee');

commit;
select * from employee;
select * from role;
select * from hours;

select *
from 
employee
inner join hours
on employee.User_Id = hours.User_Id;