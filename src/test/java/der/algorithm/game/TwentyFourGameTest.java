package der.algorithm.game;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
* @FileName:TwentyFourGameTest
* @Description:
* @Author: Derrick Ye
*/
@RunWith(SpringJUnit4ClassRunner.class)
public class TwentyFourGameTest {

    @Test
    public void testTwentyFour(){
        int[] card=new int[]{2,4,7,8};
        TwentyFourGame tfg=new TwentyFourGame(card);
        tfg.calculate();
    }
}
