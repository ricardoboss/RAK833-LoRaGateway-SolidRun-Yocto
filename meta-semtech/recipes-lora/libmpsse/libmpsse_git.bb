DESCRIPTION = "Interface library to interact with ftdi mpsse module"
HOMEPAGE = "https://github.com/chmorgan/libmpsse"
SECTION = "libs"

LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/README.md;md5=139bd2070f4ed89665fcb069ebf0781a"

DEPENDS = "libftdi"

SRC_URI = "git://github.com/devttys0/libmpsse.git;protocol=https;branch=master"
SRCREV = "a2eafa24a3446a711b13523ec06c17b5a1c6cdc1"

S = "${WORKDIR}/git/src"

inherit autotools-brokensep

EXTRA_OECONF += "--disable-python"
CFLAGS += "-DLIBFTDI1=1"

do_install_append() {
	mv ${D}${libdir}/libmpsse.so ${D}${libdir}/libmpsse.so.1
	( cd ${D}${libdir}; ln -s libmpsse.so.1 libmpsse.so )
}


