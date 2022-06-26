package com.example.main_animal_villa

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.animal_villa.MainViewModel
import com.animal_villa.dto.Character
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import junit.framework.Assert.assertNotNull
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.*
import org.junit.rules.TestRule
import java.util.*
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

class CharacterTests {

    @get:Rule
    var rule : TestRule = InstantTaskExecutorRule()
    var character : Character? = Character()

    lateinit var characterService : CharacterService

    lateinit var mvm : MainViewModel

    @MockK
    lateinit var mockCharacterService : CharacterService

    private val mainThreadSurrogate = newSingleThreadContext("Main Thread")

    @Before
    fun initMocksAndMainThread()    {
        MockKAnnotations.init(this)
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @After
    fun tearDown()  {
        Dispatchers.resetMain()
        mainThreadSurrogate.close()
    }

    @Test
    fun `given character data is available when I name my character Billy and give them the janitor occupation then Character class should have Billy as name and Janitor as occupation` () = runTest {
        givenCharacterServiceIsInitialized()
        whenCharacterDataAreReadAndParsed()
        thenTheCharacterShouldHaveTheNameBillyAndTheOccupationJanitor()
    }

    @Test
    private fun givenCharacterServiceIsInitialized()    {
        characterService = CharacterService()
    }

    @Test
    private suspend fun whenCharacterDataAreReadAndParsed() {
        character = characterService.fetchCharacter()
    }

    @Test
    private fun thenTheCharacterShouldHaveTheNameBillyAndTheOccupationJanitor()    {
        assertNotNull(character)
        assertTrue(character.toString().equals("Billy Janitor"))
    }

    @Test
    fun `given a view model with live data when populated with a character then result shows character data` () = runTest {
        givenViewModelIsInitializedWithMockData()
        whenJSONDataAreReadAndParsed()
        thenResultsShouldContainCharacter()
    }

    private fun givenViewModelIsInitializedWithMockData() {
        val character = Character("Billy", "Janitor")

        coEvery { mockCharacterService.fetchCharacter() } returns character

        mvm = MainViewModel()
        mvm.characterService = mockCharacterService
    }

    private fun whenCharacterServiceFetchCharacterInvoked() {
        mvm.fetchCharacter()
    }

    private fun thenResultsShouldContainCharacter() {
        var resultCharacter : Character? = Character()
        val latch = CountDownLatch(1)
        val observer = object : Observer<Character> {
            override fun onChanged(t: Character?) {
                resultCharacter = t
                latch.countDown()
                mvm.character.removeObserver(this)
            }
        }
        mvm.character.ObserveForever(observer)
        latch.await(10, TimeUnit.SECONDS)
        assertNotNull(character)
        assertTrue(character.toString().equals("Billy Janitor"))
    }
}