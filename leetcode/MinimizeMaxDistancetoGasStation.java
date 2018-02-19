import java.util.PriorityQueue;
import java.util.Comparator;

/*
On a horizontal number line, we have gas stations at positions stations[0], stations[1], ..., stations[N-1], where N = stations.length.

Now, we add K more gas stations so that D, the maximum distance between adjacent gas stations, is minimized.

Return the smallest possible value of D.

Example:

Input: stations = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], K = 9
Output: 0.500000
Note:

stations.length will be an integer in range [10, 2000].
stations[i] will be an integer in range [0, 10^8].
K will be an integer in range [1, 10^6].
Answers within 10^-6 of the true value will be accepted as correct.

*/

/*
*  Solution: Find the longest interval and insert the point, speed up by the sublevel max distance.
*
*  Corner Case: Too many point in one interval, we have to use the speed up.
*
*  Complexity: o(nlog(n))
*/

class MinimizeMaxDistancetoGasStation {
    class Interval {
        public int left;
        public int right;
        public int nums;
        public double getDistance() {
            return ((double)right - left) / (nums + 1);
        }
        
        public Interval(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
    
    public double minmaxGasDist(int[] stations, int K) {
        if (stations == null || stations.length < 2 || K < 0) {
            return -1;
        }
        
        PriorityQueue<Interval> pq = new PriorityQueue<>(new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                double diff = b.getDistance() - a.getDistance();
                if (diff < 0)
                    return -1;
                else if (diff > 0)
                    return 1;
                else
                    return 0;
            }
        });
        
        // speed up by the superlevel distance
        double unit = ((double)stations[stations.length - 1] - stations[0]) / (K + 1);
        
        for (int i = 0; i < stations.length - 1; i++) {
            Interval l = new Interval(stations[i], stations[i + 1]);
            l.nums = (int)((stations[i + 1] - stations[i]) / unit);
            K -= l.nums;    // subtract the used points
            pq.offer(l);
        }
        
        // insert the point greedily
        while (K > 0) {
            Interval l = pq.poll();
            l.nums++;
            pq.offer(l);
            K--;    // do not forget
        }
        
        return pq.poll().getDistance();
    }

    public static void main(String[] args) {
        MinimizeMaxDistancetoGasStation s = new MinimizeMaxDistancetoGasStation();
        System.out.println(s.minmaxGasDist(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 9));
    }
}