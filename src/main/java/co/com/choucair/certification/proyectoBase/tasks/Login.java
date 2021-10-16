package co.com.choucair.certification.proyectoBase.tasks;

import co.com.choucair.certification.proyectoBase.userinterface.ChoucairLoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class Login implements Task {

    private String strUser;
    private String strPass;

    public static Login onThePage(String strUser, String strPass) {
        return Tasks.instrumented(Login.class, strUser, strPass);
    }

    public Login(String strUser, String strPass) {
        this.strUser = strUser;
        this.strPass = strPass;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(ChoucairLoginPage.LOGIN_BUTTON),
                Enter.theValue(strUser).into(ChoucairLoginPage.INPUT_USER),
                Enter.theValue(strPass).into(ChoucairLoginPage.INPUT_PASSWORD),
                Click.on(ChoucairLoginPage.ENTER_BUTTON));

    }
}
