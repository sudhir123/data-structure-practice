package com.prac.home.algoexpert.hard;

import java.util.*;
import java.util.stream.Collectors;

/**
 * you are given a root node  and target value and distance k. You need to search and retrn all node which are at distance K frm
 * the target node. Basically sear a target node and then search all possible nodes. O(N) time and space.
 */
public class FindNodesDistanceK {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        FindNodesDistanceK f = new FindNodesDistanceK();
        BinaryTree root = new BinaryTree(1);
        root.left= new BinaryTree(2);
        root.right= new BinaryTree(3);
        root.left.left= new BinaryTree(4);
        root.left.right= new BinaryTree(5);
        root.right.right= new BinaryTree(6);
        root.right.right.left= new BinaryTree(7);
        root.right.right.right= new BinaryTree(8);

        System.out.println(f.findNodesDistanceK_solution2(root, 3, 2));
    }

    // good for learning . solution works differently. one is to traver forward to search distance node.
    // when we get node we will see if node is on left or on right and based on that k-l we will travel on other side or parent side.
    public ArrayList<Integer> findNodesDistanceK_solution2(BinaryTree tree, int target, int k) {
        ArrayList<Integer> list= new ArrayList<>();
        System.out.println(DFS_solution2(tree, 3, list, k));
        return list;
    }


    int DFS_solution2(BinaryTree tree, int target, List<Integer>list, int k){
        if (tree==null) return -1;

        if (tree.value==target){
            // forward already processed list
            findForwardNodes(tree, list, 0, k);
            return 1;
        }
        int leftDistance =DFS_solution2(tree.left,target, list, k);
        int rightDistance = DFS_solution2(tree.right,target, list, k);

        if (leftDistance==k || rightDistance==k){
            list.add(tree.value);
        }

        if (leftDistance!=-1){
            findForwardNodes(tree.right,list, leftDistance+1, k );
            return leftDistance+1;
        }
        if (rightDistance!=-1){
            findForwardNodes(tree.left,list, rightDistance+1, k );
            return rightDistance+1;
        }
        return -1;
    }
    void findForwardNodes(BinaryTree tree, List<Integer> list, int currentDis, int k) {
        if (tree==null) return;
        if (currentDis == k) {
            list.add(tree.value);
        }else {
            findForwardNodes(tree.left, list, currentDis + 1, k);
            findForwardNodes(tree.right, list, currentDis + 1, k);
        }
    }

    void findNodesAtDistance(BinaryTree tree, int distance, List<Integer>list){

    }


    public ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
        // first way y algo expert
        // loop and find parent of each node data ... and save it in hashmap.
        Map<Integer, BinaryTree> parentMap= new HashMap<>();
        prepareParentMap(tree, parentMap);
        BinaryTree targetNode=findTargetNode(tree, target);
        ArrayList<Integer> list= new ArrayList<>();
        dfs(targetNode, parentMap, list, k);
        /*List<BinaryTree> list = new ArrayList<>();

        forwardCount(tree, list, k, target);

        return new ArrayList<>(list.stream().map(x->x.value).collect(Collectors.toList()));*/
        return list;
    }

    void prepareParentMap(BinaryTree root, Map<Integer, BinaryTree>parentMap){
        if (root==null) return;
        if (root.left!=null){
            parentMap.put(root.left.value, root);
        }
        if (root.right!=null){
            parentMap.put(root.right.value, root);
        }
        prepareParentMap(root.left, parentMap);
        prepareParentMap(root.right, parentMap);
    }

    BinaryTree findTargetNode( BinaryTree root, int target){
        if (root==null) return null;
        if (root.value== target){
            return root;
        }
        BinaryTree temp=null;
        if ( (temp= findTargetNode(root.left, target))!=null || (temp= findTargetNode(root.right,target))!=null){
            return temp;
        }
        return null;
    }
    static class NodeDistance{
        BinaryTree tree;
        int disFromTarget;
        NodeDistance(BinaryTree tree, int disFromTarget){
            this.tree= tree; this.disFromTarget= disFromTarget;
        }
    }

    void dfs(BinaryTree target, Map<Integer, BinaryTree> parentMap,ArrayList<Integer> list, int distance){
        Stack<NodeDistance> stack= new Stack<>();
        Set<Integer> set = new HashSet<>();
        NodeDistance node = new NodeDistance(target,0);
        stack.push(node);
        set.add(target.value);
        while (!stack.isEmpty()){
            NodeDistance temp =stack.pop();
            if (temp.disFromTarget==distance){
                list.add(temp.tree.value);
            }else {

                if (temp.tree != null && temp.tree.left != null && !set.contains(temp.tree.left.value)) {
                    stack.push(new NodeDistance(temp.tree.left, temp.disFromTarget + 1));
                    set.add(temp.tree.left.value);
                }
                if (temp.tree != null && temp.tree.right != null && !set.contains(temp.tree.right.value )) {
                    stack.push(new NodeDistance(temp.tree.right, temp.disFromTarget + 1));
                    set.add(temp.tree.right.value);
                }
                if (parentMap.get(temp.tree.value)!=null && !set.contains(parentMap.get(temp.tree.value).value )){
                    stack.push(new NodeDistance(parentMap.get(temp.tree.value), temp.disFromTarget + 1));
                    set.add(parentMap.get(temp.tree.value).value );
                }
            }
        }
    }

    // bad/ wrong way
    void backwardCount(BinaryTree tree, List<BinaryTree> list, int k, int target) {
        if (tree == null) return;
        boolean distanceNodes = false;
        backwardCount(tree.left, list, k, target);
        backwardCount(tree.right, list, k, target);
    }

    void forwardCount(BinaryTree tree, List<BinaryTree> list, int k, int target) {
        if (tree == null) return;
        boolean distanceNodes = false;
        if (tree.value == target) {
            distanceNodes = true;
        }
        if (distanceNodes) {
            findNodes(tree, list, 0, k);
        }
        forwardCount(tree.left, list, k, target);
        forwardCount(tree.right, list, k, target);
    }

    void findNodes(BinaryTree tree, List<BinaryTree> list, int currentDis, int k) {
        if (tree==null) return;
        if (currentDis == k) {
            list.add(tree);
        }
        findNodes(tree.left, list, currentDis + 1, k);
        findNodes(tree.right, list, currentDis + 1, k);
    }
}




























