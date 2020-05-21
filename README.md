## Mongodb + React + Spring Boot

MongoDB CRUD app with Spring Boot and ReactJS front-end

#### Building the frontend continuously

In the main folder run:

```
npm install && npm run watch
```

to have your code be compiled constantly (found under `src/main/js`)

#### Building the backend and running it
Just use the gradle wrapper
```
./gradlew bootRun
```

If you want to reload the application after doing some changes, run (while the above is still running, in another terminal):

```
./gradlew compileJava
```


#### Running mongodb in docker

The easiest way to run mongodb is via a Docker container. Run:

```
docker run -it -p 27017:27017 --name mongo mongo

docker run -it -p 27017:27017 mongo
```

