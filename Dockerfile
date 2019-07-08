FROM alpine:3.9 as BUILD
LABEL maintainer="Ank"

ENV JAVA_HOME="/usr/lib/jvm/default-jvm"

RUN apk add --no-cache openjdk8 openjdk8-jre && \
    ln -sf "${JAVA_HOME}/bin/"* "/usr/bin/"

RUN apk add --no-cache git maven

ENV MEM_OPTS="-Xmx1g -Xms500m"
ENV GRADLE_OPTS="-server ${MEM_OPTS} -XX:+UseParallelGC -XX:SoftRefLRUPolicyMSPerMB=1 -XX:MaxHeapFreeRatio=99 -Dorg.gradle.daemon=false"

COPY . /intermine
WORKDIR /intermine

RUN apk add --no-cache bash

RUN /intermine/gradlew createUberJar

FROM alpine:3.9 as RUNTIME
LABEL maintainer="Ank"

ENV JAVA_HOME="/usr/lib/jvm/default-jvm"

RUN apk add --no-cache openjdk8-jre && \
    ln -sf "${JAVA_HOME}/bin/"* "/usr/bin/"

WORKDIR /intermine

COPY --from=BUILD  /intermine/build/libs/intermine-configurator-uber-0.1.0.jar /intermine/intermine-configurator.jar
COPY --from=BUILD  /intermine/src/main/resources/application.properties /intermine/app.properties
ENV MEM_OPTS="-Xmx1g -Xms500m"
ENV JAVA_OPTS="${MEM_OPTS} -XX:MaxHeapFreeRatio=99"
ENV IM_DATA_DIR=/intermine/data
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "-Dspring.config.location=/intermine/app.properties", "/intermine/intermine-configurator.jar"]