import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

import akka.actor.ActorRef;

public class ZookeeperWatcher implements Watcher {
    private final ActorRef storageActor;
    
    public ZookeeperWatcher(ActorRef sActor) {
        this.storageActor = sActor;
    }


    @Override
    public void process(WatchedEvent event) {
        
        
    }
    
}
