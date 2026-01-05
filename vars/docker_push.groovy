def call(String ProjectName, String ImageTag, String DockerHubUser){
   withCredentials([usernamePassword(
                    'credentialsId':"DockerHubCred",
                    passwordVariable:"DockerHubPass",
                    usernameVariable:"DockerHubUser")]){
                sh "docker login -u ${DockerHubUser} -p ${DockerHubPass}"
                sh "docker image tag notes-app:latest ${DockerHubUser}/:latest"
                sh "docker push ${DockerHubUser}/notes-app:latest"
                
   }
}
