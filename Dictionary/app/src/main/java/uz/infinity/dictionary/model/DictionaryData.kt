package uz.infinity.dictionary.model

data class DictionaryData(
    val id: Int,
    val english: String,
    val type: String,
    val uzbek: String,
    var favourite: Int
)

