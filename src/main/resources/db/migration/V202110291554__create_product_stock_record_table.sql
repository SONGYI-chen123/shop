CREATE TABLE IF NOT EXISTS `product_stock_record`
(
  `id`                   VARCHAR(32)    NOT NULL COMMENT '主键',
  `product_no`           VARCHAR(32)    NOT NULL COMMENT '商品编号',
  `reduce_number`        INT            NULL COMMENT '本次减少数量',
  `increase_number`      INT            NULL COMMENT '本次增加数量',
  `total_number`         INT            NOT NULL COMMENT '商品库存总量',
  `create_time`          TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time`          TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY(`id`)
USING BTREE
)ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ;