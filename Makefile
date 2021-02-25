.PHONY: dist test build

ROOT_PWD=$(shell pwd)

include z-android-base.mk
include demo/z-demo.mk
include plugin/z-plugin.mk

help: helpAndroidBase help-plugin help-demo
	@echo "more task see Makefile!"
