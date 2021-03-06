DESCRIPTION = "Elementary based client for Remember the Milk written in Python. "
AUTHOR = "Michael Pilgermann"
LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=8f0e2cd40e05189ec81232da84bd6e1a"

HOMEPAGE = "http://freshmeat.net/projects/rtmom"
SRCNAME = "rtmom"
DEPENDS = "python python-elementary"
RDEPENDS_${PN} = "python-core pyrtm"
RSUGGESTS_${PN} = "python-simplejson"

PR = "r4"

SRC_URI = "http://cloud.github.com/downloads/kichkasch/rtmom/rtmom-src-${PV}.tar.gz"

# intentionally empty, so that rtmom.conf.example goes to PN
FILES_${PN}-doc = ""
FILES_${PN} += "/opt/rtmom \
                ${datadir}/pixmaps \
                ${datadir}/applications \
                ${datadir}/doc/rtmom"
CONFFILES_${PN} += "${datadir}/doc/${PN}/rtmom.conf.example"

do_compile() {
    python ${S}/setup.py build ${D}
}

do_install() {
    python ${S}/setup.py install ${D}
    rm -rf ${D}/opt/rtmom/build/
    rm -rf ${D}/opt/rtmom/patches/
}

SRC_URI[md5sum] = "c4a1012fc0e00d2b64d8d794166bf893"
SRC_URI[sha256sum] = "9227e503a90054dd643364272d48b3eae8dae3a9c6c4a42a2859395a8786398f"
