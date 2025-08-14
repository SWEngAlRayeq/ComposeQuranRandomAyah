package app.quran_random_ayah.domain.usecase

import app.quran_random_ayah.domain.model.Ayah
import app.quran_random_ayah.domain.repo.QuranRepository
import javax.inject.Inject

class GetRandomAyahUseCase @Inject constructor(
    private val repository: QuranRepository
) {
    suspend operator fun invoke(): Result<Ayah> =
        repository.getRandomAyah()
}