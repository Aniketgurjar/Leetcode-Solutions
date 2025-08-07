class Pair {
    int position;
    int speed;

    public Pair(int position, int speed) {
        this.position = position;
        this.speed = speed;
    }

    public int getPosition() {
        return position;
    }

    public int getSpeed() {
        return speed;
    }
}

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;

        List<Pair> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cars.add(new Pair(position[i], speed[i]));
        }

        // Sort by position ascending
        cars.sort(Comparator.comparingInt(Pair::getPosition));

        int fleets = 0;
        double time = 0.0;

        
        for (int i = n - 1; i >= 0; i--) {
            Pair car = cars.get(i);
            double arrivalTime = (double)(target - car.getPosition()) / car.getSpeed();

            if (arrivalTime > time) {
                fleets++;
                time = arrivalTime;
            }
        }

        return fleets;
    }
}
