package der.algorithm.application;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
* @FileName:RobberSolutionTest
* @Description:
* @Author: Derrick Ye
*/
@RunWith(SpringJUnit4ClassRunner.class)
public class RobberSolutionTest {

    @Test
    public void testRobber(){
        RobberSolution rs=new RobberSolution();
        int[] money=new int[]{1000,9000,5000,6000,3000,2100};
        int result=rs.robPlan(money);
        assertThat(result,notNullValue());
        System.out.println(result);
    }
}
