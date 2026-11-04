class Solution {
    public int[][] kClosest(int[][] points, int k) {

        // 1. Create a Max-Heap using a custom comparator, we compare (b, a) 
        // instead of (a, b) so the point with the LARGEST distance 
        // stays at the top of the heap (Max-Heap behavior).
        
        // 2. Euclidean distance from origin (0,0): 
        // Standard formula: sqrt((x - 0)^2 + (y - 0)^2)
        // Simplified to: x^2 + y^2 (substracting 0 does nothing, 
        // and sqrt is skipped because relative order remains the same)
        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(
                        (b[0]*b[0] + b[1]*b[1]), // Distance of point B
                        (a[0]*a[0] + a[1]*a[1]) // Distance of point A
        ));

        for(int[] point : points) {
            
            maxHeap.add(point);
            if (maxHeap.size() > k) {

                maxHeap.poll();
            }
        }

        int[][] res = new int[k][];
        int count = 0;
        while (!maxHeap.isEmpty() && count < k) {

            res[count] = maxHeap.poll();
            count++;
        }
        return res;
    }
}
