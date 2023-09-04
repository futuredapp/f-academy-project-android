package app.futured.academyproject.tools.extensions

import android.content.Intent
import android.net.Uri
import app.futured.academyproject.data.model.local.Place


fun Place.createNavigationIntent(): Intent = Intent(
    Intent.ACTION_VIEW,
    Uri.parse("geo:${latitude},${longitude}?q=${name}"),
)