# Weather
Simple weather application.

## Android development

This is an app that attempts to use the latest cutting edge libraries and tools. As a summary:

 * Entirely written in [Kotlin](https://kotlinlang.org/)
 * Uses [Kotlin Coroutines](https://kotlinlang.org/docs/reference/coroutines/coroutines-guide.html) throughout.
 * Uses many of the [Architecture Components](https://developer.android.com/topic/libraries/architecture/): Room Lifecycle, Navigation
 * Uses [Hilt](https://dagger.dev/hilt/) for dependency injection
 * Slowly being migrated to use [Jetpack Compose](https://developer.android.com/jetpack/compose)

## Development setup

First off, you require the latest Android Studio 4.2 Canary to be able to build the app. This is because the project contains some pieces of UI which are written in [Jetpack Compose](https://developer.android.com/jetpack/compose) (more on that below).
