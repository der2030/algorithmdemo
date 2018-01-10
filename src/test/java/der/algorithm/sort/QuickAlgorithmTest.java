package der.algorithm.sort;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
* @FileName:QuickAlgorithmTest
* @Description:
* @Author: Derrick Ye
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class QuickAlgorithmTest {

    @Test
    public void quickSortTest(){

        int[] data={20,12,33,7,10,89,6,45,9,32,5};

        System.out.printf("before  sort:");
        for (int i=0; i<data.length; i++)
            System.out.printf("%d ", data[i]);
        System.out.printf("\n");

        QuickAlgorithm.quickSort(data,0,data.length-1);

        System.out.printf("after  sort:");
        for (int i=0; i<data.length; i++)
            System.out.printf("%d ", data[i]);
        System.out.printf("\n");
    }
}
