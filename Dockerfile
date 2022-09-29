FROM markhobson/maven-chrome/maven-chrome:jdk-11

RUN mkdir -p /usr/src/app/igt-jv
RUN chmod -R 777 /usr/src/app/igt-jv
COPY $CODEBUILD_SRC_DIR /usr/src/app/igt-jv
WORKDIR /usr/src/app/igt-jv
COPY $CODEBUILD_SRC_DIR/codebuild-maven-settings.xml /root/.m2/settings.xml
RUN cd /usr/src/app/igt-jv/
RUN mkdir -p /usr/src/app/igt-jv/target/cucumber-reports
RUN mkdir -R 777 /usr/src/app/igt-jv/target/cucumber-reports