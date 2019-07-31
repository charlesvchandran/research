// https://leetcode.com/discuss/interview-question/346626/Google-or-Phone-Screen-or-Single-Element
public class Main {

    public static int singleElement(int... nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            int rightLen = hi - mid + 1;

            // odd
            if ((rightLen & 1) == 1) {
                if (nums[mid] == nums[mid + 1]) {
                    lo = mid + 2;
                } else {
                    hi = mid;
                }
            }
            // even
            else {
                if (nums[mid] == nums[mid + 1]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }
        return nums[lo];
    }

    public static void main(String[] args) {
        test(singleElement(2, 2, 1), 1);
        test(singleElement(2, 1, 1), 2);
        test(singleElement(2, 2, 1, 1, 3), 3);
        test(singleElement(2, 2, 3, 1, 1), 3);
        test(singleElement(3, 2, 2, 1, 1), 3);
        test(singleElement(2, 2, 1, 1, 9, 9, 5, 2, 2), 5);
        test(singleElement(0, 2, 2, 1, 1, 7, 7, 9, 9), 0);
        test(singleElement(2, 2, 0, 1, 1, 7, 7, 9, 9), 0);
        test(singleElement(2, 2, 1, 1, 0, 7, 7, 9, 9), 0);
        test(singleElement(2, 2, 1, 1, 7, 7, 0, 9, 9), 0);
        test(singleElement(2, 2, 1, 1, 7, 7, 9, 9, 0), 0);
    }

    private static void test(int actual, int expected) {
        if (actual == expected) {
            System.out.println("PASSED!");
        } else {
            System.out.println(String.format("FAILED! Expected: %d, but got: %d", expected, actual));
        }
    }
}