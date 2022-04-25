package uk.co.planetbeyond.data.prefs

import javax.inject.Inject

class AppPrefsImpl @Inject constructor(
    private val prefStore: PrefStore
) : AppPrefs {

    companion object{
        const val KEY_MSISDN = "msisdnKey"
        const val KEY_LANGUAGE_SELECTED = "languageSelectedKey"
        const val KEY_OTP_VERIFIED = "otpVerifiedKey"
        const val KEY_FIRST_TIME = "firstTimeKey"
        const val KEY_IS_TELENOR = "isTelenorKey"
        const val KEY_LOGGED_IN = "loggedInKey"
        const val KEY_WORKER = "workerKey"
        const val KEY_IS_VERIFIED = "isVerifiedKey"
        const val KEY_SKILLS = "skillsKey"
        const val KEY_CITIES = "citiesKey"
        const val KEY_PROVINCE = "provinceKey"
        const val KEY_OTP_HASH = "otpHashKey"
    }

    override fun otpHashCode(): String = prefStore.getString(KEY_OTP_HASH)
    override fun saveOtpHashCode(hashStr: String) = prefStore.saveString(KEY_OTP_HASH,hashStr)

    override fun msisdn(): String = prefStore.getString(KEY_MSISDN)
    override fun setMsisdn(msisdn: String) = prefStore.saveString(KEY_MSISDN,msisdn)

    override fun isLanguageSelected(): Boolean = prefStore.getBoolean(KEY_LANGUAGE_SELECTED)
    override fun setLanguageSelect() = prefStore.saveBoolean(KEY_LANGUAGE_SELECTED,true)

    override fun isOtpVerified(): Boolean = prefStore.getBoolean(KEY_OTP_VERIFIED)
    override fun setOtpVerified(otpVerified: Boolean) = prefStore.saveBoolean(KEY_OTP_VERIFIED,otpVerified)

    override fun isLoggedIn(): Boolean = prefStore.getBoolean(KEY_LOGGED_IN)
    override fun setLoggedIn(loggedIn: Boolean) = prefStore.saveBoolean(KEY_LOGGED_IN,loggedIn)

    override fun isFirstTime(): Boolean = prefStore.getBoolean(KEY_FIRST_TIME,true)
    override fun setFirstTime() {
        prefStore.saveBoolean(KEY_FIRST_TIME,false)
    }

    /*override fun setCities(cities: List<City>)  = prefStore.saveList(KEY_CITIES,cities)
    override fun getCities(): List<City> {
        val type = object : TypeToken<List<City>>() {}
        return prefStore.getList(KEY_CITIES,type)
    }

    override fun getProvinceList(): List<Province> {
        val type = object : TypeToken<List<Province>>() {}
        return prefStore.getList(KEY_PROVINCE,type)
    }
    override fun saveProvinceList(provinceList: List<Province>) = prefStore.saveList(KEY_PROVINCE,provinceList)

    override fun getSkills(): List<SkillsResponse>{
        val type = object : TypeToken<List<SkillsResponse>>() {}///.type
        ///val type = object : TypeToken<List<City>>() {}.type
        return prefStore.getList(KEY_SKILLS,type)
    }
    override fun setSkills(skills: List<SkillsResponse>) = prefStore.saveList(KEY_SKILLS,skills)*/

    override fun isWorker(): Boolean = prefStore.getBoolean(KEY_WORKER)
    override fun setWorker(isWorker: Boolean) = prefStore.saveBoolean(KEY_WORKER,isWorker)

    override fun isVerified(): Boolean = prefStore.getBoolean(KEY_IS_VERIFIED)
    override fun setVerified(isVerified: Boolean) = prefStore.saveBoolean(KEY_IS_VERIFIED,isVerified)

    override fun isTelenorUser(): Boolean = prefStore.getBoolean(KEY_IS_TELENOR,false)
    override fun setTelenorUser(telenorUser: Boolean) = prefStore.saveBoolean(KEY_IS_TELENOR,telenorUser)
}