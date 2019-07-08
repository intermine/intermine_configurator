import os
import sys
import json
import pygit2

# clone intermine_compose git repo in current dir
repoUrl = os.environ.get("SCRIPT_GIT_REPO_URL")
repoBranch = os.environ.get("SCRIPT_GIT_REPO_BRANCH")
print('Cloning intermine-compose repo')
intermineComposeRepo = pygit2.clone_repository(
    repoUrl, "intermine-compose", checkout_branch=repoBranch)


composeRepoPath = os.path.join(os.curdir, "intermine-compose")
composeAPIPath = os.path.join(composeRepoPath, "openapi.json")
configuratorAPIPath = os.path.join(os.curdir, "openapi.json")
composeAPI = open(composeAPIPath, "rt")
configuratorAPI = open(configuratorAPIPath, "rt")

try:
    composeAPIObject = json.loads(composeAPI.read())
    composeAPI.close()
except json.JSONDecodeError:
    composeAPI.close()
    sys.stderr.write("failed to decode intermine_compose API spec")
    sys.exit(os.EX_DATAERR)

try:
    configuratorAPIObject = json.loads(configuratorAPI.read())
    configuratorAPI.close()
except json.JSONDecodeError:
    configuratorAPI.close()
    sys.stderr.write("failed to decode intermine_configurator API spec")
    sys.exit(os.EX_DATAERR)


# Check for changes in paths section of the spec
print("Merging paths section")
flag = 0
for key in configuratorAPIObject["paths"].keys():
    if key in composeAPIObject["paths"]:
        if configuratorAPIObject["paths"][key] is not composeAPIObject["paths"][key]:
            composeAPIObject["paths"][key] = configuratorAPIObject["paths"][key]
            flag += 1
        else:
            pass
    else:
        composeAPIObject["paths"][key] = configuratorAPIObject["paths"][key]
        flag += 1

# Check for changes in components section of the spec
print("Merging components section")
for key in configuratorAPIObject["components"]["schemas"].keys():
    if key in composeAPIObject["components"]["schemas"]:
        if configuratorAPIObject["components"]["schemas"][key] is not composeAPIObject["components"]["schemas"][key]:
            composeAPIObject["components"]["schemas"][key] = configuratorAPIObject["components"]["schemas"][key]
            flag += 1
        else:
            pass
    else:
        composeAPIObject["components"]["schemas"][key] = configuratorAPIObject["components"]["schemas"][key]
        flag += 1
if flag != 0:
    print("Overwriting compose API")
    composeAPI = open(composeAPIPath, "wt")
    composeAPI.write(json.dumps(composeAPIObject, indent=4))
    composeAPI.close()

    print("Commiting changes to intermine-compose repo")
    index = intermineComposeRepo.index
    index.add_all()
    index.write()
    author = pygit2.Signature("Intermine Bot", "info@intermine.org")
    commiter = pygit2.Signature("Intermine Bot", "info@intermine.org")
    tree = index.write_tree()
    message = "merged openapi.json from configurator repo with openapi.json in this repo"
    oid = intermineComposeRepo.create_commit(
        "refs/heads/master", author, commiter, message, tree, [intermineComposeRepo.head.peel().hex])

    print("pushing changes to intermine-compose master branch")
    remote = intermineComposeRepo.remotes["origin"]
    # Create a new git user and give it write access to master branch
    gitUsername = os.environ.get("SCRIPT_GIT_USERNAME")
    gitPassword = os.environ.get("SCRIPT_GIT_PASSWORD")
    credentials = pygit2.UserPass(gitUsername, gitPassword)
    remote.credentials = credentials
    callbacks = pygit2.RemoteCallbacks(credentials=credentials)
    remote.push(['refs/heads/master'], callbacks=callbacks)
else:
    print("Nothing to commit!!")
print("Merging successful")
