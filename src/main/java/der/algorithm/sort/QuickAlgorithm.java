package der.algorithm.sort;
/**
* @FileName:QuickAlgorithm
* @Description:
* @Author: Derrick Ye
*/
public class QuickAlgorithm {

    public static void quickSort(int[] data, int left, int right) {

        if (left < right) {
            int i,j,x;

            i = left;
            j = right;
            x = data[i];
            while (i < j) {
                while(i < j && data[j] > x)
                    j--;
                if(i < j)
                    data[i++] = data[j];
                while(i < j && data[i] < x)
                    i++;
                if(i < j)
                    data[j--] = data[i];
            }
            data[i] = x;
            quickSort(data, left, i-1);
            quickSort(data, i+1, right);
        }
    }
}
