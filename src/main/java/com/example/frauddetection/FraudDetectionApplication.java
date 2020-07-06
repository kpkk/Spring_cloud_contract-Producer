package com.example.frauddetection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.PropertyMapper;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@EnableBinding(Source.class)
public class FraudDetectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(FraudDetectionApplication.class, args);
	}
}



	@RestController
	class FraudController {

	private final Source src;

		 FraudController(Source src){
			this.src=src;
		}



		@GetMapping("/frauds")
		ResponseEntity<List<String>> frauds() {


			return ResponseEntity.status(200)
					.body(Arrays.asList("Roger"));
		}

@PostMapping("/message")
		void triggerMessage(){
this.src.output().send(MessageBuilder.withPayload(new Fraud("m")).build());
}
	}


	@Data
//	@NoArgsConstructor
//	@AllArgsConstructor
	class Fraud{
	private String surname;

	Fraud(String surname){
		this.surname=surname;


	}

	}


