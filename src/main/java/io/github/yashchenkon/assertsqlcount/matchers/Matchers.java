package io.github.yashchenkon.assertsqlcount.matchers;

import java.util.function.Function;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

import io.github.yashchenkon.assertsqlcount.core.QueryCountsHolder;
import io.github.yashchenkon.assertsqlcount.types.QueryCounts;

/**
 * @author Mykola Yashchenko
 */
public class Matchers {

    private Matchers() {}

    public static QueryCounts queryCounts() {
        return QueryCountsHolder.getQueryCounts();
    }

    public static BaseQueryCountsMatcher hasSelectCount(final int expectedCount) {
        return new BaseQueryCountsMatcher(QueryCounts::getSelectCount, expectedCount);
    }

    public static BaseQueryCountsMatcher hasUpdateCount(final int expectedCount) {
        return new BaseQueryCountsMatcher(QueryCounts::getUpdateCount, expectedCount);
    }

    public static BaseQueryCountsMatcher hasDeleteCount(final int expectedCount) {
        return new BaseQueryCountsMatcher(QueryCounts::getDeleteCount, expectedCount);
    }

    public static BaseQueryCountsMatcher hasInsertCount(final int expectedCount) {
        return new BaseQueryCountsMatcher(QueryCounts::getInsertCount, expectedCount);
    }

    public static BaseQueryCountsMatcher hasCallCount(final int expectedCount) {
        return new BaseQueryCountsMatcher(QueryCounts::getCallCount, expectedCount);
    }

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
