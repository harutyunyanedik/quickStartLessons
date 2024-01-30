package com.example.quickstartlessons.core.di

import androidx.room.Room
import com.example.quickstartlessons.core.room.FavoriteManager
import com.example.quickstartlessons.core.room.database.FavoriteDatabase
import org.koin.dsl.module

val roomModule = module{

    single{
        Room.databaseBuilder(get(),FavoriteDatabase::class.java,"product_database").fallbackToDestructiveMigration().build()
    }

    single{
        get<FavoriteDatabase>().dao
    }

    single{
        FavoriteManager(get())
    }

}