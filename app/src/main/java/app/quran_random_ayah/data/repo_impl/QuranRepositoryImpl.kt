package app.quran_random_ayah.data.repo_impl

import app.quran_random_ayah.data.remote.QuranApi
import app.quran_random_ayah.domain.model.Ayah
import app.quran_random_ayah.domain.repo.QuranRepository
import javax.inject.Inject

class QuranRepositoryImpl @Inject constructor(
    private val api: QuranApi
): QuranRepository {
    override suspend fun getRandomAyah(): Result<Ayah> {
        return try {
            val resp = api.getRandomAyah()
            val dto = resp.data
            if (resp.code == 200 && dto.text.isNotBlank()) {
                val ayah = Ayah(
                    number = dto.number,
                    text = dto.text,
                    surahName = dto.surah.name ?: "Unknown",
                    surahEnglishName = dto.surah.englishName
                )
                Result.success(ayah)
            } else {
                Result.failure(Exception("Empty response or missing data"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}