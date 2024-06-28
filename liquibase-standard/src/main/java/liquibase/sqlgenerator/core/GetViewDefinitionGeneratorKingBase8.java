package liquibase.sqlgenerator.core;

import liquibase.CatalogAndSchema;
import liquibase.database.Database;
import liquibase.database.core.KingBase8Database;
import liquibase.sql.Sql;
import liquibase.sql.UnparsedSql;
import liquibase.sqlgenerator.SqlGeneratorChain;
import liquibase.statement.core.GetViewDefinitionStatement;

/**
 * @author LiKai
 * @Description 人大金仓8适配
 * @Version 1.0.0
 * @Date 2024/3/20 16:18
 * @Created by JMY
 */

public class GetViewDefinitionGeneratorKingBase8 extends GetViewDefinitionGenerator {
    @Override
    public int getPriority() {
        return PRIORITY_DATABASE;
    }

    @Override
    public boolean supports(GetViewDefinitionStatement statement, Database database) {
        return database instanceof KingBase8Database;
    }

    @Override
    public Sql[] generateSql(GetViewDefinitionStatement statement, Database database, SqlGeneratorChain sqlGeneratorChain) {
        CatalogAndSchema schema = new CatalogAndSchema(statement.getCatalogName(), statement.getSchemaName()).customize(database);

        return new Sql[] {
                new UnparsedSql("select definition from pg_views where viewname='" + statement.getViewName() + "' AND schemaname='" + schema.getSchemaName() + "'" )
        };
    }
}
