package app.quran_random_ayah.domain.repo

import app.quran_random_ayah.domain.model.Ayah

interface QuranRepository {
    suspend fun getRandomAyah(): Result<Ayah>
}