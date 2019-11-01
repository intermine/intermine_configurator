# intermine-configurator
a group of web services used to create an InterMine instance

[![Build Status](https://travis-ci.org/intermine/intermine_configurator.svg?branch=master)](https://travis-ci.org/intermine/intermine_configurator)

Requirements
-------------------------------

* Java 8+
* [Redis](https://redis.io/topics/quickstart)

Add the environment $IM_DATA_DIR. This should be the same directory as set in your [intermine_compose .env file](https://github.com/intermine/intermine_compose#step-0). 

On a mac or linux: 

```bash
export IM_DATA_DIR=/tmp/sharedfs
```

Getting Started With InterMine
-------------------------------

To build the jar, run this command:

```
./gradlew build
```

Then to start the service, run this command:

```
./gradlew bootRun
```

API Specification
-------------------------------


The code is generated using [openapi.json](openapi.json)


