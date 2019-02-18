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

    def gitUrl = 'git@github.com:thenerdics/jenkinsTest.git'
  stages {
     stage('hello world') {
        steps {
        // git([ url: 'https://github.com/thenerdics/jenkinsTest.git', credentialsId: 'thenerdics', branch: "gitUpdateTest" ])
        sh 'git clone \"${gitUrl}\" || rm -rf jenkinsTest && git clone \"${gitUrl}\"'
        sh 'git branch -D gitUpdateTests'
        sh 'git checkout -b gitUpdateTests'
        sh 'rm -rf ./*'
        sh 'touch hello213.txt'
        sh 'echo "hello world2"'
        sh 'git add hello213.txt'
        sh 'git commit -m "jenkinsPush"'
        sh 'git push origin gitUpdateTests'
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