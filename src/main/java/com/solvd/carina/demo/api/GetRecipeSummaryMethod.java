package com.solvd.carina.demo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

@Endpoint(url = "${config.env.api_url}/recipes/4632/summary?rapidapi-key=${api_key}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/recipes/_get/summary_rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetRecipeSummaryMethod extends AbstractApiMethodV2 {
    public GetRecipeSummaryMethod() {
        replaceUrlPlaceholder("api_key", Configuration.getEnvArg("api_key"));
    }
}