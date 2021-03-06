DESCRIPTION = "nEo illume theme - a very fast, high contrast illume theme"
SECTION = "e/utils"
HOMEPAGE = "http://jmccloud.jm.funpic.de"
AUTHOR = "Jesus McCloud <bernd.pruenster@gmail.com"
DEPENDS = "edje-native"
RDEPENDS_${PN} = "e-wm"
RSUGGESTS_${PN} = "elementary-theme-neo gtk-theme-neo gpe-theme-neo icon-theme-neo"
inherit allarch
LICENSE = "MIT BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f523ab5986cc79b52a90d2ac3d5454a2"

SRCREV = "4e6035ef5452b2f0a128dff91ddeb8335a3aafec"
PV = "0.2+gitr${SRCPV}"

SRC_URI = "git://git.shr-project.org/repo/shr-themes.git;protocol=http;branch=master"

S = "${WORKDIR}/git/e-wm/${PN}"

do_compile() {
    ${STAGING_BINDIR_NATIVE}/edje_cc -id ${S}/. -fd ${S}/. ${S}/neo.edc -o ${S}/neo.edj
}

do_install() {
    install -d ${D}${datadir}/enlightenment/data/themes/
    install -m 0644 ${S}/neo.edj ${D}${datadir}/enlightenment/data/themes/
}

FILES_${PN} = "${datadir}/enlightenment/data/themes/"

pkg_postinst_${PN} () {
    echo "To activate this theme make sure to set your enlightenment rendering engine to SOFTWARE or enlightenment will segfault."
    echo "This theme also ships with an enlightenment bootscreen which can be activated by selecting it under STARTUP in the LOOK tab of enlightenment settings"
    echo "After activating this theme be sure to switch to SOFTWARE_16 engine in enlightenment advanced settings to unleash the theme's full power ;-)"
}
