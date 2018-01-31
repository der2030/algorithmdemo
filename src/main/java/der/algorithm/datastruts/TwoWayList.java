package der.algorithm.datastruts;
/**
* @FileName:TwoWayList
* @Description: this class implements two-way linked list ; Each link references the previous link and
 *                 the next one
* @Author: Derrick Ye
*/

public class TwoWayList {

    private Node head;
    private Node tail;

    public TwoWayList() {
        this.head = null;
        this.tail=null;
    }

    /**
     * check if the list is empty
     * @return
     */
    public boolean isEmpty(){
        return (head==null);
    }

    /**
     * insert a new node at the head
     * @param data
     */
    public void insertHead(int data){
        Node newNode=new Node(data);
        if(isEmpty())
            tail=newNode;
        else
            head.previous=newNode;
        newNode.next=head;
        head=newNode;
    }

    /**
     * delete the head node
     */
    public Node deleteHead(){
        Node tempNode=head;
        head=head.next;
        if(head==null)
            tail=null;
        return tempNode;
    }

    /**
     * insert a new node at the tail
     * @param data
     */
    public void insertTail(int data){
        Node newNode=new Node(data);
        newNode.next=null;
        tail.next=newNode;
        newNode.previous=tail;
        tail=newNode;
    }

    /**
     * delete the tail node
     * @return
     */
    public Node deleteTail(){
        Node tempNode=tail;
        tail=tail.previous;
        tail.next=null;
        return tempNode;
    }

    /**
     * insert a new node somewhere and reorder by its data
     * @param data
     */
    public void insert(int data){
        Node newNode=new Node(data);
        Node tempNode=head;
        while (tempNode!=null && data>tempNode.data)
            tempNode=tempNode.next;
        if(tempNode==head)
            insertHead(data);
        else if (tempNode==null)
            insertTail(data);
        else{
            newNode.previous=tempNode.previous;
            tempNode.previous.next=newNode;
            newNode.next=tempNode;
            tempNode.previous=newNode;
        }
    }

    /**
     * delet the node form somewhere in the list
     * @param data
     * @return
     */
    public Node delete(int data){

        Node tempNode=head;
        while (tempNode.data!=data)
            tempNode=tempNode.next;

        if(tempNode==head)
            deleteHead();
        else if(tempNode==tail)
            deleteTail();
        else{
            tempNode.previous.next=tempNode.next;
            tempNode.next.previous=tempNode.previous;
        }
        return tempNode;
    }

    /**
     * show the list's data
     */
    public void showList(){
        Node tempNode=head;
        while (tempNode!=null){
            tempNode.showNode();
            tempNode=tempNode.next;
        }
        System.out.println();
    }

}


/**
 * this class is used to implement the node of two-way linked list
 */
class Node{

    public int data;
    public Node previous;
    public Node next;

    public Node(int data) {
        this.data = data;
    }

    public void showNode(){
        System.out.print(data+",");
    }

}
