# change name of com.android.application
ROOT_APP_NAME_test := test

testClean:
	$(ROOT_PWD)/gradlew -q $(ROOT_APP_NAME_test):clean

testDependImplementation:
	$(ROOT_PWD)/gradlew -q $(ROOT_APP_NAME_test):dependencies --configuration implementation

testDependReleaseCompileClasspath:
	$(ROOT_PWD)/gradlew -q $(ROOT_APP_NAME_test):dependencies --configuration releaseCompileClasspath

testTest:
	$(ROOT_PWD)/gradlew -q $(ROOT_APP_NAME_test):test

testDebug:
	$(ROOT_PWD)/gradlew -q $(ROOT_APP_NAME_test):buildDebug

testRelease: testClean
	$(ROOT_PWD)/gradlew -q $(ROOT_APP_NAME_test):buildRelease

testAssembleDebug:
	$(ROOT_PWD)/gradlew -q $(ROOT_APP_NAME_test):assembleDebug

testAssembleRelease: testClean
	$(ROOT_PWD)/gradlew -q $(ROOT_APP_NAME_test):assembleRelease

testInstallDebug:
	$(ROOT_PWD)/gradlew -q $(ROOT_APP_NAME_test):installDebug

help-test:
	@echo "=> ${ROOT_PWD}/${ROOT_APP_NAME_test}/z-application.mk : android testlication module [ ${ROOT_APP_NAME_test} ] task"
	@echo "make ${ROOT_APP_NAME_test}Clean                         ~> clean of module [ ${ROOT_APP_NAME_test} ]"
	@echo "make ${ROOT_APP_NAME_test}DependImplementation          ~> see dependencies implementation of module [ ${ROOT_APP_NAME_test} ]"
	@echo "make ${ROOT_APP_NAME_test}DependReleaseCompileClasspath ~> see dependencies implementation of module [ ${ROOT_APP_NAME_test} ]"
	@echo "make ${ROOT_APP_NAME_test}Test                          ~> run test of module [ ${ROOT_APP_NAME_test} ]"
	@echo "make ${ROOT_APP_NAME_test}Debug                         ~> build debug of module [ ${ROOT_APP_NAME_test} ]"
	@echo "make ${ROOT_APP_NAME_test}Release                       ~> build release of module [ ${ROOT_APP_NAME_test} ]"
	@echo "make ${ROOT_APP_NAME_test}AssembleDebug                 ~> assemble debug of module [ ${ROOT_APP_NAME_test} ]"
	@echo "make ${ROOT_APP_NAME_test}AssembleRelease               ~> assemble release of module [ ${ROOT_APP_NAME_test} ]"
	@echo "make ${ROOT_APP_NAME_test}InstallDebug                  ~> install debug of module [ ${ROOT_APP_NAME_test} ]"
	@echo ""