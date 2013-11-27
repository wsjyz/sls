CREATE TABLE `t_player` (
  `player_id` varchar(50) NOT NULL,
  `player_name` varchar(100) NOT NULL,
  `male` int(2) default '1' COMMENT '0 否，1 是',
  `experience` int(8) default '0' COMMENT '经验值',
  PRIMARY KEY  (`player_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8