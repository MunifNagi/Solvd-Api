package com.solvd.carina.demo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

@Endpoint(url = "${config.env.api_url}/mealplanner/${config.env.username}/items/11951203?hash=${config.env.user_hash}&rapidapi-key=${api_key}", methodType = HttpMethodType.DELETE)
@RequestTemplatePath(path = "api/meals/_delete/item_rq.json")
@ResponseTemplatePath(path = "api/meals/_delete/item_rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class RemoveFromPlanMethod extends AbstractApiMethodV2 {
    public RemoveFromPlanMethod() {
        replaceUrlPlaceholder("api_key", Configuration.getEnvArg("api_key"));
    }
}
