# change name of com.android.application
ROOT_APP_NAME_demo := demo
ROOT_APP_PACKAGE_demo := com.sinlov.android.plugin.demo
ROOT_APP_LAUNCHER_ACTIVITY_demo := com.sinlov.android.plugin.demo.MainActivity
ROOT_APP_LANCHER_PARAMS_demo :="-a android.intent.action.MAIN -c android.intent.category.LAUNCHER"

.PHONY: demoClean
demoClean:
	${ENV_GRADLE_WRAPPER_EXEC} -q $(ROOT_APP_NAME_demo):clean

.PHONY: demoDependImplementation
demoDependImplementation:
	${ENV_GRADLE_WRAPPER_EXEC} -q $(ROOT_APP_NAME_demo):dependencies --configuration implementation

.PHONY: demoDependReleaseCompileClasspath
demoDependReleaseCompileClasspath:
	${ENV_GRADLE_WRAPPER_EXEC} -q $(ROOT_APP_NAME_demo):dependencies --configuration releaseCompileClasspath

.PHONY: demoTest
demoTest:
	${ENV_GRADLE_WRAPPER_EXEC} -q $(ROOT_APP_NAME_demo):test

.PHONY: demoDebug
demoDebug:
	${ENV_GRADLE_WRAPPER_EXEC} -q $(ROOT_APP_NAME_demo):buildDebug

.PHONY: demoRelease
demoRelease:
	${ENV_GRADLE_WRAPPER_EXEC} -q $(ROOT_APP_NAME_demo):buildRelease

.PHONY: demoAssembleDebug
demoAssembleDebug:
	${ENV_GRADLE_WRAPPER_EXEC} -q $(ROOT_APP_NAME_demo):assembleDebug

.PHONY: demoAssembleRelease
demoAssembleRelease: demoRelease
	${ENV_GRADLE_WRAPPER_EXEC} -q $(ROOT_APP_NAME_demo):assembleRelease

.PHONY: demoInstallDebug
demoInstallDebug:
	${ENV_GRADLE_WRAPPER_EXEC} -q $(ROOT_APP_NAME_demo):installDebug

.PHONY: demoLaunch
demoLaunch:
	@adb shell am start -n ${ROOT_APP_PACKAGE_demo}/${ROOT_APP_LAUNCHER_ACTIVITY_demo} ${ROOT_APP_LANCHER_PARAMS_demo}

.PHONY: demoLaunchDebug
demoLaunchDebug: demoInstallDebug demoLaunch
	@echo "has launch ${ROOT_PWD}/${ROOT_APP_NAME_demo} as: ${ROOT_APP_PACKAGE_demo}/${ROOT_APP_LAUNCHER_ACTIVITY_demo}"

.PHONY: demoInstallRelease
demoInstallRelease:
	${ENV_GRADLE_WRAPPER_EXEC} -q $(ROOT_APP_NAME_demo):installRelease

.PHONY: demoLaunchRelease
demoLaunchRelease: demoInstallRelease demoLaunch
	@echo "has launch ${ROOT_PWD}/${ROOT_APP_NAME_demo} as: ${ROOT_APP_PACKAGE_demo}/${ROOT_APP_LAUNCHER_ACTIVITY_demo}"

.PHONY: demoUninstallAll
demoUninstallAll:
	${ENV_GRADLE_WRAPPER_EXEC} -q $(ROOT_APP_NAME_demo):uninstallAll

.PHONY: help-demo
help-demo:
	@echo "=> ${ROOT_PWD}/${ROOT_APP_NAME_demo}/z-demo.mk : android application module [ ${ROOT_APP_NAME_demo} ] task"
	@echo "make ${ROOT_APP_NAME_demo}Clean                         ~> clean of module [ ${ROOT_APP_NAME_demo} ]"
	@echo "make ${ROOT_APP_NAME_demo}DependImplementation          ~> see dependencies implementation of module [ ${ROOT_APP_NAME_demo} ]"
	@echo "make ${ROOT_APP_NAME_demo}DependReleaseCompileClasspath ~> see dependencies implementation of module [ ${ROOT_APP_NAME_demo} ]"
	@echo "make ${ROOT_APP_NAME_demo}Test                          ~> run demo of module [ ${ROOT_APP_NAME_demo} ]"
	@echo "make ${ROOT_APP_NAME_demo}Debug                         ~> build debug of module [ ${ROOT_APP_NAME_demo} ]"
	@echo "make ${ROOT_APP_NAME_demo}Release                       ~> build release of module [ ${ROOT_APP_NAME_demo} ]"
	@echo "make ${ROOT_APP_NAME_demo}AssembleDebug                 ~> assemble debug of module [ ${ROOT_APP_NAME_demo} ]"
	@echo "make ${ROOT_APP_NAME_demo}AssembleRelease               ~> assemble release of module [ ${ROOT_APP_NAME_demo} ]"
	@echo "make ${ROOT_APP_NAME_demo}InstallDebug                  ~> install debug of module [ ${ROOT_APP_NAME_demo} ]"
	@echo "make ${ROOT_APP_NAME_demo}LaunchDebug                   ~> install debug and launch of module [ ${ROOT_APP_NAME_demo} ]"
	@echo "make ${ROOT_APP_NAME_demo}InstallRelease                ~> install release of module [ ${ROOT_APP_NAME_demo} ]"
	@echo "make ${ROOT_APP_NAME_demo}LaunchRelease                 ~> install release and launch of module [ ${ROOT_APP_NAME_demo} ]"
	@echo ""