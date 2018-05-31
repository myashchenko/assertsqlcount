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

package io.github.yashchenko.assertsqlcount.inspector;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.github.yashchenkon.assertsqlcount.inspector.QueryCountsInspector;
import io.github.yashchenkon.assertsqlcount.test.AssertSqlQueriesCount;

/**
 * @author Mykola Yashchenko
 */
public class QueryCountsInspectorTest {

    private QueryCountsInspector queryCountsInspector = new QueryCountsInspector();

    @BeforeEach
    public void before() {
        AssertSqlQueriesCount.reset();
    }

    @Test
    public void shouldIncrementCount() {
        String selectStatement = "SELECT * FROM Table";
        queryCountsInspector.inspect(selectStatement);
        queryCountsInspector.inspect(selectStatement);

        AssertSqlQueriesCount.assertSelectCount(2);
    }
}
