# change name of com.android.application
ROOT_APP_NAME_demo := demo

demoClean:
	$(ROOT_PWD)/gradlew -q $(ROOT_APP_NAME_demo):clean

demoDependImplementation:
	$(ROOT_PWD)/gradlew -q $(ROOT_APP_NAME_demo):dependencies --configuration implementation

demoDependReleaseCompileClasspath:
	$(ROOT_PWD)/gradlew -q $(ROOT_APP_NAME_demo):dependencies --configuration releaseCompileClasspath

demoTest:
	$(ROOT_PWD)/gradlew -q $(ROOT_APP_NAME_demo):test

demoDebug:
	$(ROOT_PWD)/gradlew -q $(ROOT_APP_NAME_demo):buildDebug

demoRelease:
	$(ROOT_PWD)/gradlew -q $(ROOT_APP_NAME_demo):buildRelease

demoAssembleDebug:
	$(ROOT_PWD)/gradlew -q $(ROOT_APP_NAME_demo):assembleDebug

demoAssembleRelease: demoRelease
	$(ROOT_PWD)/gradlew -q $(ROOT_APP_NAME_demo):assembleRelease

demoInstallDebug:
	$(ROOT_PWD)/gradlew -q $(ROOT_APP_NAME_demo):installDebug

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
	@echo ""