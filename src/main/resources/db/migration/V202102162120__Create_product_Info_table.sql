CREATE TABLE IF NOT EXISTS `product`
(
  `id`                   VARCHAR(32)    NOT NULL COMMENT '主键',
  `name`                 VARCHAR(32)    NOT NULL COMMENT '商品名',
  `category`             VARCHAR(32)    NOT NULL COMMENT '商品种类',
  `purchase_price`       DECIMAL(10, 2) NOT NULL COMMENT '商品进货价',
  `retail_price`         DECIMAL(10, 2) NOT NULL COMMENT '商品进货价',
  `stock_number`         INT            NOT NULL COMMENT '商品库存数量',
  `create_time`          TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time`          TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY(`id`)
USING BTREE
)ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ;