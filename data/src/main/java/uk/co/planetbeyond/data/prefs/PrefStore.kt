package uk.co.planetbeyond.data.prefs

import com.google.gson.reflect.TypeToken

interface PrefStore {

    fun getString(key: String, def: String = ""): String
    fun getBoolean(key: String, def: Boolean = false): Boolean

    fun saveString(key: String, value: String?)
    fun saveBoolean(key: String, value: Boolean?)

    fun getInt(key: String, value: Int = -1): Int // -1
    fun saveInt(key: String, value: Int)

    fun saveLong(key: String,value: Long)
    fun getLong(key: String,def:Long = -1L):Long

    ///fun <T> getObject(key: String,typeToken: Type):T?
    fun <T> getObject(key: String,typeToken: TypeToken<T>): T?
    fun <T> saveObject(key: String,value:T?)

    fun <T> getList(key: String, typeToken: TypeToken<List<T>>): List<T>
    fun <T> saveList(key: String,value:List<T>)

    ///fun <T> getList(key: String,type:T): List<T>

    fun remove(key: String)
}