package com.solvd.carina.demo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

@Endpoint(url = "${config.env.api_url}/recipes/analyze?language=en&includeNutrition=false&includeTaste=false&rapidapi-key=${api_key}", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/recipes/_post/analyze_rq.json")
@ResponseTemplatePath(path = "api/recipes/_post/analyze_rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class AnalyzeRecipeMethod extends AbstractApiMethodV2 {
    public AnalyzeRecipeMethod() {
        replaceUrlPlaceholder("api_key", Configuration.getEnvArg("api_key"));
    }
}
