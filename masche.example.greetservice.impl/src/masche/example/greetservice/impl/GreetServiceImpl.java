package masche.example.greetservice.impl;

import org.osgi.service.component.annotations.Component;

import io.reactivex.Single;
import masche.example.greet.v1.GreetRequest;
import masche.example.greet.v1.GreetResponse;
import masche.example.greet.v1.GreetServiceService;
import masche.example.greet.v1.Greeting;
import masche.example.greet.v1.RxGreetServiceGrpc;

@Component(property = { "service.exported.interfaces=*", "service.exported.configs=ecf.grpc.server",
		"ecf.grpc.server.port=50002" })
public class GreetServiceImpl extends RxGreetServiceGrpc.GreetServiceImplBase implements GreetServiceService {

	@Override
	public Single<GreetResponse> greet(Single<GreetRequest> request) {
		System.out.println("Received greet request: " + request);
		final Greeting greeting = request.blockingGet().getGreeting();
		final String title = greeting.getTitle();
		final String name = greeting.getName();
		return Single.just(GreetResponse.newBuilder().setResult(String.format("Hello %s %s.", title, name)).build());
	}

}