CREATE TABLE `t_player_level_setting` (
  `level_id` varchar(8) COLLATE utf8_bin NOT NULL DEFAULT '',
  `level_title` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '级别名称',
  `need_exp` int(11) DEFAULT NULL COMMENT '需要的经验值',
  PRIMARY KEY (`level_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;