<img alt="Alarm logo" src="alarm.svg" width="92px"/>

[![EO principles respected here](https://www.elegantobjects.org/badge.svg)](https://www.elegantobjects.org)
[![DevOps By Rultor.com](https://www.rultor.com/b/yegor256/rultor)](https://www.rultor.com/p/yegor256/rultor)
[![We recommend IntelliJ IDEA](https://www.elegantobjects.org/intellij-idea.svg)](https://www.jetbrains.com/idea/)
[![License](https://img.shields.io/badge/license-MIT-green.svg)](https://github.com/ticketsyncs/clockfarm/blob/master/LICENSE)
[![PDD status](http://www.0pdd.com/svg?name=ticketsyncs/clockfarm)](http://www.0pdd.com/p?name=ticketsyncs/clockfarm)

[![Terraform](https://github.com/ticketsyncs/clockfarm/actions/workflows/terraform.yml/badge.svg)](https://github.com/ticketsyncs/clockfarm/actions/workflows/terraform.yml)
[![Java CI with Maven](https://github.com/ticketsyncs/clockfarm/actions/workflows/maven.yml/badge.svg)](https://github.com/ticketsyncs/clockfarm/actions/workflows/maven.yml)
[![codecov](https://codecov.io/github/ticketsyncs/clockfarm/branch/master/graph/badge.svg?token=H0DGTD88KX)](https://codecov.io/github/ticketsyncs/clockfarm)
[![Docker](https://img.shields.io/docker/v/abialiauski/ticketsyncs-clockfarm/latest)](https://hub.docker.com/repository/docker/abialiauski/ticketsyncs-clockfarm/general)
[![Hits-of-Code](https://hitsofcode.com/github/h1alexbel/ticket-harvest-sync)](https://hitsofcode.com/view/github/h1alexbel/ticket-harvest-sync)


Clockfarm is Core Engine of Ticketsyncs, here we synchronize ticket systems like [```Jira```](https://www.atlassian.com/software/jira) and [```Harvest```](https://www.getharvest.com), the time tracking app.

# Prerequisites

You need to have [```Docker```](https://www.docker.com), ```Java 17+```, and ```Maven 3.3+``` installed.

# Quick Start

```shell
$ sh up.sh
```

# How to contribute
Fork repository, make changes, send us a [pull request](https://www.yegor256.com/2014/04/15/github-guidelines.html).
We will review your changes and apply them to the `master` branch shortly,
provided they don't violate our quality standards. To avoid frustration,
before sending us your pull request please run full Maven build:

```bash
$ mvn clean install -Pqulice
```
