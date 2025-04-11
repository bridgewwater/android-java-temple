# android-java-temple

for android temple of project write as java

repo: [https://github.com/bridgewwater/android-java-temple](https://github.com/bridgewwater/android-java-temple)

## env

| item           | version |
| :------------- |:--------|
| jdk            | 1.11+   |
| gradle         | 7.4     |
| com.android.tools.build:gradle | 7.1.3   |
| android studio | 2021    |
| android build tools | 32.0.0  |
| android compile sdk | 32      |
| android min sdk | 23      |
| android target sdk | 32      |

- library version

| item                                | version |
|:------------------------------------| :------ |
| androidx.multidex:multidex          | 2.0.1   |
| androidx.multidex:multidex          | 2.0.1   |
| androidx.appcompat:appcompat        | 1.2.0   |

- test library version

| item                                | version |
|:------------------------------------|:--------|
| junit:junit:                        | 4.12    |
| androidx.test:core:                 | 1.5.0   |
| org.robolectric:robolectric         | 4.4     |

more version see [config.gradle](config.gradle)

## warning

if application use [view binding](https://developer.android.com/topic/libraries/view-binding)

if can not found databinding class, just use `File -> Invalidate Caches / Just Restart`