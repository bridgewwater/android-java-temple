.PHONY: dist test build

ROOT_PWD=$(shell pwd)

include z-android-base.mk
include test/z-application.mk
include plugin/z-plugin.mk

help: helpAndroidBase help-plugin help-test
	@echo "more task see Makefile!"
