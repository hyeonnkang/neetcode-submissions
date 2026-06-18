class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> num = new ArrayDeque<>();
        for(String token : tokens){
            if(token.equals("+")
             || token.equals("*")
             || token.equals("-")
             || token.equals("/")){
                int sec = num.pollLast();
                int fir = num.pollLast();
                switch(token){
                    case "+" : num.addLast(fir + sec); break;
                    case "-" : num.addLast(fir - sec); break;
                    case "*" : num.addLast(fir * sec); break;
                    case "/" : num.addLast(fir / sec); break;
                }

                continue;
            }
            num.addLast(Integer.parseInt(token));
        }
        return num.pollLast();
    }
}
