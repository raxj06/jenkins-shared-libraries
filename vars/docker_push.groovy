def call(String ProjectName, String ImageTag, String DockerHubUser){
   withCredentials([usernamePassword(
                    'credentialsId':"DockerHubCred",
                    passwordVariable:"DockerHubPass",
                    usernameVariable:"DockerHubUser")]){
                sh "docker login -u ${DockerHubUser} -p ${DockerHubPass}"
                sh "docker image tag ${ProjectName}:${ImageTag} ${DockerHubUser}/:${ImageTag}"
                sh "docker push ${DockerHubUser}/${ProjectName}:${ImageTag}"
                
   }
}
