# check env set ANDROID_HOME
checkEnvAndroidHome:
ifndef ANDROID_HOME
	@ echo Environment variable ANDROID_HOME is not set
	exit 1
endif

# init this project
init: checkEnvAndroidHome
	$(ROOT_PWD)/gradlew clean buildEnvironment

cleanRoot:
	$(ROOT_PWD)/gradlew clean

adbCrash: checkEnvAndroidHome
	adb shell dumpsys dropbox --print data_app_crash

helpAndroidBase:
	@echo "=> $(ROOT_PWD)/z-android-base.mk : android base task"
	@echo "make init -> init this project for check base build error"
	@echo "make adbCrash ~> show last crash info"
	@echo ""