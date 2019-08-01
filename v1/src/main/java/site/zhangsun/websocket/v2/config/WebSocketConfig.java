package site.zhangsun.websocket.v2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import site.zhangsun.websocket.v2.handler.MyWebSocketHandler;
import site.zhangsun.websocket.v2.intercepter.MyHandShakeInterceptor;

/**
 * Functions: Web Socket Configuration.
 *
 * @author Murphy Zhang Sun
 * @date 2019-08-01 09:46
 * @since v4.0.1
 */
@EnableWebMvc
@EnableWebSocket
@Configuration
public class WebSocketConfig implements WebSocketConfigurer {

    private final MyHandShakeInterceptor myHandShakeInterceptor;

    private final MyWebSocketHandler myWebSocketHandler;

    public WebSocketConfig(MyWebSocketHandler myWebSocketHandler, MyHandShakeInterceptor myHandShakeInterceptor) {
        this.myWebSocketHandler = myWebSocketHandler;
        this.myHandShakeInterceptor = myHandShakeInterceptor;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry
                // 类似于添加RequestMapping
                .addHandler(myWebSocketHandler, "/ws/v2/url")
                // 添加拦截器做AOP操作
                .addInterceptors(myHandShakeInterceptor)
                // 允许跨域
                .setAllowedOrigins("*");
    }
}
