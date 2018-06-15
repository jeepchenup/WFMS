package com.wfms.spring.beans.mix;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@Import({CDConfig.class, CDPlayerConfig.class})
@ImportResource("classpath:mix/mixed-bean.xml")
public class SystemConfig {

}
