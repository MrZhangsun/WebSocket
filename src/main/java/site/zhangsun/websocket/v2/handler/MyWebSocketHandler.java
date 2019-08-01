package site.zhangsun.websocket.v2.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Functions: WebSocket Controller Version 2.
 *
 * @author Murphy Zhang Sun
 * @date 2019-08-01 09:26
 * @since v4.0.1
 */
@Slf4j
@Component
public class MyWebSocketHandler implements WebSocketHandler {

    private static AtomicInteger counter = new AtomicInteger();

    private static List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) {
        // 收集所有的建立连接
        sessions.add(webSocketSession);
        counter.set(sessions.size());
        log.info("Finished Established Connection...., URL: {}", webSocketSession.getUri());
    }

    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) {
        if (webSocketMessage.getPayloadLength() != 0) {
            log.info("Received Message From Client: {}", webSocketMessage.getPayload().toString());
            log.info("Handle Client.....");
            return;
        }
        log.info("Head Beat...");
    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) {
        log.error(throwable.getCause().getMessage());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) {
        // remove closed session
        sessions.remove(webSocketSession);
        counter.set(sessions.size());
        log.info("Finished Closed Connection....");
    }

    /**
     * 是否支持消息拆分发送：如果接收的数据量比较大，最好打开(true), 否则可能会导致接收失败。
     * 如果出现WebSocket连接接收一次数据后就自动断开，应检查是否是这里的问题。
     */
    @Override
    public boolean supportsPartialMessages() {
        return true;
    }

    public static List<WebSocketSession> getSessions() {
        return sessions;
    }
}
