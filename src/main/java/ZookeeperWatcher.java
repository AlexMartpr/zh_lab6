import java.io.IOException;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import akka.actor.ActorRef;

public class ZookeeperWatcher implements Watcher {
    private final String CONNECET = "127.0.0.1:2181";
    private final Integer SESSION_TIMEOUT = 3000;

    private final ActorRef configStorageActor;
    private final ZooKeeper zoo;
    private int currentPort;
    
    public ZookeeperWatcher(ActorRef sActor, int p) throws IOException {
        this.configStorageActor = sActor;
        this.zoo = new ZooKeeper(CONNECET, SESSION_TIMEOUT, this);
        this.currentPort = p;
        this.CreateZooServers();
    }

    private void CreateZooServers() {

    }


    @Override
    public void process(WatchedEvent event) {
        
        
    }
    
}
