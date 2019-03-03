pipeline {
    agent any
    parameters{
        string(defaultValue:"increment",description:"What increment?", name:'increment')
    }
    tools { 
        maven 'jenkins-mani' 
        nodejs 'nodejs-mani'
        
    }
    stages {
        stage ('Maven increment') {
            steps {
                script {
                    checkout scm
                    sh 'git stash && git pull'
                    def updateversion = load("variables/vars/updateVersion.groovy")
                    def choice = "${params.increment}"

                    println "${choice}"
                    updateversion.mavenIncrement()
                    def mvnVersion = sh (script: "mvn build-helper:parse-version | grep Building | cut -d ' ' -f4", returnStdout: true)
                    if (mvnVersion){
                        println "Maven package updated to version: ${mvnVersion}"
                        sh """
                            git config --global user.email "manvirbrar1988@gmail.com"
                            git config --global user.name "thenerdics"
                            git add .
                            git commit -am "Mvn pdated to version: ${mvnVersion}"
                        """
                    }
                }
            }
        }
        stage ('Node increment') {
            steps {
                script {
                    checkout scm
                    sh 'git stash && git pull'
                    def updateversion = load("variables/vars/updateVersion.groovy")
                    def choice = "${params.increment}"
                    updateversion.npmIncrement(choice)
                    def npmVersion = sh ( script: "cat package.json| jq -r '.version'", returnStdout: true )
                    if (npmVersion){
                        echo "Npm package updated to version:${npmVersion}"
                    }
                }
            }
        }
    }
}