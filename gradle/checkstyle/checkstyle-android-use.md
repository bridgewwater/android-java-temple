# jacoco-android

unit test code coverage use as: [https://www.eclemma.org/jacoco/](https://www.eclemma.org/jacoco/)

## notes

- `only use in module build.gradle`

## checkstyle coverage

- use at different module when in library

```gradle
apply plugin: 'com.android.library'

// checkstyle android library
apply from: rootProject.file("gradle/checkstyle/checkstyle-android-library.gradle")
```

- use at different module when in application

```gradle
apply plugin: 'com.android.application'
// checkstyle android application
apply from: rootProject.file("gradle/checkstyle/checkstyle-android-application.gradle")
```

**Generate checkstyle:**

The [checkstyle](http://www.puppycrawl.com/dtds/configuration_1_2.dtd) plugin generates coverage reports based off the unit tests.

```bash
$ gradlew checkstyleDebug
$ gradlew [module]:checkstyleDebug
$ gradlew [module]:checkstyleRelease
```


- see coverage xml at `$moduleDir/build/reports/checkstyle`
- see coverage html at `$moduleDir/build/reports/checkstyle`
