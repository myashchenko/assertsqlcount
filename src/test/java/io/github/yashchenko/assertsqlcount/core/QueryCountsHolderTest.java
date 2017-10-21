package io.github.yashchenko.assertsqlcount.core;

import org.junit.jupiter.api.Test;

import io.github.yashchenkon.assertsqlcount.core.QueryCountsHolder;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Mykola Yashchenko
 */
public class QueryCountsHolderTest {

    @Test
    public void shouldClearCounts() {
        QueryCountsHolder.getQueryCounts().incrementUpdate();
        assertEquals(1, QueryCountsHolder.getQueryCounts().getUpdateCount());

        QueryCountsHolder.clear();
        assertEquals(0, QueryCountsHolder.getQueryCounts().getUpdateCount());
    }
}
