import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolutionTest {
    @Test
    public void distanceKTest1(){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode target = root.left;
        int k = 2;


        List<Integer> expected = new ArrayList<>(List.of(1,4,7));
        List<Integer> actual = new Solution().distanceK(root, target, k);
        Collections.sort(actual);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void distanceKTest2(){
        TreeNode root = new TreeNode(1);
        TreeNode target = root;
        int k = 3;

        List<Integer> expected = new ArrayList<>();
        List<Integer> actual = new Solution().distanceK(root, target, k);

        Assertions.assertEquals(expected, actual);
    }
}
