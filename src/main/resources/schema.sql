SET @@foreign_key_checks = 0;

DROP TABLE IF EXISTS `charge_points`;
CREATE TABLE `charge_points`
(
    `id`     bigint(20)   NOT NULL AUTO_INCREMENT,
    `vendor` varchar(255) NOT NULL,
    `model`  varchar(255) NOT NULL,
    `status` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

DROP TABLE IF EXISTS `transactions`;
CREATE TABLE `transactions`
(
    `id`                 bigint(20)   NOT NULL AUTO_INCREMENT,
    `charging_connector` varchar(255) NOT NULL,
    `status`             varchar(255) NOT NULL,
    `charge_point_id`    bigint(20)   NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`charge_point_id`) REFERENCES `charge_points` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

DROP TABLE IF EXISTS `transaction_events`;
CREATE TABLE `transaction_events`
(
    `id`             bigint(20)   NOT NULL AUTO_INCREMENT,
    `event_type`     varchar(255) NOT NULL,
    `event_data`     varchar(8192) NOT NULL,
    `transaction_id` bigint(20)   NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`transaction_id`) REFERENCES `transactions` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

SET @@foreign_key_checks = 1;
