package uz.gita.recyclerviewpractice

data class SecondItemData constructor(
    val title: String,
    val firstVariant: String,
    val secondVariant: String,
    val thirdVariant: String,
    val fourthVariant: String
) : ItemViewData {
    override fun getItemType(): Int {
        return 1
    }
}