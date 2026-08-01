class Solution {
    public int maximumWidth(int[] planks) {
        int maxVal = 0;
        for (int p : planks) {
            if (p > maxVal) {
                maxVal = p;
            }
        }
        if (maxVal <= 200000) {
            int[] freq = new int[maxVal + 1];
            for (int p : planks) {
                freq[p]++;
            }

            List<Integer> uniqueHeights = new ArrayList<>();
            for (int i = 1; i <= maxVal; i++) {
                if (freq[i] > 0) {
                    uniqueHeights.add(i);
                }
            }

            int[] pairCounts = new int[2 * maxVal + 1];
            int uSize = uniqueHeights.size();

            for (int i = 0; i < uSize; i++) {
                int h1 = uniqueHeights.get(i);
                int count1 = freq[h1];

                pairCounts[2 * h1] += count1 / 2;

                for (int j = i + 1; j < uSize; j++) {
                    int h2 = uniqueHeights.get(j);
                    int count2 = freq[h2];
                    pairCounts[h1 + h2] += Math.min(count1, count2);
                }
            }

            int maxWidth = 0;
            for (int H = 1; H <= 2 * maxVal; H++) {
                int single = (H <= maxVal) ? freq[H] : 0;
                int total = single + pairCounts[H];
                if (total > maxWidth) {
                    maxWidth = total;
                }
            }

            return maxWidth;
        } else {
            Map<Integer, Integer> freq = new HashMap<>();
            for (int p : planks) {
                freq.put(p, freq.getOrDefault(p, 0) + 1);
            }

            List<Integer> uniqueHeights = new ArrayList<>(freq.keySet());
            Map<Integer, Integer> pairCounts = new HashMap<>();
            int uSize = uniqueHeights.size();

            for (int i = 0; i < uSize; i++) {
                int h1 = uniqueHeights.get(i);
                int count1 = freq.get(h1);

                if (count1 >= 2) {
                    pairCounts.put(2 * h1, pairCounts.getOrDefault(2 * h1, 0) + count1 / 2);
                }

                for (int j = i + 1; j < uSize; j++) {
                    int h2 = uniqueHeights.get(j);
                    int count2 = freq.get(h2);
                    pairCounts.put(h1 + h2, pairCounts.getOrDefault(h1 + h2, 0) + Math.min(count1, count2));
                }
            }

            Set<Integer> allHeights = new HashSet<>(freq.keySet());
            allHeights.addAll(pairCounts.keySet());

            int maxWidth = 0;
            for (int H : allHeights) {
                int total = freq.getOrDefault(H, 0) + pairCounts.getOrDefault(H, 0);
                if (total > maxWidth) {
                    maxWidth = total;
                }
            }

            return maxWidth;
        }
    }
}