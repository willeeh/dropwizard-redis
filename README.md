dropwizard-redis
================

Example application to have a prototype with Dropwizard, Guice (IoC) and Redis.

Assumptions:
- Have dropwizard-guice as a dependency.
- Have installed Redis on your machine.
- Have launched redis-server on port 6379 (you can change the port but application.yml file should have the same one)

Easy as 1, 2, 3. Do the following:

```
git clone https://github.com/willeeh/dropwizard-redis.git
cd dropwizard-redis/
mvn package
java -jar target/dropwizard-redis-1.0-SNAPSHOT.jar server src/main/resources/local/application.yml
```

Go to a terminal and type:
```
curl -H "Accept: application/json" -H "Content-type: application/json" -X POST -d '{"message":"My first post!"}' http://localhost:8080/v1/post
```

Then you can see your post on redis launching redis-cli and type:
```
get posts:1
get counter:posts
```

This is it.
