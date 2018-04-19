用户表
CREATE TABLE `user` (
	`user_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
	`user_name` VARCHAR(35) NOT NULL COMMENT '用户名',
	`password` VARCHAR(20) NOT NULL COMMENT '密码',
	PRIMARY KEY (user_id)
);



排片表
alter table `plan` change  `movie_id`  `movie_name` VARCHAR(35) NOT NULL;
alter table `plan` add `hall_name` varchar(10) not null
create table   `plan`(
     `plan_id` int(10) NOt NULL AUTO_INCREMENT COMMENT '拍片计划',
    `startTime` VARCHAR(35) NOT NULL COMMENT '开始时间',
    `sumTime` VARCHAR(35) NOT NULL COMMENT '片长',
    `hall_id`
    `hall_name` VARCHAR(35) NOT NULL COMMENT '影厅',
    `movie_name` VARCHAR(35) NOT NULL COMMENT '影片',
    PRIMARY KEY (plan_id)
    );
    insert into plan(startTime,sumTime,hall_id,movie_name,hall_name) values('15:00','2.00','001','头号玩家','3Dmax1')

影片
alter table `movie` add `price` varchar(10) default '30';

insert into movie(movieName) values ('头号玩家')
create table `movie`(

   `movie_id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
   `movieName` VARCHAR(20) NOT NULL COMMENT 'name',
   `price`
   PRIMARY KEY (movie_id)
);

大厅 用planID与seatNumber

alter table `hall` change hall_id plan_id int(10) NOT NULL
insert into hall(plan_id,seatNumber) values(1,1);

create table  `hall`(

`id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
`plan_id` int(10) NOT NULL,
`seatNumber` int(10) NOT NULL,
 PRIMARY KEY (id)

);

insert into middleOrder(user_id,order_id) values(1,20180417)
中间表
create table middleOrder(
`id` INT(10) NOT NULL AUTO_INCREMENT ,
`user_id` VARCHAR(20) NOT NULL ,
`order_id` VARCHAR(20) not NULL,
primary key(id)

);

订单表uorder order为关键字


alter table uorder modify order_id int(20) auto_increment;
insert into uorder(state,movie_id,plan_id,user_id,seatNumber) values ('not',1,1,2,3)
alter table `order` add `plan_id` int(10) NOt NULL;
alter table `order` add `user_id` int(10) NOt NULL;
alter table `order` add `seatNumber` int(10) NOt NULL;
alter table uorder AUTO_INCREMENT =20180417
alter table `order` change order_id  order_id int(20) NOT NULL;
id生成规则 System.currentTimeMillis()/1000
create table `order`(
`order_id` INT(20) NOT NULL AUTO_INCREMENT,
`state`VARCHAR(10) NOT NULL,
`verifyCode` VARCHAR(10) ,
`movie_id` int(10) NOT NULL,
`seatNumber`
primary key (order_id)
);

 plan----->电影表  --->  hall

 user---->middleOrder ---->order


 mineActivity:显示用户购票信息

根据用户id查orderid,根据orderID查movieID，plan_id,以及state，verifyCode

select startTime,sumTime,hall_Name from plan where plan_id=#{planId}

select movieName, price from movie where movie_Id=#{movieId}


select seatNumber,movieId,plan_id,state ,verifyCode from order where user_id=1

select  p.startTime,p.sumtime,p.hall_name, m.movieName, m.price,u.seatNumber,u.state ,u.verifyCode
from
plan p,movie m,uorder u
where
p.plan_id = (select plan_id from uorder where user_id=1)
and m.movie_id=(select movie_id from uorder where user_id=1)
and u.user_id=1;



 {code:"状态码",
  data{
    name:"用户名",
    state:"付款信息",
    movieName:"电影名称"
    startTime :"开始时间"
    sumTime:"总时间"
    price:"价格"
    hall:"大厅"
    verifyCode:"验证码"
    seatNumber:"座位号"
    }
  }


PlanActivity:根据电影名从movie表中查放映场次
select p.startTime,p.sumTime,m.price,p.hall_Name ,p.hall_id from movie m,plan p
where movieName='头号玩家'

{code:"状态码"
data{
   // movie:"电影名"
    startTime :"开始时间"
    sumTime:"总时间"

    hallName:"大厅"
    hall_id:"datingID"
    price:"价格"
    }
}

seatActivity

select seatNumber from hall where plan_id=1

根据plan_id 来选择



