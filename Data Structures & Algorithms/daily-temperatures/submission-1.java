class Solution {
    int n;

    public int[] dailyTemperatures(int[] temperatures) {
        this.n = temperatures.length;

        int[] answer = new int[n];
        Arrays.fill(answer, 0);

        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = n-1; i >= 0; i--){
            // deque에 temperatures[i]보다 작거나 같은 숫자면 삭제
            while(!deque.isEmpty()){
                if(temperatures[deque.peekLast()] <= temperatures[i]){
                    deque.pollLast();
                    continue;
                }
                break;
            }
            // deque에 남은 숫자 저장
            if(!deque.isEmpty()){
                answer[i] = deque.peekLast() - i;
            }

            // 현재 숫자 추가
            deque.addLast(i);
        }
        return answer;
    }
}
