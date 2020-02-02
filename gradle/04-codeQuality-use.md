# code Quality

## notes

- use `codeQuality` must after setting plugin
- `only use in module build.gradle`

## Setting Plugin

`root build.gradle`

```gradle
buildscript {
    ...

    dependencies {
        ...
        classpath "org.kt3k.gradle.plugin:coveralls-gradle-plugin:2.8.1"
    }
}
```

`module android build.gradle`

```gradle
apply from: rootProject.file("gradle/codeQualityApp.gradle")
// apply from: rootProject.file("gradle/codeQualityLib.gradle")

...
android {
    testOptions.unitTests {
        all {
            jacoco {
                includeNoLocationClasses = true
            }
        }
    }
}
...
```

- `codeQualityApp.gradle` just use `apply plugin: 'com.android.application'`
- `codeQualityLib.gradle` just use `apply plugin: 'com.android.library'`

> if not setting `includeNoLocationClasses` will not report unitTests!

# code quality

## Lint Reports

**Generate Lint Reports:**


The [Lint](http://developer.android.com/tools/help/lint.html) plugin generates reports based off the source code.

    $ gradlew lintDebug

## pmd Reports

**Generate pmd Reports:**

    $ gradlew pmdDebug


## findbugs reports

**Generate findbugs Reports:**

    $ gradlew findbugsDebug

## jacoco coverage

**Generate Jacoco Test Coverage:**


The [Jacoco](http://www.eclemma.org/jacoco/) plugin generates coverage reports based off the unit tests.

    $ gradlew jacocoDebugReport
    $ gradlew [module]:jacocoDebugReport

## checkstyle coverage

**Generate checkstyle:**

The [checkstyle](http://www.puppycrawl.com/dtds/configuration_1_2.dtd) plugin generates coverage reports based off the unit tests.

    $ gradlew checkstyleDebug