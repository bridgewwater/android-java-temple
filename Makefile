.PHONY: dist test build

ROOT_PWD=$(shell pwd)

include z-android-base.mk
include plugin/z-plugin.mk
include demo/z-demo.mk

help: helpAndroidBase help-plugin help-demo
	@echo "more task see Makefile!"
