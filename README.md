# Brief Introduction

My custom meta-layer for stm32mp1 board series.

# Yocto Setup

## Host setup

A Yocto Project build requires that some packages be installed for the build that are documented under the Yocto Project. Go to Yocto Project Quick Start and check for the packages that must be installed for your build machine. Essential Yocto Project host packages are:

```bash
$ sudo apt-get update && sudo apt-get install -y \
wget git-core diffstat unzip texinfo gcc-multilib \
build-essential chrpath socat cpio python python3 python3-pip python3-pexpect \
xz-utils debianutils iputils-ping python3-git python3-jinja2 libegl1-mesa libsdl1.2-dev \
pylint3 xterm rsync curl gawk zstd lz4 locales bash-completion
```

## Repo setup

Repo is a tool built on top of Git that makes it easier to manage projects that contain multiple repositories.

Install or update **repo** to the latest version.

```bash
mkdir -p ~/bin
curl https://storage.googleapis.com/git-repo-downloads/repo > ~/bin/repo
chmod a+x ~/bin/repo
export PATH=~/bin:$PATH
```

Make sure that Git is set up properly with the following commands:

```bash
git config --global user.name "Your Name"
git config --global user.email "Your Email"
git config --list
```

## Yocto setup

The following example shows how to download the STM32MP1 Distribution Package OpenSTLinux distribution.

```bash
mkdir -p ~/yocto-stm32mp1
cd ~/yocto-stm32mp1
repo init -u https://github.com/STMicroelectronics/oe-manifest.git -b refs/tags/openstlinux-6.1-yocto-mickledore-mp1-v23.06.21
repo sync
```

When this process is completed, the source code is checked out into the directory yocto-stm32mp1/layers. Then we need use the following command to clone this meta-layer (meta-tmoore3-stm32mp1) to `yocto-stm32mp1/layers` folder.

```bash
cd layers
git clone git@github.com:tmoore3/meta-tmoore3-stm32mp1.git
```

# Yocto Build

## Build configurations

ST provides a script ***envsetup.sh***, To use the script, the name of the specific machine to be built for needs to be specified. The script will set up a directory and the configuration files for the specified machine.

The syntax for the  ***envsetup.sh*** script is shown below:

```bash
DISTRO=openstlinux-weston MACHINE=<machine> source layers/meta-st/scripts/envsetup.sh
```

Take stm32mp157f-dk2 board as example, we can use following command to setup the Yocto build environment.

```bash
cd ~/yocto-stm32mp1
DISTRO=openstlinux-weston MACHINE=stm32mp15-disco source layers/meta-st/scripts/envsetup.sh
```

## Add Layer

```bash
bitbake-layers add-layer ../layers/meta-tmoore3-stm32mp1/
```
