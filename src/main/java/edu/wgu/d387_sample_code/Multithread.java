package edu.wgu.d387_sample_code;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

@Component
public class Multithread{
    private String en_message;
    private String fr_message;
    static ExecutorService messageExecutor = newFixedThreadPool(2);
    public String[] getMessages() {
        Properties properties = new Properties();

        messageExecutor.execute(()-> {
            try {
                InputStream stream = new ClassPathResource("translation_en_US.properties").getInputStream();
                properties.load(stream);

                en_message = properties.getProperty("welcomeMessage");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        messageExecutor.execute(()-> {
            try {
                InputStream stream = new ClassPathResource("translation_fr_CA.properties").getInputStream();
                properties.load(stream);

                fr_message = properties.getProperty("welcomeMessage");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return new String[]{en_message, fr_message};
    }
}
