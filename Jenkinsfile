node {
    stage('Hello world test'){
        echo "Hello World"
    }
    stage('Maven test'){
        checkout scm
        sh( script: 'ls', returnStdout: true )
        sh( script: 'mvn -version', returnStdout: true )

    }
}