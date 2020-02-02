# Gradle Plugin

- if want full plugin add dependencies at `root build.gradle`

```gradle
buildscript {
    ...
    dependencies {
        classpath 'com.android.tools.build:gradle:2.2.3'
        classpath "org.kt3k.gradle.plugin:coveralls-gradle-plugin:2.8.1"
        classpath "org.sonarsource.scanner.gradle:sonarqube-gradle-plugin:2.2.1"
    ...
    }
}

```

- `com.android.tools.build:gradle` version must 2.2+

> you can import dependencies you want more info set use of utils

More info see at [preface of gradle for android](preface.md)

## Use

- scan and compile config

`root build.gradle`

```gradle
// utils
apply from: rootProject.file("gradle/utils.gradle")
// buildScan
apply from: rootProject.file("gradle/buildScan.gradle")
// codeQuality
apply from: rootProject.file("gradle/codeQuality.gradle")
```

`module build.gradle`

```gradle
// upload
apply from: rootProject.file("gradle/nexusUpload.gradle")
```

- custom compile

`root build.gradle`

```gradle
apply from: rootProject.file("gradle/compile.gradle")
```

- more info see [preface of gradle for android](preface.md)

# dependencies

## update

    $ gradlew tasks --refresh-dependencies

## seeDependencies

    $ gradlew :moduleName:dependencies

# **Running the Unit Tests:**


The [Junit](http://junit.org/junit4/) and [Robolectric](https://github.com/robolectric/robolectric) tests run on the JVM, no need for emulators or real devices.


    $ gradlew testDebug
    $ gradlew :module:testDebugUnitTest

## single unit test

**Run a single unit test in the `debug flavor`:**

    $ gradlew testDebug --tests="*MainActivityTest*"

## test with devices

    $ gradlew installDebug

# build APK

    $ gradlew clean assembleDebug
    $ gradlew clean assembleRelease