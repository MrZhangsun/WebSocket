package site.zhangsun.stomp.pojo;

/**
 * Functions: HelloMessage
 *
 * @author Murphy Zhang Sun
 * @date 2019-08-01 17:06
 * @since v4.0.1
 */
public class HelloMessage {
    private String name;

    public HelloMessage() {
    }

    public HelloMessage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
