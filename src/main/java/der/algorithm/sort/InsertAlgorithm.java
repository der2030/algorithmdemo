package der.algorithm.sort;
/**
* @FileName:InsertAlgorithm
* @Description:
* @Author: Derrick Ye
*/
public class InsertAlgorithm {

    public static int[] insertOrder(int[] numbers){

        int length=numbers.length;
        int insertnum;
        for(int i=1;i<length;i++){
            insertnum=numbers[i];
            int j=i-1;
            while(j>=0 && numbers[j]>insertnum){
                numbers[j+1]=numbers[j];
                j--;
            }
            numbers[j+1]=insertnum;
        }


        return numbers;
    }
}
