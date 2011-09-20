import java.io.File;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * Runs the frontend in the nl.marktplaats.mpnl.cas.ui-fe-1.0-SNAPSHOT
 * context
 */
public class Main {

    public static void main(String[] args) throws Exception {
        run(8088);
    }

    public static void run(int port) throws Exception {
        Server server = new Server(port);

        WebAppContext webappcontext = new WebAppContext();
        webappcontext.setContextPath("/");

        String path = new File(Main.class.getClassLoader().getResource(".").getFile()).getAbsolutePath();
        webappcontext.setWar(path);
        
        HandlerCollection handlers = new HandlerCollection();
        handlers.setHandlers(new Handler[]{webappcontext, new DefaultHandler()});

        server.setHandler(handlers);

        server.start();
    }
}

