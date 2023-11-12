import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
       //FOR TESTS only
        int[][] test = {{ 5 , 3 ,  0 ,  0 , 7 ,  0 ,  0 ,  0 ,  0 }
        ,{ 6 ,  0 ,  0 , 1 , 9 , 5 ,  0 ,  0 ,  0 }
        ,{  0 , 9 , 8 ,  0 ,  0 ,  0 ,  0 , 6 ,  0 }
        ,{ 8 ,  0 ,  0 ,  0 , 6 ,  0 ,  0 ,  0 , 3 }
        ,{ 4 ,  0 ,  0 , 8 ,  0 , 3 ,  0 ,  0 , 1 }
,       { 7 ,  0 ,  0 ,  0 , 2 ,  0 ,  0 ,  0 , 6 }
,{  0 , 6 ,  0 ,  0 ,  0 ,  0 , 2 , 8 ,  0 }
,{  0 ,  0 ,  0 , 4 , 1 , 9 ,  0 ,  0 , 5 }
,{  0 ,  0 ,  0 ,  0 , 8 ,  0 ,  0 , 7 , 9 }};
        System.out.println(Arrays.deepToString(matrixReshape(test,2,4)));

    }
    public static int removeDuplicates(int[] nums){ //entfernt alle Duplikate und ändert NICHT die Größe | return ist anzahl uniquer Elemente
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
    public static int removeElement(int[] nums, int val) { //entfernt ein bestimmtes Element | ändert nicht die Größe
        int pos = 0;
        for(int i = 0; i < nums.length;i++){
            if(nums[i] != val){
                nums[pos] = nums[i];
                pos++;
            }
        }
        return pos;
    }
    public static int searchInsert(int[] nums, int target) { //sucht die Position wo das Target eingefügt werden sollte
        int start = 0;
        int end = nums.length-1;

        while (start <= end) {
            int mid = start + (end-start)/2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) end = mid-1;
            else start = mid+1;
        }
        return start;
    }
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {//merges zwei sortierte Liste in eine sortierte Liste, die aber teil der einen ist
        int[] temp = Arrays.copyOf(nums1,m);
        //int min = Math.min(m,n);
        int pos1 = 0;
        int pos2 = 0;
        int c=0;

        while(pos1 <m && pos2 <n){
            if(temp[pos1] <= nums2[pos2]){
                nums1[c] = temp[pos1];
                pos1++;
                c++;
            }else{
                nums1[c] = nums2[pos2];
                c++;
                pos2++;
            }
        }
        if(pos1 ==m && pos2 != n){
            while(pos2<n){
                nums1[c] = nums2[pos2];
                c++;
                pos2++;
            }
        }else{
            while(pos1<m){
                nums1[c] = temp[pos1];
                pos1++;
                c++;
            }
        }
    }

    public static int maxProfit(int[] prices) {
        int currentMax = 0;
        for(int i = 0; i< prices.length;i++){
            for(int j = i+1; j < prices.length;j++){
                if(prices[j]-prices[i] > currentMax){
                    currentMax = prices[j]-prices[i];
                }
            }
        }
        return currentMax;
    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int i = 0; i < nums.length;i++){
            for(int j = i+1; j <= (k+i);j++){
                if(j >= nums.length) break;
                if(nums[i] == nums[j]) return true;
            }
        }
        return false;
    }
    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i <nums.length-1;i++){
            if(nums[i+1] - nums[i] != 1){
                return nums[i]+1;
            }
        }
        if(nums[0] != 0){
            return 0;
        }else{
            return nums.length;
        }
    }

    public static int[][] imageSmoother(int[][] img) { //creates image smoother 2 mal 2 Matrix
        int[][] result = new int[img.length][img[0].length];

        for(int x = 0; x < img[0].length;x++){
            for(int y = 0; y < img.length;y++){
                int sumOfPixels = 0;
                int numberOfPixels =0;

                if(x-1 >=0 && y-1 >=0){//darüber links
                    numberOfPixels++;
                    sumOfPixels += img[y-1][x-1];
                }
                if(y-1 >=0){//darüber
                    numberOfPixels++;
                    sumOfPixels += img[y-1][x];
                }
                if(x+1<img[0].length && y-1>=0){//darüber rechts
                    numberOfPixels++;
                    sumOfPixels += img[y-1][x+1];
                }
                if(x-1>=0){//links
                    numberOfPixels++;
                    sumOfPixels += img[y][x-1];
                }
                if(x+1<img[0].length){//rechts
                    numberOfPixels++;
                    sumOfPixels += img[y][x+1];
                }

                if(x+1<img[0].length && y+1 < img.length){//darunter rechts
                    numberOfPixels++;
                    sumOfPixels += img[y+1][x+1];
                }
                if(y+1 < img.length){//darunter
                    numberOfPixels++;
                    sumOfPixels += img[y+1][x];
                }
                if(x-1 >=0 && y+1 < img.length){//darunter links
                    numberOfPixels++;
                    sumOfPixels += img[y+1][x-1];
                }
                numberOfPixels++;
                sumOfPixels += img[y][x];

                result[y][x] = sumOfPixels/numberOfPixels;
            }
        }
        return result;
    }

    public int islandPerimeter(int[][] grid) {
        int sum = 0;
        for(int x = 0; x < grid[0].length;x++){
            for(int y = 0; y < grid.length;y++){
                if(grid[y][x] == 1){
                    sum += 4;

                    sum -= (y - 1 >= 0 && grid[x][y - 1] == 1) ? 1  : 0;
                    sum -= (y + 1 != grid[x].length && grid[x][y + 1] == 1)  ? 1 : 0;
                    sum -= (x - 1 >= 0 && grid[x - 1][y] == 1 ) ? 1 : 0;
                    sum -= (x + 1 != grid.length && grid[x + 1][y] == 1) ? 1 : 0;
                }
                
            }
        }
        return sum;
    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        if(r*c != mat.length*mat[0].length)return mat;//some amount of Elements

        int[] linear = new int[mat.length*mat[0].length];
        int[][] result = new int[r][c]; //r = y; c = x
        int count =0 ;

        for(int y = 0; y < mat.length;y++){
            for(int x = 0; x < mat[0].length;x++){
                linear[count] = mat[y][x];
                count++;
            }
        }
        count = 0;
        for(int y = 0 ;y <r; y++ ){
            for(int x = 0; x < c; x++){
                result[y][x] = linear[count];
                count++;
            }
        }
        return  result;
    }


    public static boolean isValidSudoku(char[][] board) {//NOT CHECKED //Sudoku checker
        for(int y =0; y<board.length;y++){
            for(int x = 0; x<board[0].length;x++){
                //check collumn
                for(int i= 0; i < 9;i++){
                    if((board[i][x] == board[y][x]) && i!=y) return false;
                }
                //check row
                for(int i = 0; i < 9;i++){
                    if((board[y][i] == board[y][x]) && i!=x) return false;
                }
                // check 3x3
                int xboard = x/3;
                int yboard = y/3;
                for(int i = xboard*3; i < xboard*3+3;i++){
                    for(int j = yboard*3; j < yboard*3+3;j++){
                        if((board[j][i] == board[y][x]) && i!=x && y!=j) return false;
                    }
                }
            }
        }
        return true;

    }
}