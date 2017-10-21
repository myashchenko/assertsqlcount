package io.github.yashchenkon.assertsqlcount.test;

import io.github.yashchenkon.assertsqlcount.core.QueryCountsHolder;
import io.github.yashchenkon.assertsqlcount.exception.SqlCountMismatchException;

import static io.github.yashchenkon.assertsqlcount.core.QueryCountsHolder.*;

/**
 * @author Mykola Yashchenko
 */
public class AssertSqlCount {
    public static void reset() {
        clear();
    }

    public static void assertSelectCount(int expectedSelectCount) {
        assertSqlCount("select", expectedSelectCount, getQueryCounts().getSelectCount());
    }

    public static void assertUpdateCount(int expectedUpdateCount) {
        assertSqlCount("update", expectedUpdateCount, getQueryCounts().getUpdateCount());
    }

    public static void assertInsertCount(int expectedInsertCount) {
        assertSqlCount("insert", expectedInsertCount, getQueryCounts().getInsertCount());
    }

    public static void assertDeleteCount(int expectedDeleteCount) {
        assertSqlCount("delete", expectedDeleteCount, getQueryCounts().getDeleteCount());

    }

    public static void assertCallCount(int expectedCallCount) {
        assertSqlCount("call", expectedCallCount, getQueryCounts().getCallCount());
    }

    private static void assertSqlCount(String statement, int expectedCount, int actualCount) {
        if (expectedCount != actualCount) {
            throw new SqlCountMismatchException(statement, expectedCount, actualCount);
        }
    }
}
