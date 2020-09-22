package com.cliffdev.proxy;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "proxy")
public class ProxyConfig {

    private List<String> list = new ArrayList();

    public List<String> getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public List<Info> getListExt() {
        List<Info> infoList = new ArrayList();
        for(String item:list)
        {
            Info info = new Info(item);
            infoList.add(info);
        }
        return  infoList;
    }

    public class Info{

        public Info(String infoStr){
            String [] arr = infoStr.split(";");
            local = arr[0];
            remote = arr[1];
        }

        private String local;
        private String remote;

        public String localIp(){
            return local.split(":")[0];
        }
        public int localPort(){
            return Integer.parseInt(local.split(":")[1]);
        }

        public String remoteIp(){
            return remote.split(":")[0];
        }
        public int remotePort(){
            return Integer.parseInt(remote.split(":")[1]);
        }

        public String toString(){
            return local+"=>"+remote;
        }
    }
}
