package com.juaracoding;

import org.json.simple.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class TugasAPI {
    String endpointNowplaying = "https://api.themoviedb.org/3/movie/now_playing";

    @Test
    public void NowPlaying() {
        given()
                .queryParam("api_key", "b328e9ea1f68e15f3f0f289867c3c561")
                .queryParam("language", "en-US")
                .queryParam("page", "1")
                .when()
                .get("https://api.themoviedb.org/3/movie/now_playing")
                .then().statusCode(200); //then kayak assert , hasilnya nanti 200
    }

    @Test
    public void MoviePopular() {
        given()
                .queryParam("api_key", "b328e9ea1f68e15f3f0f289867c3c561")
                .queryParam("language", "en-US")
                .queryParam("page", "1")
                .when()
                .get("https://api.themoviedb.org/3/movie/now_playing")
                .then().statusCode(200);
    }

    @Test
    public void MovieRating() {
        JSONObject request = new JSONObject();
        request.put("value", "8.50");

        given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiMzI4ZTllYTFmNjhlMTVmM2YwZjI4OTg2N2MzYzU2MSIsInN1YiI6IjY0ZGNiY2U5YTNiNWU2MDBlMjliZjczOSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.BYcbvdk0ApL-kFvreWbqY-7Fa53gJS93Cstb_iWKfjY")

                .header("Content-Type", "application/json")
                .body(request.toJSONString())

                .when()
                .post("https://api.themoviedb.org/3/movie/1083862/rating")
                .then()
                .statusCode(201); //created

    }
}
