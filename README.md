# RAK833-LoRaGateway-SolidRun-Yocto
verified on HummingBoard2 rev 1.4 and MicroSOM rev 1.5

##	prepare yocto image
 
step1 : Download

  refer to guide (https://wiki.solid-run.com/doku.php?id=products:imx6:software:os:yocto)

  First, get Poky:

      git clone -b fido git://git.yoctoproject.org/poky.git
  Then get the Freescale layers:      

      cd poky
      git clone -b fido git://git.yoctoproject.org/meta-fsl-arm
      git clone -b fido git://github.com/SolidRun/meta-solidrun-arm-imx6.git      
      
  Add meta-semtech lora layer

      git clone https://github.com/RAKWireless/RAK833-LoRaGateway-SolidRun-Yocto.git
      
  then run 

      source oe-init-build-env

step2 : Editing local.conf and bblayers.conf at build/conf

      set MACHINE ??= "solidrun-imx6" at local.conf       
      add  meta-fsl-arm meta-solidrun-arm-imx6  meta-semtech to bblayers.conf 
refer [bblayers.conf](https://github.com/RAKWireless/RAK833-LoRaGateway-SolidRun-Yocto.git)

step3 : Customizing images for lora image

      add IMAGE_INSTALL += "git libftdi libmpsse bash cmake lora-packet-forwarder lora-gateway-dev lora-gateway-staticdev lora-gateway-utils" to core-image-base.bb (../poky/meta/recipes-core/images) , 
refer [core-image-base.bb](https://github.com/RAKWireless/RAK833-LoRaGateway-SolidRun-Yocto.git)

step4 : Building packages
        
      source oe-init-build-env
      nice bitbake core-image-base

step5 : flashing image to SD card(https://wiki.solid-run.com/doku.php?id=products:imx6:overview:flashsdcard)
        sudo dd if=core-image-base-solidrun-imx6.sdcard of=/dev/sdb bs=4M conv=fsync

step6 : plug RAK833 module to solidrun HB2 board.
        make sure the mini-pcie PERST# signal(pin 22) pulled down (default high will cause rak833 function error)

step7 : Start the packet-forwarder application

      $ cd /opt/lora-packet-forwarder
      $ ./lora_pkt_fwd

      
           
         
           
