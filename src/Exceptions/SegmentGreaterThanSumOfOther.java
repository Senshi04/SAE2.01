package Exceptions;

import ardoise.Segment;

public class SegmentGreaterThanSumOfOther extends Exception{
    public SegmentGreaterThanSumOfOther(){
        super();
    }

    public String toString(){
        return "Un des côtés est supérieur à la somme des deux autres";
    }
}
