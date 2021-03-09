package org.kb.reactive;

import io.smallrye.mutiny.Multi;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ReactiveService {
    public String getFromStream() {
        // Observable
        Multi<String> multi = Multi.createFrom().emitter( multiEmitter -> {
            System.out.println("Emit row 1");
            multiEmitter.emit("item 1");

            System.out.println("Emit row 2");
            multiEmitter.emit("item 2");

            System.out.println("Emit row 3");
            multiEmitter.emit("item 3");

            System.out.println("Emit row 4");
            multiEmitter.emit("item 4");

            System.out.println("Emit complete");
            multiEmitter.complete();
        });

        // Observer 1
        multi.subscribe().with(
                item -> {
                        try {
                            System.out.println("----Sleep 1: 10s");
                            Thread.sleep(5000);
                        }
                        catch (Exception ex) {
                            System.out.println(ex);
                        }

                        System.out.println("Receive 1:" + item);
                    },
                failure -> { System.out.println(failure); },
                () -> {System.out.println("Receive complete 1");}
        );

        System.out.println("----------------------------------------------------");

        // Observer 2
        multi.subscribe().with(
                item -> {
                    try {
                        System.out.println("----Sleep 2: 5s");
                        Thread.sleep(5000);
                    }
                    catch (Exception ex) {
                        System.out.println(ex);
                    }

                    System.out.println("Receive 2:" + item);
                },
                failure -> { System.out.println(failure); },
                () -> {System.out.println("Receive complete 2");}
        );

        return "Stream content";
    }
}
