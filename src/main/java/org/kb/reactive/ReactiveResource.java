package org.kb.reactive;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/reactive")
public class ReactiveResource {
    @Inject
    ReactiveService reactiveService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return reactiveService.getFromStream();
    }
}