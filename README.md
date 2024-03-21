# Liquibase [![Build and Test](https://github.com/liquibase/liquibase/actions/workflows/build.yml/badge.svg)](https://github.com/liquibase/liquibase/actions/workflows/build.yml) [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=liquibase&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=liquibase)
<p align="center"><img src="https://github.com/liquibase/liquibase/blob/master/Liquibase.png" width="30%" height="30%"></p>

## 修改支持国产化个人自用项目
最近工作需要使用liquibase项目，故进行研究实现该功能，目前仅对国产化数据库进行适配开发工作。
### 使用版本
拉取官方4.25.1版本，直接fork会导致官方存在一大堆workflow到本项目，故自己上传
https://github.com/liquibase/liquibase/tree/v4.25.1
### 已适配数据库：
- 达梦适配（已实现功能，由于dameng jdbc 存在自动将名称转义增加/的问题导致每次执行都会新建LOG表的问题待修复）
- 人大金仓适配（已实现功能，初步测试无问题）
### Activiti适配
activiti需要修改activiti-engine
https://github.com/oForevero/Activiti-support-kingbase-dm
