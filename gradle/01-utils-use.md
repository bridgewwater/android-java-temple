# utils

## notes

- use utils must after setting plugin

## Setting Plugin

`root build.gradle`

```gradle
...
apply from: rootProject.file("gradle/utils.gradle")
```

# utils use

## isReleaseBuild

```gradle
    if (isReleaseBuild()) {
        // release use
    } else {
        // SNAPSHOT use
    }
```

> this can let develop and release be different

## checkBasePropertiesConfig

- most use at `root build.gradle` for check base config error

```gradle
task clean(type: Delete) {
    checkBasePropertiesConfig()
    delete rootProject.buildDir
}
```

- not need config this