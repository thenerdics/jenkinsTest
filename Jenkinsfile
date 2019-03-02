node {
    stage('Hello world test'){
        echo "Hello World"
        sh 'ls'
    }
    stage('Maven test'){
        checkout scm
        sh( script: 'ls', returnStdout: true )
        sh( script: 'mvn -version', returnStdout: true )

    }
}