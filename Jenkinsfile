#!/groovy

pipeline {
    agent any
    triggers { 
        pollSCM('H */4 * * 1-5') 
    }
    parameters{
        choice(description:"What increment?", name:'increment', choices: ['major','minor','patch','hotfix'])
        string(description:"What's the hotfix name?", name:'hotfix', defaultValue:'')
    }
    tools { 
        maven 'jenkins-mani' 
        nodejs 'nodejs-mani'
        
    }
    stages {
        stage ('Load scm triggers') {
            steps {
                script {
                    def scmVars = checkout([
                        $class : 'GitSCM',
                        branches : [[name: '*/scmTriggers']],
                        doGenerateSubmoduleConfigurations: false,
                        extensions : [/*[$class: 'CleanBeforeCheckout']*/],
                        submoduleCfg : [],
                        userRemoteConfigs: [[credentialsId: 'thenerdics', url: 'https://github.com/thenerdics/jenkinsTest.git']]
                    ])
                }
            }
        }
        stage ('Job stage') {
            steps {
                script {
                    echo "Hello world"
                }
                deleteDir()
            }
        }
    }
}