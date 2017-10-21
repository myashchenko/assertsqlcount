package io.github.yashchenko.assertsqlcount.types;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.github.yashchenkon.assertsqlcount.types.QueryCounts;

/**
 * @author Mykola Yashchenko
 */
public class QueryCountsTest {

    @Test
    public void shouldIncrementValues() {
        QueryCounts queryCounts = new QueryCounts();
        queryCounts.incrementSelect();
        queryCounts.incrementCall();
        queryCounts.incrementInsert();
        queryCounts.incrementDelete();
        queryCounts.incrementUpdate();

        Assertions.assertEquals(1, queryCounts.getCallCount());
        Assertions.assertEquals(1, queryCounts.getSelectCount());
        Assertions.assertEquals(1, queryCounts.getInsertCount());
        Assertions.assertEquals(1, queryCounts.getDeleteCount());
        Assertions.assertEquals(1, queryCounts.getUpdateCount());
    }
}
