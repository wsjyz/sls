CREATE TABLE `t_topic` (
  `topic_id` varchar(50) NOT NULL,
  `title` varchar(500) NOT NULL COMMENT '题目内容',
  `level` int(2) NOT NULL default '1' COMMENT '难度： 1 简单 2 普通  3 困难',
  PRIMARY KEY  (`topic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8