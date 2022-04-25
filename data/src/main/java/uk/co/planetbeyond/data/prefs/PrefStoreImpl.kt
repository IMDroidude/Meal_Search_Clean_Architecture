package uk.co.planetbeyond.data.prefs

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PrefStoreImpl @Inject constructor(@ApplicationContext context: Context) : PrefStore {

    private val sharedPrefs = context.getSharedPreferences("planet_beyond_prefs", Context.MODE_PRIVATE)

    override fun getInt(key: String, value: Int): Int = sharedPrefs.getInt(key, value)

    override fun saveInt(key: String, value: Int) {
        sharedPrefs.edit().putInt(key, value).apply()
    }

    override fun saveLong(key: String, value: Long) {
        sharedPrefs.edit().putLong(key,value)
    }

    override fun getLong(key: String, def: Long) = sharedPrefs.getLong(key,-1L)

    override fun getBoolean(key: String, def: Boolean): Boolean {
        return sharedPrefs.getBoolean(key, def)
    }
    override fun saveBoolean(key: String, value: Boolean?) {
        sharedPrefs.edit().putBoolean(key, value ?: false).apply()
    }

    override fun getString(key: String, def: String): String {
        return sharedPrefs.getString(key, def) ?: def
    }
    override fun saveString(key: String, value: String?) {
        sharedPrefs.edit().putString(key, value).apply()
    }

    override fun remove(key: String) {
        sharedPrefs.edit().remove(key).apply()
    }

    /*override fun <T> getObject(key: String, type: Type): T? {
        val json: String = getString(key, "{}")
        return Gson().fromJson(json, type)
    }*/
    /*inline fun <reified T> genericType() = object: TypeToken<T>() {}.type
    val turnsType = genericType<AppConfig>()*/
    override fun <T> getObject(key: String,typeToken: TypeToken<T>): T? {
        val json: String = getString(key, "{}")
        return Gson().fromJson(json, typeToken.type)
    }
    override fun <T> saveObject(key: String, value: T?) {
        val json = Gson().toJson(value)
        saveString(key,json)
    }

    override fun <T> getList(key: String, typeToken: TypeToken<List<T>>): List<T> {
        return Gson().fromJson(getString(key, "[]"), typeToken.type)
    }

    override fun <T> saveList(key: String, value: List<T>) {
        val gson = GsonBuilder().create()
        val jsonArray = gson.toJsonTree(value).asJsonArray
        saveString(key,jsonArray.toString())
    }
}