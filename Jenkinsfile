pipeline {
    environment{
    registry = "skillassure/galaxemovie-usermanagement"
    registryCredential = "Docker-Hub-Auth"
    dockerImage = ''
  }
  agent any



    stages {
        
        stage('build the project') {
      steps {
        echo 'building the project'
        sh 'mvn clean install'
       
      }
        }
    
     stage('Sonarqube'){
       steps{
         echo "Sonarqube codequality"
         sh '''
   mvn clean verify sonar:sonar \
      -Dsonar.projectKey=scheduling \
      -Dsonar.host.url=http://20.205.141.142:9000 \
      -Dsonar.login=sqp_106db4f80ed9fd4c1df1392e2414ef01fc659338
         '''
       }
    }
    
     stage('Build docker image'){
      steps{
        echo "Building docker image"
        script{
          dockerImage = docker.build registry + ":$BUILD_NUMBER"
        }
      }
    }



   stage('Push docker image'){
      steps{
        echo "Pushing docker image"
        script{
           docker.withRegistry('',registryCredential) {
            dockerImage.push()
            dockerImage.push('latest')
          }
        }
      }      
    }
//     stage('Deploy to Dev'){   
//       steps{
//         echo "Deploying to dev environment"
//         sh 'docker rm -f cmd-fe-hcl-dotnet2022 || true'
//         sh 'docker run -d --name=cmd-fe-hcl-dotnet2022 -p 85:80 -e VIRTUAL_HOST=cmd.learn.skillassure.com -e  LETSENCRYPT_HOST=cmd.learn.skillassure.com skillassure/cmd-fe-hcl-dotnet2022'
//         //sh 'npm start'
//       }
//     }  
  }
}
