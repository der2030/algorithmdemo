package der.algorithm.application;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Map;

/**
* @FileName:LoadBalanceAlgorithmTest
* @Description:
* @Author: Derrick Ye
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LoadBalanceAlgorithmTest {

    @Test
    public void testLoadBalance() throws InterruptedException{
        LoadBalanceAlgorithm.Server server1=new LoadBalanceAlgorithm.Server("192.168.10.1",3);
        LoadBalanceAlgorithm.addServer(Arrays.asList(
                new LoadBalanceAlgorithm.Server("192.168.10.2",3),
                new LoadBalanceAlgorithm.Server("192.168.10.3",2),
                new LoadBalanceAlgorithm.Server("192.168.10.4",30),
                new LoadBalanceAlgorithm.Server("192.168.10.15",2),
                new LoadBalanceAlgorithm.Server("192.168.10.16",50),
                server1
        ));

        long currtime = System.currentTimeMillis();

        for (int i = 0; i < 15; i++) {
            if(i>=2){
                LoadBalanceAlgorithm.getMaster().setDown(true);
            }
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    LoadBalanceAlgorithm.Server server = LoadBalanceAlgorithm.getServer();
                    System.out.println("ip:"+server.getIp()+"   weight:" + server.getWeight());
                }
            });
            t.start();
            t.join();
        }

        currtime = System.currentTimeMillis() - currtime;
        System.out.println("time ====> " + currtime/1000);

        Map<String,LoadBalanceAlgorithm.Server> servers = LoadBalanceAlgorithm.getServers();



        for (String key:servers.keySet()){
            LoadBalanceAlgorithm.Server server = servers.get(key);

            System.out.println(server.getType()+" "+"ip:"+server.getIp()+"   weight:" + server.getWeight()  +" accesscount:"+server.getAccessCount()
                    +" isdown:" + server.isDown());


        }

        System.out.println(LoadBalanceAlgorithm.getGcdWeight());
        System.out.println(LoadBalanceAlgorithm.getMaxWeight());

    }

}
