package me.ameerhamza.relaxe.data

import android.os.Bundle
import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.versionedparcelable.ParcelField
import com.google.gson.Gson
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Feature(
    val title: String,
    @DrawableRes val iconId: Int,
    val lightColor: Color,
    val mediumColor: Color,
    val darkColor: Color,
) : Parcelable


class FeatureParamType : NavType<Feature>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): Feature? {
        return bundle.getParcelable(key)
    }

    override fun parseValue(value: String): Feature {
        return Gson().fromJson(value, Feature::class.java)
    }

    override fun put(bundle: Bundle, key: String, value: Feature) {
        bundle.putParcelable(key, value)
    }
}
