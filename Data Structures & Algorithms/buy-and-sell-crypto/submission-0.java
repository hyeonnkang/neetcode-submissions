class Solution {
    public int maxProfit(int[] prices) {
        // sufMax[i] : i 뒤에 있는 수 중 가장 최댓값
        int[] sufMax = new int[prices.length];
        sufMax[prices.length-1] = 0;
        for(int i = prices.length-2; i >= 0; i--){
            sufMax[i] = Math.max(prices[i+1], sufMax[i+1]);
        }

        int max = 0;
        for(int i = 0; i < prices.length; i++){
            max = Math.max(sufMax[i]-prices[i], max);
        }
        return max;
    }
}
