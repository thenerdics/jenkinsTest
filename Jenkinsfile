node {
    stage('Hello world test'){
        echo "This is a test"
    }
    stage('Maven test'){
        checkout scm
        sh( script: 'pwd', returnStdout: true )
    }
}