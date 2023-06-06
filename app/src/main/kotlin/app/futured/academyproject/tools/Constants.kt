package app.futured.academyproject.tools

interface Constants {

    object Api {
        const val BASE_PROD_URL = "https://gis.brno.cz/ags1/rest/services/OMI/"
        const val TIMEOUT_IN_SECONDS = 30L
    }

    object Ui {
        const val PLACE_CARD_ASPECT_RATIO = 1.7f
        const val GRADIENT_OVERLAY_ALPHA = 0.7f
    }
}
