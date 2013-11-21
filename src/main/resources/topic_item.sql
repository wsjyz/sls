CREATE TABLE `t_topic_item` (
  `item_id` varchar(50) NOT NULL,
  `topic_id` varchar(50) NOT NULL,
  `content` varchar(500) NOT NULL COMMENT '选项内容',
  `right` int(2) NOT NULL COMMENT '是否为正确答案，0 否，1 是',
  `index` int(2) NOT NULL COMMENT '选项序号',
  PRIMARY KEY  (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8