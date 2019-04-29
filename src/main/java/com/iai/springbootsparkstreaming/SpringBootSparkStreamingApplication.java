package com.iai.springbootsparkstreaming;

import com.iai.springbootsparkstreaming.model.Product;
import com.iai.springbootsparkstreaming.services.ProductService;
import com.iai.springbootsparkstreaming.spark.services.EtlService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;

@SpringBootApplication
public class SpringBootSparkStreamingApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootSparkStreamingApplication.class, args);
//        context.getBean(EtlService.class).start();
    }

}
