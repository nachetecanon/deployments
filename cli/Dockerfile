FROM openjdk:10

COPY build/distributions/deployment-tool.tar /tmp/deployment-tool.tar
RUN tar -xf /tmp/deployment-tool.tar -C /opt/

ENTRYPOINT ["/opt/deployment-tool/bin/deployment-tool"]