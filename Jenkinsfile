pipeline {
    agent any
    tools { 
        maven 'jenkins-mani' 
        
    }
    stages {
        stage ('Initialize') {
            steps {
                checkout scm
                
                script {
                    def updateversion = load('variables/vars/updateVersion.groovy')
                    updateversion.increment()
                    def version = sh (script: "mvn build-helper:parse-version | grep Building | cut -d ' ' -f4", returnStdout: true)
                    if (version){
                        println "Updated to version: ${version}"
                        sh """
                        git config --global user.email "manvirbrar1988@gmail.com"
                        git config --global user.name "thenerdics"
                        git add .
                        git commit -am "Updated to version: ${version}"
                        """
                    }
                }
                
            }
        }

        stage ('Build') {
            steps {
                echo 'This is a minimal pipeline.'
            }
        }
    }
}