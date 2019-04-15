/** 建表 */
CREATE DATABASE /*!32312 IF NOT EXISTS*/`norm` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

/** 授权用户 root全部权限，read只读权限 */
grant all privileges on norm.* to norm_root@localhost identified by 'normApi%123';
grant select on norm.* to norm_read@localhost identified by 'normApi%123';
flush privileges;

