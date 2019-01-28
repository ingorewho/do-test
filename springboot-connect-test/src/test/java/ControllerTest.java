import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 18:14 2018/11/15
 */
public class ControllerTest {

    public static void main(String[] args){
        String url = "http://127.0.0.1:8081/test";
        for (int i =0; i < 1; i++){
            Thread t = new Thread(()->{
                RestTemplate template = new RestTemplate();
                template.getForEntity(url , Object.class);
            });
            t.start();
        }
    }
}
