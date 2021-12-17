import java.io.IOException;

import akka.NotUsed;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.Http;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.http.javadsl.server.Route;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;

public class AnonymizerZooApp {
    private static final String URL_STRING = "url";
    private static final String COUNT_STRING = "count";
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
            final Http http = Http.get(system);
            final ActorMaterializer mat = ActorMaterializer.create(system);
            final Flow<HttpRequest, HttpResponse, NotUsed> flow;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.exit(-1);
        }

    }

    public Route createRouter() {
        return route(get(() -> 
            parameter(URL_STRING, url ->
                parameter(COUNT_STRING, count)
            )
        ));
    }

}
