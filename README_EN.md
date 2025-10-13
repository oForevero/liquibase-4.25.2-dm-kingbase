## language
English | [简体中文](./README.mdd)
## 
Modifications to support domestically produced personal projects
Recently, I've needed to use the Liquibase project for work, so I'm researching and implementing this feature. Currently, we're only working on adapting and developing support for the Renmin University of China Jincang and DAMO databases.

### Versions Used
Pull the official version 4.25.2. Directly forking it will result in a large number of official workflows being added to this project, so I uploaded it myself: https://github.com/liquibase/liquibase/tree/v4.25.2

### Adapted databases:
DaMeng Adaptation (functionality implemented, preliminary testing shows no errors with additions, deletions, modifications, and checks)
RenDa KingCang Adaptation (functionality implemented, preliminary testing shows no issues)
Activiti Adaptation
Activiti requires modifying activiti-engine: https://github.com/oForevero/Activiti-support-kingbase-dm

### odification Idea (after analyzing the source code)
For Liquibase adaptation, implement a class that inherits from AbstractJdbcDatabase. Since the domestic database Dameng is Oracle-compatible, copy the Oracle class directly. Since Kingbase is PostgreSQL-compatible, copy the PostgreSQL class. Then, modify the corresponding database name, database JDBC, port, and other configurations.

For the query connection of the DM database and some initialization sql of Registry, Oracle and PostgreSQL cannot be used (some tables/views do not have problems). For example, if Oracle has the ALL_QUEUE_TABLES view but DM does not, you need to modify the corresponding sql mapping class AbstractJdbcDatabase, repair the sql query caused by the corresponding incompatibility, and configure the dmDatabse class and RegistryDatabase class that you have rewritten accordingly.
