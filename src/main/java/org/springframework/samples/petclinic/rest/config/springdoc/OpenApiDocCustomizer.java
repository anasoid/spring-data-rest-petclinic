package org.springframework.samples.petclinic.rest.config.springdoc;

import io.swagger.v3.core.filter.SpecFilter;
import io.swagger.v3.oas.models.OpenAPI;
import org.springdoc.core.customizers.GlobalOpenApiCustomizer;

public class OpenApiDocCustomizer extends SpecFilter implements GlobalOpenApiCustomizer {

	private static final int OPERATION_ID_MAX_LENGTH = 80;

	@Override
	public void customise(OpenAPI openApi) {
		//removePropertyIdPaths(openApi);

		removeBrokenReferenceDefinitions(openApi);
	}

	private void removePropertyIdPaths(OpenAPI openApi) {
		openApi
			.getPaths()
			.entrySet()
			.removeIf(path -> path.getKey().matches(".*/\\{id\\}/[a-zA-Z]+/\\{propertyId\\}$"));
	}


}
