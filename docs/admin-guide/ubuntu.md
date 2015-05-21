These are packages that we recommend you install on your server.

## Rolling log files

### Install logrotate 
```
sudo apt-get install logrotate
```

### Configure logrotate
See [logrotate tutorial](https://www.digitalocean.com/community/tutorials/how-to-manage-log-files-with-logrotate-on-ubuntu-12-10) on Digital Ocean.

## Unattended upgrades

### Install unattended-upgrades 
```
sudo apt-get install unattended-upgrades
```

### Enabled unattended-upgrades
```
sudo dpkg-reconfigure -plow unattended-upgrades
``` 
For more details see documentation about [Automatic Security Updates](https://help.ubuntu.com/community/AutomaticSecurityUpdates).


```
Welcome to Ubuntu 12.04.5 LTS (GNU/Linux 3.2.0-83-virtual x86_64)

 * Documentation:  https://help.ubuntu.com/

  System information as of Thu May 21 20:01:31 UTC 2015

  System load:  0.0                Processes:           87
  Usage of /:   32.7% of 78.74GB   Users logged in:     0
  Memory usage: 13%                IP address for eth0: 172.31.40.181
  Swap usage:   0%

  Graph this data and manage this system at:
    https://landscape.canonical.com/

  Get cloud support with Ubuntu Advantage Cloud Guest:
    http://www.ubuntu.com/business/services/cloud

  Use Juju to deploy your cloud instances and workloads:
    https://juju.ubuntu.com/#cloud-precise

6 packages can be updated.            
0 updates are security updates.       <========================= These are the packages to be updated

New release '14.04.2 LTS' available.
Run 'do-release-upgrade' to upgrade to it.

*** /dev/xvda1 will be checked for errors at next reboot ***

*** System restart required ***
You have mail.
Last login: Thu May 21 18:13:58 2015 from allscreens03.a.subnet.rcn.com
```
