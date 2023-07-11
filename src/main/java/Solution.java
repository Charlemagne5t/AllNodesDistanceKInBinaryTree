import java.util.*;

public class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        int targetValue = target.val;
        dfsBuildGraph(root, graph);

        return bfs(graph, targetValue, k);
    }

    private List<Integer> bfs(Map<Integer, List<Integer>> graph, int targetValue, int k) {
        List<Integer> result = new ArrayList<>();
        int level = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(targetValue);
        Set<Integer> visited = new HashSet<>();

        while (!queue.isEmpty() && level <= k) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                visited.add(current);
                if (level == k) {
                    result.add(current);
                }
                List<Integer> neighbours = graph.get(current);
                for (int j = 0; j < neighbours.size(); j++) {
                    if (!visited.contains(neighbours.get(j))) {
                        queue.add(neighbours.get(j));
                    }
                }
            }
            level++;
        }
        return result;
    }

    private void dfsBuildGraph(TreeNode root, Map<Integer, List<Integer>> graph) {
        if (root == null) {
            return;
        }
        if (!graph.containsKey(root.val)) {
            graph.put(root.val, new ArrayList<>());
        }

        if (root.left != null && !graph.containsKey(root.left.val)) {
            graph.put(root.left.val, new ArrayList<>());
        }
        if (root.left != null) {
            graph.get(root.left.val).add(root.val);
            graph.get(root.val).add(root.left.val);
        }

        dfsBuildGraph(root.left, graph);

        if (root.right != null && !graph.containsKey(root.right.val)) {
            graph.put(root.right.val, new ArrayList<>());
        }
        if (root.right != null) {
            graph.get(root.right.val).add(root.val);
            graph.get(root.val).add(root.right.val);
        }
        dfsBuildGraph(root.right, graph);
    }
}
