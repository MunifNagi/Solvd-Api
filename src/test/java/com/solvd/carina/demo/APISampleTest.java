package com.solvd.carina.demo;

import java.lang.invoke.MethodHandles;

import com.solvd.carina.demo.api.GetWeatherMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;

/**
 * This sample shows how create REST API tests.
 *
 * @author qpsdemo
 */
public class APISampleTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "munifnagi")
    @TestPriority(Priority.P1)
    public void testGetStanding() {
        GetWeatherMethod getWeatherMethod  = new GetWeatherMethod();
        getWeatherMethod.callAPI();
        getWeatherMethod.callAPIExpectSuccess();
//        getStandingMethod.validateResponseAgainstSchema("api/football/_get/rs.schema");
    }

}
