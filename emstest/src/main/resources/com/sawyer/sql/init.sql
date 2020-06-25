CREATE table t_user(
	id VARCHAR(40) primary key,
	username VARCHAR(40),
	realname VARCHAR(40),
	password VARCHAR(40),
	sex VARCHAR(8)
);

CREATE table t_emp(
	id VARCHAR(40) primary key,
	name VARCHAR(60),
	salary double(7,2),
	age int(3),
	bir date
);