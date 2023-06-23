package uz.infinity.mycontact

data class ContactData(
    val id : Int,
    val img: Int,
    val fullName: String,
    val phone: String
) {
    override fun equals(other: Any?): Boolean {
        if (other == null) return false
        if (other === this) return true
        if (other !is ContactData) return false
        return fullName == other.fullName
    }

    override fun hashCode(): Int {
        return this.fullName.hashCode()
    }
}

