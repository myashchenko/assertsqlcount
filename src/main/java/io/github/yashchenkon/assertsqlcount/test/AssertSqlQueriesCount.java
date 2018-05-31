/*
 * MIT License
 *
 * Copyright (c) 2018 Mykola Yashchenko
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package io.github.yashchenkon.assertsqlcount.test;

import io.github.yashchenkon.assertsqlcount.exception.SqlCountMismatchException;

import static io.github.yashchenkon.assertsqlcount.core.QueryCountsHolder.*;

/**
 * Asserts for the counters.
 *
 * @author Mykola Yashchenko
 */
public class AssertSqlQueriesCount {

    /**
     * Resets all counters.
     */
    public static void reset() {
        clear();
    }

    /**
     * Verifies select counter.
     *
     * @param expectedSelectCount - expected counter value
     */
    public static void assertSelectCount(final int expectedSelectCount) {
        assertSqlCount("select", expectedSelectCount, getQueryCounts().getSelectCount());
    }

    /**
     * Verifies update counter.
     *
     * @param expectedUpdateCount - expected counter value
     */
    public static void assertUpdateCount(final int expectedUpdateCount) {
        assertSqlCount("update", expectedUpdateCount, getQueryCounts().getUpdateCount());
    }

    /**
     * Verifies insert counter.
     *
     * @param expectedInsertCount - expected counter value
     */
    public static void assertInsertCount(final int expectedInsertCount) {
        assertSqlCount("insert", expectedInsertCount, getQueryCounts().getInsertCount());
    }

    /**
     * Verifies delete counter.
     *
     * @param expectedDeleteCount - expected counter value
     */
    public static void assertDeleteCount(final int expectedDeleteCount) {
        assertSqlCount("delete", expectedDeleteCount, getQueryCounts().getDeleteCount());

    }

    /**
     * Verifies call counter.
     *
     * @param expectedCallCount - expected counter value
     */
    public static void assertCallCount(final int expectedCallCount) {
        assertSqlCount("call", expectedCallCount, getQueryCounts().getCallCount());
    }

    private static void assertSqlCount(final String statement, final int expectedCount, final int actualCount) {
        if (expectedCount != actualCount) {
            throw new SqlCountMismatchException(statement, expectedCount, actualCount);
        }
    }
}
