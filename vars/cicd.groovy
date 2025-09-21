def newGit(repo)
{
  git "${repo}"
}
def newMaven()
{
  sh '''export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64
            export PATH=$JAVA_HOME/bin:$PATH
            mvn clean install
}
