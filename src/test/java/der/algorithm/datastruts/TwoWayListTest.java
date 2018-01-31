package der.algorithm.datastruts;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
* @FileName:TwoWayListTest
* @Description:
* @Author: Derrick Ye
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TwoWayListTest {

    @Test
    public void testTwoWayList(){
        TwoWayList testList=new TwoWayList();

        testList.insertHead(20);
        testList.insertTail(15);
        testList.showList();

        testList.insert(3);
        testList.insert(19);
        testList.insert(5);
        testList.showList();
        
    }
}
