package com.ign.springcloud.msvc.items;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MscvItemsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MscvItemsApplication.class, args);
	}

}
