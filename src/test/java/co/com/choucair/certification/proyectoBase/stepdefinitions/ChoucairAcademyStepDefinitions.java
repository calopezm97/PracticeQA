package co.com.choucair.certification.proyectoBase.stepdefinitions;

import co.com.choucair.certification.proyectoBase.model.AcademyChoucairData;
import co.com.choucair.certification.proyectoBase.questions.Answer;
import co.com.choucair.certification.proyectoBase.tasks.Login;
import co.com.choucair.certification.proyectoBase.tasks.OpenUp;
import co.com.choucair.certification.proyectoBase.tasks.Search;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;

public class ChoucairAcademyStepDefinitions {

    @Before
    public void setStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^than Carlos wants to learn automation at the academy Choucair$")
    public void thanCarlosWantsToLearnAutomationAtTheAcademyChoucair(List<AcademyChoucairData> academyChoucairData) throws Exception{
        OnStage.theActorCalled("Carlos").wasAbleTo(OpenUp.thePage(), (Login
                .onThePage(academyChoucairData.get(0).getStrUser(), academyChoucairData.get(0).getStrPass())));
    }


    @When("^he search for the course (.*) on the choucair academy platform$")
    public void heSearchForTheCourseFoundationLevelOnTheChoucairAcademyPlatform(List<AcademyChoucairData> academyChoucairData) throws Exception{
        OnStage.theActorInTheSpotlight().attemptsTo(Search.the(academyChoucairData.get(0).getStrCourse()));
    }

    @Then("^he finds the course called resources (.*)$")
    public void heFindsTheCourseCalledResourcesFoundationLevel(List<AcademyChoucairData> academyChoucairData) throws Exception {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(Answer.toThe(academyChoucairData.get(0).getStrCourse())));
    }

}
