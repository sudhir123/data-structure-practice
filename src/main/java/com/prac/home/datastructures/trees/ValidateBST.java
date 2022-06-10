package com.prac.home.datastructures.trees;
/**
 * Implement a function to check if a binary tree is a binary search tree. Basically all left nodes are less than the parent node
 * if root=5 max 4 can be in left node ...one approach is max and min ... another simple approach is copy elements to array
 * and see if array is in increasing order.
 */
public class ValidateBST {
    int[] arr = {5,4,6, 3,7};
    int index=0;
    Integer lastPrinted=0;
    Integer min=0, max=0;
    Node rootBST=null;

    Node createTreeRootNode(int[] arr, int startIndex, int endIndex){
        if (endIndex<startIndex) return null;
        int midIndex = (startIndex+endIndex) /2;
        Node node = new Node(arr[midIndex]);
        System.out.print(arr[midIndex]+", ");
        node.left= createTreeRootNode(arr, startIndex, midIndex-1);
        node.right= createTreeRootNode(arr, midIndex+1, endIndex);
        return node;
    }

    Node createBSTAroundRootKey(int rootKeyData){
        if (rootBST==null){
            rootBST=new Node(rootKeyData);
        }
        insertKey(10, rootBST);
        insertKey(5, rootBST);
        insertKey(3, rootBST);
        insertKey(7, rootBST);
        insertKey(15, rootBST);
        insertKey(17, rootBST);
        insertKey(30, rootBST);

        return rootBST;
    }

    boolean insertKey(int data, Node rootBST){
        if (rootBST==null){
            return true;
        }
        if (rootBST.data > data){
            if(insertKey(data,rootBST.left)){
                rootBST.left=new Node(data);
                return false;
            }
        }else {
            if (insertKey(data,rootBST.right)){
                rootBST.right=new Node(data);
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ValidateBST validateBST= new ValidateBST();
        Node root= validateBST.createTreeRootNode(validateBST.arr, 0, validateBST.arr.length-1);
        System.out.println();
        //System.out.println("Root Node Data -> "+root.data);

        //System.out.println(validateBST.BST(root));

        //System.out.println(validateBST.checkBST(root));

        //System.out.println(validateBST.checkBSTSolution2(root));

        System.out.println(validateBST.createBSTAroundRootKey(5).data); //20
        /*System.out.println(validateBST.rootBST.left.data+"   "+ validateBST.rootBST.right.data); //10, 30
        System.out.println(validateBST.rootBST.left.left.data+"   "+ validateBST.rootBST.left.right.data); // 5,15
        System.out.println(validateBST.rootBST.left.left.left.data+"   "+ validateBST.rootBST.left.left.right.data); // 3,7
        System.out.println(validateBST.rootBST.left.right.right.data+"   "); // 17*/

        System.out.println(validateBST.checkBSTWithMinMaxSolution(validateBST.rootBST, null, null));
    }
    // # solution 1:- create an array from tree and check if array is in increasing order. Basically we need to know the size in adv
    void createArray(Node root, int[]arr){
        if (root==null) return;
        createArray(root.left,arr );
        arr[index]= root.data;
        index++;
        createArray(root.right, arr);
    }
    // now just need to check the increasing order
    boolean checkBST(Node root){
        int[] arr = new int[9];
        createArray(root,arr);
        for (int i=0; i <arr.length-1; i++){
            System.out.print(arr[i]+" ");
            if(arr[i]> arr[i+1]){
                return false;
            }
        }
        return true;
    }


    // # solution 2 :- array is used only for comparing, and that too every two elements. why not compare directly with last one.
    boolean checkBSTSolution2(Node root){
        if (root==null)
            return true;
        if (!checkBSTSolution2(root.left))
            return false;
        if (lastPrinted!=null && root.data<=lastPrinted)
            return false;
        lastPrinted= root.data;
        if (!checkBSTSolution2(root.right))
            return false;

        return true;
    }

    // # solution3 Min-Max solution. when we move left max gets updated and when we move right min gets updated. We check for each node.
    boolean checkBSTWithMinMaxSolution(Node root, Integer min, Integer max){
        if (root==null)
            return true;
        if( (min!=null && min >= root.data) || (max!=null && max < root.data))
            return false;
        if (!(checkBSTWithMinMaxSolution(root.left, min, root.data)) || !checkBSTWithMinMaxSolution(root.right, root.data, max))
            return false;
        return true;
    }


    // my thinking
    boolean BST(Node rootNode){
        if(checkBinarySearchTree(rootNode)==Integer.MAX_VALUE){
            return false;
        }else{
            return true;
        }
    }
    int checkBinarySearchTree(Node root){
        if (root==null) return -1;
        int rootData= root.data;
        System.out.println("Current Data-> "+rootData);
        int leftNodeData= checkBinarySearchTree(root.left);
        System.out.print("Left Data-> "+leftNodeData);
        int rightNodeData= checkBinarySearchTree(root.right);
        System.out.print("       right Data-> "+leftNodeData);
        System.out.println();System.out.println();
        if((leftNodeData<rootData && rightNodeData>rootData) || (leftNodeData==-1 && rightNodeData==-1)){
            return rootData;
        }else {
            return Integer.MAX_VALUE;
        }
    }


    class Node{
        int data;
        Node left, right ;
        Node(int data){ this.data=data;}
    }
}
