package dk.kvalitetsit.hello.configuration;

import dk.kvalitetsit.hello.service.FileService;
import dk.kvalitetsit.hello.service.ResponseTimeService;
import dk.kvalitetsit.hello.service.ResponseTimeServiceImpl;
import dk.kvalitetsit.prometheus.app.info.actuator.VersionProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ResponseTimeServiceConfiguration {
    @Bean
    public ResponseTimeService helloService(VersionProvider versionProvider, FileService fileService) {
        return new ResponseTimeServiceImpl(versionProvider.getVersion(), fileService);
    }
}
