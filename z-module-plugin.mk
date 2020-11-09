
ROOT_MODULE_plugin := plugin

pluginClean:
	$(ROOT_PWD)/gradlew -q $(ROOT_MODULE_plugin):clean

pluginDependImplementation:
	$(ROOT_PWD)/gradlew -q $(ROOT_MODULE_plugin):dependencies --configuration implementation

pluginDependReleaseCompileClasspath:
	$(ROOT_PWD)/gradlew -q $(ROOT_MODULE_plugin):dependencies --configuration releaseCompileClasspath

pluginTest:
	$(ROOT_PWD)/gradlew -q $(ROOT_MODULE_plugin):test

pluginTestDebug:
	$(ROOT_PWD)/gradlew -q $(ROOT_MODULE_plugin):testDebugUnitTest

pluginTestRelease: pluginClean
	$(ROOT_PWD)/gradlew -q $(ROOT_MODULE_plugin):testReleaseUnitTest

pluginDebug:
	$(ROOT_PWD)/gradlew -q $(ROOT_MODULE_plugin):buildDebug

pluginRelease:
	$(ROOT_PWD)/gradlew -q $(ROOT_MODULE_plugin):buildRelease

pluginAssembleDebug: pluginClean
	$(ROOT_PWD)/gradlew -q $(ROOT_MODULE_plugin):assembleDebug

pluginAssembleRelease: pluginClean
	$(ROOT_PWD)/gradlew -q $(ROOT_MODULE_plugin):assembleRelease

helpplugin:
	@echo "=> $(ROOT_PWD)/z-module-plugin.mk : android library module [ $(ROOT_MODULE_plugin) ] task"
	@echo "make $(ROOT_MODULE_plugin)Clean                         ~> clean of module [ $(ROOT_MODULE_plugin) ]"
	@echo "make $(ROOT_MODULE_plugin)DependImplementation          ~> see dependencies implementation of module [ $(ROOT_MODULE_plugin) ]"
	@echo "make $(ROOT_MODULE_plugin)DependReleaseCompileClasspath ~> see dependencies implementation of module [ $(ROOT_MODULE_plugin) ]"
	@echo "make $(ROOT_MODULE_plugin)Test                          ~> run test of module [ $(ROOT_MODULE_plugin) ]"
	@echo "make $(ROOT_MODULE_plugin)TestDebug                     ~> run test Debug of module [ $(ROOT_MODULE_plugin) ]"
	@echo "make $(ROOT_MODULE_plugin)TestRelease                   ~> run test Release of module [ $(ROOT_MODULE_plugin) ]"
	@echo "make $(ROOT_MODULE_plugin)Debug                         ~> build debug of module [ $(ROOT_MODULE_plugin) ]"
	@echo "make $(ROOT_MODULE_plugin)Release                       ~> build release of module [ $(ROOT_MODULE_plugin) ]"
	@echo "make $(ROOT_MODULE_plugin)AssembleDebug                 ~> assemble debug of module [ $(ROOT_MODULE_plugin) ]"
	@echo "make $(ROOT_MODULE_plugin)AssembleRelease               ~> assemble release of module [ $(ROOT_MODULE_plugin) ]"
	@echo ""