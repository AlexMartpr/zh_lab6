import java.util.ArrayList;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

public class ConfigStorage extends AbstractActor {
    private ArrayList<String> storageServers;

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
        .match(MessageServer.class, msg -> this.storageServers=msg.getUrls())
        .match(, externalPredicate, apply)
    }
    


}
