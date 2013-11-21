CREATE TABLE `t_room` (
  `room_id` varchar(50) NOT NULL,
  `room_name` varchar(100) default NULL,
  `bg_href` varchar(200) default NULL COMMENT '房间图片地址',
  `remain` int(8) NOT NULL COMMENT '剩下的奖品数',
  `total` int(8) NOT NULL COMMENT '总奖品数',
  `detail_href` varchar(200) default NULL COMMENT '详情介绍链接',
  `description` varchar(500) default NULL,
  PRIMARY KEY  (`room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8