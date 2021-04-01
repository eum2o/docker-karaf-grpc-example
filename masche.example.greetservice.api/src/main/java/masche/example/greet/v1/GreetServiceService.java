package masche.example.greet.v1;

import io.reactivex.Flowable;
import io.reactivex.Single;

@javax.annotation.Generated(
value = "by grpc-osgi-generator (REACTIVEX) - A protoc plugin for ECF's grpc remote services distribution provider at https://github.com/ECF/grpc-RemoteServiceSProvider ",
comments = "Source: greet.proto.  ")
public interface GreetServiceService {

    
    default Single<masche.example.greet.v1.GreetResponse> greet(Single<masche.example.greet.v1.GreetRequest> requests)  {
        return null;
    }
}
