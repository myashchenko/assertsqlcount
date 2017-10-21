package io.github.yashchenkon.assertsqlcount.types;

import lombok.Getter;

/**
 * @author Mykola Yashchenko
 */
@Getter
public class QueryCounts {
    private int selectCount;
    private int insertCount;
    private int updateCount;
    private int deleteCount;
    private int callCount;

    public void incrementSelect() {
        selectCount++;
    }

    public void incrementInsert() {
        insertCount++;
    }

    public void incrementUpdate() {
        updateCount++;
    }

    public void incrementDelete() {
        deleteCount++;
    }

    public void incrementCall() {
        callCount++;
    }
}
