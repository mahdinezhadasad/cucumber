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

import javax.validation.constraints.AssertTrue;
import java.util.List;
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

    @When(": I am calling this table CourseEntity")
    public void iAmCallingThisTableCourseEntity() {
        
    }

    @Then(": I add value in this ([a-zA-Z0-9-_]+) table:$")
    public void iAddValueInThisTable( DataTable table) {

        List<List<String>>  list = table.asLists(String.class);


       // for (List<String> columns : CourseEntity) {
         //   store.add(new CourseEntity(columns.get(0), columns.get(1),columns.get(2)));

        //}


    }

    @When(": then I will get the same data which is upload from endpoint")
    public void thenIWillGetTheSameDataWhichIsApload(DataTable table) {


        assertThat(table.cell(0,0), Boolean.parseBoolean("leidi"));
    }
}