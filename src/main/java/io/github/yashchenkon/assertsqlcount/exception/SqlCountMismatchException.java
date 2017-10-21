package io.github.yashchenkon.assertsqlcount.exception;

/**
 * @author Mykola Yashchenko
 */
public class SqlCountMismatchException extends RuntimeException {

    public SqlCountMismatchException(String statement, int expectedCount, int actualCount) {
        super("Expected " + statement + " query count: " + expectedCount + ", actual: " + actualCount);
    }
}
