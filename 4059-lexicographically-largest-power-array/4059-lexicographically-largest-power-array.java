class Solution {
    public int[] largestPower(int[] nums) 
    {
        List<Integer> list = new ArrayList<>();
        for (int x : nums) {
            list.add(x);
        }
        
        boolean[] bitAlive = new boolean[15];
        Arrays.fill(bitAlive, true);
        
        List<Integer> sorted = solve(list, 14, bitAlive);
        
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = sorted.get(i);
        }
        
        int[] power = new int[15];
        for (int k = 0; k < 15; k++) {
            int bit = 14 - k;
            int j = 0;
            while (j < ans.length && ((ans[j] >> bit) & 1) == 1) {
                j++;
            }
            power[k] = j;
        }
        return power;
    }
    
    private List<Integer> solve(List<Integer> list, int bitIdx, boolean[] bitAlive) {
        if (list.size() <= 1 || bitIdx < 0) {
            return list;
        }
        
        int targetBit = -1;
        for (int b = bitIdx; b >= 0; b--) {
            if (bitAlive[b]) {
                int onesCount = 0;
                for (int x : list) {
                    if (((x >> b) & 1) == 1) onesCount++;
                }
                if (onesCount > 0 && onesCount < list.size()) {
                    targetBit = b;
                    break;
                }
            }
        }
        if (targetBit == -1) {
            return list;
        }
        
        List<Integer> ones = new ArrayList<>();
        List<Integer> zeros = new ArrayList<>();
        for (int x : list) {
            if (((x >> targetBit) & 1) == 1) {
                ones.add(x);
            } else {
                zeros.add(x);
            }
        }
        boolean[] firstAlive = bitAlive.clone();
        List<Integer> sortedFirst = solve(ones, targetBit - 1, firstAlive);
        
        boolean[] secondAlive = bitAlive.clone();
        secondAlive[targetBit] = false;
        for (int b = 14; b >= 0; b--) {
            if (secondAlive[b]) {
                for (int x : sortedFirst) {
                    if (((x >> b) & 1) == 0) {
                        secondAlive[b] = false;
                        break;
                    }
                }
            }
        }
        
        List<Integer> sortedSecond = solve(zeros, targetBit - 1, secondAlive);
        
        List<Integer> result = new ArrayList<>(sortedFirst);
        result.addAll(sortedSecond);
        return result;
        
    }
}