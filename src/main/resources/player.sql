CREATE TABLE `t_player` (
  `player_id` varchar(50) NOT NULL,
  `player_name` varchar(100) NOT NULL,
  `male` int(2) default '1' COMMENT '0 否，1 是',
  `experience` int(8) default '0' COMMENT '经验值',
  `peopleName` varchar(20) default NULL COMMENT '真实姓名',
  `qq` varchar(15) default NULL,
  `phone` varchar(15) default NULL,
  `email` varchar(30) default NULL,
  `address` varchar(100) default NULL,
  PRIMARY KEY  (`player_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
