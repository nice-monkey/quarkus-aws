### build & deploy api-gateway on localstack with quarkus

1) start localstack 1.4.0

Make sure you pass this env variable when you start localstack container `LAMBDA_EXECUTOR=docker`

2) Install serverless

https://www.serverless.com/framework/docs/getting-started

In the project folder install the serverless plugin for localstack
```
sls plugin install -c ./serverless-local.yml -n serverless-localstack
```

1) Install graalVM
Download from https://www.graalvm.org/downloads/

Check java version
```
$ java --version
openjdk 11.0.17 2022-10-18
OpenJDK Runtime Environment GraalVM CE 22.3.0 (build 11.0.17+8-jvmci-22.3-b08)
OpenJDK 64-Bit Server VM GraalVM CE 22.3.0 (build 11.0.17+8-jvmci-22.3-b08, mixed mode, sharing)
```

2) build the app
```
./gradlew clean build -i -Dquarkus.package.type=native
```

3) deploy to localstack
```
sls deploy -c ./serverless-local
```

The result will look something like

```
✔ Service deployed to stack api-gateway-local (10s)

endpoint: http://localhost:4566/restapis/<API-ID>/local/_user_request_
functions:
  hello-api: api-gateway-local-hello-api (17 MB)
```

4) test the remote api (replace API-ID with the value from previous command)
```
curl -s  http://localhost:4566/restapis/<API-ID>/local/_user_request_/hello/ | jq
```
