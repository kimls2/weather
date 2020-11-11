package app.weather.buildsrc

object Versions {
    const val ktlint = "0.39.0"
}

object Libs {
    const val androidGradlePlugin = "com.android.tools.build:gradle:4.2.0-alpha16"
    const val timber = "com.jakewharton.timber:timber:4.7.1"
    const val leakCanary = "com.squareup.leakcanary:leakcanary-android:2.5"

    object Accompanist {
        private const val version = "0.3.2"
        const val coil = "dev.chrisbanes.accompanist:accompanist-coil:$version"
    }

    object Mdc {
        const val material = "com.google.android.material:material:1.1.0"
        const val composeThemeAdapter =
            "com.google.android.material:compose-theme-adapter:1.0.0-alpha06"
    }

    object Kotlin {
        private const val version = "1.4.10"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
        const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:$version"
    }

    object Coroutines {
        private const val version = "1.4.0"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
    }

    object AndroidX {
        const val appcompat = "androidx.appcompat:appcompat:1.3.0-alpha02"
        const val browser = "androidx.browser:browser:1.0.0"
        const val collection = "androidx.collection:collection-ktx:1.1.0"
        const val recyclerview = "androidx.recyclerview:recyclerview:1.2.0-alpha06"

        object Navigation {
            private const val version = "2.3.1"
            const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"
            const val ui = "androidx.navigation:navigation-ui-ktx:$version"
            const val safeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:$version"
        }

        object Fragment {
            private const val version = "1.3.0-beta01"
            const val fragment = "androidx.fragment:fragment:$version"
            const val fragmentKtx = "androidx.fragment:fragment-ktx:$version"
        }

        const val constraintlayout = "androidx.constraintlayout:constraintlayout:2.0.2"
        const val coreKtx = "androidx.core:core-ktx:1.5.0-alpha04"

        object Lifecycle {
            private const val version = "2.3.0-beta01"
            const val extensions = "androidx.lifecycle:lifecycle-extensions:$version"
            const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
            const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
        }

        object Compose {
            private const val version = "1.0.0-alpha06"

            const val compiler = "androidx.compose.compiler:compiler:$version"

            const val runtime = "androidx.compose.runtime:runtime:$version"
            const val livedata = "androidx.compose.runtime:runtime-livedata:$version"

            const val foundation = "androidx.compose.foundation:foundation:$version"
            const val layout = "androidx.compose.foundation:foundation-layout:$version"

            const val ui = "androidx.compose.ui:ui:$version"
            const val material = "androidx.compose.material:material:$version"

            const val animation = "androidx.compose.animation:animation:$version"

            const val tooling = "androidx.ui:ui-tooling:$version"
            const val test = "androidx.ui:ui-test:$version"
        }

        object Hilt {
            private const val version = "1.0.0-alpha02"
            const val work = "androidx.hilt:hilt-work:$version"
            const val viewmodel = "androidx.hilt:hilt-lifecycle-viewmodel:$version"
            const val compiler = "androidx.hilt:hilt-compiler:$version"
        }
    }

    object Dagger {
        private const val version = "2.29.1"
        const val dagger = "com.google.dagger:dagger:$version"
        const val compiler = "com.google.dagger:dagger-compiler:$version"
    }

    object Hilt {
        private const val version = "2.29.1-alpha"
        const val library = "com.google.dagger:hilt-android:$version"
        const val compiler = "com.google.dagger:hilt-android-compiler:$version"
        const val testing = "com.google.dagger:hilt-android-testing:$version"
        const val gradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$version"
    }

    object Retrofit {
        private const val version = "2.9.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:$version"
    }

    object OkHttp {
        private const val version = "4.9.0"
        const val okhttp = "com.squareup.okhttp3:okhttp:$version"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$version"
    }

    object Coil {
        private const val version = "1.0.0-rc3"
        const val coil = "io.coil-kt:coil:$version"
    }

    object AssistedInject {
        private const val version = "0.6.0"
        const val annotationDagger2 =
            "com.squareup.inject:assisted-inject-annotations-dagger2:$version"
        const val processorDagger2 =
            "com.squareup.inject:assisted-inject-processor-dagger2:$version"
    }

    object Stetho {
        private const val version = "1.5.1"
        const val stetho = "com.facebook.stetho:stetho:$version"
        const val okhttp3 = "com.facebook.stetho:stetho-okhttp3:$version"
    }
}
