package com.rh.innovation.cloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@ConfigurationProperties
@RefreshScope
@Getter
public class CloudConfig {

	@Value("${nome.candidato}")
	private String nomeCandidato;
	
	@Value("hello.APi.Active")
	private boolean helloApiActive;
}
