CREATE TABLE `user`
(
    `user_id`            varchar(255) NOT NULL,
    `encrypted_password` varchar(255) NOT NULL,
    `created_at`         timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at`         timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `authority`
(
    `authority_id` varchar(255) NOT NULL,
    `created_at`   timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at`   timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`authority_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `relation_user_authority`
(
    `user_id`      varchar(255) NOT NULL,
    `authority_id` varchar(255) NOT NULL,
    `created_at`   timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at`   timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`user_id`, `authority_id`),
    FOREIGN KEY `user_id_foreign` (`user_id`) REFERENCES `user` (`user_id`),
    FOREIGN KEY `authority_id_foreign` (`authority_id`) REFERENCES `authority` (`authority_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
