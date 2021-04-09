# jacoco-android

unit test code coverage use as: [https://www.eclemma.org/jacoco/](https://www.eclemma.org/jacoco/)

## notes

- `only use in module build.gradle`

## jacoco coverage

- use at different module when in library

```gradle
apply plugin: 'com.android.library'

// jacoco android library
apply from: rootProject.file("gradle/jacoco/jacoco-android-library.gradle")
```

- use at different module when in application

```gradle
apply plugin: 'com.android.application'
// jacoco android application
apply from: rootProject.file("gradle/jacoco/jacoco-android-application.gradle")
```

**Generate Jacoco Test Coverage:**


The [Jacoco](http://www.eclemma.org/jacoco/) plugin generates coverage reports based off the unit tests.

```bash
$ gradlew jacocoDebugReport
$ gradlew [module]:jacocoDebugReport
$ gradlew [module]:jacocoReleaseReport
```

- see coverage xml at `$moduleDir/build/reports/jacoco`
- see coverage html at `$moduleDir/build/reports/jacocoHtml`
