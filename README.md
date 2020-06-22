# Survey platform - system ankieterski
### description of the project

The platofrm allows you to pose a closed question, and answer others questions.
The user is free to chose the number of possible closed answers.
You can search for a question that interests you, just type a part of the content of the questions.
System generates also charts showing the collected data in an interesting way.

### opis projektu
Strona umożliwia zadawanie zamkniętych pytań i odpowiadanie na cudze pytania.
Użytkownik ma możliwość wybierania liczby możliwych zamkniętych odpowiedzi.
Można również wyszukiwać interesujące pytanie, wystarczy wpisać fragment jego treści.
System generuje również wykresy pokazujące zebrane dane w ciekawy sposób.

## Screenshots / Zrzuty ekranu

Adding questions - just fill up the form.

Dodawanie pytań - po prostu wypełnij formularz.
![You can add qouestion](/dodawanie_pytan.jpg)

Filtering questions - type some part of content of questions that interest you - you will see all the results.
You can also choose for your query a phrase fromt the list.

Filtrowanie pytań - napisz fragment treści pytań, które Cię interesują - zobaczysz wszystkie wyniki.
Możesz również wybrać do swojego zapytania wyrażenie z listy.
![You can search for qouestion](/wyszukiwanie_pytan.jpg)

Displaying the statistics -  type some part of content of the question that interest you - you will see 
the most accurate result.

Wyświetlanie statystyk - napisz fragment treści pytania, które Cię interesuje - zobaczysz najtrafniejszy
wynki.
![You can see the statistics](/statystyki.jpg)

### How to run the app / Jak uruchomić aplikację

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

###Technologies / Technologie

## Mongodb + React + Spring Boot
MongoDB CRUD app with Spring Boot and ReactJS front-end

Platform uses database "testdb":

![Database](/db-01.png)


Json view:

![Database](/db-02.png)

Aleksandra Cynk
Olena Obertynska

