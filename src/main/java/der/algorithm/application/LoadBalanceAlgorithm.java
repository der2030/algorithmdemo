package der.algorithm.application;

import java.math.BigInteger;
import java.util.*;

/**
* @FileName:LoadBalanceAlgorithm
* @Description: this class implements load balance algorithm
* @Author: Derrick Ye
*/
public class LoadBalanceAlgorithm {

    private final static String SERVER_MASTER = "master" ;
    private final static String SERVER_SLAVE = "slave" ;

    //server number
    private static Integer currentIndex = -1;
    //current weighe
    private static  Integer currentWeight = 0;
    //maxmium weight
    private static Integer maxWeight = 0;
    //maxmium common divisor of weight
    private static Integer gcdWeight = 0;
    //master server
    private static Server master;
    //server set
    private static Map<String,Server> servers = Collections.synchronizedMap(new HashMap<String, Server>());


    public static Integer getCurrentIndex() {
        return currentIndex;
    }

    public static Integer getCurrentWeight() {
        return currentWeight;
    }

    public static Integer getMaxWeight() {
        return maxWeight;
    }

    public static Server getMaster() {
        return master;
    }

    public static void setMaster(Server master) {
        LoadBalanceAlgorithm.master = master;
    }

    public static Integer getGcdWeight() {
        return gcdWeight;
    }

    //add server
    public static void addServer(Server server){
        if(server==null){
            throw  new RuntimeException("error:server is nullable!");
        }
        int index  = servers.size();
        servers.put(String.valueOf(index),server);
        if(server.getType()!=null&&SERVER_MASTER.equals(server.getType())){
            servers.put(SERVER_MASTER,server);
        }else if(server.getType()==null){
            server.setType(SERVER_SLAVE);
        }
    }

    //add multiple servers
    public static void addServer(List<Server> servers) {
        for (int i = 0; i < servers.size(); i++) {
            Server server = servers.get(i);
            addServer(server);
        }
        LoadBalanceAlgorithm.initOrReload();
    }

    //check weight and caculate common visifor of weight
    public synchronized static void initOrReload(){
        Set<String> keys = servers.keySet();
        Server prev_server = null ;
        for(String key:keys){
            Server server = servers.get(key);
            if(prev_server!=null){
                gcdWeight = new BigInteger(String.valueOf(prev_server.getWeight())).gcd(new BigInteger(String.valueOf(prev_server.getWeight()))).intValue();
            }
            if(server.getWeight()>maxWeight){
                maxWeight = server.getWeight();
            }
            prev_server = server;
        }
        if(master==null){
            master = servers.get("0");
            master.setType(SERVER_MASTER);
            servers.put(SERVER_MASTER,master);
        }
    }

    //access server using Round Robin algorithm
    public static Server getServer(){
        int count = 0;
        int size = servers.size();
        while (true){
            currentIndex = (currentIndex+1)%size;
            if(currentIndex==0){
                currentWeight = currentWeight - gcdWeight;
                if (currentWeight <= 0) {
                    currentWeight = maxWeight;
                }
            }
            Server server = servers.get(String.valueOf(currentIndex));
            if(server!=null&&server.getWeight()>=currentWeight&&!server.isDown){
                server.addAccessCount();
                return  server;
            }
            if(count>=size){
                if(master.isDown){
                    new RuntimeException("error:master is down!");
                }
                return master;
            }
            count++;

        }
    }

    public static Map<String, Server> getServers() {
        return servers;
    }



    public static class Server{

      //server id
      private  String id;
      ///server ip
      private String ip;
      //weight
      private int weight;
      //server type:master/slave
      private String type;
      //access count
      private Integer accessCount = 0;
      //check if server is down
      private boolean isDown;

      public Server(String ip, int weight) {
          this.ip = ip;
          this.weight = weight;
      }

      public String getId() {
          return id;
      }

      public void setId(String id) {
          this.id = id;
      }

      public String getIp() {
          return ip;
      }

      public void setIp(String ip) {
          this.ip = ip;
      }

      public int getWeight() {
          return weight;
      }

      public void setWeight(int weight) {
          this.weight = weight;
      }

      public String getType() {
          return type;
      }

      public void setType(String type) {
          this.type = type;
      }

      public Integer getAccessCount() {
          return accessCount;
      }

      public void setAccessCount(Integer accessCount) {
          this.accessCount = accessCount;
      }

      public void addAccessCount() {
          synchronized (this.accessCount){
              this.accessCount++;
          }
      }

      public boolean isDown() {
          return isDown;
      }

      public void setDown(boolean down) {

          if((this.isDown&&down)||(!this.isDown&&!down)){
              return;
          }else{
              //移除或恢复操作
              initOrReload();
          }

          isDown = down;
      }
  }

}



