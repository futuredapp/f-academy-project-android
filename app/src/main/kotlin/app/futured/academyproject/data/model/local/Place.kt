package app.futured.academyproject.data.model.local

data class Place(
    val id: Int,
    val longitude: Double? = null,
    val latitude: Double? = null,
    val name: String,
    val type: String,
    val note: String? = null,
    val webUrl: String? = null,
    val program: String? = null,
    val street: String? = null,
    val streetNumber: String? = null,
    val email: String? = null,
    val phone: String? = null,
    val nameEN: String? = null,
    val noteEN: String? = null,
    val accessibilityId: String? = null,
    val openFrom: String? = null,
    val openTo: String? = null,
    val image1Url: String? = null,
)
