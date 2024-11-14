package com.sky.config;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqttConfiguration {

    private static final String MQTT_BROKER_URL = "tcp://你的MQTT服务器地址:端口";
    private static final String CLIENT_ID = "SpringBootClient";

    @Bean
    public MqttClient mqttClient() throws MqttException {
        MqttClient client = new MqttClient(MQTT_BROKER_URL, CLIENT_ID, new MemoryPersistence());

        MqttConnectOptions options = new MqttConnectOptions();
        options.setCleanSession(true);
        //todo
        options.setUserName("你的用户名"); // 可选
        options.setPassword("你的密码".toCharArray()); // 可选

        client.connect(options);
        return client;
    }
}
