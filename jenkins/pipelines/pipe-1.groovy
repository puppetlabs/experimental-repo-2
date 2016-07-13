stage "Load meow from github file."
def meow = fileLoader.fromGit(
    'src/com/puppet/util/Meow',
    'git@github.com:puppetlabs/jenkins-global-workflowlib.git',
    'master', null, '')

node {
     meow.experimental_repo_2_test()
}
