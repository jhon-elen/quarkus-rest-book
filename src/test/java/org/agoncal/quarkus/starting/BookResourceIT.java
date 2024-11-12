package org.agoncal.quarkus.starting;

import io.quarkus.test.junit.QuarkusIntegrationTest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusIntegrationTest
class BookResourceIT extends BookResourceTest {

    @Test
    void shouldGetABook() {
        given()
            .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
            .pathParam("id", 1)
        .when()
            .get("/api/books/{id}")
        .then()
            .statusCode(200)
            .body("title", is("Understanding Quarkus"))
            .body("author", is("Antonio"))
            .body("genre", is("Information Technology"))
            .body("yearOfPublication", is(2020));
    }
}
