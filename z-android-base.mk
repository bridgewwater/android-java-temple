# check env set ANDROID_HOME
checkEnvAndroidHome:
ifndef ANDROID_HOME
	@ echo Environment variable ANDROID_HOME is not set
	exit 1
endif

# init this project
.PHONY: init
init:
	@$(ROOT_PWD)/gradlew clean buildEnvironment --warning-mode all

.PHONY: cleanRoot
cleanRoot:
	$(ROOT_PWD)/gradlew clean

.PHONY: cleanGradleBuildAndIdea
cleanGradleBuildAndIdea:
	$(ROOT_PWD)/gradlew clean cleanBuildCache cleanIdea

.PHONY: adbCrash
adbCrash: checkEnvAndroidHome
	adb shell dumpsys dropbox --print data_app_crash

.PHONY: helpAndroidBase
helpAndroidBase:
	@echo "=> $(ROOT_PWD)/z-android-base.mk : android base task"
	@echo "make init                    ~> init this project for check base build error"
	@echo "make cleanRoot               ~> clean root"
	@echo "make cleanGradleBuildAndIdea ~> clean root"
	@echo "make adbCrash                ~> show last crash info"
	@echo ""