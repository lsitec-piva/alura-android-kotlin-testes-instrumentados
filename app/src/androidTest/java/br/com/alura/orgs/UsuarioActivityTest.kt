package br.com.alura.orgs

import androidx.test.core.app.ActivityScenario.*
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.*
import br.com.alura.orgs.ui.activity.FormularioCadastroUsuarioActivity
import br.com.alura.orgs.ui.activity.LoginActivity
import org.junit.Test

class UsuarioActivityTest {

    @Test
    fun deveTerTodosOsCamposNecessariosFazerLogin() {
        launch(LoginActivity::class.java)

        onView(withId(R.id.activity_login_usuario)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.activity_login_senha)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.activity_login_botao_entrar)).check(ViewAssertions.matches(isDisplayed()))
    }

    @Test
    fun deveTerTodosOsCamposNecessariosFazerCadastro() {
        launch(FormularioCadastroUsuarioActivity::class.java)

        onView(withId(R.id.activity_formulario_cadastro_usuario)).check(
            ViewAssertions.matches(
                isDisplayed()
            )
        )
        onView(withId(R.id.activity_formulario_cadastro_email)).check(
            ViewAssertions.matches(
                isDisplayed()
            )
        )
        onView(withId(R.id.activity_formulario_cadastro_senha)).check(
            ViewAssertions.matches(
                isDisplayed()
            )
        )
        onView(withId(R.id.activity_formulario_cadastro_botao_cadastrar)).check(
            ViewAssertions.matches(
                isDisplayed()
            )
        )
    }

    @Test
    fun deveSerCapazDePreencherOsCamposDeLoginEEntrar() {
        launch(LoginActivity::class.java)

        onView(withId(R.id.activity_login_usuario))
            .perform(
                typeText("usuario_de_login"),
                closeSoftKeyboard()
            )
        onView(withId(R.id.activity_login_senha))
            .perform(
                typeText("senha_de_login"),
                closeSoftKeyboard()
            )

        onView(withId(R.id.activity_login_botao_entrar))
            .perform(click())
    }

    @Test
    fun deveSerCapazDePreencherOsCamposDeCadastroECadastrar() {
        launch(FormularioCadastroUsuarioActivity::class.java)

        onView(withId(R.id.activity_formulario_cadastro_usuario))
            .perform(
                typeText("usuario_de_cadastro"),
                closeSoftKeyboard()
            )
        onView(withId(R.id.activity_formulario_cadastro_email))
            .perform(
                typeText("cadastro@email.com"),
                closeSoftKeyboard()
            )
        onView(withId(R.id.activity_formulario_cadastro_senha))
            .perform(
                typeText("senha_de_cadastro"),
                closeSoftKeyboard()
            )

        onView(withId(R.id.activity_formulario_cadastro_botao_cadastrar))
            .perform(click())
    }

}