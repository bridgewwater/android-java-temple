.PHONY: dist test build

ifeq ($(OS),Windows_NT)
  ROOT_PWD=$(shell powershell -Command '(Get-Location).Path')
  ENV_GRADLE_WRAPPER_EXEC=.\gradlew.bat
else
  ROOT_PWD=$(shell pwd)
  ENV_GRADLE_WRAPPER_EXEC=./gradlew
endif

include z-android-base.mk
include plugin/z-plugin.mk
include demo/z-demo.mk

.PHONY: help
help: help-plugin help-demo help.android.base
	@echo "more task see Makefile!"
