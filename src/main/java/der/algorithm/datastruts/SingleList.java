package der.algorithm.datastruts;
/**
* @FileName:SingleList
* @Description:  this class implements a single linked list
* @Author: Derrick Ye
*/
public class SingleList {

    private SLNode head;

    public SingleList(){
        head=null;
    }

    /**
     * insert an element at the head
     * @param v
     */
    public void insertHead(int v){
        SLNode newNode=new SLNode(v);
        newNode.next=head;
        head=newNode;
    }

    /**
     * insert a new node at a specific position
     * @param head
     * @param data
     * @param position
     * @return
     */
    public SLNode insertNode(SLNode head,int data,int position) {

        SLNode newNode=new SLNode(data);

        if (position==0){
            newNode.next=head;
            return newNode;
        }

        SLNode current=head;
        while(--position>0){
            current=current.next;
        }
        newNode.next=current.next;
        current.next=newNode;

        return head;
    }

    /**
     * delete an element at the head
     * @return
     */
    public SLNode deleteHead() {
        SLNode temp=head;
        head=head.next;
        return temp;
    }

    /**
     * check if the single list is empty
     * @return
     */
    public boolean isEmpty(){
        return (head==null);
    }

    /**
     * print the contents of the single list
     */
    public void printList(){
        SLNode current=head;
        while(current!=null){
            System.out.print(current.getValue()+" ");
            current=current.next;
        }
        System.out.println();
    }

    public SLNode getHead() {
        return head;
    }

}

/**
* @FileName:SingleList
* @Description: this class is the nodes of the single linked list
* @Author: Derrick Ye
*/
class SLNode{

   public int value;
   public SLNode next;

   public SLNode(){}

    public SLNode (int value) {
       this.value=value;
    }

    public int getValue() {
        return value;
    }

}
