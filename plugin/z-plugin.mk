# com.android.library
ROOT_MODULE_plugin := plugin

.PHONY: pluginTasks
pluginTasks:
	${ENV_GRADLE_WRAPPER_EXEC} -q $(ROOT_MODULE_plugin):tasks

.PHONY: pluginClean
pluginClean:
	${ENV_GRADLE_WRAPPER_EXEC} -q $(ROOT_MODULE_plugin):clean

.PHONY: pluginDependImplementation
pluginDependImplementation:
	${ENV_GRADLE_WRAPPER_EXEC} -q $(ROOT_MODULE_plugin):dependencies --configuration implementation

.PHONY: pluginDependReleaseCompileClasspath
pluginDependReleaseCompileClasspath:
	${ENV_GRADLE_WRAPPER_EXEC} -q $(ROOT_MODULE_plugin):dependencies --configuration releaseCompileClasspath

.PHONY: pluginTest
pluginTest:
	${ENV_GRADLE_WRAPPER_EXEC} -q $(ROOT_MODULE_plugin):test

.PHONY: pluginTestDebug
pluginTestDebug:
	${ENV_GRADLE_WRAPPER_EXEC} -q $(ROOT_MODULE_plugin):testDebugUnitTest

.PHONY: pluginTestRelease
pluginTestRelease: pluginClean
	${ENV_GRADLE_WRAPPER_EXEC} -q $(ROOT_MODULE_plugin):testReleaseUnitTest

.PHONY: pluginJacocoReportDebug
pluginJacocoReportDebug:
	${ENV_GRADLE_WRAPPER_EXEC} -q $(ROOT_MODULE_plugin):jacocoDebugReport

.PHONY: pluginJacocoReportRelease
pluginJacocoReportRelease:
	${ENV_GRADLE_WRAPPER_EXEC} -q $(ROOT_MODULE_plugin):jacocoReleaseReport

.PHONY: pluginDebug
pluginDebug:
	${ENV_GRADLE_WRAPPER_EXEC} -q $(ROOT_MODULE_plugin):buildDebug

.PHONY: pluginRelease
pluginRelease:
	${ENV_GRADLE_WRAPPER_EXEC} -q $(ROOT_MODULE_plugin):build

.PHONY: pluginAssembleDebug
pluginAssembleDebug: pluginClean
	${ENV_GRADLE_WRAPPER_EXEC} -q $(ROOT_MODULE_plugin):assembleDebug

.PHONY: pluginAssembleRelease
pluginAssembleRelease: pluginClean
	${ENV_GRADLE_WRAPPER_EXEC} -q $(ROOT_MODULE_plugin):assembleRelease

.PHONY: pluginPublishToMavenLocal
pluginPublishToMavenLocal:
	${ENV_GRADLE_WRAPPER_EXEC} -q $(ROOT_MODULE_plugin):publishToMavenLocal
	$(info will publish at $$HOME/.m2/repository)

.PHONY: pluginPublish
pluginPublish:
	${ENV_GRADLE_WRAPPER_EXEC} -q $(ROOT_MODULE_plugin):publish

.PHONY: pluginUploadArchives
pluginUploadArchives: pluginClean
	${ENV_GRADLE_WRAPPER_EXEC} -q $(ROOT_MODULE_plugin):uploadArchives

.PHONY: help-plugin
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