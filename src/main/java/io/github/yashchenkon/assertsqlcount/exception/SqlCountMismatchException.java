package io.github.yashchenkon.assertsqlcount.exception;

/**
 * @author Mykola Yashchenko
 */
public class SqlCountMismatchException extends RuntimeException {

    public SqlCountMismatchException(final String statement, final int expectedCount, final int actualCount) {
        super("Expected " + statement + " query count: " + expectedCount + ", actual: " + actualCount);
    }
}
