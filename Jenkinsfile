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
        git(
            url: 'https://github.com/thenerdics/jenkinsTest.git',
            credentialsId: 'thenerdics',
            branch: "gitUpdateTest"
        )
        sh 'git branch'
        sh 'git checkout gitUpdateTest'
        sh 'touch hello.txt'
        sh 'echo "hello world"'
        sh 'git add --all'
        sh 'git commit -m "jenkinsPush"'
        }
     }
     stage('')

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