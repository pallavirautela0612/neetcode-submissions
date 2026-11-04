class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<double[]> que = 
                        new PriorityQueue<>((a,b) -> Double.compare(a[0], b[0]));
        int[] origin = {0,0};

        for (int i = 0; i < points.length; i++) {

            int x1 = origin[0];     int y1 = origin[1];
            int x2 = points[i][0];  int y2 = points[i][1];

            // Calculate Euclidean distance
            Double distance = Math.sqrt(Math.pow((x1-x2), 2) + Math.pow((y1-y2), 2));

            // Store Distance & Index into queue; sorting on distance
            que.add(new double[]{distance, (double)i});
        }

        int[][] out = new int[k][];

        for (int i = 0; i < k; i++) {

            int idx = (int) que.poll()[1]; // Fetching the index of smallest distance
            out[i] = points[idx];
        }
        
        return out;
    }
}
