 class DoubleLinkedList{
    public static class Node{
        int data;
        Node next;
        Node prev;
        Node(int d){
            prev=null;
            data=d;
            next=null;

        }

    }
    public static Node head;
    public static void printDLL(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"<->");
            temp=temp.next;    
        }
        System.out.print("null");
    }
    public static Node reverse(){
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp=temp.prev;
         return temp;
    }
    public  static void main(String[] args){
        head=new Node(10);
        head.next=new Node(20);
        head.next.next=new Node(30);
        head.next.next.next=new Node(40);
        head.next.next.next.next=new Node(50);
        head.prev=null;
        head.next.prev=head;
        head.next.next.prev=head.next;
        head.next.next.next.prev=head.next.next;
        head.next.next.next.next.prev=head.next.next.next;
        printDLL();
        head=reverse();
        printDLL();



    }

}