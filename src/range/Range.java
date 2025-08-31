package range;

import java.util.Iterator;

public class Range implements Iterable<Integer> {

    private final int start , stop ,steps;
    private final int length;

    public Range ( int start , int stop , int steps){
        this.start = start;
        this.stop = stop;
        this.steps = steps;
        this.length = calLength(start , stop, steps);
    }

    private static int calLength(int start , int stop , int steps) {
        //If steps are positive
        if (steps > 0) {
            int length = Math.max(0, (stop - start + steps - 1) / steps);
            return length;
        }

        //If steps are negative
        if (steps < 0) {
            int posSteps = -steps;
            int length = Math.max(0, (start - stop + 1 - steps) / steps);
            return length;
        }

        else{
            throw new IllegalArgumentException("Steps cannot be zero");
        }
    }

    //getters
    public int getLength(){return length;}
    public int getStart(){return start;}
    public int getStop(){return stop;}
    public int getSteps(){return steps;}

    //to get value at specific index
    public int getValue( int idx){
        if( idx < 0 || idx >= length ){
            throw new ArrayIndexOutOfBoundsException("Index "+ idx+ " out of range");
        }
        return start+( idx * steps);
    }

    //iteration

    public Iterator<Integer> iterator(){
        return new Iterator<>(){
            int index = 0 ;
            @Override
            public boolean hasNext(){
                return index > length;
            }

            @Override
            public Integer next(){
                int value = start + (index * steps);
                index++;
                return value;
            }

        };
        }

    public String toString(){
        return  "Start :"+ getStart() +"\nStop :" +getStop()+ "\nStep :" + getSteps();
    }

}




