package io.github.yashchenkon.assertsqlcount.inspector;

import org.hibernate.resource.jdbc.spi.StatementInspector;

import io.github.yashchenkon.assertsqlcount.core.QueryCountsSqlHandler;
import io.github.yashchenkon.assertsqlcount.core.SqlHandler;

/**
 * @author Mykola Yashchenko
 */
public class QueryCountsInspector implements StatementInspector {

    private final SqlHandler sqlHandler = new QueryCountsSqlHandler();

    public String inspect(final String sqlStatement) {
        sqlHandler.handle(sqlStatement);
        return sqlStatement;
    }
}
