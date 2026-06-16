class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // value, 빈도수
        Map<Integer, Integer> map = new HashMap<>(); 
        for(int num : nums){
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num)+1);
        }

        // [값, 개수]
        // 개수가 큰 순, 숫자가 작은 순서로 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->{
            if(a[1] == b[1]) return a[0]-b[0];
            return b[1]-a[1];
        });
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            pq.offer(new int[]{e.getKey(), e.getValue()});
        }

        int[] answer = new int[k];
        int idx = 0;
        while(!pq.isEmpty() && idx < k){
            answer[idx++] = pq.poll()[0];
        }
        return answer;
    }
}
