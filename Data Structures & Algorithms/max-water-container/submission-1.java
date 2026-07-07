class Solution {
    public int maxArea(int[] heights) {
        int answer = 0;
        int left = 0;
        int right = heights.length-1;
        while(left < right){
            int width = right - left;
            int area = Math.min(heights[left], heights[right]) * width;
            answer = Math.max(answer, area);

            if(heights[left] < heights[right]) left++;
            else right--;
        }
        return answer;
    }
}
