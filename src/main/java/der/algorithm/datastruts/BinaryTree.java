package der.algorithm.datastruts;
/**
* @FileName:BinaryTree
* @Description:
* @Author: Derrick Ye
*/
public class BinaryTree <T extends Comparable<T>>{

    private BinaryTreeNode<T> btRoot;

    public BinaryTree(){
        btRoot=null;
    }

    /**
     * insert node into the binary tree
     * @param bTree the given binary tree
     * @param newNode the inserted node
     */
    public void insert(BinaryTree<T> bTree,BinaryTreeNode<T> newNode){
        int res;
        BinaryTreeNode<T> tempNode=null;
        BinaryTreeNode<T> node=bTree.btRoot;

        while(node!=null){
            tempNode=node;
            res=newNode.key.compareTo(node.key);
            if(res<0){
                node=node.left;
            }else{
                node=node.right;
            }
        }

        newNode.parent=tempNode;
        if(tempNode==null)
            bTree.btRoot=newNode;
        else{
            res=newNode.key.compareTo(tempNode.key);
            if(res<0)
                tempNode.left=newNode;
            else
                tempNode.right=newNode;
        }
    }

    /**
     * create new node and insert into the binary tree
     * @param key  the value of the inserted node
     */
    public void insert(T key){
        BinaryTreeNode<T> newNode=new BinaryTreeNode<>(key,null,null,null);
        if(newNode!=null)
            insert(this,newNode);
    }

    /**
     * print the binary tree
     * @param tree  the binary tree
     * @param key  the value of the node
     * @param direction -0 represents the root node
     *                    -1 represents the left chile of the parent node
     *                    1  represents  the right child of the parent node
     */
    private void print(BinaryTreeNode<T> tree, T key, int direction) {

        if(tree != null) {

            if(direction==0)
                System.out.printf("%2d is root\n", tree.key);
            else
                System.out.printf("%2d is %2d's %6s child\n", tree.key, key, direction==1?"right" : "left");

            print(tree.left, tree.key, -1);
            print(tree.right,tree.key,  1);
        }
    }

    public void print() {
        if (btRoot != null)
            print(btRoot, btRoot.key, 0);
    }

    /**
     * find the nod by the given key value in the binary tree
     * @param x
     * @param key
     * @return
     */
    private BinaryTreeNode<T> search(BinaryTreeNode<T> x, T key) {
        if (x==null)
            return x;

        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return search(x.left, key);
        else if (cmp > 0)
            return search(x.right, key);
        else
            return x;
    }

    public BinaryTreeNode<T> search(T key) {
        return search(btRoot, key);
    }

    /**
     * Preorder traverses the binary tree
     * @param tree
     */
    private void preOrder(BinaryTreeNode<T> tree) {
        if(tree != null) {
            System.out.print(tree.key+" ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    public void preOrder() {
        preOrder(btRoot);
    }

    /**
     * Inorder traverses the binary tree
     * @param tree
     */
    private void inOrder(BinaryTreeNode<T> tree) {
        if(tree != null) {
            inOrder(tree.left);
            System.out.print(tree.key+" ");
            inOrder(tree.right);
        }
    }

    public void inOrder() {
        inOrder(btRoot);
    }

    /**
     * Postorder traverses the binary tree
     * @param tree
     */
    private void postOrder(BinaryTreeNode<T> tree) {
        if(tree != null)
        {
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.print(tree.key+" ");
        }
    }

    public void postOrder() {
        postOrder(btRoot);
    }

    /**
     * find the minimum node
     * @param tree
     * @return
     */
    private BinaryTreeNode<T> minimum(BinaryTreeNode<T> tree) {
        if (tree == null)
            return null;

        while(tree.left != null)
            tree = tree.left;
        return tree;
    }

    public T minimum() {
        BinaryTreeNode<T> p = minimum(btRoot);
        if (p != null)
            return p.key;

        return null;
    }

    /**
     * find the maxmum node
     * @param tree
     * @return
     */
    private BinaryTreeNode<T> maximum(BinaryTreeNode<T> tree) {
        if (tree == null)
            return null;

        while(tree.right != null)
            tree = tree.right;
        return tree;
    }

    public T maximum() {
        BinaryTreeNode<T> p = maximum(btRoot);
        if (p != null)
            return p.key;

        return null;
    }

    /**
     * find the successor node of the given node
     * @param x
     * @return
     */
    public BinaryTreeNode<T> successor(BinaryTreeNode<T> x) {
        if (x.right != null)
            return minimum(x.right);
        BinaryTreeNode<T> y = x.parent;
        while ((y!=null) && (x==y.right)) {
            x = y;
            y = y.parent;
        }
        return y;
    }

    /**
     * find the predecessor node of the given node
     * @param x
     * @return
     */
    public BinaryTreeNode<T> predecessor(BinaryTreeNode<T> x) {

        if (x.left != null)
            return maximum(x.left);

        BinaryTreeNode<T> y = x.parent;
        while ((y!=null) && (x==y.left)) {
            x = y;
            y = y.parent;
        }

        return y;
    }

    /**
     * remove the given node in the binary tree
     * @param bst
     * @param z
     * @return
     */
    private BinaryTreeNode<T> remove(BinaryTree<T> bst, BinaryTreeNode<T> z) {
        BinaryTreeNode<T> x=null;
        BinaryTreeNode<T> y=null;

        if ((z.left == null) || (z.right == null) )
            y = z;
        else
            y = successor(z);

        if (y.left != null)
            x = y.left;
        else
            x = y.right;

        if (x != null)
            x.parent = y.parent;

        if (y.parent == null)
            bst.btRoot = x;
        else if (y == y.parent.left)
            y.parent.left = x;
        else
            y.parent.right = x;

        if (y != z)
            z.key = y.key;

        return y;
    }

    /**
     *
     * @param key
     */
    public void remove(T key) {
        BinaryTreeNode<T> z, node;

        if ((z = search(btRoot, key)) != null)
            if ( (node = remove(this, z)) != null)
                node = null;
    }

    /**
     * destroy the given binary tree
     * @param tree
     */
    private void destroy(BinaryTreeNode<T> tree) {
        if (tree==null)
            return ;

        if (tree.left != null)
            destroy(tree.left);
        if (tree.right != null)
            destroy(tree.right);

        tree=null;
    }

    public void clear() {
        destroy(btRoot);
        btRoot = null;
    }
}
