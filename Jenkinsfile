pipeline {
    agent any
    parameters{
        string(defaultValue:"increment",description:"What increment?", name:'increment')
    }
    tools { 
        maven 'jenkins-mani' 
        
    }
    stages {
        def updateversion = load("variables/vars/updateVersion.groovy")
        stage ('Maven increment') {
            steps {
                checkout scm
                
                script {
                    def choice = "${params.increment}"
                    println "${choice}"
                    updateversion.mavenIncrement()
                    updateversion.npmIncrement(choice)
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

        stage ('Node increment') {
            steps {
                echo 'This is a minimal pipeline.'
            }
        }
    }
}