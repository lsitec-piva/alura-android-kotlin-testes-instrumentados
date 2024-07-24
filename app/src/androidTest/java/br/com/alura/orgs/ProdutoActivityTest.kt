package br.com.alura.orgs

import androidx.test.core.app.ActivityScenario.*
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import br.com.alura.orgs.ui.activity.FormularioProdutoActivity
import br.com.alura.orgs.ui.activity.ListaProdutosActivity
import br.com.alura.orgs.ui.activity.LoginActivity
import org.junit.Test

class ProdutoActivityTest {

    @Test
    fun deveMostrarONomeDoAplicativo() {
        launch(ListaProdutosActivity::class.java)

        onView(withText("Orgs")).check(matches(isDisplayed()))
    }

    @Test
    fun deveMostrarNomeDoAplicativoQuandoEstaNaTelaDeLogin() {
        launch(LoginActivity::class.java)

        onView(withText("Orgs")).check(matches(isDisplayed()))
    }

    @Test
    fun deveMostrarCamposNecessariosParaCriarUmProduto() {
        launch(FormularioProdutoActivity::class.java)

        onView(withId(R.id.activity_formulario_produto_nome)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_formulario_produto_descricao)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_formulario_produto_valor)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_formulario_produto_botao_salvar)).check(matches(isDisplayed()))

    }

    @Test
    fun deveSerCapazDePreencherOsCamposESalvar() {
        launch(FormularioProdutoActivity::class.java)

        onView(withId(R.id.activity_formulario_produto_nome))
            .perform(
                typeText("Banana"),
                closeSoftKeyboard()
            )
        onView(withId(R.id.activity_formulario_produto_descricao))
            .perform(
                typeText("banana prata"),
                closeSoftKeyboard()
            )
        onView(withId(R.id.activity_formulario_produto_valor))
            .perform(
                typeText("6.99"),
                closeSoftKeyboard()
            )

        onView(withId(R.id.activity_formulario_produto_botao_salvar))
            .perform(click())

        launch(ListaProdutosActivity::class.java)

        onView(withText("Banana")).check(matches(isDisplayed()))
    }

}