package app.quran_random_ayah.data.model

data class AyahDto(
    val number: Int,
    val text: String,
    val numberInSurah: Int?,
    val juz: Int,
    val surah: SurahDto
)
