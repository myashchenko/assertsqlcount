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

    public static BaseQueryCountsMatcher hasSelectCount(int expectedCount) {
        return new BaseQueryCountsMatcher(QueryCounts::getSelectCount, expectedCount);
    }

    public static BaseQueryCountsMatcher hasUpdateCount(int expectedCount) {
        return new BaseQueryCountsMatcher(QueryCounts::getUpdateCount, expectedCount);
    }

    public static BaseQueryCountsMatcher hasDeleteCount(int expectedCount) {
        return new BaseQueryCountsMatcher(QueryCounts::getDeleteCount, expectedCount);
    }

    public static BaseQueryCountsMatcher hasInsertCount(int expectedCount) {
        return new BaseQueryCountsMatcher(QueryCounts::getInsertCount, expectedCount);
    }

    public static BaseQueryCountsMatcher hasCallCount(int expectedCount) {
        return new BaseQueryCountsMatcher(QueryCounts::getCallCount, expectedCount);
    }

    public static class BaseQueryCountsMatcher extends BaseMatcher<QueryCounts> {

        private final Function<QueryCounts, Integer> getter;
        private final int expectedCount;

        public BaseQueryCountsMatcher(Function<QueryCounts, Integer> getter, int expectedCount) {
            this.getter = getter;
            this.expectedCount = expectedCount;
        }

        @Override
        public boolean matches(Object o) {
            if (o == null) {
                throw new NullPointerException();
            }

            QueryCounts queryCounts = (QueryCounts) o;

            return getter.apply(queryCounts) == expectedCount;
        }

        @Override
        public void describeTo(Description description) {

        }
    }
}
