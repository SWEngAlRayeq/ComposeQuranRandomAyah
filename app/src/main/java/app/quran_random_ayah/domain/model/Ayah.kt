package app.quran_random_ayah.domain.model

data class Ayah(
    val number: Int,
    val text: String,
    val surahName: String,
    val surahEnglishName: String?
)