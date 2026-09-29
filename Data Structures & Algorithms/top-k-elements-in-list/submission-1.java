class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequent = new HashMap<>();
        for (int i : nums) {
            if (frequent.containsKey(i)) {
                frequent.put(i, frequent.get(i) + 1);
            } else {
                frequent.put(i, 1);
            }
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(frequent.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = list.get(i).getKey();
        }

        return result;
    }
}
