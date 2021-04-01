package masche.example.greet.v1;

import static masche.example.greet.v1.GreetServiceGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;


@javax.annotation.Generated(
value = "by RxGrpc generator",
comments = "Source: greet.proto")
public final class RxGreetServiceGrpc {
    private RxGreetServiceGrpc() {}

    public static RxGreetServiceStub newRxStub(io.grpc.Channel channel) {
        return new RxGreetServiceStub(channel);
    }

    public static final class RxGreetServiceStub extends io.grpc.stub.AbstractStub<RxGreetServiceStub> {
        private GreetServiceGrpc.GreetServiceStub delegateStub;

        private RxGreetServiceStub(io.grpc.Channel channel) {
            super(channel);
            delegateStub = GreetServiceGrpc.newStub(channel);
        }

        private RxGreetServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
            delegateStub = GreetServiceGrpc.newStub(channel).build(channel, callOptions);
        }

        @java.lang.Override
        protected RxGreetServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RxGreetServiceStub(channel, callOptions);
        }

        public io.reactivex.Single<masche.example.greet.v1.GreetResponse> greet(io.reactivex.Single<masche.example.greet.v1.GreetRequest> rxRequest) {
            return com.salesforce.rxgrpc.stub.ClientCalls.oneToOne(rxRequest,
                new com.salesforce.reactivegrpc.common.BiConsumer<masche.example.greet.v1.GreetRequest, io.grpc.stub.StreamObserver<masche.example.greet.v1.GreetResponse>>() {
                    @java.lang.Override
                    public void accept(masche.example.greet.v1.GreetRequest request, io.grpc.stub.StreamObserver<masche.example.greet.v1.GreetResponse> observer) {
                        delegateStub.greet(request, observer);
                    }
                }, getCallOptions());
        }

        public io.reactivex.Single<masche.example.greet.v1.GreetResponse> greet(masche.example.greet.v1.GreetRequest rxRequest) {
            return com.salesforce.rxgrpc.stub.ClientCalls.oneToOne(io.reactivex.Single.just(rxRequest),
                new com.salesforce.reactivegrpc.common.BiConsumer<masche.example.greet.v1.GreetRequest, io.grpc.stub.StreamObserver<masche.example.greet.v1.GreetResponse>>() {
                    @java.lang.Override
                    public void accept(masche.example.greet.v1.GreetRequest request, io.grpc.stub.StreamObserver<masche.example.greet.v1.GreetResponse> observer) {
                        delegateStub.greet(request, observer);
                    }
                }, getCallOptions());
        }

    }

    public static abstract class GreetServiceImplBase implements io.grpc.BindableService {

        public io.reactivex.Single<masche.example.greet.v1.GreetResponse> greet(io.reactivex.Single<masche.example.greet.v1.GreetRequest> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            masche.example.greet.v1.GreetServiceGrpc.getGreetMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            masche.example.greet.v1.GreetRequest,
                                            masche.example.greet.v1.GreetResponse>(
                                            this, METHODID_GREET)))
                    .build();
        }

        protected io.grpc.CallOptions getCallOptions(int methodId) {
            return null;
        }

    }

    public static final int METHODID_GREET = 0;

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final GreetServiceImplBase serviceImpl;
        private final int methodId;

        MethodHandlers(GreetServiceImplBase serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_GREET:
                    com.salesforce.rxgrpc.stub.ServerCalls.oneToOne((masche.example.greet.v1.GreetRequest) request,
                            (io.grpc.stub.StreamObserver<masche.example.greet.v1.GreetResponse>) responseObserver,
                            new com.salesforce.reactivegrpc.common.Function<io.reactivex.Single<masche.example.greet.v1.GreetRequest>, io.reactivex.Single<masche.example.greet.v1.GreetResponse>>() {
                                @java.lang.Override
                                public io.reactivex.Single<masche.example.greet.v1.GreetResponse> apply(io.reactivex.Single<masche.example.greet.v1.GreetRequest> single) {
                                    return serviceImpl.greet(single);
                                }
                            });
                    break;
                default:
                    throw new java.lang.AssertionError();
            }
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver<Req> invoke(io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                default:
                    throw new java.lang.AssertionError();
            }
        }
    }

}
