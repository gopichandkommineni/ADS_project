# ADS Project Report Fall - 19

Gopichand Kommineni: 03055523

[gopichandk@ufl.edu](mailto:gopichandk@ufl.edu)

**Programming Language:**
To implement this Job Scheduler, I have used JAVA programming

**Functions and Classes Used:**

**Class Node.java**
This class has all the variables related a to a Building. A Building contains the following fields:

-
  - **Executed\_time** : The time for which the building has been worked on.
  - **total\_time** : The total construction time of a building
  - **bn0:**  The Building number of a newly inserted building which is always unique
We use this class to make an array of building objects.


**Class MinHeap.java**

This class is where all the work on a minheap happens, The minheap is arranged on the executed time.

- Public MinHeap(): constructor function that initializes the array of objects with 2000 size.
- Private int parent(pos): Gives the parent of a node if it exists.
- Private int lef(pos): Gives the left child of the pos
- Private int right(pos): Gives the right child of the pos
- Public void printArray(): prints the elements of heap
- Private void swap(pos1,pos2): Swaps the nodes at the two positions in the tree.
- Private void minHeapity(pos): Function that is called when we want to rearrange the tree if the tree does not satisfy the min heap properties where left child is smaller that parent while right child is larger. It does this comparison based on the executed time and if there is a tie we use the building number to do the comparison.
- Public void add(Node treenode): Inserts the new node and puts it in the right position by transitioning upwards into the tree.
- Public node remove(): Removes and returns the minheap minimum element and  rearranges the heap to satisfy properties.
- Public void downheap(pos): heapifies down from the given position
- Public void upheap(pos):heapifies up from the given position
- Public node minimumelement(): Returns the value of the minimum element of the min heap.

**Class RedBlackTree.java**

This class holds the class for a redblacknode and also the entire working of a red black tree.

Class Redblacknode():Holds the following variables: - Node received building – Redblacknode parent – leftchild – rightchild – int color.

Node minimum(): to return minimum node.

Node maximum(): to return maximum node.

Node insert(int ): for inserting node into the tree.

Node deleteNode(int) :for deleting the given key.

Void rightrotate(Node) : for rotating right.

Void leftrotate(Node): for rotating left.

Node searchTree(int) : for searching for a specific key.

**Class risingCity.java**

This is the main driver function that has the main logic of the program.

- Public static void input(): Takes rbt and minheap and building number and total time as input and calls the insert functions on both the data structures.
- Public static String performOperation(): for performing the read input instruction from the input file.
- Public static void main(String[] args): The main entry point of the project.





**Program Structure:**

1. The program starts at the risingity.java file, where it creates the Red black Tree and minheap. The input from the command line which is a file name and searches for the file in local directory and then starts reading the file contents one line at a time.
2. The while loop is used to read the file contents till the point where input file still has a line to read. We extract the next input lines time and store it, and if the city\_time is equal to this building time we read this line and either insert or print depending upon the input command.
3. The Next case handle is if the incoming building time is greater than the city time counter, that implies there is sufficient time to work on building and we choose as min\_building from the minheap.
4. After choosing a min\_building depending on its executed time or building number if it is a tie, we check if we can work on it for 5 days or less, if this condition is true we increment executed time and city time by that amount or for other case we increment both times by 5 and repeat this process till the inner while loop end, the loop terminates when the heap does not have any more elements left.
5. After the times are incremented, we check If the building is done construction, if so we delete it from both the data structures and also write it to the output file.
6. If after incrementing the city time is now equal to the next incoming input statement&#39;s building time, we read the input file and either insert the next building or print according to the input.
7. When we reach the end of the input text file, we might still have some buildings that have to be worked on, we assign another loop that finishes this work on each building and removes it from the structures while printing it out.
8. In the end we also display the total time it takes to finish this construction job.