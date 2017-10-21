package io.github.yashchenko.assertsqlcount.types;

import org.junit.jupiter.api.Test;

import io.github.yashchenkon.assertsqlcount.types.QueryCounts;
import io.github.yashchenkon.assertsqlcount.types.QueryType;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Mykola Yashchenko
 */
public class QueryTypeTest {

    @Test
    public void shouldIncrementAppropriateCounts() {
        QueryCounts queryCounts = new QueryCounts();

        QueryType.CALL.process(queryCounts);
        assertEquals(1, queryCounts.getCallCount());

        QueryType.INSERT.process(queryCounts);
        assertEquals(1, queryCounts.getInsertCount());

        QueryType.UPDATE.process(queryCounts);
        assertEquals(1, queryCounts.getUpdateCount());

        QueryType.DELETE.process(queryCounts);
        assertEquals(1, queryCounts.getDeleteCount());

        QueryType.SELECT.process(queryCounts);
        assertEquals(1, queryCounts.getSelectCount());
    }

    @Test
    public void shouldParseQuery() {
        String selectStatement = "SELECT * FROM Table";
        assertEquals(QueryType.SELECT, QueryType.getQueryType(selectStatement));

        String updateStatement = "UPDATE Table SET col = 1";
        assertEquals(QueryType.UPDATE, QueryType.getQueryType(updateStatement));

        String insertStatement = "INSERT INTO Table (col1, col2) VALUES (1, 2)";
        assertEquals(QueryType.INSERT, QueryType.getQueryType(insertStatement));

        String deleteStatement = "DELETE FROM Table WHERE id = 1";
        assertEquals(QueryType.DELETE, QueryType.getQueryType(deleteStatement));

        String callStatement = "call procedure1(arg1, arg2)";
        assertEquals(QueryType.CALL, QueryType.getQueryType(callStatement));
    }
}
