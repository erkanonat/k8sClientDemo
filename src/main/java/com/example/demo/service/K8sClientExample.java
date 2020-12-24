package com.example.demo.service;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class K8sClientExample {

    public void listDeployments() {

        try {

            Config config = new ConfigBuilder().withMasterUrl("https://mymaster.com").build();
            KubernetesClient client = new DefaultKubernetesClient(config);
            client.apps().deployments().inNamespace("egys").list();

        }catch (Exception ex) {
             log.error(ex.toString());
        }

    }

}
