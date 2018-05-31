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
