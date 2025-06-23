package org.springframework.samples.petclinic.rest.config;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.mapping.RepositoryDetectionStrategy.RepositoryDetectionStrategies;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RepositoryRestResourceConfig implements RepositoryRestConfigurer {

	private EntityManager entityManager;


	@Override
	public void configureRepositoryRestConfiguration(
		RepositoryRestConfiguration config, CorsRegistry cors) {
		config.setBasePath("/api");
		RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);
		exposeIdsForJpaEntities(config);
		config.setRepositoryDetectionStrategy(RepositoryDetectionStrategies.DEFAULT);

	}

	private void exposeIdsForJpaEntities(RepositoryRestConfiguration config) {
		entityManager
			.getMetamodel()
			.getEntities()
			.forEach(entityType -> config.exposeIdsFor(entityType.getJavaType()));
	}


	@Autowired
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


}
