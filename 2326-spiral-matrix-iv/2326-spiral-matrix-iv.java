/*

Definition for singly-linked list.

public class ListNode {

    int val;

    ListNode next;

    ListNode(){}

    ListNode(int val){
        
        this.val = val;
    }

    ListNode(int val , ListNode next){
        
        this.val = val;
        
        this.next = next;
    }
}

*/

class Solution {

    public int[][] spiralMatrix(int R , int C , ListNode head_node){

        ListNode current_node = head_node;
        
        int[][] matrix = new int[R][C];

        for(int top_pointer = 0 , bottom_pointer = (R - 1) , left_pointer = 0 , right_pointer = (C - 1) ; ((top_pointer <= bottom_pointer) && (left_pointer <= right_pointer)) ; ){

            for(int j = left_pointer ; (j <= right_pointer) ; j++){

                matrix[top_pointer][j] = ((current_node != null) ? (current_node.val) : (-1));

                current_node = ((current_node != null) ? (current_node.next) : (null));
            }

            top_pointer++;

            for(int i = top_pointer ; (i <= bottom_pointer) ; i++){
                
                matrix[i][right_pointer] = ((current_node != null) ? (current_node.val) : (-1));
                
                current_node = ((current_node != null) ? (current_node.next) : (null));
            }

            right_pointer--;

            if(top_pointer <= bottom_pointer){

                for(int j = right_pointer ; (j >= left_pointer) ; j--){
                    
                    matrix[bottom_pointer][j] = ((current_node != null) ? (current_node.val) : (-1));
                    
                    current_node = ((current_node != null) ? (current_node.next) : (null));
                }

                bottom_pointer -= 1;
            }

            if(left_pointer <= right_pointer){

                for(int i = bottom_pointer ; (i >= top_pointer) ; i--){
                    
                    matrix[i][left_pointer] = ((current_node != null) ? (current_node.val) : (-1));
                    
                    current_node = ((current_node != null) ? (current_node.next) : (null));
                }

                left_pointer++;
            }
        }

        return matrix;
    }
}