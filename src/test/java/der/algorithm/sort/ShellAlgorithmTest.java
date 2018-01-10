package der.algorithm.sort;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
* @FileName:ShellAlgorithmTest
* @Description:
* @Author: Derrick Ye
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ShellAlgorithmTest {

    @Test
    public void ShellSortTest(){
        int[] data={20,12,33,7,10,89,6,45,9,32,5};
        int[] sorted=ShellAlgorithm.shellOrder(data);
        assertThat(sorted,notNullValue());
        for(int i=0;i<sorted.length;i++)
            System.out.println(sorted[i]);
    }
}
