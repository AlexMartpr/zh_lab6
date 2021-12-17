import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class AnonymizerZooApp {
    public static void main(String[] args) {
        final ActorSystem system = ActorSystem.create("routes");
        ActorRef storageActor = system.actorOf(Props.create(ConfigStorage.class));
    }
}
