pipeline {
  agent any
  stages {
    stage("Run unit tests"){
      steps {
        script {
          try {
            sh  '''
              # Run unit tests without capturing stdout or logs, generates cobetura reports
              echo "Yo I'm HERE!!!"
              '''
          } finally {
            sh '''
            echo "exit"
            '''
          }
        }
      }
    }
    stage ('Speak') {
      steps{
        echo "Hello, CONDITIONAL"
      }
    }
  }
}