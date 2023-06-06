package app.futured.academyproject.tools.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import app.futured.academyproject.data.model.local.Place

class PlacesProvider : PreviewParameterProvider<List<Place>> {
    override val values = sequenceOf(
        listOf(
            Place(
                id = 1434,
                name = "Národní divadlo",
                type = "divadlo",
                longitude = 14.414,
                latitude = 50.081,
                image1Url = "https://gis.brno.cz/ost/filebox/ug_file.php?FILE_ID=180654&RECORD_ID=17554&AGENDA_IDENT=GEO_ASSETS"
            )
        )
    )
}
