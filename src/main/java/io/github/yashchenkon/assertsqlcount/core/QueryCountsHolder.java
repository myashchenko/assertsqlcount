package io.github.yashchenkon.assertsqlcount.core;

import io.github.yashchenkon.assertsqlcount.types.QueryCounts;

import static java.lang.ThreadLocal.withInitial;

/**
 * @author Mykola Yashchenko
 */
public class QueryCountsHolder {

    private static final ThreadLocal<QueryCounts> QUERY_COUNTS_HOLDER = withInitial(QueryCounts::new);

    public static QueryCounts getQueryCounts() {
        return QUERY_COUNTS_HOLDER.get();
    }

    public static void clear() {
        QUERY_COUNTS_HOLDER.set(new QueryCounts());
    }
}
