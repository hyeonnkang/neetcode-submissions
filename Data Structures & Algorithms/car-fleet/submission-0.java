class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Car[] cars = new Car[n];
        for(int i = 0; i < n; i++){
            cars[i] = new Car(position[i], speed[i]);
        }
        Arrays.sort(cars, (a, b) -> b.position - a.position);

        for(int i = 0; i < n; i++){
            cars[i].cost = (double)(target - cars[i].position) / cars[i].speed;
        }

        int answer = 0;
        double lastTime = -1.0;
        for(int i = 0; i < n; i++){
            if(cars[i].cost > lastTime) {
                answer++;
                lastTime = cars[i].cost;
            }
        }
        return answer;
    }

    class Car{
        int position;
        int speed;
        double cost;

        Car(int p, int s){
            position = p;
            speed = s;
        }
    }
}
