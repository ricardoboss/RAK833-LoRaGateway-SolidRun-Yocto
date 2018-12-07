SUMMARY = "A console-only image that fully supports the target device \
hardware."

IMAGE_FEATURES += "splash"

LICENSE = "MIT"

inherit core-image

IMAGE_INSTALL += "git libftdi libmpsse bash cmake lora-packet-forwarder lora-gateway-dev lora-gateway-staticdev lora-gateway-utils"
