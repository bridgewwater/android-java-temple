pipeline {
  agent any // 构建代理, any 表示任意，常见的有 docker{}
  options {
    timeout(time: 30, unit: 'MINUTES') // 构建超时
    // buildDiscarder(logRotator(numToKeepStr:'10')) // 保留构建数量 10 个
  }
  stages { // 阶段列表
    stage('Print Environment') { // 阶段 环境变量打印
      steps { // 执行步奏
        echo '=> print Environment start'
        echo "NODE_NAME= ${NODE_NAME}"
        echo "JENKINS_HOME= ${JENKINS_HOME}"
        echo "JENKINS_URL= ${JENKINS_URL}"
        echo "WORKSPACE= ${WORKSPACE}"
        echo "JOB_NAME= ${JOB_NAME}"
        echo "BUILD_URL= ${BUILD_URL}"
        echo "BUILD_ID= ${BUILD_ID}"
        echo "BUILD_NUMBER= ${BUILD_NUMBER}"
        echo "BUILD_TAG= ${BUILD_TAG}"
        echo '=> print Environment end'
      }
    }
    stage('Debug jenkins') { // 调试 jk
      steps {
        print '=> Debug begin'
        echo "-> Prints public args"
        echo '${PATH}'
        echo "${PATH}"
        echo "-> Prints jenkins args"
        echo 'DEPLOY_TO= ${DEPLOY_TO} Parameter build needs to be set, otherwise an error is reported  No such property:'
        echo "-> Prints the currently set environment variable"
        echo 'GOPROXY= ${GOPROXY}'
        echo "GOPROXY= ${GOPROXY}"
        print '=> Debug End'
        echo 'Multi-line shell execution'
        sh '''
        whoami
        pwd
        ls
        '''
      }
    }
    stage('Print environment android') { // 调试 jk
      steps {
        print '=> print android env'
        echo "JAVA_HOME= ${JAVA_HOME}"
        echo "java -version"
        java -version
        echo "GRADLE_HOME= ${GRADLE_HOME}"
        echo "gradle -version"
        gradle -version
        echo "ANDROID_HOME= ${ANDROID_HOME}"
        echo "adb version"
        adb version
      }
    }
    // stage('Checkout SCM') {
    //   steps {
    //     checkout scm
    //     sh 'git --no-pager rev-parse HEAD --short HEAD'
    //     sh 'git --no-pager log --oneline -1 --pretty=format:"%h - %an, %ar : %s"'
    //     }
    // }
    stage('Example Deploy') {
      when {
          expression { // 条件为构建成功
            currentBuild.result == null || currentBuild.result == 'SUCCESS'
          }
          branch 'production' // 分支为 production
          environment name: 'DEPLOY_TO', value: 'production' // DEPLOY_TO 值为 production
      }
      steps {
        echo "Deploying DEPLOY_TO= ${DEPLOY_TO}"
        archiveArtifacts artifacts: '**/build/*.apk', allowEmptyArchive: true
      }
    }
    stage('Info more') {
      steps {
        echo "more see https://www.jenkins.io/zh/doc/book/pipeline/jenkinsfile/"
      }
    }
  }
}