CREATE TABLE `t_board` (
`board_id`  int(11) NOT NULL AUTO_INCREMENT COMMENT '论坛版块ID' ,
`board_name`  varchar(150) NOT NULL DEFAULT '' COMMENT '论坛版块名' ,
`board_desc`  varchar(255) NULL DEFAULT NULL COMMENT '论坛版块描述' ,
`topic_num`  int(11) NOT NULL DEFAULT 0 COMMENT '帖子数量' ,
PRIMARY KEY (`board_id`)
)
;