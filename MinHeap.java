package a4;

public class MinHeap implements Heap {
  
  private int size = 0; // number of elements currently in the heap
  private int[] elts;   // heap array
  private int max;      // array declared size
  
  // ================================================
  // constructors
  // ================================================
  
  public MinHeap(int umax) { // user defined heap size
    this.max = umax;
    this.elts = new int[umax];
  }
  public MinHeap( ) { // default heap size is 100
    this.max = 100;
    this.elts = new int[100];
  }

  //==================================================
  // methods we need to grade
  //==================================================
  
  public int[] getArray() { // do not change this method
    return this.elts;
  }
  
  //=========================================================
  // public methods -- Implement these for the assignment.
  // Note that we want a Min Heap... so the operations
  // getFront and delFront and insert have to compare 
  // for min being at the root  
  //========================================================= 


  public void insert(int p){
    //Hint: remember to update size.  Also, remember that we skip index 0 in the array.
    /*Your code here */
    //System.out.println(p);
    if (size >= this.max){
      return; //if the size is greater than or equal to the max we cannot do anything
    }
    this.elts[size+1] = p;//putting p in the last slot in the array
    int index = size + 1;
    //System.out.println("Before bubbleing: " + this.elts[index]);
    size++;
    bubbleUp(index);
    return;

  }
  private void bubbleUp(int index){
    //System.out.println("index: "+ index);
    if (index==0){return;} //leaving index 0 empty
    if (index>0){
      if(this.elts[index] < this.elts[index / 2]){ //if the left child is less than the parent
        //System.out.println(this.elts[index] + " swap with: " + this.elts[index / 2] );
        int holderValue = this.elts[index];
        this.elts[index] = this.elts[index/2];
        this.elts[index/2] = holderValue;
        index = index/2;
        bubbleUp(index);
        }
      else{
        return;
      }
    }
  }

  
  public void delFront(){
    /*Your code here */
    if (size==0) return;
    int holder = elts[1];
    elts[1] = elts[size];
    elts[size] = 0; //swaps the first and last
   // System.out.println("1: "+ elts[1] + ", 2: " + elts[size]);
    this.size--; //gets rid of last value
    //System.out.println("1: "+ elts[1] + ", 2: " + elts[size]);
    bubbleDown(1);
   // Print.heap(this);


  }
  private void bubbleDown(int index) {
    // System.out.println("index: "+ index);
    int minChildIndex = 0; //min index of the right of left child
    int rChildIndex = (2 * index) + 1;
    int lChildIndex = (2 * index);
    if (index == 0) {
      return;
    } //leaving index 0 empty

    while ((this.elts[index] > this.elts[rChildIndex] || this.elts[index] > this.elts[lChildIndex]) && (lChildIndex <= size)) { //if the left child is less than the parent
      //  System.out.println(index + " swap with: " + index * 2 );
     //    System.out.println("size:"+ size);
      if (index <= size){
        if ((lChildIndex > size) && (rChildIndex > size)) return;
        if ((lChildIndex <= size) && (rChildIndex > size)) {
          minChildIndex = lChildIndex;
        }  else if (((this.elts[lChildIndex] <= this.elts[rChildIndex]) && (lChildIndex <= size) && rChildIndex <= size)) {
          minChildIndex = lChildIndex;
       //   System.out.print("where this is");
        } else if (((this.elts[lChildIndex] > this.elts[rChildIndex]) && (lChildIndex <= size) && rChildIndex <= size)) {
          minChildIndex = rChildIndex;
        }


        if (this.elts[index] > this.elts[minChildIndex]) {
          int holdervalue = this.elts[minChildIndex];
          this.elts[minChildIndex] = this.elts[index];
          this.elts[index] = holdervalue;

        }
        index = minChildIndex;
     //   System.out.println("index after: " + index);
        lChildIndex = 2 * index;
        rChildIndex = 2 * index + 1;

      }
    }

    return;
  }
  
  public int getFront() throws IllegalStateException {
    //Return the element at the front (i.e., the smallest) element in the min-heap.
    //If the min-heap has no elements, throw an IllegalStateException.
    /*Your code here */
    if (size == 0) {
      throw new IllegalStateException(); //Dummy return statement.  Remove (or move elsewhere) when you implement!
    }
    return elts[1];
  }
  
  public boolean empty( ) {
    /*Your code here */
    if (this.size == 0){
      return true;
    }
    else{
      return false;
    }
  }

  public int size() {
    /*Your code here */
    return this.size;
    //return -1; //Dummy return statement.  Remove (or move elsewhere) when you implement!
  }

  
  public void clear() { 
    /*Your code here */
    this.elts = new int[max];
    this.size = 0;
  }
  
  public void build (int[] e, int ne) {
    //Hint: remember to skip slot 0 in the heap array.
    /* Your code here */
    clear(); //clear current heap
    this.size = ne; //setting max
  //  this.elts = new int[ne]; //setting size
    for(int i = 0; i<e.length; i++){
      this.elts[i+1] = e[i];
   //   System.out.println(this.elts[i]); //check if they added correctly
    }
    for (int j = this.size(); j > 0; j--){
      bubbleDown(j);
    }

  }  
  
  public int[] sort() {
    // Hint: the smallest element will go in slot 0
    /*Your code here */
    int size_v = this.size();
    int[] result = new int[size_v];
    for (int i = 0; i<size_v; i++) {
      result[i] = getFront();
   //   System.out.println("result[i]: " + result[i]);
      delFront();
    }
  //print the sorted list
 //  for(int j=0; j<result.length; j++){
 //     System.out.print(result[j] + "working ");
  //  }

    return result;

   // return null;// Dummy return statement.  Remove (or move elsewhere) when you implement!
  }

}
