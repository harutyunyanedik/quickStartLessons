package com.example.quickstartlessons.core.di

import androidx.room.Room
import com.example.quickstartlessons.core.room.FavoriteManager
import com.example.quickstartlessons.core.room.database.FavoriteDataBase
import org.koin.dsl.module

val roomModule = module {
    single {
        Room.databaseBuilder(get(), FavoriteDataBase::class.java, "favorite_database").fallbackToDestructiveMigration().build()
    }

    single {
        get<FavoriteDataBase>().dao
    }

    single {
        FavoriteManager(get())
    }
}