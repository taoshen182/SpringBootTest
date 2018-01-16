DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
          `username` varchar(255) NOT NULL,
          `password` varchar(255) default NULL,
          `enabled` varchar(255) default NULL,
          PRIMARY KEY  USING BTREE (`username`)
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
          `username` varchar(255) NOT NULL,
          `authority` varchar(255) default NULL,
          PRIMARY KEY  USING BTREE (`username`)
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `group_authorities`;
  CREATE TABLE `group_authorities` (
          `group_id` int(11) NOT NULL,
          `authority` varchar(255) default NULL
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `group_members`;
 CREATE TABLE `group_members` (
          `group_id` int(11) NOT NULL,
          `username` varchar(255) default NULL
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `groups`;
CREATE TABLE `groups` (
          `id` int(11) NOT NULL auto_increment,
          `group_name` varchar(255) default NULL,
          PRIMARY KEY  (`id`)
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `users` VALUES ('admin', 'admin', 'true');
INSERT INTO `users` VALUES ('guest', 'guest', 'true');

INSERT INTO `group_authorities` VALUES (1, 'ROLE_USER');
INSERT INTO `group_authorities` VALUES (2, 'ROLE_USER');
INSERT INTO `group_authorities` VALUES (2, 'ROLE_ADMIN');

INSERT INTO `authorities` VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO `authorities` VALUES ('guest', 'ROLE_USER');

INSERT INTO `group_members` VALUES (1, 'guest');
INSERT INTO `group_members` VALUES (2, 'admin');


INSERT INTO `groups` VALUES (1, 'Users');
INSERT INTO `groups` VALUES (2, 'Administrators');