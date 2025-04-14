# check env set ANDROID_HOME
checkEnvAndroidHome:
ifndef ANDROID_HOME
	@ echo Environment variable ANDROID_HOME is not set
	exit 1
endif

.PHONY: env
env:
	@echo "================ env start ================"
	@echo "ROOT_PWD                         ${ROOT_PWD}"
	@echo "ENV_GRADLE_WRAPPER_EXEC          ${ENV_GRADLE_WRAPPER_EXEC}"
	@echo "================ env end ================"
	@echo ""
	${ENV_GRADLE_WRAPPER_EXEC} --version

# init this project
.PHONY: init
init: checkEnvAndroidHome
	@${ENV_GRADLE_WRAPPER_EXEC} clean buildEnvironment --warning-mode all

.PHONY: clean.root
clean.root:
	${ENV_GRADLE_WRAPPER_EXEC} clean

.PHONY: clean.idea
clean.idea:
	${ENV_GRADLE_WRAPPER_EXEC} cleanIdea

.PHONY: clean.idea.module
clean.idea.module:
	${ENV_GRADLE_WRAPPER_EXEC} cleanIdeaModule

.PHONY: clean.build.catch
clean.build.catch:
	$(RM) -r .gradle/
	$(info finish remove folder .gradle)
	$(RM) -r build/
	$(info finish remove folder .build)
	$(RM) -r buildCache/
	$(info finish remove folder .buildCache)
	$(RM) -r buildCacheDir/
	$(info finish remove folder .buildCacheDir)

.PHONY: clean
clean: clean.root

.PHONY: clean.all
clean.all: clean.root clean.idea clean.build.catch
	@echo "clean all done"

.PHONY: adb.crash
adb.crash: checkEnvAndroidHome
	adb shell dumpsys dropbox --print data_app_crash

.PHONY: help.android.base
help.android.base:
	@echo "=> $(ROOT_PWD)/z-android-base.mk : android base task"
	@echo "make env                         ~> show project env"
	@echo "make init                        ~> init this project for check base build error"
	@echo ""
	@echo "make clean.root                  ~> clean root"
	@echo "make clean.idea.module           ~> clean gradle build cache"
	@echo "make clean.build.catch           ~> clean build catch"
	@echo "make clean.idea                  ~> clean IDEA project files"
	@echo "make clean.all                   ~> clean all"
	@echo "make clean                       ~> clean sample"
	@echo ""
	@echo "make adb.crash                   ~> show last crash info"
	@echo ""