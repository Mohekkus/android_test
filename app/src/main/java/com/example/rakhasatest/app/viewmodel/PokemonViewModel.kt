package com.example.rakhasatest.app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rakhasatest.app.repository.PokemonRepository
import com.example.rakhasatest.database.AppDatabase
import com.example.rakhasatest.database.room.PokemonEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.sync.withPermit

class PokemonViewModel(
    private val pokemonRepository: PokemonRepository,
    private val pokemonDatabase: AppDatabase
): ViewModel() {

    private var _pokemonList = MutableLiveData<MutableList<PokemonEntity>>()
    val pokemonList: LiveData<MutableList<PokemonEntity>> = _pokemonList

    fun getPokemonList() {
       CoroutineScope(Dispatchers.IO).launch {
            val offset =
                pokemonDatabase.pokemonDao().count()

            val response = pokemonRepository.getPokemonList(
                offset
            )
           }

    }

    private suspend fun getDetailedPokemon(indexDetailItem: String): PokemonEntity? {
        val response = pokemonRepository.getPokemon()


        return null
    }
}