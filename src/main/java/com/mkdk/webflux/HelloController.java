package com.mkdk.webflux;

import org.reactivestreams.Publisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@RestController
public class HelloController {

	@GetMapping
	@ResponseBody
	public Publisher<String> sayHello(){
		return Mono.just("Hello world - Mono");
	}

	@GetMapping(value = "/flux")
	@ResponseBody
	public Publisher<String> sayMultipleHello(){
		List<String> lista = Arrays.asList("Hello 1\n", "Hello 2\n", "Hello 3\n", "Hello 4\n");
		return Flux.fromStream(lista.stream());
	}
}
