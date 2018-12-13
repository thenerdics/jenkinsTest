pipeline {
  agent any
  stages {
    stage("Run unit tests"){
      steps {
        script {
          try {
            sh  '''
              # Run unit tests without capturing stdout or logs, generates cobetura reports
              cd ./python
              nosetests3 --with-xcoverage --nocapture --with-xunit --nologcapture --cover-package=application
              cd ..
              '''
          } finally {
            junit 'nosetests.xml'
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