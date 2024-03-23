FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

KERNEL_CONFIG_FRAGMENTS:append = "${WORKDIR}/fragments/${LINUX_VERSION}/fragment-08-fbdevconsole.config"

SRC_URI:append = " \
    file://${LINUX_VERSION}/fragment-08-fbdevconsole.config;subdir=fragments \
    "

SRC_URI:class-devupstream += "file://${LINUX_VERSION}/fragment-08-fbdevconsole.config;subdir=fragments"
