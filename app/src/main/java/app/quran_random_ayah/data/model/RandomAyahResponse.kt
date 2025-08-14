package app.quran_random_ayah.data.model

data class RandomAyahResponse(
    val code: Int,
    val status: String,
    val data: AyahDto
)

