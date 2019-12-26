# ifood-backend-api

Backend able to accept RESTful requests receiving as parameter either city name or lat long coordinates and returns a playlist suggestion according to the current temperature


## Technical Details

Application developed in Java 8, Spring Boot, WebFlux with JUnit as a test framework, and Jacoco for test coverage. The user can enter the city name or city latitude and longitude, and based on the parameters our backend will do a search in an OpenWeather API returning the temperature in this city, based on this temperature our backend will sort which track type , and will search the Deezer API for a playlist.


### Installation and Execution

	1 - Download the sources or clone the repository located at https://github.com/rjramos70/ifood-backend-api;
	2 - Open the IDE of your choice;
	3 - Import the project into your workspace;
	4 - Verify if the project has the JUnit 4 library in its pathway;
	5 - Build the project by right-clicking > Run As > Maven Build ... > in the 'Goals' field fill in with 'clean package' and then clicking on the 'Run' button;


### Run the Project

To run the project right click on the project name > Run As > Spring Boot App.


## Test the Project

Our project is initially set to run on **port 9091**, as per our configuration file 'application.yml'.

To test our API the user can use either the browser of his choice or Postman to make a request of type GET.

The available services are:

Get playlist by city name:

[http://localhost:9091/api/v1/playlist/{city_name}](http://localhost:9091/api/v1/playlist/{city_name})

get playlist by latitude and longitude:

[http://localhost:9091/api/v1/playlist/{latitude}/{longitude}](http://localhost:9091/api/v1/playlist/{latitude}/{longitude})

Both requests return the following JSon:

```
{
    "city_name": "...",
    "temperature": 0,
    "latitude": 0.0,
    "longitude": 0.0,
    "suggest_track": "...",
    "tracks": {
        "data": [
            {
                "title": "...",
                "artist": {
                    "name": "..."
                },
                "album": {
                    "title": "..."
                }
            },
			{
                "title": "...",
                "artist": {
                    "name": "..."
                },
                "album": {
                    "title": "..."
                }
            }
        ]
    }
}
```


## Improvement

* Increase code test coverage so far by 91% to at least 95%.

* Due to the short time available no container was implemented with Docker

