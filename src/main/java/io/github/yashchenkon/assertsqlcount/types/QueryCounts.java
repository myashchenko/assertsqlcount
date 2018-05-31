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

import lombok.Getter;

/**
 * Contains all specific counters.
 *
 * @author Mykola Yashchenko
 */
@Getter
public class QueryCounts {
    private int selectCount;
    private int insertCount;
    private int updateCount;
    private int deleteCount;
    private int callCount;

    /**
     * Increment select count.
     */
    public void incrementSelect() {
        selectCount++;
    }

    /**
     * Increment insert count.
     */
    public void incrementInsert() {
        insertCount++;
    }

    /**
     * Increment update count.
     */
    public void incrementUpdate() {
        updateCount++;
    }

    /**
     * Increment delete count.
     */
    public void incrementDelete() {
        deleteCount++;
    }

    /**
     * Increment call count.
     */
    public void incrementCall() {
        callCount++;
    }
}
