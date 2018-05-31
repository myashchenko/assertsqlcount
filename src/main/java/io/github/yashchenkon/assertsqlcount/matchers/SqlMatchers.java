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

package io.github.yashchenkon.assertsqlcount.matchers;

import java.util.function.Function;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

import io.github.yashchenkon.assertsqlcount.core.QueryCountsHolder;
import io.github.yashchenkon.assertsqlcount.types.QueryCounts;

/**
 * Matchers for the tests.
 *
 * @author Mykola Yashchenko
 */
public class SqlMatchers {

    private SqlMatchers() {}

    /**
     * Returns current query count object.
     *
     * @return query count object
     */
    public static QueryCounts queryCounts() {
        return QueryCountsHolder.getQueryCounts();
    }

    /**
     * Matcher that verifies select count.
     *
     * @param expectedCount - expected count
     * @return matcher
     */
    public static BaseQueryCountsMatcher hasSelectCount(final int expectedCount) {
        return new BaseQueryCountsMatcher(QueryCounts::getSelectCount, expectedCount);
    }

    /**
     * Matcher that verifies update count.
     *
     * @param expectedCount - expected count
     * @return matcher
     */
    public static BaseQueryCountsMatcher hasUpdateCount(final int expectedCount) {
        return new BaseQueryCountsMatcher(QueryCounts::getUpdateCount, expectedCount);
    }

    /**
     * Matcher that verifies delete count.
     *
     * @param expectedCount - expected count
     * @return matcher
     */
    public static BaseQueryCountsMatcher hasDeleteCount(final int expectedCount) {
        return new BaseQueryCountsMatcher(QueryCounts::getDeleteCount, expectedCount);
    }

    /**
     * Matcher that verifies insert count.
     *
     * @param expectedCount - expected count
     * @return matcher
     */
    public static BaseQueryCountsMatcher hasInsertCount(final int expectedCount) {
        return new BaseQueryCountsMatcher(QueryCounts::getInsertCount, expectedCount);
    }

    /**
     * Matcher that verifies call count.
     *
     * @param expectedCount - expected count
     * @return matcher
     */
    public static BaseQueryCountsMatcher hasCallCount(final int expectedCount) {
        return new BaseQueryCountsMatcher(QueryCounts::getCallCount, expectedCount);
    }

    /**
     * Matcher class to verify counter.
     */
    public static class BaseQueryCountsMatcher extends BaseMatcher<QueryCounts> {

        private final Function<QueryCounts, Integer> getter;
        private final int expectedCount;

        public BaseQueryCountsMatcher(final Function<QueryCounts, Integer> getter, final int expectedCount) {
            this.getter = getter;
            this.expectedCount = expectedCount;
        }

        @Override
        public boolean matches(final Object o) {
            if (o == null) {
                throw new NullPointerException();
            }

            final QueryCounts queryCounts = (QueryCounts) o;

            return getter.apply(queryCounts) == expectedCount;
        }

        @Override
        public void describeTo(final Description description) {
            description.appendText("Expected : ").appendValue(expectedCount);
        }
    }
}
