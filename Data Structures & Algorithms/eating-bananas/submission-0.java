class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);

        int left = 1;
        int right = piles[piles.length-1];

        int answer = 0;
        while(left <= right){
            // k를 mid로 설정
            int mid = (left + right) / 2;

            // 모든 바나나를 먹는 데 h안에 먹을 수 있는지 확인
            if(isPossibleEat(mid, h, piles)){
                answer = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return answer;
    }

    boolean isPossibleEat(int k, int h, int[] piles){
        int sum = 0;
        for(int pile : piles){
            sum += (pile / k) + (pile % k > 0 ? 1 : 0);
            if(sum > h) return false;
        }
        return true;
    }
}
