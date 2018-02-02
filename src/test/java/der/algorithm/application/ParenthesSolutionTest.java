package der.algorithm.application;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

/**
* @FileName:ParenthesSolutionTest
* @Description:
* @Author: Derrick Ye
*/
public class ParenthesSolutionTest {

    @Test
    public void testParethes(){
        ParenthesSolution ps =new ParenthesSolution();
        String str1="()[]{";
        boolean boo1=ps.validParethes(str1);
        assertThat(boo1,is(false));

        String str2="([){";
        boolean boo2=ps.validParethes(str2);
        assertThat(boo2,is(false));

        String str3="()[]{}";
        boolean boo3=ps.validParethes(str3);
        assertThat(boo3,is(true));
    }
}
