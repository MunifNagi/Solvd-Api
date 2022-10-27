package com.solvd.carina.demo;

import java.lang.invoke.MethodHandles;

import com.solvd.carina.demo.api.*;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;

public class APISampleTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "munif")
    @TestPriority(Priority.P1)
    public void testGetRecipeSummary() {
        GetRecipeSummaryMethod getRecipeSummaryMethod = new GetRecipeSummaryMethod();
        getRecipeSummaryMethod.callAPIExpectSuccess();
        getRecipeSummaryMethod.validateResponseAgainstSchema("api/recipes/_get/summary_rs.schema");
    }

    @Test()
    @MethodOwner(owner = "munif")
    @TestPriority(Priority.P1)
    public void testGetSimilarRecipes() {
        GetSimilarRecipesMethod getSimilarRecipesMethod = new GetSimilarRecipesMethod();
        getSimilarRecipesMethod.callAPIExpectSuccess();
        getSimilarRecipesMethod.validateResponse(JSONCompareMode.LENIENT);
        getSimilarRecipesMethod.validateResponseAgainstSchema("api/recipes/_get/similar_rs.schema");
    }

    @Test()
    @MethodOwner(owner = "munif")
    @TestPriority(Priority.P1)
    public void testAnalyzeRecipe() {
        AnalyzeRecipeMethod analyzeRecipeMethod = new AnalyzeRecipeMethod();
        analyzeRecipeMethod.callAPIExpectSuccess();
        analyzeRecipeMethod.validateResponse(JSONCompareMode.LENIENT);
        analyzeRecipeMethod.validateResponseAgainstSchema("api/recipes/_post/analyze_rs.schema");
    }

    @Test()
    @MethodOwner(owner = "munif")
    @TestPriority(Priority.P1)
    public void testSearchIngredient() {
        SearchIngredientMethod searchIngredientAutocomplete = new SearchIngredientMethod();
        searchIngredientAutocomplete.callAPIExpectSuccess();
        searchIngredientAutocomplete.validateResponse(JSONCompareMode.LENIENT);
        searchIngredientAutocomplete.validateResponseAgainstSchema("api/ingredients/_get/search_rs.schema");
    }
    @Test()
    @MethodOwner(owner = "munif")
    @TestPriority(Priority.P1)
    public void testGenerateMealPlanMethod() {
        GenerateMealPlanMethod generateMealPlanMethod = new GenerateMealPlanMethod();
        generateMealPlanMethod.callAPIExpectSuccess();
        generateMealPlanMethod.validateResponseAgainstSchema("api/meals/_get/generate_rs.schema");
    }
    @Test()
    @MethodOwner(owner = "munif")
    @TestPriority(Priority.P1)
    public void testGetMealPlanMethod() {
        GetMealPlanMethod getMealPlanDay = new GetMealPlanMethod();
        getMealPlanDay.callAPIExpectSuccess();
        getMealPlanDay.validateResponseAgainstSchema("api/meals/_get/plan_rs.schema");
    }

    @Test()
    @MethodOwner(owner = "munif")
    @TestPriority(Priority.P1)
    public void testConnectUserMethod() {
        ConnectUserMethod connectUserMethod = new ConnectUserMethod();
        connectUserMethod.callAPIExpectSuccess();
        connectUserMethod.validateResponseAgainstSchema("api/meals/_post/user_rs.schema");
    }
    @Test()
    @MethodOwner(owner = "munif")
    @TestPriority(Priority.P1)
    public void testAddToMealPlanMethod() {
        AddToMealPlanMethod addToMealPlanMethod = new AddToMealPlanMethod();
        addToMealPlanMethod.callAPIExpectSuccess();
        addToMealPlanMethod.validateResponseAgainstSchema("api/meals/_post/plan_rs.schema");
    }
    @Test()
    @MethodOwner(owner = "munif")
    @TestPriority(Priority.P1)
    public void testRemoveFromMealPlanMethod() {
        RemoveFromPlanMethod removeFromPlanMethod = new RemoveFromPlanMethod();
        removeFromPlanMethod.callAPIExpectSuccess();
        removeFromPlanMethod.validateResponseAgainstSchema("api/meals/_delete/item_rs.schema");
    }
    @Test()
    @MethodOwner(owner = "munif")
    @TestPriority(Priority.P1)
    public void testClearMealPlanMethod() {
        ClearMealPlanMethod clearMealPlanMethod = new ClearMealPlanMethod();
        clearMealPlanMethod.callAPIExpectSuccess();
        clearMealPlanMethod.validateResponse(JSONCompareMode.STRICT);
        clearMealPlanMethod.validateResponseAgainstSchema("api/meals/_delete/plan_rs.schema");
    }
}