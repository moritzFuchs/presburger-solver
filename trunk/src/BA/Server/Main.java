package BA.Server;
 
import javax.servlet.ServletContext;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;

import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.server.session.HashSessionManager;
import org.eclipse.jetty.server.session.SessionHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.servlet.ServletMapping;
import org.eclipse.jetty.servlets.MultiPartFilter;

 
public class Main
{
    
	public static String system = "MAC";
//	public static String system = "Linux";
//	public static String system = "Windows";

    public static void main(String[] args) throws Exception
    {
        Server server = new Server();
        SelectChannelConnector connector = new SelectChannelConnector();
        connector.setPort(8080);
        server.addConnector(connector);
        
        ResourceHandler resource_handler = new ResourceHandler();
        resource_handler.setDirectoriesListed(false);
        resource_handler.setWelcomeFiles(new String[]{ "index.html" });

        resource_handler.setResourceBase("./static");

        
        ContextHandler context = new ContextHandler();
        context.setContextPath("/solver");
        context.setResourceBase(".");
        context.setClassLoader(Thread.currentThread().getContextClassLoader());
        server.setHandler(context);
        
        context.setHandler(new SolverHandler());
        
        
        ServletContextHandler sh = new ServletContextHandler();
        MultiPartFilter mf = new MultiPartFilter();
        sh.addFilter("org.eclipse.jetty.servlets.MultiPartFilter", "/upload", 0);
        sh.addServlet("BA.Server.FileUpload", "/upload");
        
        ContextHandler exportContext = new ContextHandler();
        exportContext.setContextPath("/export");
        exportContext.setResourceBase(".");
        exportContext.setClassLoader(Thread.currentThread().getContextClassLoader());
        server.setHandler(exportContext);
        
        exportContext.setHandler(new ExportHandler());
        HashSessionManager x = new HashSessionManager();
        x.setSavePeriod(1800);
        SessionHandler s = new SessionHandler(x);
        
        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[] { s,resource_handler,context,sh,exportContext, new DefaultHandler() });
        server.setHandler(handlers);
 
        server.start();
        server.join();
    }
}
