package io.github.yashchenkon.assertsqlcount.test;

import io.github.yashchenkon.assertsqlcount.exception.SqlCountMismatchException;

import static io.github.yashchenkon.assertsqlcount.core.QueryCountsHolder.*;

/**
 * @author Mykola Yashchenko
 */
public class AssertSqlCount {
    public static void reset() {
        clear();
    }

    public static void assertSelectCount(final int expectedSelectCount) {
        assertSqlCount("select", expectedSelectCount, getQueryCounts().getSelectCount());
    }

    public static void assertUpdateCount(final int expectedUpdateCount) {
        assertSqlCount("update", expectedUpdateCount, getQueryCounts().getUpdateCount());
    }

    public static void assertInsertCount(final int expectedInsertCount) {
        assertSqlCount("insert", expectedInsertCount, getQueryCounts().getInsertCount());
    }

    public static void assertDeleteCount(final int expectedDeleteCount) {
        assertSqlCount("delete", expectedDeleteCount, getQueryCounts().getDeleteCount());

    }

    public static void assertCallCount(final int expectedCallCount) {
        assertSqlCount("call", expectedCallCount, getQueryCounts().getCallCount());
    }

    private static void assertSqlCount(final String statement, final int expectedCount, final int actualCount) {
        if (expectedCount != actualCount) {
            throw new SqlCountMismatchException(statement, expectedCount, actualCount);
        }
    }
}
