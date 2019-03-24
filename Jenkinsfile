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
        stage ('Maven increment') {
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
        stage ('Node increment') {
            steps {
                script {
                    
                    def updateversion = load("vars/updateVersion.groovy")
                    // sh 'git stash && git pull'
                    def choice = "${params.increment}"
                    try {
                        println "\\updateversion.npmIncrement(choice)"
                    }catch(e){
                        println "Something went wrong:\n${e}"
                    }
                    String npmVersion = sh ( script: "cat ./package.json | grep -i version | cut -d ':' -f2 | tr -d '\"' | tr -d ' '", returnStdout: true )
                    if (npmVersion){
                        echo "Npm package updated to version: ${npmVersion}"
                    }
                }
                deleteDir()
            }
        }
    }
}