package i.love.wsq.springbucks;

import i.love.wsq.springbucks.model.Color;
import i.love.wsq.springbucks.model.OrderState;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbucksApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbucksApplication.class, args);

        System.out.println(Color.BLUE.ordinal());
    }

}
