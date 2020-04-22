Cerebro
------------
[![Docker Pulls](https://img.shields.io/docker/pulls/sirocchj/cerebro.svg)](https://hub.docker.com/r/sirocchj/cerebro)
[![Build Status](https://travis-ci.com/sirocchj/cerebro.svg?branch=master)](https://travis-ci.com/sirocchj/cerebro)

Cerebro is an open source (MIT License) ElasticSearch web admin tool built using Scala, Play Framework, AngularJS and Bootstrap.

This is a WIP fork of the original Cerebro, please visit [https://github.com/lmenezes/cerebro](https://github.com/lmenezes/cerebro) if you are interested in the original one
------------

This fork aims to:
- reduce the types of installations to 2: either .tgz or docker
- gradually replace Play with Http4s and Angular with Vue (or React)
- implement additional features

### Requirements
Cerebro needs Java 1.8 or newer to run.

### Local installation
- Download it from [https://github.com/sirocchj/cerebro/releases](https://github.com/sirocchj/cerebro/releases)
- Extract the files (`tar xfz cerebro-x.y.z.tgz`)
- Run it `bin/cerebro` (or `bin/cerebro.bat` if on Windows)
- Access it on [http://localhost:9000](http://loclhost:9000)

### Docker
You can find the official docker images in the official [docker hub repo](https://hub.docker.com/r/sirocchj/cerebro/).
The docker image is based on `openjdk:11.0.7-jre-slim`

### Configuration
#### HTTP server address and port
You can run Cerebro listening on a different host and port than the default (`0.0.0.0:9000`) by:

```
bin/cerebro -Dhttp.port=1234 -Dhttp.address=127.0.0.1
```

#### LDAP config
LDAP can be configured using the following environment variables:

```bash
# Set it to ldap to activate ldap authorization
AUTH_TYPE=ldap

# Your ldap url
LDAP_URL=ldap://exammple.com:389

LDAP_BASE_DN=OU=users,DC=example,DC=com

# Usually method should  be "simple" otherwise, set it to the SASL mechanisms
LDAP_METHOD=simple

# user-template executes a string.format() operation where
# username is passed in first, followed by base-dn. Some examples
#  - %s => leave user untouched
#  - %s@domain.com => append "@domain.com" to username
#  - uid=%s,%s => usual case of OpenLDAP
LDAP_USER_TEMPLATE=%s@example.com

# User identifier that can perform searches
LDAP_BIND_DN=admin@example.com
LDAP_BIND_PWD=adminpass

# Group membership settings (optional)

# If left unset LDAP_BASE_DN will be used
# LDAP_GROUP_BASE_DN=OU=users,DC=example,DC=com

# Attribute that represent the user, for example uid or mail
# LDAP_USER_ATTR=mail

# If left unset LDAP_USER_TEMPLATE will be used
# LDAP_USER_ATTR_TEMPLATE=%s

# Filter that tests membership of the group. If this property is empty then there is no group membership check
# AD example => memberOf=CN=mygroup,ou=ouofthegroup,DC=domain,DC=com
# OpenLDAP example => CN=mygroup
# LDAP_GROUP=memberOf=memberOf=CN=mygroup,ou=ouofthegroup,DC=domain,DC=com

```

When using Docker, you can add all the above environment variables in a file (e.g. `env-ldap`)
and pass it to Docker as follows:

```bash
 docker run -p 9000:9000 --env-file env-ldap sirocchj/cerebro
```

#### Other settings
Other settings are exposed through the `conf/application.conf` file found inside the application directory.

It is also possible to use an alternate configuration file defined on a different location using:

```
bin/cerebro -Dconfig.file=/some/other/dir/alternate.conf
```
