package com.example.cucumber;

import com.example.cucumber.controller.CourseController;
import com.example.cucumber.entity.CourseEntity;
import com.example.cucumber.model.Course;
import com.example.cucumber.repository.CourseRepository;
import com.example.cucumber.service.CourseService;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.AssertTrue;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class StepDefsIntegrationTest extends SpringIntegrationTest {

    @Autowired
    CourseController courseController;

    @Autowired
    CourseRepository courseRepository;

   // @Autowired
    //CourseEntity course;

    private List<CourseEntity> store;



    @When("^the client calls /udacity$")
    public void the_client_issues_POST_hello() throws Throwable {
        executePost();
    }

    @Given("^the client calls /hello$")
    public void the_client_issues_GET_hello() throws Throwable {
        executeGet("http://localhost:8080/hello");
    }

    @When("^the client calls /version$")
    public void the_client_issues_GET_version() throws Throwable {
        executeGet("http://localhost:8080/version");
    }

    @Then("^the client receives status code of (\\d+)$")
    public void the_client_receives_status_code_of(int statusCode) throws Throwable {
        final HttpStatus currentStatusCode = latestResponse.getTheResponse().getStatusCode();
        assertThat("status code is incorrect : " + latestResponse.getBody(), currentStatusCode.value(), is(statusCode));
    }

    @And("^the client receives server version (.+)$")
    public void the_client_receives_server_version_body(String version) throws Throwable {
        assertThat(latestResponse.getBody(), is(version));
    }

    @Given(": the following table")
    public void courseTable(DataTable table) {
        List<Map<String, String>> courses = table.asMaps();
        for (Map<String, String> course : courses) {
            String cId = course.get("id");
            String cTitle = course.get("title");
            String cDescription = course.get("description");
            assertThat(cId, is("5"));
            assertThat(cTitle, is("leidi"));
            assertThat(cDescription, is("how to solve problem"));
        }
    }
    @Then(": I will get the same data which is upload from endpoint")
    public void thenIWillGetTheSameDataWhichIsUpload(DataTable table) {
        List<String> courses = table.asList();
        String cId = courses.get(0);
        String cTitle = courses.get(1);
        String cDescription = courses.get(2);
        assertThat(cId, is("5"));
        assertThat(cTitle, is("leidi"));
        assertThat(cDescription, is("how to solve problem"));
    }
}