# package

## notes

- use utils must after setting plugin

## config depend

add `package.gradle` at root of project

```gradle
subprojects {
    apply plugin: 'maven'
    apply plugin: 'idea'

    ext {
        test_depends = [
                junit                         : 'junit:junit:4.6',
                mockito_core                  : 'org.mockito:mockito-core:2.7.22',
                robolectric                   : 'org.robolectric:robolectric:3.3.2',
                robolectric_shadows_support_v4: 'org.robolectric:shadows-support-v4:3.3.2',
                easymock                      : 'org.easymock:easymock:3.4',
                powermock_core                : 'org.powermock:powermock-core:1.6.5',
                powermock_module_junit4       : 'org.powermock:powermock-module-junit4:1.6.5',
                powermock_api_easymock        : 'org.powermock:powermock-api-easymock:1.6.5',

        ]
        android_test_depends = [
                robotium_solo: 'com.jayway.android.robotium:robotium-solo:5.5.4'
        ]
        apt_compiler = [
                butterknife_compiler: 'com.jakewharton:butterknife-compiler:8.1.0',
        ]
        depends = [
                com_android_support_support_v4         : 'com.android.support:support-v4:25.0.1',
                com_android_support_appcompat_7        : 'com.android.support:appcompat-v7:25.0.1',
                com_android_support_support_annotations: 'com.android.support:support-annotations:25.0.1',
                com_android_support_recyclerview_v7    : 'com.android.support:recyclerview-v7:25.0.1',
                com_android_support_cardview_v7        : 'com.android.support:cardview-v7:25.0.1',
                com_android_support_design             : 'com.android.support:design:25.0.1',
                butterknife                            : 'com.jakewharton:butterknife:8.1.0',
        ]
        provided_depends = [
        ]
        custom_depends = [
        ]
    }
}
```

> you can add new note of this project dependencies

## Setting depend

`in root build.gradle`

```gradle
apply from: rootProject.file("package.gradle")
```

## use project center dependencies

`after root build.gradle setting` in `module build.gradle`

```gradle
dependencies {
//    compile fileTree(include: ['*.jar'], dir: 'libs')
    // test start
    testCompile test_depends.junit,
                test_depends.mockito_core,
                test_depends.robolectric,
                test_depends.robolectric_shadows_support_v4
    androidTestCompile android_test_depends.robotium_solo
    // test end
    apt apt_compiler.butterknife_compiler
    compile depends.com_android_support_support_v4,
            depends.com_android_support_appcompat_7,
//            depends.com_android_support_recyclerview_v7,
//            depends.com_android_support_cardview_v7,
//            depends.com_android_support_design,
            depends.butterknife,
            project(':yourMoudle')
}
```

## add new dependencies

in node of `package.gradle`

```gradle
...
        custom_depends = [
            new_dep_lib : 'com.my.group:mylib:1.0.0',
        ]
...
```

in use of depends

```gradle
    compile custom_depends.new_dep_lib
```