# Nexus public utils

## notes

- use `nexusUpload` must after setting plugin
- `only use in module build.gradle`
- nexus must in `apply plugin: 'com.android.library'`
- nexus Server `just has nexus server`
- nexus repo URL `need three repo 'lib' 'module' 'module-SNAPSHOT'`
- nexus group `each project has one group, this for code quality`
- nexus artifact_id `each module in group artifact id`
- nexus user `nexus user name`
- nexus password `nexus user password`
- first config `root gradle.properties` and `module gradle.properties`

In `root gradle.properties` edit to new

```properties
VERSION_NAME=1.1.1-SNAPSHOT
VERSION_CODE=1001001
```

> `VERSION_NAME` is Very important!


## Setting Plugin

In `root gradle.properties` edit

```properties
VERSION_NAME=1.1.1
VERSION_CODE=1001001

# Project comple set
ANDROID_COMPILE_SDK_VERSION = 23
ANDROID_BUILD_TOOLS_VERSION = 23.0.3
ANDROID_MIN_SDK_VERSION = 15
ANDROID_TARGET_SDK_VERSION = 15

# important!
GROUP=com.code.android

# important!
#NEXUS_USERNAME=
#NEXUS_PASSWORD=
#RELEASE_REPOSITORY_URL=
#SNAPSHOT_REPOSITORY_URL = file:///Users/sinlov/Dowload/SNAPSHOT/mvn-repo/


POM_DEVELOPER_ID=tianran
POM_DEVELOPER_NAME=tianran <tianran@mail.com>

POM_LICENCE_NAME=The commany Software License, Version 1.0
POM_LICENCE_URL=http://www.keruyun.com//licenses/LICENSE-1.0.txt
POM_LICENCE_DIST=repo
POM_DESCRIPTION=
```


> if VERSION_NAME contans SNAPSHOT this project will archive to snapshots which archive to releases not chants

|key|for|desc|
|---|---|---|
|VERSION_NAME|version|like 0.0.1 for change release or debug|
|VERSION_CODE|code|for update|
|ANDROID_COMPILE_SDK_VERSION|compile sdk version|version for compile|
|ANDROID_BUILD_TOOLS_VERSION|build tools version|version of build tools|
|ANDROID_MIN_SDK_VERSION|min sdk version|version of this module support|
|ANDROID_TARGET_SDK_VERSION|target sdk version|version of target|
|SNAPSHOT_REPOSITORY_URL|snapshot repository| Nexus user can Override by env `SNAPSHOT_REPOSITORY_URL` default is mavenCenter snapshot |
|RELEASE_REPOSITORY_URL|release repository| Nexus user can Override by env `RELEASE_REPOSITORY_URL` default is mavenCenter release |
|GROUP|group ID|like package name com.game.package|
|NEXUS_USERNAME|nexus username|Nexus user can Override by env `NEXUS_USERNAME` |
|NEXUS_PASSWORD|nexus password|Nexus password can Override by env `NEXUS_PASSWORD`|
|SNAPSHOT_REPOSITORY_URL|snapshot repo|for develop|
|RELEASE_REPOSITORY_URL|release repo|for release|
|POM_DEVELOPER_ID|develop id|id of developer|
|POM_DEVELOPER_NAME|develop name|name of developer|
|POM_LICENCE_NAME|licence|name of licence|
|POM_LICENCE_URL|licence url|URL of licence|
|POM_LICENCE_DIST|dist|dist of licence|
|POM_DESCRIPTION|description|description of this project|


In `module gradle.properties` edit

```properties
POM_NAME=Android-modulename
# important!
POM_ARTIFACT_ID=modulename
POM_PACKAGING=aar
```

|key|for|desc|
|---|---|---|
|POM_NAME|name|name of this artifact|
|POM_ARTIFACT_ID|artifact ID|package zoo|
|POM_PACKAGING|packaging|packaging way aar of jar|

### POM_PACKAGING

|key|for|desc|
|---|---|---|
|aar|android compiler lib|out android arr package release|
|jar|android provided lib|out arr and jar package release use provided with `@jar` in `com.android.application`|
|eclipse|for old android ADT|out aar, jar, eclipse.zip for full|

In `module build.gradle` edit


```gradle
android {
    compileSdkVersion ANDROID_COMPILE_SDK_VERSION as int
    buildToolsVersion ANDROID_BUILD_TOOLS_VERSION

    defaultConfig {
        minSdkVersion ANDROID_MIN_SDK_VERSION as int
        targetSdkVersion ANDROID_TARGET_SDK_VERSION as int
        versionCode VERSION_CODE as int
        versionName VERSION_NAME
    }
    ...
}

...
// uploadArchives
apply from: rootProject.file("gradle/maven/nexusUpload.gradle")
```

# nexus upload

run

    $ gradlew uploadArchives

or

    $ gradlew :[module]:uploadArchives


> if `VERSION_NAME contains SNAPSHOT` this project will archive to snapshots which archive to releases not chants
