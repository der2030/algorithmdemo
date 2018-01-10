package der.algorithm.sort;
/**
* @FileName:ShellAlgorithm
* @Description:
* @Author: Derrick Ye
*/
public class ShellAlgorithm {

    public static int[] shellOrder(int[] nums){
        int len=nums.length;

        while(len!=0){
            len=len/2;
            for(int x=0;x<len;x++){
                for(int i=x+len;i<nums.length;i+=len){
                    int j=i-len;
                    int temp=nums[i];
                    for(;j>=0 && temp<nums[j];j-=len){
                        nums[j+len]=nums[j];
                    }
                    nums[j+len]=temp;
                }
            }
        }

        return nums;
    }
}
