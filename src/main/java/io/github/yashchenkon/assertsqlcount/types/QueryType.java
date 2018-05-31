package io.github.yashchenkon.assertsqlcount.types;

/**
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

    public abstract void process(final QueryCounts queryCounts);

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
