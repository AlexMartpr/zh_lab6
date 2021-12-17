import org.apache.zookeeper.ZooKeeper;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class AnonymizerZooApp {
    public final String CONNECT = "127.0.0.1:2181";
    public final Integer SESSION_TIMEOUT = 3000;
    public static void main(String[] args) {
        final ActorSystem system = ActorSystem.create("routes");
        ActorRef storageActor = system.actorOf(Props.create(ConfigStorage.class));
        if (args.length != 1) {
            System.out.println("Missed argument for Port. Returning...");
            System.exit(-1);
        }
        int port;
        try {
            port = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        ZookeeperWatcher watcher = new ZookeeperWatcher();
        ZooKeeper zoo = new ZooKeeper(CONNECT,SESS, watcher)
    }
}
