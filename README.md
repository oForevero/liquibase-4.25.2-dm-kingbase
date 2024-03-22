# Liquibase [![Build and Test](https://github.com/liquibase/liquibase/actions/workflows/build.yml/badge.svg)](https://github.com/liquibase/liquibase/actions/workflows/build.yml) [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=liquibase&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=liquibase)
<p align="center"><img src="https://github.com/liquibase/liquibase/blob/master/Liquibase.png" width="30%" height="30%"></p>

## 修改支持国产化个人自用项目
最近工作需要使用liquibase项目，故进行研究实现该功能，目前仅对国产化数据库进行适配开发工作。
### 使用版本
拉取官方4.25.1版本，直接fork会导致官方存在一大堆workflow到本项目，故自己上传
https://github.com/liquibase/liquibase/tree/v4.25.1
### 已适配数据库：
- 达梦适配（已实现功能，初步测试增删改查无误）
- 人大金仓适配（已实现功能，初步测试无问题）
### Activiti适配
activiti需要修改activiti-engine
https://github.com/oForevero/Activiti-support-kingbase-dm
### 修改思路（剖析源码后的想法）
1. 对于liquibase的适配需要实现对于 AbstractJdbcDatabase 的继承类，由于国产化数据库达梦适配与oracle，则直接复制oracle类，而kingbase适配与postgre，故复制postgre类
然后，修改对应的数据库名和数据库jdbc，端口等配置即可。


2. 对于达梦数据库的查询连接和kingbase的部分初始化sql不能使用oracle和postgre（部分表/视图不存在问题），如oracle存在 ALL_QUEUE_TABLES 视图 但是达梦不存在，则需要额外
修改对应sql映射类 AbstractJdbcDatabase，对对应不适配造成的sql查询进行修复，并对自己改写的dmDatabse类和kingbaseDatabase类进行对应配置
