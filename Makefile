.PHONY: dist test build

ROOT_PWD=$(shell pwd)

include z-android-base.mk
include plugin/z-plugin.mk
include demo/z-demo.mk

.PHONY: help
help: help-plugin help-demo help.android.base
	@echo "more task see Makefile!"
