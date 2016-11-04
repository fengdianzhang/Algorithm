/**
 * Copyright (C) 2016 Togic Corporation. All rights reserved.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fdz.algo.sort;

import java.util.ArrayList;
import java.util.List;

import com.algs4.stdlib.StdRandom;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by fengdianzhang on 16-11-4.
 */
public class SortTest {
    private final int[] array = new int[100];
    private final List<String> classNames = new ArrayList<>();

    @Before
    public void init() {
        classNames.add("com.fdz.algo.sort.Insertion");
        classNames.add("com.fdz.algo.sort.Selection");

        for (int i = 0; i < 100; i++) {
            array[i] = StdRandom.uniform(0, 100);
        }
    }

    @Test
    public void testSort() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        for (String name : classNames) {
            System.out.println("start to test " + name + "...");
            Class<?> clazz = Class.forName(name);
            Sort sorter = (Sort) clazz.newInstance();
            for (int i = 0; i < 3; i++) {
                StdRandom.shuffle(array);
                sorter.sort(array);
                assertTrue(i + 1 + "th failed...", isSorted(array));
                System.out.println(i + 1 + "th passed...");
            }
            System.out.println(name + " passed...\n");
        }
    }

    private boolean isSorted(int a[]) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) return false;
        }
        return true;
    }
}
