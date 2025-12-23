package com.k2.ex1;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class TwoSumTest {

    @Test
    public void testHappyPath() {
        TwoSum solver = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] expected = {0, 1};
        assertArrayEquals(expected, solver.twoSum(nums, target));
    }

    @Test
    public void testMinimalArray() {
        TwoSum solver = new TwoSum();
        int[] nums = {3, 3};
        int target = 6;
        int[] expected = {0, 1};
        assertArrayEquals(expected, solver.twoSum(nums, target));
    }

    @Test
    public void testNoSolution() {
        TwoSum solver = new TwoSum();
        int[] nums = {1, 2, 3};
        int target = 7;
        // Current implementation returns {-1, -1} when no pair found
        int[] expected = {-1, -1};
        assertArrayEquals(expected, solver.twoSum(nums, target));
    }

    @Test
    public void testLargeArrayPerformance() {
        TwoSum solver = new TwoSum();
        final int n = 100_000; // large but reasonable for test environments
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }
        final int smallIndex = 10;
        final int largeIndex = n - 1;
        int target = nums[smallIndex] + nums[largeIndex];

        // ensure the operation completes within 2 seconds and returns a correct pair
        assertTimeout(Duration.ofSeconds(2), () -> {
            int[] res = solver.twoSum(nums, target);
            assertNotNull(res, "Result should not be null");
            assertEquals(2, res.length, "Result must contain two indices");
            int i = res[0];
            int j = res[1];
            assertTrue(i >= 0 && i < n, "Index i out of bounds: " + i);
            assertTrue(j >= 0 && j < n, "Index j out of bounds: " + j);
            assertNotEquals(i, j, "Indices should be distinct");
            assertEquals(target, nums[i] + nums[j], "Values at returned indices must sum to target");
        });
    }
}
