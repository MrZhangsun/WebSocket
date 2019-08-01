package site.zhangsun.websocket.v1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * Functions: web Socket Configuration
 *
 * @author Murphy Zhang Sun
 * @date 2019-07-31 18:30
 * @since v4.0.1
 */
//@Configuration
public class WebSocketConfig {

    /**
     * function is to scan all @link{ServerEndpoint} and @link{ServerEndpointConfig}
     *
     * @return websocket context
     */
  // @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
