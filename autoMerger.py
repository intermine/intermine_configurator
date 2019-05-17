import os
import sys
import json
import pygit2

# clone intermine_compose git repo in current dir
print('Cloning intermine-compose repo')
intermineComposeRepo = pygit2.clone_repository(
    "https://github.com/intermine/intermine-compose", "intermine-compose", checkout_branch="master")


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
for key in configuratorAPIObject["paths"].keys():
    if key in composeAPIObject["paths"]:
        if configuratorAPIObject["paths"][key] is not composeAPIObject["paths"][key]:
            composeAPIObject["paths"][key] = configuratorAPIObject["paths"][key]
        else:
            pass
    else:
        composeAPIObject["paths"][key] = configuratorAPIObject["paths"][key]

# Check for changes in components section of the spec
print("Merging components section")
for key in configuratorAPIObject["components"].keys():
    if key in composeAPIObject["components"]:
        if configuratorAPIObject["components"][key] is not composeAPIObject["components"][key]:
            composeAPIObject["components"][key] = configuratorAPIObject["components"][key]
        else:
            pass
    else:
        composeAPIObject["components"][key] = configuratorAPIObject["components"][key]

print("Overwriting compose API")
composeAPI = open(composeAPIPath, "wt")
composeAPI.write(json.dumps(composeAPIObject, indent=4))
composeAPI.close()

print("Commiting changes to intermine-compose repo")
index = intermineComposeRepo.index
index.add_all()
index.write()
author = pygit2.Signature("Ankur Kumar", "ank@leoank.me")
commiter = pygit2.Signature("Ankur Kumar", "ank@leoank.me")
tree = index.write_tree()
message = "Merge intermine_configurator API"
oid = intermineComposeRepo.create_commit(
    "refs/heads/master", author, commiter, message, tree, [intermineComposeRepo.head.get_object().hex])

print("pushing changes to intermine-compose master branch")
remote = intermineComposeRepo.remotes["origin"]
# Create a new git user and give it write access to master branch
gitUsername = os.environ.get("gitUserName")
gitPassword = os.environ.get("gitPassword")
credentials = pygit2.UserPass(gitUsername, gitPassword)
remote.credentials = credentials
callbacks = pygit2.RemoteCallbacks(credentials=credentials)
remote.push(['refs/heads/master'], callbacks=callbacks)

print("Merging successful")
