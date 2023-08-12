package com.example.cl.ejercicio8modulo6.data.local

import android.content.Context
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import androidx.arch.core.executor.testing.InstantTaskExecutorRule

import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

class BreedRoomDatabaseTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var breedsDao: RazaDao
    private lateinit var db: RazaDatabase

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, RazaDatabase::class.java).build()
        breedsDao = db.getRazaDao()
    }

    @After
    fun tearDown() {
        db.close()
    }

    @Test
    fun insertBreeds_empty() = runBlocking {
        // Given
        val breedList = listOf<RazaEntity>()

        // When
        breedsDao.insertRaza(breedList)

        // Then A
        val it = breedsDao.getRazas().getOrAwaitValue()
        assertThat(it).isNotNull() // assertEquals(it,null)
        assertThat(it).isEmpty() // assertEquals(it.size,0)


        // Then B
        breedsDao.getRazas().observeForever {
            assertThat(it).isNotNull()
            assertThat(it).isEmpty()
        }
    }

    @Test
    fun insertBreeds_happyCase_1element() = runBlocking {
        // Given
        val breedList = listOf(RazaEntity("breed1"))

        // When
        breedsDao.insertRaza(breedList)

        // Then
        breedsDao.getRazas().observeForever {
            assertThat(it).isNotNull()
            assertThat(it).isNotEmpty()
            assertThat(it).hasSize(1)
        }
    }

    @Test
    fun insertBreeds_happyCase_3elements() = runBlocking {
        // Given
        val breedList = listOf(RazaEntity("breed1"), RazaEntity("breed2"), RazaEntity("breed3"))

        // When
        breedsDao.insertRaza(breedList)

        // Then
        breedsDao.getRazas().observeForever {
            assertThat(it).isNotNull()
            assertThat(it).isNotEmpty()
            assertThat(it).hasSize(3)
        }
    }
}


@VisibleForTesting(otherwise = VisibleForTesting.NONE)
fun <T> LiveData<T>.getOrAwaitValue(
    time: Long = 2,
    timeUnit: TimeUnit = TimeUnit.SECONDS,
    afterObserve: () -> Unit = {}
): T {
    var data: T? = null
    val latch = CountDownLatch(1)
    val observer = object : Observer<T> {
        override fun onChanged(value: T) {
            data = value
            latch.countDown()
            this@getOrAwaitValue.removeObserver(this)
        }
    }
    this.observeForever(observer)

    try {
        afterObserve.invoke()

        // Don't wait indefinitely if the LiveData is not set.
        if (!latch.await(time, timeUnit)) {
            throw TimeoutException("LiveData value was never set.")
        }

    } finally {
        this.removeObserver(observer)
    }

    @Suppress("UNCHECKED_CAST")
    return data as T
}

