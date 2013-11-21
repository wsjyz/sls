CREATE TABLE `t_user` (
  `user_id` varchar(50) NOT NULL,
  `user_name` varchar(100) NOT NULL,
  `male` int(2) default '1' COMMENT '0 否，1 是',
  PRIMARY KEY  (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8