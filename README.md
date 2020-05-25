## Mongodb + React + Spring Boot

MongoDB CRUD app with Spring Boot and ReactJS front-end

![You can add qouestion](/dodawanie_pytan.jpg)
You can add qouestion


![You can search for qouestion](/wyszukiwanie_pytan.jpg)
You can search for qouestion


![You can see the statistics](/statystyki.jpg)
You can see the statistics



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
However it usually doesn't work (it works for single page apps), so you have to kill and revoke the above
```
./gradlew compileJava
```
Opens here: http://localhost:8080/

#### Running mongodb in docker

The easiest way to run mongodb is via a Docker container. Run:
(First time)
```
sudo systemctl start docker
docker run -it -p 27017:27017 --name mongo mongo
```

(later)
```
sudo systemctl start docker
docker run -it -p 27017:27017 mongo
```

