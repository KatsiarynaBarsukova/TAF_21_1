package tests.api;

import baseEntities.BaseApiTest;
import com.google.gson.Gson;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Project;
import models.User;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class TestRaiApiTest1 extends BaseApiTest {

    private int projectID;

    @Test
    public void addProject1() {
        String endpoint = "index.php?/api/v2/add_project";

        Project expectedProject = Project.builder()
                .name("WP_Project_01")
                .annoucement("This is a description!!!")
                .isShowAnnouncement(true)
                .typeOfProject(1)
                .build();

        given()
                .body(String.format("{\n" +
                                "  \"name\": \"%s\",\n" +
                                "  \"announcement\": \"%s\",\n" +
                                "  \"show_announcement\": %b,\n" +
                                "  \"suite_mode\" : %d\n" +
                                "}"
                        expectedProject.getName(),
                        expectedProject.getAnnoucement(),
                        expectedProject.isShowAnnouncement(),
                        expectedProject.getTypeOfProject()
                ))
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void addProject3() {
        String endpoint = "index.php?/api/v2/add_project";

        Project expectedProject = Project.builder()
                .name("WP_Project_03")
                .annoucement("This is a description!!!")
                .isShowAnnouncement(true)
                .typeOfProject(1)
                .build();

        given()
                .body(expectedProject, ObjectMapperType.GSON)
                .log().body()
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void addProject4() {
        String endpoint = "index.php?/api/v2/add_project";

        Project expectedProject = Project.builder()
                .name("WP_Project_04")
                .annoucement("This is a description!!!")
                .isShowAnnouncement(true)
                .typeOfProject(1)
                .build();

        projectID = given()
                .body(expectedProject, ObjectMapperType.GSON)
                .log().body()
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().get("id");
        System.out.println(projectID);
    }
    @Test
    public void addProject5() {
        String endpoint = "index.php?/api/v2/add_project";

        Project expectedProject = Project.builder()
                .name("WP_Project_05")
                .annoucement("This is a description!!!")
                .isShowAnnouncement(true)
                .typeOfProject(1)
                .build();

        Response response = given()
                .body(expectedProject, ObjectMapperType.GSON)
                .log().body()
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        Assert.assertEquals(response.getBody().jsonPath().get("name"), expectedProject.getName());


    }
    @Test(dependsOnMethods = "addProject4")
    public void updateProject() {
        String endpoint = "/index.php?/api/v2/update_project/{project_id}";

        Project expectedProject = Project.builder()
                .name("WP_Project_03_upd")
                .typeOfProject(2)
                .build();

        given()
                .pathParam("project_id", projectID)
                .body(expectedProject, ObjectMapperType.GSON)
                .log().all()
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);

    }

}
