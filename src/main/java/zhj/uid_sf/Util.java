package zhj.uid_sf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

@Component
@Configuration
@ConfigurationProperties(prefix = "server")
public class Util {

    @Value("${server.port}")
    private static int port;

    @Value("${project.version}")
    public static String version;

    public static InetAddress getNetInfo() throws Exception {
        return InetAddress.getLocalHost();
    }

    public static int getPort(){
        return port==0?8080:port;
    }

    public static String getVersion(){
        return version;
    }
}
