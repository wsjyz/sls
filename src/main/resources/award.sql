CREATE TABLE `t_award` (
  `award_id` varchar(50) NOT NULL,
  `award_name` varchar(100) DEFAULT NULL,
  `bg_href` varchar(200) DEFAULT NULL COMMENT '房间图片地址',
  `remain` int(8) NOT NULL COMMENT '剩下的奖品数',
  `total` int(8) NOT NULL COMMENT '总奖品数',
  `detail_href` varchar(200) DEFAULT NULL COMMENT '详情介绍链接',
  `description` varchar(500) DEFAULT NULL,
  `price` int(8) DEFAULT NULL COMMENT '价值，元，省略角分单位',
  `rate_of_win` varchar(10) DEFAULT NULL COMMENT '中奖概率',
  PRIMARY KEY (`award_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;