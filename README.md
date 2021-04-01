# docker-karaf-grpc-example

This repository provides an example how you can access an [OSGi service](http://docs.osgi.org/specification/osgi.cmpn/7.0.0/service.component.html) from outside the OSGi ecosystem (e.g. plain Java, Python, Go, C#, and all other [languages supported by gRPC](https://grpc.io/docs/languages/)).

Note that this example is based on the HealthCheck example on [grpc-RemoteServiceProvider](https://github.com/ECF/grpc-RemoteServicesProvider).


## Overview 

Basically it works as follows:
* Install and run [Apache Karaf](https://karaf.apache.org/) (in a [Docker](https://www.docker.com/) container in this case).
* In Karaf, install the [grpc-RemoteServiceProvider](https://github.com/ECF/grpc-RemoteServicesProvider).
  * It will distribute installed OSGi services based upon [gRPC](https://grpc.io/).
* Generate your OSGi service using the [grpc-osgi-generator](https://github.com/ECF/grpc-osgi-generator).
  * In this example a simple "GreetService" is used. It receives a request with title + name and returns a greeting response.
* Deploy your OSGi service on Karaf.
* Now the deployed OSGi service can be consumed by any gRPC client without requiring any OSGi related dependencies.

### Code Overview
* [OSGi service definition (specified with .proto)](https://github.com/martinschemel/docker-karaf-grpc-example/blob/master/masche.example.greetservice.api/src/main/proto/greet.proto)
* [OSGi service implementation](https://github.com/martinschemel/docker-karaf-grpc-example/blob/master/masche.example.greetservice.impl/src/masche/example/greetservice/impl/GreetServiceImpl.java)
* [Plain Java (gRPC) client](https://github.com/martinschemel/docker-karaf-grpc-example/blob/master/masche-example-plain-grpc-greetclient/src/main/java/masche/example/greetservice/client/Main.java)

## Test It Yourself

Execute the following steps to test yourself:

### Run Karaf in Docker With the Greet Example Pre-Installed

Clone this repository and cd into `docker/`. Now build an image with 
```
docker build -t greet-example .
```
and start a new container based on the built image with
```
docker run -it --rm -p 50002:50002 greet-example
```
Wait a few seconds until Karaf has all pre-configured features installed (features to pre-install are configured in [docker-karaf-grpc-preinstalled-features.xml](https://github.com/martinschemel/docker-karaf-grpc-example/blob/master/docker/docker-karaf-grpc-preinstalled-features.xml) which is copied to the `$KARAF_HOME/deploy` directory, see [Dockerfile](https://github.com/martinschemel/docker-karaf-grpc-example/blob/master/docker/Dockerfile)). The feature installation has finished when the endpoint description is printed to console. Something like this:
```xml
--Endpoint Description---
<endpoint-descriptions xmlns="http://www.osgi.org/xmlns/rsa/v1.0.0">
  <endpoint-description>
    <property name="ecf.endpoint.id" value-type="String" value="grpc://localhost:50002"/>    
    <property name="objectClass" value-type="String">
      <array>
        <value>masche.example.greet.v1.GreetServiceService</value>
      </array>
    </property>
    <!-- ... more lines -->
  </endpoint-description>
</endpoint-descriptions>
---End Endpoint Description
```

The service can now be consumed with any gRPC client. All you need is the [greet.proto](https://raw.githubusercontent.com/martinschemel/docker-karaf-grpc-example/master/masche.example.greetservice.api/src/main/proto/greet.proto) file.

### Example Plain gRPC-Java Client
_(If you open the code in Eclipse, you probably want to install the `org.eclipse.ecf.provider.grpc` feature from updatesite http://raw.githubusercontent.com/ECF/grpc-RemoteServicesProvider/master/build)_

Clone this repository and cd into `masche-example-plain-grpc-greetclient/`. This is a simple Java project (no plug-in, no OSGi dependencies). It contains a copy of the [greet.proto](https://github.com/martinschemel/docker-karaf-grpc-example/blob/master/masche-example-plain-grpc-greetclient/src/main/proto/greet.proto) file and a [main class](https://github.com/martinschemel/docker-karaf-grpc-example/blob/master/masche-example-plain-grpc-greetclient/src/main/java/masche/example/greetservice/client/Main.java) consuming the GreetService. The generated sources are not committed, so you first have to build it with maven (`mvn clean install`) to generate the sources for the .proto file. See [gRPC-java](https://github.com/grpc/grpc-java) for details.

Now you can run the main and should see the following console output:
```
Response: Hello Dr. Doc.
```

## Recommended Reading
* Learn more about OSGi remote services and the gRPC remote service provider in particular on https://github.com/ECF/grpc-RemoteServicesProvider
* Karaf quick start: https://karaf.apache.org/manual/latest/#_quick_start
* gRPC (Java) quick start: https://grpc.io/docs/languages/java/quickstart/
