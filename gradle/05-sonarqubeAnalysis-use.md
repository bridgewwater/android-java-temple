# sonarqube Analysis

## notes

- use `sonarqubeAnalysis` must after setting plugin
- `only use in root build.gradle`
- must has sonarqube server
- need sonarqube user name
- need sonarqube password
- need sonarqube default skip module must of time is Integration-Test module
- because sonarqube analysis with full project, so one project must has one GROUP

## Setting Plugin

- add dependencies at `root build.gradle`

```gradle
buildscript {
    ...

    dependencies {
        ...
        classpath "org.sonarsource.scanner.gradle:sonarqube-gradle-plugin:2.2.1"
    }

    ...
}

...

apply from: rootProject.file("gradle/sonarqubeAnalysis.gradle")

```

> `sonarqube-gradle-plugin:2.2.1` can update by your want

- must In `root gradle.properties` edit

```properties
SONAR_HOST_URL=http://sonar.myServerURL.com
SONAR_LOGIN_USER=sonay_user
SONAR_LOGIN_PASSWORD=sonay_user_pwd
SONAR_DEFAULT_SKIP_MODULE=test
```

|key|for|desc|
|---|---|---|
|SONAR_HOST_URL|URL|sonarqube server url|
|SONAR_LOGIN_USER|user|sonarqube user|
|SONAR_LOGIN_PASSWORD|password|sonarqube user password|
|SONAR_DEFAULT_SKIP_MODULE|module|not analysis at setting.gradle|


- custom set of plugin

```properties
SONAR_PROJECT_NAME_TAG=Android:
SONAR_SOURCES=src
SONAR_SOURCES_ENCODING=UTF-8
```

|key|for|desc|
|---|---|---|
|PROJECT_ROOT_NAME|last tag|show at sonarqube projectName and projectKey default `use project clone father path`|
|SONAR_PROJECT_NAME_TAG|first tag|show at sonarqube project behind default is `Android:`|
|SONAR_SOURCES|source set|default is `src` at `each module`|
|SONAR_SOURCES_ENCODING|encode setting|default is `UTF-8`|


# analysis

- at root of project run

```sh
$ ./gradlew sonarqube
```

- if need `refresh-dependencies` or `generate`

```sh
$ ./gradlew clean --refresh-dependencies
$ ./gradlew :moduleName:generateReleaseSources
```

> moduleName change to your need generate

- if need set more module skip analysis add at `root build.gradle`

```gradle
project(":skipmodulename1") {
    sonarqube {
        skipProject = true
    }
}

project(":skipmodulename2") {
    sonarqube {
        skipProject = true
    }
}
```

> `skipmodulename1` or `skipmodulename2` is you module set at `setting.gradle`