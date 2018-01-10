package der.algorithm.datastruts;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
* @FileName:BinaryTreeTest
* @Description:
* @Author: Derrick Ye
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BinaryTreeTest {

    @Test
    public void btOrderTest(){
        int[] data={20,12,33,7,10,89,6,45,9,32,5};
        int len;
        BinaryTree<Integer> tree=new BinaryTree<>();

        System.out.print("==Append one by one: ");
        len = data.length;
        for(int i=0; i<len; i++) {
            System.out.print(data[i]+" ");
            tree.insert(data[i]);
        }

        System.out.print("\n== Preorder Traversal: ");
        tree.preOrder();

        System.out.print("\n== Inorder Traversal: ");
        tree.inOrder();

        System.out.print("\n== Postorder Traversal: ");
        tree.postOrder();
        System.out.println();

        System.out.println("== The minimum value is  "+ tree.minimum());
        System.out.println("== The maximum value is: "+ tree.maximum());
        System.out.println("== The details of Binary Tree: ");
        tree.print();

        System.out.print("\n== Delete node: "+ data[3]);
        tree.remove(data[3]);

        System.out.print("\n== Inorder Traversal: ");
        tree.inOrder();
        System.out.println();

        // 销毁二叉树
        tree.clear();
    }
}
