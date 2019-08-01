package site.zhangsun.websocket.v2.intercepter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import java.util.Map;

/**
 * Functions: Web Socket Hand Shake Interceptor Which Is Used to Do AOP Business.
 *      在连接建立的时候会执行下面相应的方法，连接建立完成之后就不会再执行，所以此处可以用来作权限校验等工作
 *
 * @author Murphy Zhang Sun
 * @date 2019-08-01 09:42
 * @since v4.0.1
 */
@Slf4j
@Component
public class MyHandShakeInterceptor extends HttpSessionHandshakeInterceptor {
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        log.info("Hand Shake Interceptor Before....");
        return super.beforeHandshake(request, response, wsHandler, attributes);
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception ex) {
        super.afterHandshake(request, response, wsHandler, ex);
        log.info("Hand Shake Interceptor After....");
    }
}
