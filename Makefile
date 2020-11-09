.PHONY: dist test build

ROOT_PWD=$(shell pwd)

include z-android-base.mk
include z-app.mk
include z-module-plugin.mk

help: helpAndroidBase helpplugin helpApp
	@echo "more task see Makefile!"
