import java.io.IOException;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import akka.actor.ActorRef;

public class ZookeeperWatcher implements Watcher {
    private final String CONNECET = "127.0.0.1:2181";
    private final Integer SESSION_TIMEOUT = 3000;

    private final ActorRef storageActor;
    private final ZooKeeper zoo;
    
    public ZookeeperWatcher(ActorRef sActor) {
        this.storageActor = sActor;
        this.zoo = new ZooKeeper(CONNECET, SESSION_TIMEOUT, this);
    }


    @Override
    public void process(WatchedEvent event) {
        
        
    }
    
}
