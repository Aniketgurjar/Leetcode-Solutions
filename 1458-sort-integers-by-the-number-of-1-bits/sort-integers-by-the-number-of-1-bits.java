import java.util.*;

public class Solution {
    public int[] sortByBits(int[] arr) {
      
        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(nums, (a, b) -> {
            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);
            if (countA == countB) {
                return a - b;
            } else {
                return countA - countB;
            }
        });

        
        return Arrays.stream(nums).mapToInt(Integer::intValue).toArray();
    }
}
