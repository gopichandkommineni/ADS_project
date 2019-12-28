public class MinHeap {

    private Node [] array;
    private int size = 0;

    public MinHeap(){
        array = new Node[2000];
    }

    public boolean isEmpty(){
        if(size == 0)
        {
            return true;
        }
        return false;
    }

    public void add(Node treenode){
        if(size == 2000)
        {
            System.out.println("Heap is full");  
            return;
        }

        int j = 0;
        int index = 0;
        while(true)
        {
        
            if(array[parent(j)] == null)
            {
                array[parent(j)] = treenode;
                index = parent(j);
                size++;
                break;
            }
            if(array[left(j)] == null)
            {
                array[left(j)] = treenode;
                index = left(j);
                size++;
                break;
            }
            if(array[right(j)] == null)
            {
                array[right(j)] = treenode;
                index = right(j);
                size++;
                break;
            }
            j++;
        }
        upHeap(index);
    }

    private void upHeap(int i){

        while(i >= 0)
        {
            if(array[parent(i)].executed_time > array[i].executed_time )
            {
                swap(parent(i), i);
                i = parent(i);
            }
            else if(array[parent(i)].executed_time == array[i].executed_time && array[parent(i)].bno>array[i].bno){
               swap(parent(i),i);
                i = parent(i);
            }
            else
            {
                break;
            }
        }
    }

    public Node remove(){
        Node root = null;
        if(size == 0)
        {
            System.out.println("Heap is Empty");
            return null;
        }

        for(int i = 0; i < array.length - 1; i ++)
        {
            if(array[i + 1] == null)
            {   
                
                root = array[0];
                array[0] = null;
                swap(i, 0);
                size--;
                break;
            }
        }
        //System.out.println("Removing Node ( "+root.bno+" , "+root.executed_time+" )");
        downHeap(0);
        return root;
    }

    private void downHeap(int i){

        while(array[parent(i)] != null)
        {   
            
            if( array[left(i)]!=null && array[i].executed_time > array[left(i)].executed_time )
            {
                //System.out.println("comparing "+array[i].executed_time+" with  "+array[left(i)].executed_time);
                //System.out.print();
                swap(i, left(i));
                i = left(i) - 1;
            }
            else if (array[right(i)]!=null && array[i].executed_time > array[right(i)].executed_time )
            {
                swap(i, right(i));
                i = right(i) - 1;
            }
            else if(array[left(i)]!=null && array[i].executed_time == array[left(i)].executed_time && array[i].bno > array[left(i)].bno)
            {
                swap(i, left(i));
                i = left(i) - 1;
            }
            else if(array[right(i)]!=null && array[i].executed_time == array[right(i)].executed_time && array[i].bno > array[right(i)].bno)
            {
                swap(i, right(i));
                i = right(i) - 1;
            }
            else
            {
                break;
            }
        }
    }

    public int peek(){
        return array[0].executed_time;
    }

    protected int parent(int j){
        return (j-1)/2;  
    }

    protected int left(int j){
        return 2*j + 1;  
    }

    protected int right(int j){
        return 2*j + 2;  
    }

    protected boolean hasLeft(int j){
        return left(j) < size;  
    }

    protected boolean hasRight(int j){
        return right(j) < size;  
    }

    protected void swap(int i, int j){
        Node temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void printArray(){
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print("[ "+array[i].bno+" , "+array[i].executed_time+" ]");
            if(i != size -1)
                System.out.print(", ");
        }
        System.out.println("]");
    }
}