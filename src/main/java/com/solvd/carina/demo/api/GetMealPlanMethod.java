package com.solvd.carina.demo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

@Endpoint(url = "${config.env.api_url}/mealplanner/${config.env.username}/day/2022-10-26?hash=${config.env.user_hash}&rapidapi-key=${api_key}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/meals/_get/plan_rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetMealPlanMethod extends AbstractApiMethodV2 {
    public GetMealPlanMethod() {
        replaceUrlPlaceholder("api_key", Configuration.getEnvArg("api_key"));
    }
}
