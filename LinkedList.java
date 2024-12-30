/*import java.util.Arrays;
    public class ArrayList<T>{
        private static final int Initial_Capacity = 10;
        //this is to set capacity of a list to 10 
        private T[] elements; 
        private int size = 0; 

        public ArrayList(){
            //check how can i other wise write this section of code;
            elements = (T[]) new Object[Initial_Capacity];
        }

        public void add(T element){

            if(size == elements.length){
                //is increascapacity a inbuilt function ??
                increaseCapacity();
            }
            //how does this work 
            elements[size++] = element;
        }
        public T get(int index){
            if(index >= size || index <0){
                // this will be thrown if we try to get element which is tried to read and out of bound. 
                throw new IndexOutOfBoundsException("Index: " + index + ", size: " + size);
            }
            return elements[index];
        }
        public void remove(int index){
            if(index >= size || index <0){
                throw new IndexOutOfBoundsException("Index: " + index + ", size: " + size);
            }
            for(int i=index; i<size-1; i++){
                elements[i] = elements[i+1];
            }
            elements[--size] = null; 
        }
        public int size(){
            return size;
        }

        public void increaseCapacity(){
            // what the hell is Arrays.copyOf() function and what other functions are there
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
        public static void main(String[] args) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            list.add(3);
            list.add(4);
            list.add(5);
            list.add(6);
            list.add(7);
            list.add(8);
            list.add(9);
            list.add(10);
            list.add(11);
            list.add(12);
            list.add(13);

            System.out.println("Size of the list: " + list.size());
            System.out.println("Element at index 1: " + list.get(1));
            System.out.println("Element at index 5: " + list.get(5));
            System.out.println("Element at index 10: " + list.get(10));
            System.out.println("Element at index 12: " + list.get(12));
            list.remove(0);
            System.out.println("Element at index 0: " + list.get(0));
            System.out.println("Size of the list: " + list.size());

        }
    }
*/
// declaring the linked-list 
public class LinkedList<T>{
    private static class Node<T>{ // node elements represents each element of linked list 
        T data; // data stored in the node
        Node<T> next; // reference to the next node 
        // constructor to initialize the node with data
        Node(T data){
            this.data = data;
            this.next = null;
        }
    }
    private Node<T> head; // head of the list
    private int size; // size of the list 
// constructor to initialize the linked list 
    public LinkedList(){
        head = null; // intially the list is empty 
        size = 0; // size is 0 intially 
    }
    // add method to add element to end of the list 
    public void add(T data){
        Node<T> newNode = new Node<>(data);// create a new node with the given data 
        if(head ==null){
            head = newNode; // if the list is empty then set the new node as the head; 
        }else{
            Node<T> current = head; // start from the head of the list
            while(current.next !=null){
                current = current.next; // traverse to the end of the list 
            }
            current.next = newNode; // set the new node as the last node's next 
        }
        size++; // increase the size of the list 
    }
    //method to get an element at a specific index
    public T get(int index){
        if(index >= size || index <0){
            //check for valid index
            throw new IndexOutOfBoundsException("Index: " + index + ", size: " + size);
        }
        // start from the head
        Node<T> current = head; 
        for(int i=0; i<index; i++){
            // traverse the specified index 
            current = current.next; 
        }
        // return the data of a specified index 
        return current.data; 
    }
    public T remove(int index){
        if(index >= size || index <0){
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
        if(index ==0){
            head = head.next; 
        }else{
            Node<T> current = head; 
            for(int i=0; i<index-1; i++){
                current = current.next; 
            }
            current.next = current.next.next; 
        }
        size--; 
        return null;
     }
    public int size(){
        return size;
    }
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        //list.add(9);
        //list.add(10);
        //list.add(11);
        //list.add(12);
        System.out.println("Size of the list: " + list.size());
        System.out.println("Element at index 1: " + list.get(1));
        System.out.println("Element at index 5: " + list.get(5));
        System.out.println("Element at index 10: " + list.get(10));
        System.out.println("Element at index 12: " + list.get(12));
        list.remove(0);
        System.out.println("Element at index 0: " + list.get(0));
        System.out.println("Size of the list: " + list.size());
        
    }
}