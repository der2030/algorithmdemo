package der.algorithm.datastruts;
/** 
* @FileName:BinaryTreeNode
* @Description: 
* @Author: Derrick Ye
*/
public class BinaryTreeNode <T extends Comparable<T>>{

    T key;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;
    BinaryTreeNode<T> parent;

    public BinaryTreeNode(T key,BinaryTreeNode<T> parent,BinaryTreeNode<T> left,BinaryTreeNode<T> right){
        this.key=key;
        this.left=left;
        this.right=right;
        this.parent=parent;

    }

    public T getKey() {
        return key;
    }

    public String toString() {
        return "key:"+key;
    }

}
