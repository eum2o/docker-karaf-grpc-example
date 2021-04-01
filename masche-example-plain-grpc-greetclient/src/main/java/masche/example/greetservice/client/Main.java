package masche.example.greetservice.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import masche.example.greet.v1.GreetRequest;
import masche.example.greet.v1.GreetResponse;
import masche.example.greet.v1.GreetServiceGrpc;
import masche.example.greet.v1.GreetServiceGrpc.GreetServiceBlockingStub;
import masche.example.greet.v1.Greeting;

public class Main {
	public static void main(String[] args) {
		final ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50002).usePlaintext().build();

		final GreetServiceBlockingStub client = GreetServiceGrpc.newBlockingStub(channel);
		final String title = "Dr.";
		final String name = "Doc";

		final GreetResponse response = client.greet(GreetRequest.newBuilder()
				.setGreeting(Greeting.newBuilder().setTitle(title).setName(name).build()).build());

		System.out.println("Response: " + response.getResult());

		channel.shutdown();
	}
}
