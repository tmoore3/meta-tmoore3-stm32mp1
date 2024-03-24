SUMMARY = "Enable USB-IP remote server"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit systemd

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "usbip.service"

SRC_URI = " file://stm32mp_usbip_bind_unbind.sh \
    file://usbip.service \
    file://99-usb-usbip.rules \
    "

do_install() {
  install -d ${D}${systemd_unitdir}/system/
  install -m 0644 ${WORKDIR}/usbip.service  ${D}/${systemd_unitdir}/system

  install -d ${D}${sbindir}
  install -m 0755 ${WORKDIR}/stm32mp_usbip_bind_unbind.sh ${D}${sbindir}

  install -D -p -m 0644 ${WORKDIR}/99-usb-usbip.rules ${D}${sysconfdir}/udev/rules.d/99-usb-usbip.rules 
}

FILES:${PN} += "${systemd_unitdir}/system/usbip.service ${sysconfdir}/udev/rules.d/99-usb-usbip.rules "