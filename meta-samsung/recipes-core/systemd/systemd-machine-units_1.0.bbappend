FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_crespo = " \
  file://rndissetup.sh \
  file://rndissetup.service \
  file://disablefbcon.sh \
  file://disablefbcon.service \
  file://logind.conf \
"

SRC_URI_append_tuna = " \
  file://rndissetup.sh \
  file://rndissetup.service \
"

do_install_append() {
        if [ "${MACHINE}" = "crespo" -o "${MACHINE}" = "tuna" ]; then
                install -d ${D}${bindir}
                install -m 0755 ${WORKDIR}/rndissetup.sh ${D}${bindir}
                install -d ${D}${systemd_unitdir}/system
                install -m 0644 ${WORKDIR}/rndissetup.service ${D}${systemd_unitdir}/system
        fi
        if [ "${MACHINE}" = "crespo" ]; then
                install -m 0755 ${WORKDIR}/disablefbcon.sh ${D}${bindir}
                install -d ${D}${sysconfdir}/systemd
                install -m 0655 ${WORKDIR}/logind.conf ${D}${sysconfdir}/systemd/
        fi
}

SYSTEMD_SERVICE_${PN}_crespo = "rndissetup.service disablefbcon.service"
SYSTEMD_SERVICE_${PN}_tuna = "rndissetup.service"

PRINC := "${@int(PRINC) + 9}"
