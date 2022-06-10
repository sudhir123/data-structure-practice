package com.prac.home.datastructures.stack;

/**
 * Three in One: Describe how you could use a single array to implement three stacks.
 */
class FixedMultiStack{
    private int numberOfStacks=3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public FixedMultiStack(int stackSize) { // 3
        this.stackCapacity = stackSize;
        values = new int[stackSize * numberOfStacks]; //9
        sizes = new int[numberOfStacks]; //3
    }
    public void push(int stackNum, int value) throws Exception {
        if (isFull(stackNum)){
            throw new Exception();
        }
        sizes[stackNum]++;
        values[indexOfTop(stackNum)] = value;
    }
    public int pop(int stackNum) throws Exception {
        if (isEmpty(stackNum)){
            throw new Exception();
        }
        int index=indexOfTop(stackNum);
        sizes[stackNum]--;
        return values[index] ;
    }
    private boolean isFull(int stackNum){
        int offsetStartingPointOfStack = stackNum*stackCapacity;
        int maxOffset= (offsetStartingPointOfStack + stackCapacity);
        if(sizes[stackNum]< (maxOffset-offsetStartingPointOfStack)){
            return false;
        }
        return true;
    }
    private boolean isEmpty(int stackNum){
        if(sizes[stackNum]==0) return true;
        return false;
    }
    private int indexOfTop(int stackNum) {
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum];
        return offset + size - 1;
    }
}
public class SingleArrayTheeStacks {
    public static void main(String[] args) throws Exception {
        FixedMultiStack stack = new FixedMultiStack(3);
        stack.push(0, 1);
        stack.push(0, 2);
        stack.push(0, 3);
        stack.push(1, 4);
        stack.push(1, 5);
        stack.push(1, 6);
        stack.push(2, 7);
        stack.push(2, 8);
        stack.push(2, 9);
        System.out.println(stack.pop(0));
        System.out.println(stack.pop(0));
        System.out.println(stack.pop(0));
        System.out.println(stack.pop(1));
        System.out.println(stack.pop(1));
        System.out.println(stack.pop(1));
        System.out.println(stack.pop(2));
        System.out.println(stack.pop(2));
        System.out.println(stack.pop(2));
    }
}
