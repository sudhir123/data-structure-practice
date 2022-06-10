package com.prac.home.algoexpert.hard;

/**
 * #Array
 * Best approach is Merge sort and then apply logic for inversions. First build merge sort.
 */
public class CountInversions {
    /**
     * lets try with merge sort, in which we keep on dividing the array until reach the single number.
     * While merging as many discrepancies we get as counter. My assumption sorting will be done while returning
     */
    public int countInversions(int[] array) {
        return sorting(array,0);
    }

    int sorting (int[] array, int counter){
        int n = array.length;
        if (n<2) return 0;
        int mid = array.length/2;
        int[] left = new int[mid];
        int[] right = new int[n-mid];

        for (int i=0; i<mid; i++){
            left[i]= array[i];
        }
        for (int i =mid; i< n ; i ++){
            right[i-mid]= array[i];
        }
        int counterLeft=sorting(left, counter);
        int counterRight= sorting(right,counter);
        counter=merge(array, left, right, left.length, right.length);
        return counter+counterLeft+counterRight;
    }

    int merge(int[] array , int[] left, int[] right, int leftMaxIndex, int rightMaxIndex){
        int i =0 , j=0, k=0, counter=0;
        while (i<leftMaxIndex && j<rightMaxIndex){
            if (left[i]<=right[j]){
                array[k++]=left[i++];
            }else {
                //System.out.println("left[i]->"+left[i]+" && right[j]->"+right[j]+" && Array-->"+ Arrays.toString(left));
                array[k++]=right[j++];
                counter=counter+(leftMaxIndex-i);
            }
        }
        while (i<leftMaxIndex){
            array[k++]=left[i++];
        }
        while (j<rightMaxIndex){
            array[k++]=right[j++];
        }
        return counter;
    }



    public static void main(String[] args) {
        CountInversions c= new CountInversions();
        int[] arr = new int[]{2, 3, 3, 1, 9, 5, 6};
        System.out.println(c.countInversions(arr));
    }

    // brute force bad solution
    /*public int countInversions(int[] array) {
        int counter=0;
        for (int i =0 ; i < array.length; i++){
            for (int j= i+1 ; j <array.length; j++){
                if (i<j && array[i]>array[j]){
                    counter++;
                }

            }
        }
        return counter;
    }*/
}
















