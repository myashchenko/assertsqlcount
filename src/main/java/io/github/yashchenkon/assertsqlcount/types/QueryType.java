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

package io.github.yashchenkon.assertsqlcount.types;

/**
 * Query types.
 *
 * @author Mykola Yashchenko
 */
public enum QueryType {
    SELECT {
        @Override
        public void process(final QueryCounts queryCounts) {
            queryCounts.incrementSelect();
        }
    },
    UPDATE {
        @Override
        public void process(final QueryCounts queryCounts) {
            queryCounts.incrementUpdate();
        }
    },
    DELETE {
        @Override
        public void process(final QueryCounts queryCounts) {
            queryCounts.incrementDelete();
        }
    },
    INSERT {
        @Override
        public void process(final QueryCounts queryCounts) {
            queryCounts.incrementInsert();
        }
    },
    CALL {
        @Override
        public void process(final QueryCounts queryCounts) {
            queryCounts.incrementCall();
        }
    };

    /**
     * Increments specific counter.
     *
     * @param queryCounts - counters holder
     */
    public abstract void process(final QueryCounts queryCounts);

    /**
     * Detects the type of the specific query.
     *
     * @param query - SQL query
     * @return query type
     */
    public static QueryType getQueryType(final String query) {
        final String trimmedQuery = removeRedundantSymbols(query.toLowerCase());
        final char firstChar = trimmedQuery.charAt(0);

        final QueryType type;
        switch (firstChar) {
            case 'w':
            case 's':
                type = QueryType.SELECT;
                break;
            case 'i':
                type = QueryType.INSERT;
                break;
            case 'u':
                type = QueryType.UPDATE;
                break;
            case 'd':
                type = QueryType.DELETE;
                break;
            case 'c':
            case '?':
                type = QueryType.CALL;
                break;
            default:
                throw new AssertionError("Unknown QueryType");
        }
        return type;
    }

    private static String removeRedundantSymbols(final String query) {
        return query
                .replaceAll("--.*\n", "")
                .replaceAll("\n", "")
                .replaceAll("/\\*.*\\*/", "")
                .trim();
    }
}
