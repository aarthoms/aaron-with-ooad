/*
    Labeled Loops in Java 
    - Control flow construct when you prefix a loop with an identifier. This allows the break/continue to target a specific outer loop, not just the inner one. 
    - Syntax => 
        labelName: 
            for(...){
                if(condition){
                    break labelName; (or continue labelName)
                }
            }
    - Labels are identifiers, You cannot jump arbritarily, only structured flow is allowed.
*/

class LabeledLoops {
    // You are given a 2D integer matrix; If any row is negative, skip that row and move to the next one
    public static void main(String args[]){
        int[][] matrix = {
            {2,4,6},
            {1,-3,5}, 
            {7, 8, 9}, 
            {10, -2, 3}
        }; 
        int i, j; 
        outer:
        for(i = 0; i<matrix.length; i++){
            int sum = 0; 
            for(j = 0; j<matrix[i].length; j++){
                if(matrix[i][j]<0){
                    System.out.println("Continuing Outer"); 
                    continue outer; 
                }
                sum += matrix.length; 
            }
            System.out.println("Sum of row "+i+ " is "+ sum); 
        }
    }
}