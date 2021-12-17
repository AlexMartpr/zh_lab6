import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

import akka.actor.ActorRef;

public class ZookeeperWatcher implements Watcher {
    private final String CONNECET = "127.0.0.1:2181";
    private final Integer SESSION_TIMEOUT = 3000;
    private final ActorRef storageActor;
    
    public ZookeeperWatcher(ActorRef sActor) {
        this.storageActor = sActor;
    }


    @Override
    public void process(WatchedEvent event) {
        
        
    }
    
}
