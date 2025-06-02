# android-java-temple

for android temple of project write as java

repo: [https://github.com/bridgewwater/android-java-temple](https://github.com/bridgewwater/android-java-temple)

## env

> max `jdk version 1.17`, `android studio 2024`

| item                           | version |
|:-------------------------------|:--------|
| jdk                            | 1.11+   |
| gradle                         | 7.4     |
| com.android.tools.build:gradle | 7.1.3   |
| android studio                 | 2021    |
| android build tools            | 32.0.0  |
| android compile sdk            | 32      |
| android min sdk                | 23      |
| android target sdk             | 32      |

- library version

| item                           | version |
|:-------------------------------|:--------|
| androidx.annotation:annotation | 1.2.0   |
| androidx.appcompat:appcompat   | 1.2.0   |
| androidx.multidex:multidex     | 2.0.1   |

- test library version

| item                        | version |
|:----------------------------|:--------|
| junit:junit                 | 4.13.2  |
| androidx.test:core          | 1.5.0   |
| org.robolectric:robolectric | 4.10.3  |

more version see [config.gradle](config.gradle)

## dev

task

```bash
# see help
make help
# init project
make init
# check dependency
make dep
# run ci
make ci
```