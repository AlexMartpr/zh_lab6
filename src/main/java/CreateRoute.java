import java.time.Duration;
import java.util.regex.Pattern;

import akka.actor.ActorRef;
import akka.http.javadsl.Http;
import akka.http.javadsl.server.Route;
import akka.pattern.Patterns;

public class CreateRoute {
    private final int TIMEOUT = 5;

    private final Http http;
    private final ActorRef confActor;


    public CreateRoute(Http http, ActorRef conf) {
        this.http = http;
        this.confActor = conf;
    }


    private Route createRoute() {
        return route(get(() -> 
            parameter(URL_STRING, url ->
                parameter(COUNT_STRING, count -> {
                    if (Integer.parseInt(count) == 0) {
                        return completeWithFuture(this.http.singleRequest(HttpRequest.create(utl)));
                    } else {
                        return completeWithFuture(
                            Patterns.ask(this.confActor
                                        ,new EmptyMessage(),
                                        Duration.ofSeconds(TIMEOUT))
                                    .thenApply(serverUrl -> (String)serverUrl)    
                        );
                    }   
                }
            )
        ));
    }

}
