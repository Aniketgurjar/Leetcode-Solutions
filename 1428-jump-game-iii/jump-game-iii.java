
class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        int[] vis = new int[n]; // 0 = not visited, -1 = visited

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis[start] = -1; // mark as visited when adding to queue

        while (!q.isEmpty()) {
            int k = q.poll();

            if (arr[k] == 0) {
                return true;
            }

            int choice1 = k + arr[k];
            int choice2 = k - arr[k];

            if (choice1 >= 0 && choice1 < n && vis[choice1] == 0) {
                vis[choice1] = -1;
                q.add(choice1);
            }
            if (choice2 >= 0 && choice2 < n && vis[choice2] == 0) {
                vis[choice2] = -1;
                q.add(choice2);
            }
        }
        return false;
    }
}
