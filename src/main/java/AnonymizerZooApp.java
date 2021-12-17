import java.io.IOException;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class AnonymizerZooApp {
    public static void main(String[] args) throws IOException {
        final ActorSystem system = ActorSystem.create("routes");
        ActorRef storageActor = system.actorOf(Props.create(ConfigStorage.class));
        if (args.length != 1) {
            System.out.println("Missed argument for Port. Returning...");
            System.exit(-1);
        }
        int port;
        try {
            port = Integer.parseInt(args[0]);
            ZookeeperWatcher watcher = new ZookeeperWatcher(storageActor, port);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        //ZooKeeper zoo = new ZooKeeper(CONNECET, SESSION_TIMEOUT, watcher);

    }
}
