import java.util.ArrayList;

import akka.actor.AbstractActor;

public class ConfigStorage extends AbstractActor {
    private ArrayList<String> storageServers;

    @Override
    public Receive createReceive() {
        return Re;
    }
    
}
