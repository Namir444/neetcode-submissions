

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequency of each number
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create buckets where index = frequency
        // Max frequency can be nums.length, so array size is nums.length + 1
        List<Integer>[] freq = new List[nums.length + 1];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int num = entry.getKey();
            int frequency = entry.getValue();
            freq[frequency].add(num);
        }

        // Step 3: Iterate from highest frequency bucket down to lowest
        int[] result = new int[k];
        int index = 0;

        for (int i = freq.length - 1; i >= 0 && index < k; i--) {
            for (int num : freq[i]) {
                result[index++] = num;
                if (index == k) {
                    return result;
                }
            }
        }

        return result;
    }
}
