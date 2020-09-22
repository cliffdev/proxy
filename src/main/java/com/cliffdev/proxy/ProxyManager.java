package com.cliffdev.proxy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class ProxyManager {

    @Autowired
    private ProxyConfig proxyConfig;

    @Autowired
    private  HexDumpProxy hexDumpProxy;
            
    public void execute(){
        List<ProxyConfig.Info> proxyList = proxyConfig.getListExt();
        if(proxyList != null ){
            for(ProxyConfig.Info item :proxyList) {
                log.info("正在启动:"+item);
                try {
                    hexDumpProxy.start(item.localIp(), item.localPort(), item.remoteIp(), item.remotePort());
                    log.info("启动:"+item+" oK");
                }catch (Exception ex){
                    log.info(item+" 启动异常",ex);
                }
            }
        }
    }

}
