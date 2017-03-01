
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `task_schedule_job`
-- ----------------------------
DROP TABLE IF EXISTS `task_schedule_job`;
CREATE TABLE `task_schedule_job` (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `job_name` varchar(255) DEFAULT NULL COMMENT '定时器名称',
  `job_group` varchar(255) DEFAULT NULL COMMENT '任务分组',
  `job_status` varchar(255) DEFAULT NULL COMMENT '任务状态 是否启动任务：0没有 1：启动',
  `cron_expression` varchar(255) NOT NULL COMMENT 'cron表达式',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `bean_class` varchar(255) DEFAULT NULL COMMENT '任务执行时调用哪个类的方法 包名+类名',
  `is_concurrent` varchar(255) DEFAULT NULL COMMENT '任务是否有状态',
  `spring_id` varchar(255) DEFAULT NULL COMMENT 'spring bean ',
  `method_name` varchar(255) NOT NULL COMMENT '任务调用的方法名',
  PRIMARY KEY (`job_id`),
  UNIQUE KEY `name_group` (`job_name`,`job_group`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='计划任务信息';

-- ----------------------------
-- Records of task_schedule_job
-- ----------------------------
INSERT INTO `task_schedule_job` VALUES ('1', null, '2014-08-08 14:17:34', 'test', 'test', '0', '0/1 * * * * ?', 'test', 'com.snailxr.base.task.TaskTest', '0', null, 'run1');
INSERT INTO `task_schedule_job` VALUES ('2', null, '2014-04-25 14:17:19', 'test1', 'test', '0', '0/5 * * * * ?', 'test2', null, '1', 'taskTest', 'run');
INSERT INTO `task_schedule_job` VALUES ('10', '2014-04-25 16:52:17', '2014-08-08 14:17:27', '中间', '1111', '0', '0/1 * * * * ?', 'xxx', 'com.snailxr.base.task.TaskTest', '1', '', 'run');
