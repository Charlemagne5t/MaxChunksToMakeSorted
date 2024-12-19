import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int maxChunksToSorted(int[] arr) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing((int[] a) -> a[0]));

        for (int i = 0; i < arr.length; i++) {
            int[] toAdd = new int[2];
            toAdd[0] = Math.min(arr[i], i);
            toAdd[1] = Math.max(arr[i], i);
            pq.offer(toAdd);
        }


        int c = 0;
        int end = -1;

        while (!pq.isEmpty()) {
            if (pq.peek()[0] > end) {
                c++;
                end = pq.poll()[1];
            } else {

                end = Math.max(end, pq.poll()[1]);
            }

        }
        return c;
    }
}