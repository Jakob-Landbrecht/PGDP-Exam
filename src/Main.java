import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
       //FOR TESTS only
        int[] num1 = {1,2,3,5,8,0,0,0};
        int[] num2 = {2,5,6};
        merge(num1,5,num2,3);
        System.out.println(Arrays.toString(num1));

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

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
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
}