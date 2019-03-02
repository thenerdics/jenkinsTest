node {
    stage('Hello world test'){
        echo "This is a test"
    }
    stage('Maven test'){
        checkout scm
        shell( script: 'ls', returnStdout: true )
    }
}