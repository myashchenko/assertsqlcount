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

package io.github.yashchenko.assertsqlcount.types;

import org.junit.jupiter.api.Test;

import io.github.yashchenkon.assertsqlcount.types.QueryCounts;
import io.github.yashchenkon.assertsqlcount.types.QueryType;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Mykola Yashchenko
 */
public class QueryTypeTest {

    @Test
    public void shouldIncrementAppropriateCounts() {
        QueryCounts queryCounts = new QueryCounts();

        QueryType.CALL.process(queryCounts);
        assertEquals(1, queryCounts.getCallCount());

        QueryType.INSERT.process(queryCounts);
        assertEquals(1, queryCounts.getInsertCount());

        QueryType.UPDATE.process(queryCounts);
        assertEquals(1, queryCounts.getUpdateCount());

        QueryType.DELETE.process(queryCounts);
        assertEquals(1, queryCounts.getDeleteCount());

        QueryType.SELECT.process(queryCounts);
        assertEquals(1, queryCounts.getSelectCount());
    }

    @Test
    public void shouldParseQuery() {
        String selectStatement = "SELECT * FROM Table";
        assertEquals(QueryType.SELECT, QueryType.getQueryType(selectStatement));

        String updateStatement = "UPDATE Table SET col = 1";
        assertEquals(QueryType.UPDATE, QueryType.getQueryType(updateStatement));

        String insertStatement = "INSERT INTO Table (col1, col2) VALUES (1, 2)";
        assertEquals(QueryType.INSERT, QueryType.getQueryType(insertStatement));

        String deleteStatement = "DELETE FROM Table WHERE id = 1";
        assertEquals(QueryType.DELETE, QueryType.getQueryType(deleteStatement));

        String callStatement = "call procedure1(arg1, arg2)";
        assertEquals(QueryType.CALL, QueryType.getQueryType(callStatement));
    }
}
