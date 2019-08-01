package site.zhangsun.stomp.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;
import site.zhangsun.stomp.pojo.Greeting;
import site.zhangsun.stomp.pojo.HelloMessage;

/**
 * Functions: GreetingController
 *
 * @author Murphy Zhang Sun
 * @date 2019-08-01 17:11
 * @since v4.0.1
 */
@RestController
public class GreetingController {
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }
}
