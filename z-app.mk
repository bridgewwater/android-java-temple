
ROOT_APP_NAME := test

appClean:
	$(ROOT_PWD)/gradlew -q $(ROOT_APP_NAME):clean

appDependImplementation:
	$(ROOT_PWD)/gradlew -q $(ROOT_APP_NAME):dependencies --configuration implementation

appDependReleaseCompileClasspath:
	$(ROOT_PWD)/gradlew -q $(ROOT_APP_NAME):dependencies --configuration releaseCompileClasspath

appTest:
	$(ROOT_PWD)/gradlew -q $(ROOT_APP_NAME):test

appDebug:
	$(ROOT_PWD)/gradlew -q $(ROOT_APP_NAME):buildDebug

appRelease:
	$(ROOT_PWD)/gradlew -q $(ROOT_APP_NAME):buildRelease

appAssembleDebug: appClean
	$(ROOT_PWD)/gradlew -q $(ROOT_APP_NAME):assembleDebug

appAssembleRelease: appClean
	$(ROOT_PWD)/gradlew -q $(ROOT_APP_NAME):assembleRelease

helpApp:
	@echo "=> $(ROOT_PWD)/z-app.mk : android application module [ $(ROOT_APP_NAME) ] task"
	@echo "make appClean                         ~> clean of module [ $(ROOT_APP_NAME) ]"
	@echo "make appDependImplementation          ~> see dependencies implementation of module [ $(ROOT_APP_NAME) ]"
	@echo "make appDependReleaseCompileClasspath ~> see dependencies implementation of module [ $(ROOT_APP_NAME) ]"
	@echo "make appTest                          ~> run test of module [ $(ROOT_APP_NAME) ]"
	@echo "make appDebug                         ~> build debug of module [ $(ROOT_APP_NAME) ]"
	@echo "make appRelease                       ~> build release of module [ $(ROOT_APP_NAME) ]"
	@echo "make appAssembleDebug                 ~> assemble debug of module [ $(ROOT_APP_NAME) ]"
	@echo "make appAssembleRelease               ~> assemble release of module [ $(ROOT_APP_NAME) ]"
	@echo ""