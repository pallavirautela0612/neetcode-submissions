class Solution {
    public int leastInterval(char[] tasks, int n) {

        // Count the frequency of each uppercase English letter task (A-Z)
        int[] taskFreq = new int[26];
        for (char ch : tasks) {

            taskFreq[ch - 'A']++;
        }

        // Initialize a Max-Heap so we always process the most frequent task first.
        // Greedily schdling the most frequent tasks helps minimize total idle time.
        PriorityQueue<Integer> maxHeap = 
                                new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for (int freq : taskFreq) {

            if (freq > 0) {

                maxHeap.add(freq);
            }
        }

        // Initialize a queue to hold tasks currently in cooldown.
        // stores array of [remaining_frequency, available_when_at_this_cycle]
        Queue<int[]> coolDownQueue = new LinkedList<>();
        int cycles = 0;

        // Continue the simulation as long as there are tasks waiting to run 
        // or stuck in the cooldown queue.
        while (!maxHeap.isEmpty() || !coolDownQueue.isEmpty()) {

            // Increment at every iteration, either CPU is processing or sitting idle
            cycles++;

            // Check if task at front of the cooldown queue has finished waiting.
            // If its release time matches the current cycle, move it back into heap.
            if (!coolDownQueue.isEmpty() && coolDownQueue.peek()[1] == cycles) {

                maxHeap.add(coolDownQueue.poll()[0]);
            }

            if (!maxHeap.isEmpty()) {

                int task = maxHeap.poll();
                task--;
                
                // If task still has instances left, send it to the cooldown queue.
                // It becomes available at (current cycle + n + 1) to account for 
                // 'n' full cooling slots.
                if (task > 0) {
                    coolDownQueue.add(new int[] {task, cycles + n + 1});
                }
            }
        }
        return cycles;
    }
}
