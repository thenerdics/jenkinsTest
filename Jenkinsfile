
pipeline {
    agent any
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
                    sh 'git checkout mavenTest'
                    sh 'git stash && git pull'
                    def updateversion = load("variables/vars/updateVersion.groovy")
                    def choice = "${params.increment}"
                    def hotfix = "${params.hotfix}"

                    echo "Increment choice is: ${choice}" 
                    updateversion.mavenIncrement(choice, hotfix)
                    def mvnVersion = sh (script: "mvn build-helper:parse-version | grep Building | cut -d ' ' -f4 | tr -d ' '", returnStdout: true)
                    if (mvnVersion){
                        println "Maven package updated to version: ${mvnVersion}"
                        sh """
                            git add .
                            git commit -am "Mvn updated to version: ${mvnVersion}"
                        """
                    }
                }
            }
        }
        stage ('Node increment') {
            steps {
                script {
                    def updateversion = load("variables/vars/updateVersion.groovy")
                    sh 'git stash && git pull'
                    def choice = "${params.increment}"
                    try {
                        updateversion.npmIncrement(choice)
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