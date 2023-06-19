package app.futured.academyproject.data.model.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Properties(
    @SerialName("ogc_fid") val ogcFid: Int,
    @SerialName("nazev") val name: String,
    @SerialName("druh") val type: String,
    @SerialName("poznamka") val note: String? = null,
    @SerialName("web") val webUrl: String? = null,
    @SerialName("program") val program: String? = null,
    @SerialName("ulice") val street: String? = null,
    @SerialName("cp_co") val streetNumber: String? = null,
    @SerialName("email") val email: String? = null,
    @SerialName("telefon") val phone: String? = null,
    @SerialName("nazev_en") val nameEN: String? = null,
    @SerialName("poznamka_en") val noteEN: String? = null,
    @SerialName("pristupnost_id") val accessibilityId: String? = null,
    @SerialName("zastit_org") val protectionOrg: String? = null,
    @SerialName("brnopass") val brnoPass: String? = null,
    @SerialName("v_provozu") val inOperation: String,
    @SerialName("zastit_org_en") val protectionOrgEN: String? = null,
    @SerialName("otevrene_od") val openFrom: String? = null,
    @SerialName("otevrene_do") val openTo: String? = null,
    @SerialName("pristupnost") val accessibility: String? = null,
    @SerialName("pristupnost_en") val accessibilityEN: String? = null,
    @SerialName("mapa_pristupnosti") val accessibilityMap: String? = null,
    @SerialName("obr_id1") val image1Url: String? = null,
    @SerialName("obr_id2") val image2Url: String? = null,
    @SerialName("obr_id3") val image3Url: String? = null,
    @SerialName("obr_id4") val image4Url: String? = null,
    @SerialName("obr_id5") val image5Url: String? = null,
)
