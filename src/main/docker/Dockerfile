FROM frolvlad/alpine-oraclejdk8:slim
MAINTAINER ssins<ssins@hextec.cn>
ENV TIME_ZONE Asia/Shanghai
ARG APP_NAME
ARG APP_VERSION
ENV APP_NAME ${APP_NAME}
ENV APP_VERSION ${APP_VERSION}
RUN apk update \
  && apk add --no-cache tzdata \
  && ln -sf /usr/share/zoneinfo/${TIME_ZONE} /etc/localtime \
  && echo "${TIME_ZONE}" > /etc/timezone
VOLUME /tmp
ADD ${APP_NAME} ${APP_NAME}
CMD /usr/lib/jvm/java-8-oracle/jre/bin/java -jar -Djava.security.egd=file:/dev/./urandom ${APP_NAME}
EXPOSE 8080