class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> maxHeap = 
                            new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {

            maxHeap.add(stone);
        }

        while(maxHeap.size() > 1) {

            int x = maxHeap.poll();
            int y = maxHeap.poll();

            if (x == y) {

                continue;
            } else if (x > y) {

                maxHeap.add(x-y);
            } else {

                maxHeap.add(y-x);
            }
        }

        return (maxHeap.isEmpty()) ? 0: maxHeap.peek();
    }
}
