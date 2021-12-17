import akka.actor.ActorRef;
import akka.http.javadsl.Http;
import akka.http.javadsl.server.Route;

public class CreateRoute {
    private final Http http;
    private final ActorRef confActor;


    public CreateRoute(Http http, ActorRef conf) {
        this.http = http;
        this.confActor = conf;
        return this.createRoute();
    }


    private Route createRoute() {
    }

}
