pipeline {
  agent any
  stages {
    stage("Run unit tests"){
      steps {
        script {
          try {
            sh  '''
              curl http://localhost:8080/api/json?tree=result | grep -i "result"
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