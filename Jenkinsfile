void setBuildStatus(String message, String state) {
  step([
      $class: "GitHubCommitStatusSetter",
      reposSource: [$class: "ManuallyEnteredRepositorySource", url: "https://github.com/my-org/my-repo"],
      contextSource: [$class: "ManuallyEnteredCommitContextSource", context: "ci/jenkins/build-status"],
      errorHandlers: [[$class: "ChangingBuildStatusErrorHandler", result: "UNSTABLE"]],
      statusResultSource: [ $class: "ConditionalStatusResultSource", results: [[$class: "AnyBuildResult", message: message, state: state]] ]
  ]);
}

pipeline {
agent any
  stages {
     stage('hello world') {
        steps {
        sh 'rm -rf ./*'
        checkout scm
        // git([ url: 'https://github.com/thenerdics/jenkinsTest.git', credentialsId: 'thenerdics', branch: "gitUpdateTest" ])
        sh 'git branch'
        sh 'git checkout gitUpdateTest'
        sh 'touch hello23.txt'
        sh 'echo "hello world2"'
        sh 'git add hello23.txt'
        sh 'git commit -m "jenkinsPush"'
        sh 'git push '
        }
     }
     stage('second'){
        steps{
            sh 'cat hello.txt'
        }
     }

  }
  post {
    success {
        setBuildStatus("Build succeeded", "SUCCESS");
    }
    failure {
        setBuildStatus("Build failed", "FAILURE");
    }
  }
}