package org.guyu.elasticsearch.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author guyu
 * created at 2018/12/3 4:21 PM
 */
@Configuration
//@EnableElasticsearchRepositories(basePackages = "org.guyu.elasticsearch.repository.es")
public class EsConfig {
    @Bean
    public IndexPrefix indexPrefix() {
        return new IndexPrefix();
    }

    public static class IndexPrefix {
        @Value("${pulse.profile:abc}")
        private String profile;
        public String getPrefix() {
            return profile;
        }
    }

    @Bean
    public IndexSuffix indexSuffix() {
        return new IndexSuffix();
    }

    public static class IndexSuffix {

        public String getSuffix() {
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.MONTH, 1);
            Date nextMonth = cal.getTime();
            DateFormat dateFormat = new SimpleDateFormat("YYYYMM");
            return dateFormat.format(nextMonth);
        }
    }

}
