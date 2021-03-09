package com.aboubakergb.noteapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Parcel
import android.os.Parcelable

class DbManager {

    companion object {
        const val dbName= "MyNotes"
        const val dbNotesTable ="Notes"
        const val colID = "ID"
        const val colTitle="Title"
        const val colDes = "Description"
        const val dbVersion = 1
    }

    // create table SQL
    val sqLCreateTable = "CREATE TABLE IF NOT EXISTS " + dbNotesTable + " (" + colID +" INTEGER PRIMARY KEY, "+ colTitle + "TEXT,"+
            colDes +"TEXT;"
    var sqlDB  : SQLiteDatabase?=null

    constructor(context: Context){
        // To access your database
        val db = DatabaseHelperNotes(context)
        // Gets the data repository in write mode
        sqlDB=db.writableDatabase
    }

    inner class DatabaseHelperNotes:SQLiteOpenHelper{
        var context :Context?=null
        constructor(context:Context):super (context , dbName, null,dbVersion ){
            this.context=context

        }
        override fun onCreate(db: SQLiteDatabase?) {
            db?.execSQL(sqLCreateTable)
        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            db?.execSQL("DROP TABLE IF EXISTS $dbNotesTable")
        }

    }


    fun insertNote(values :ContentValues):Long{
        val id =sqlDB!!.insert(dbNotesTable,"",values)
        return id
    }


}