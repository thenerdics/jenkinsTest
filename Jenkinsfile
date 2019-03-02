node {
    stage('Hello world test'){
        echo "Hello World"
        sh 'printenv'
    }
    stage('Maven test'){
        checkout scm
        sh( script: 'printenv', returnStdout: true )
        sh( script: 'mvn -version', returnStdout: true )
    }
}