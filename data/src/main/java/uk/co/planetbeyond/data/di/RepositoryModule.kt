package uk.co.planetbeyond.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uk.co.planetbeyond.data.prefs.AppPrefs
import uk.co.planetbeyond.data.prefs.AppPrefsImpl
import uk.co.planetbeyond.data.prefs.PrefStore
import uk.co.planetbeyond.data.prefs.PrefStoreImpl
import uk.co.planetbeyond.data.repository.RepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindPrefStore(prefStoreImpl: PrefStoreImpl): PrefStore

    @Binds
    fun bindAppPrefs(appPrefsImpl: AppPrefsImpl): AppPrefs

    /*@Binds
    fun bindRepository(repositoryImpl: RepositoryImpl): Repository*/
}