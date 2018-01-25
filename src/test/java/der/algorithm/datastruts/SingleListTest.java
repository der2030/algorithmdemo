package der.algorithm.datastruts;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
* @FileName:SingleListTest
* @Description:
* @Author: Derrick Ye
*/

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SingleListTest {

    @Test
    public void testSingleList(){
        SingleList sList=new SingleList();
        System.out.println(sList.isEmpty());

        sList.insertHead(11);
        sList.insertHead(2);
        sList.insertHead(33);
        sList.insertHead(7);
        sList.insertHead(100);
        sList.printList();

        sList.deleteHead();
        sList.printList();

        SLNode newNode=sList.getHead();
        sList.insertNode(newNode,500,3);
        sList.printList();
    }


}
