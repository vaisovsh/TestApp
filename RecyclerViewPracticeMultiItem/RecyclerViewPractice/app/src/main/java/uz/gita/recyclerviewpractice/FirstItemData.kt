package uz.gita.recyclerviewpractice

data class FirstItemData constructor(
    val name: String,
    val date: String
) : ItemViewData {
    override fun getItemType(): Int{
        return 0
    }
}