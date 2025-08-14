package app.quran_random_ayah.di

import app.quran_random_ayah.data.repo_impl.QuranRepositoryImpl
import app.quran_random_ayah.domain.repo.QuranRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindQuranRepo(impl: QuranRepositoryImpl): QuranRepository

}