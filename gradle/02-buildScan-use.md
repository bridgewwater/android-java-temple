# buildScan

## notes

- use `buildScan` must after setting plugin
- `only use in root build.gradle`

## Setting Plugin

`root build.gradle`

```gradle
buildscript {
    ...
    repositories {
        maven { url "https://plugins.gradle.org/m2/" }
    }
    ...
    dependencies {
        classpath "com.gradle:build-scan-plugin:1.4"
    ...
    }
}

apply from: rootProject.file("gradle/buildScan.gradle")
```

# build scan

- setting plugin and use build scan