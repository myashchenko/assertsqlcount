package io.github.yashchenkon.assertsqlcount.core;

import io.github.yashchenkon.assertsqlcount.types.QueryType;

/**
 * @author Mykola Yashchenko
 */
public class QueryCountsSqlHandler implements SqlHandler {

    @Override
    public void handle(String sqlStatement) {
        QueryType queryType = QueryType.getQueryType(sqlStatement);
        queryType.process(QueryCountsHolder.getQueryCounts());
    }
}
