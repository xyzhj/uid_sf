package zhj.uid_sf;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(SnowFlakeProperties.class)
public class Config {

    @Bean
    public SnowFlake snowFlake(SnowFlakeProperties properties) {
        return new SnowFlake(properties);
    }

}
