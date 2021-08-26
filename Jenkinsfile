pipeline { 
    agent any  
    stages { 
        stage('Build App') { 
            steps { 
               echo 'This is a minimal pipeline.' 
               sh 'chmod +x mvnw'
               sh './mvnw package'
            }
        }

        stage('Build Docker Image'){
            steps{
                echo 'building docker image'
                sh 'ls -al'
               // sh 'docker build -t eranga/mobile-app:latest .'
            }
        }

        stage('Push Docker Image'){
            steps{
                echo 'Pushing image in to registry'
            }
        }

        stage('Deployment'){
            steps{
                echo 'deploying...'
            }
        }

        stage('Regression test'){
            steps{
                echo 'starting regression testing..'
            }
        }

        stage('Traffic switching'){
            steps{
                echo 'switching traffic...'
            }
        }
    }
}
