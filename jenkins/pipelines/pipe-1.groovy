stage "Load meow from github file."
def meow = fileLoader.fromGit(
    'src/com/puppet/util/Meow',
    'git@github.com:puppetlabs/jenkins-global-workflowlib.git',
    'master', null, '')

node {
     meow.experimental_repo_2_test()
}

stage "Trigger experimental-repo-1 pipe-2"
build job: 'experimental_experimental-repo-1_pipe-2_master'
