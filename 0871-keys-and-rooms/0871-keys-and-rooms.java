class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // Idea: do DFS on the graph of rooms, saving which of rooms were lready visited
        // iterate through array of visited rooms and see if they all are there

        // '1' => visited, '0' => not visited
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        graphDfs(rooms, visited, 0);

        // iterate through array 'visited' to check if there are any unvisited rooms
        for (boolean v : visited) {
            if (!v)
                return false;
        }

        return true;
    }

    // help-function that does dfs-walkthrough the given graph, starting from 'currentRoom' and adding on each step rooms from the 'rooms'-subarrays
    private void graphDfs(List<List<Integer>> rooms, boolean[] visited, int currentRoom) {
        List<Integer> rm = rooms.get(currentRoom);
        for (int i = 0; i < rm.size(); i++) {
            // get key one-by-one from the currentRoom and mark corresponding rooms as 'visited'
            int key = (int) rm.get(i);
            // visit new room (by found key) only if we haven't visited it before
            if (!visited[key]) {
                visited[key] = true;
                // recursive call for each new room (corresponding to found keys)
                graphDfs(rooms, visited, key);
            }
        }
    }
}