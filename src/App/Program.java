package App;

import range.Range;

public class Program {
    public void run(){
        Range range= new Range(50,10,-5);

        // Iterate using for-each
        for(int i: range){
            System.out.print(i + " ");
        }
        System.out.println();

        // Show length
        System.out.println("Length = " + range.getLength());

        // Use get(k) explicitly
        System.out.println("Element at index 3 = " + range.getValue(2));
    }
}
