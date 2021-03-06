import java.time.Duration;

import akka.actor.ActorRef;
import akka.http.javadsl.Http;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.Query;
import akka.http.javadsl.model.Uri;
import akka.http.javadsl.server.Route;
import akka.japi.Pair;
import akka.pattern.Patterns;

import static akka.http.javadsl.server.Directives.*;

public class CreateRoute {
    private final String URL_STRING = "url";
    private final String COUNT_STRING = "count";
    private final int TIMEOUT = 10;

    private final Http http;
    private final ActorRef confActor;


    public CreateRoute(Http http, ActorRef conf) {
        this.http = http;
        this.confActor = conf;
    }


    private String initUrl(String serverUrl, String url, int count) {
        String u = String.valueOf(Uri.create(serverUrl).query(Query.create(Pair.create(URL_STRING, url),
        Pair.create(COUNT_STRING, String.valueOf(count - 1)))));
        System.out.println("hi" + u);
        return u;
    }

    public Route createRoute() {
        return route(
            get(() -> 
            parameter(URL_STRING, url ->
                parameter(COUNT_STRING, count -> {
                    if (Integer.parseInt(count) == 0) {
                        return completeWithFuture(this.http.singleRequest(HttpRequest.create(url)));
                    } else {
                        return completeWithFuture(
                            Patterns.ask(this.confActor
                                        ,new EmptyMessage(),
                                        Duration.ofSeconds(TIMEOUT))
                                    .thenApply(serverUrl -> (String)serverUrl)
                                        .thenCompose((serverUrl) -> this.http.singleRequest(HttpRequest.create(this.initUrl(serverUrl, url, Integer.parseInt(count)))))    
                        );
                    }   
                }
            ))
        ));
    }

}
