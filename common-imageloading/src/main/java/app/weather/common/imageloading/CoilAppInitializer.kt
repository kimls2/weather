package app.weather.common.imageloading

import android.app.Application
import android.content.Context
import app.weather.appinitializers.AppInitializer
import coil.Coil
import coil.ImageLoader
import coil.annotation.ExperimentalCoilApi
import coil.util.CoilUtils
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.OkHttpClient
import javax.inject.Inject

class CoilAppInitializer @OptIn(ExperimentalCoilApi::class)
@Inject constructor(
    private val okHttpClient: OkHttpClient,
    @ApplicationContext private val context: Context
) : AppInitializer {
    override fun init(application: Application) {
        val coilOkHttpClient = okHttpClient.newBuilder()
            .cache(CoilUtils.createDefaultCache(context))
            .build()
        Coil.setImageLoader {
            ImageLoader.Builder(application)
                .okHttpClient(coilOkHttpClient)
                .build()
        }
    }
}
