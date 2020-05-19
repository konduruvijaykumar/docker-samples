FROM openjdk:8

# We can only take jre by using FROM openjdk:8-jre
# Then we have to compile and copy class files from local to docker image while creation

# COPY . /usr/src/myapp
COPY HelloWorld.java /usr/src/myapp/

WORKDIR /usr/src/myapp

RUN javac HelloWorld.java

CMD ["java", "HelloWorld"]
