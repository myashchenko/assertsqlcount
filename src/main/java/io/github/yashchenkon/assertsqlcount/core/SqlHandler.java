package io.github.yashchenkon.assertsqlcount.core;

/**
 * @author Mykola Yashchenko
 */
public interface SqlHandler {
    void handle(String sqlStatement);
}
