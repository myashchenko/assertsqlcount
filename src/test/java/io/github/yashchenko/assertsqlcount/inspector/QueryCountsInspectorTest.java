package io.github.yashchenko.assertsqlcount.inspector;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.github.yashchenkon.assertsqlcount.inspector.QueryCountsInspector;
import io.github.yashchenkon.assertsqlcount.test.AssertSqlCount;

/**
 * @author Mykola Yashchenko
 */
public class QueryCountsInspectorTest {

    private QueryCountsInspector queryCountsInspector = new QueryCountsInspector();

    @BeforeEach
    public void before() {
        AssertSqlCount.reset();
    }

    @Test
    public void shouldIncrementCount() {
        String selectStatement = "SELECT * FROM Table";
        queryCountsInspector.inspect(selectStatement);
        queryCountsInspector.inspect(selectStatement);

        AssertSqlCount.assertSelectCount(2);
    }
}
