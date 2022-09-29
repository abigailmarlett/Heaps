package a4;

public class Main {

  public static void main(String[] args) {
    int[] e = new int[] {6, 12, 9, 4, 5, 3};


    MinHeap hp = new MinHeap(300);

    for (int i=0; i<e.length; i++) {
      hp.insert(e[i]);
    }
 //  System.out.println("heap many inserts: ");
    Print.heap(hp);  // one form
 //   System.out.println(hp.getFront());
  //  System.out.println(hp.empty());
  //  System.out.println(hp.size());
  //  System.out.println(hp.sort());
   //hp.delFront();
   // hp.delFront();
   // hp.build(e, 5);
    hp.build(e,6);
    Print.heap(hp);
   // System.out.println("heap magic build: ");
   // Print.heap(hp);  // another form

   // hp.clear();
   // Print.heap(hp);
   // System.out.println(hp.empty());
  //  System.out.println(hp.size());


    /*You are free to test your code however you wish.  Some code samples
    are commented below as an example.  These operations (e.g., insert, build)
    won't function correctly until you provide the implementation in MinHeap.java.
     */

    /*

    int[] e = new int[] {  101, 37, 26, 19, 15, 12, 9, 2, 3, 5  };
    int[] e = new int[] {  6, 12, 9, 4, 5, 3  };
    
    MinHeap hp = new MinHeap(300);

    for (int i=0; i<e.length; i++) {
      hp.insert(e[i]);
    }

    
    System.out.println("heap many inserts: ");
    Print.heap(hp);  // one form

    
    hp.build(e,6);
    System.out.println("heap magic build: ");
    Print.heap(hp);  // another form

     */

  }
}

