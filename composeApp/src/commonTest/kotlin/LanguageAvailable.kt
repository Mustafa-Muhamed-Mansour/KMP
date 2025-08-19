import com.scaffold.entities.LanguageModel
import com.scaffold.network.ApiService
import com.scaffold.repositories.LanguageRepository
import com.scaffold.response.LanguageResponse
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class LanguageAvailable {

    //Here "E3melele" test before for function (by using Junit Test)
    @Before
    fun beforeTest() {
        println(message = "Before test: Build")
    }

    //Here "E3melele" test after for function (by using Junit Test)
    @After
    fun afterTest() {
        println(message = "After test: tearDown")
    }

    //Here test Repository (by using Junit Test & fake data "mockk" )
    @Test
    fun testRepositoryForAvailableLanguage() = runTest { // (1) AAA
               // Arrange
        val apiService = mockk<ApiService>()
        val fakeResponse = LanguageResponse(
            languageModel = listOf(
                LanguageModel(language = "Arabic", native = "العربية", locale = "ar")
            )
        )
        coEvery { apiService.getAllLanguages() } returns fakeResponse
        val repo = LanguageRepository(apiService)

               // Act
        val result = repo.fetchAllLanguages().getOrNull()
        val language = result?.languageModel?.map { it.language }

               // Assert
        // here "E3melele" test ---> if the output that i'm expected equal to the output actual
        assertEquals(
            expected = listOf("Arabic"),
            actual = language
        )
    }
}


                     /* NOTE */
          // There is found a new school and she "GWT"
    // given instead of arrange, when instead of act, and then instead of assert