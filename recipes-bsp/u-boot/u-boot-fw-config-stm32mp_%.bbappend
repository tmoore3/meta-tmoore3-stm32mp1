FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " \
       file://fw_env.config.mmc \
       "

do_install:append() {
    ln -s -r ${D}${sysconfdir}/fw_env.config.mmc ${D}${sysconfdir}/fw_env.config 
}
