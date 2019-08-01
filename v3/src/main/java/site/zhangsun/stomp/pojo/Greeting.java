package site.zhangsun.stomp.pojo;

/**
 * Functions: Greeting
 *
 * @author Murphy Zhang Sun
 * @date 2019-08-01 17:10
 * @since v4.0.1
 */
public class Greeting {
    private String content;

    public Greeting() {
    }

    public Greeting(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
