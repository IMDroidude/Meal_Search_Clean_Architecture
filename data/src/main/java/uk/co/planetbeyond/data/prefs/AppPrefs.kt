package uk.co.planetbeyond.data.prefs


interface AppPrefs {

    fun msisdn():String
    fun setMsisdn(msisdn:String)

    fun isLanguageSelected():Boolean
    fun setLanguageSelect()

    fun isOtpVerified():Boolean
    fun setOtpVerified(otpVerified:Boolean)

    fun isLoggedIn():Boolean
    fun setLoggedIn(loggedIn:Boolean)

    fun isWorker():Boolean
    fun setWorker(isWorker:Boolean)

    fun isVerified():Boolean
    fun setVerified(isVerified:Boolean)

    /*fun getSkills():List<SkillsResponse>
    fun setSkills(skills:List<SkillsResponse>)

    fun getProvinceList():List<Province>
    fun saveProvinceList(provinceList:List<Province>)

    fun getCities():List<City>
    fun setCities(cities:List<City>)*/

    fun otpHashCode():String
    fun saveOtpHashCode(hashStr:String)
    /*fun isEmployer():Boolean
    fun setEmployer(isEmployer:Boolean)*/

    //appStartFirstTime
    fun isFirstTime():Boolean
    fun setFirstTime()

    fun isTelenorUser():Boolean
    fun setTelenorUser(telenorUser:Boolean)
}