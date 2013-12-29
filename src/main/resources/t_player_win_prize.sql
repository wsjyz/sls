CREATE TABLE `t_player_win_prize` (
  `player_win_prize_id` varchar(8) COLLATE utf8_bin NOT NULL,
  `player_id` varchar(8) COLLATE utf8_bin DEFAULT NULL,
  `award_id` varchar(8) COLLATE utf8_bin DEFAULT NULL,
  `award_name` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `price` int(8) DEFAULT NULL,
  `opt_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`player_win_prize_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

