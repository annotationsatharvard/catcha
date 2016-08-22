FROM tomcat:7

ENV version v0.5.12
ENV CATALINA_OPTS -Xms512m -Xmx512m -XX:MaxPermSize=256m

RUN  mkdir -p /root/.grails
COPY catch-config.properties /root/.grails

RUN rm -rf /usr/local/tomcat/webapps/ROOT \
    && curl -L -o /usr/local/tomcat/webapps/ROOT.war https://github.com/annotationsatharvard/catcha/releases/download/${version}/catch.war \
    && mkdir -p /usr/local/tomcat/webapps/ROOT \
    && unzip /usr/local/tomcat/webapps/ROOT.war -d /usr/local/tomcat/webapps/ROOT \
    # replace db host for docker-compose. This can be deprecated once the db parameters can be passed through environment variables
    && sed -i -e 's/mysql:\/\/localhost:3306/mysql:\/\/db:3306/' \
      -e 's/catch_test/catch/' \
      /root/.grails/catch-config.properties

VOLUME ['/usr/local/tomcat/webapps/ROOT/uploads']
