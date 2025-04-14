# com.android.library
ROOT_MODULE_plugin := plugin

pluginTasks:
	${ENV_GRADLE_WRAPPER_EXEC} -q $(ROOT_MODULE_plugin):tasks

pluginClean:
	${ENV_GRADLE_WRAPPER_EXEC} -q $(ROOT_MODULE_plugin):clean

pluginDependImplementation:
	${ENV_GRADLE_WRAPPER_EXEC} -q $(ROOT_MODULE_plugin):dependencies --configuration implementation

pluginDependReleaseCompileClasspath:
	${ENV_GRADLE_WRAPPER_EXEC} -q $(ROOT_MODULE_plugin):dependencies --configuration releaseCompileClasspath

pluginTest:
	${ENV_GRADLE_WRAPPER_EXEC} -q $(ROOT_MODULE_plugin):test

pluginTestDebug:
	${ENV_GRADLE_WRAPPER_EXEC} -q $(ROOT_MODULE_plugin):testDebugUnitTest

pluginTestRelease: pluginClean
	${ENV_GRADLE_WRAPPER_EXEC} -q $(ROOT_MODULE_plugin):testReleaseUnitTest

pluginJacocoReportDebug:
	${ENV_GRADLE_WRAPPER_EXEC} -q $(ROOT_MODULE_plugin):jacocoDebugReport

pluginJacocoReportRelease:
	${ENV_GRADLE_WRAPPER_EXEC} -q $(ROOT_MODULE_plugin):jacocoReleaseReport

pluginDebug:
	${ENV_GRADLE_WRAPPER_EXEC} -q $(ROOT_MODULE_plugin):buildDebug

pluginRelease:
	${ENV_GRADLE_WRAPPER_EXEC} -q $(ROOT_MODULE_plugin):build

pluginAssembleDebug: pluginClean
	${ENV_GRADLE_WRAPPER_EXEC} -q $(ROOT_MODULE_plugin):assembleDebug

pluginAssembleRelease: pluginClean
	${ENV_GRADLE_WRAPPER_EXEC} -q $(ROOT_MODULE_plugin):assembleRelease

pluginPublishToMavenLocal:
	${ENV_GRADLE_WRAPPER_EXEC} -q $(ROOT_MODULE_plugin):publishToMavenLocal
	$(info will publish at $$HOME/.m2/repository)

pluginPublish:
	${ENV_GRADLE_WRAPPER_EXEC} -q $(ROOT_MODULE_plugin):publish

pluginUploadArchives: pluginClean
	${ENV_GRADLE_WRAPPER_EXEC} -q $(ROOT_MODULE_plugin):uploadArchives

help-plugin:
	@echo "=> ${ROOT_PWD}/${ROOT_MODULE_plugin}/z-plugin.mk : android library module [ $(ROOT_MODULE_plugin) ] task"
	@echo "make $(ROOT_MODULE_plugin)Tasks                         ~> show task of module [ $(ROOT_MODULE_plugin) ]"
	@echo "make $(ROOT_MODULE_plugin)Clean                         ~> clean of module [ $(ROOT_MODULE_plugin) ]"
	@echo "make $(ROOT_MODULE_plugin)DependImplementation          ~> see dependencies implementation of module [ $(ROOT_MODULE_plugin) ]"
	@echo "make $(ROOT_MODULE_plugin)DependReleaseCompileClasspath ~> see dependencies implementation of module [ $(ROOT_MODULE_plugin) ]"
	@echo "make $(ROOT_MODULE_plugin)Test                          ~> run test of module [ $(ROOT_MODULE_plugin) ]"
	@echo "make $(ROOT_MODULE_plugin)TestDebug                     ~> run test Debug of module [ $(ROOT_MODULE_plugin) ]"
	@echo "make $(ROOT_MODULE_plugin)TestRelease                   ~> run test Release of module [ $(ROOT_MODULE_plugin) ]"
	@echo "make $(ROOT_MODULE_plugin)JacocoReportDebug             ~> run report jacoco debug of module [ $(ROOT_MODULE_plugin) ]"
	@echo "make $(ROOT_MODULE_plugin)JacocoReportRelease           ~> run report jacoco release of module [ $(ROOT_MODULE_plugin) ]"
	@echo "make $(ROOT_MODULE_plugin)Debug                         ~> build debug of module [ $(ROOT_MODULE_plugin) ]"
	@echo "make $(ROOT_MODULE_plugin)Release                       ~> build release of module [ $(ROOT_MODULE_plugin) ]"
	@echo "make $(ROOT_MODULE_plugin)AssembleDebug                 ~> assemble debug of module [ :$(ROOT_MODULE_plugin):assembleDebug ]"
	@echo "make $(ROOT_MODULE_plugin)AssembleRelease               ~> assemble release of module [ :$(ROOT_MODULE_plugin):assembleRelease ]"
	@echo "make $(ROOT_MODULE_plugin)UploadArchives                ~> module [ :$(ROOT_MODULE_plugin):uploadArchives ] deprecated by at gradle 7.+"
	@echo "make $(ROOT_MODULE_plugin)Publish                       ~> module [ :$(ROOT_MODULE_plugin):publish ] effect at gradle 7.+"
	@echo "make $(ROOT_MODULE_plugin)pluginPublishToMavenLocal     ~> module [ :$(ROOT_MODULE_plugin):publishToMavenLocal ] effect at gradle 7.+"
	@echo ""