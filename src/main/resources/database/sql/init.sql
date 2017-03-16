-- 用户表初始化
INSERT INTO `T_USER` (`userId`, `userName`, `userPassword`) VALUES ("NapsterLong","NapsterLong","AgWT1pm+lsGTk88F6oY4wg==");

-- 角色表初始化
INSERT INTO `T_ROLE` (`roleId`, `roleName`) VALUES ("1000","超级管理员"),("2000","管理员");

-- 用户角色关系表初始化
INSERT INTO `T_RE_USER_ROLE` (`roleId`, `userId`) VALUES ("1000","NapsterLong")
