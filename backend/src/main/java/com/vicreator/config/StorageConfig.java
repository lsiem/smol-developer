```java
package com.vicreator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.sftp.session.DefaultSftpSessionFactory;
import org.springframework.integration.sftp.session.SftpRemoteFileTemplate;

@Configuration
public class StorageConfig {

    @Bean
    public DefaultSftpSessionFactory sftpSessionFactory() {
        DefaultSftpSessionFactory factory = new DefaultSftpSessionFactory(true);
        factory.setHost("sftp.server.com");
        factory.setPort(22);
        factory.setUser("username");
        factory.setPassword("password");
        factory.setAllowUnknownKeys(true);
        return factory;
    }

    @Bean
    public SftpRemoteFileTemplate sftpRemoteFileTemplate() {
        return new SftpRemoteFileTemplate(sftpSessionFactory());
    }
}
```