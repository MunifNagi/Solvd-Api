package com.solvd.carina.demo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;

import java.util.Properties;

public class GetStandingMethod extends AbstractApiMethodV2 {
    public GetStandingMethod() {
        super(null, "api/football/_getStanding/rs.json", new Properties());
        replaceUrlPlaceholder("base_url","https://api-football-v1.p.rapidapi.com/v3/");
    }
}