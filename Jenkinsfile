node {
    stage('Hello world test'){
        echo "Hello World"
        sh 'java -version'
    }
    stage('Maven test'){
        dir('usr/local')
        checkout scm
        sh( script: 'printenv', returnStdout: true )
        sh( script: 'mvn -version', returnStdout: true )
    }
}