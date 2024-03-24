FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " \
    file://busybox-tmoore3-stm32mp1.cfg \
    "
