def newGit(repo)
{
  git "${repo}"
}
def newMaven()
{
  sh 'mvn package'
}
