package com.fooddeliveryservice.fooddeliveryservice.Controller;

import com.github.openjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
public class FoodDeliveryController {
    @RequestMapping("/")
    public String index() {
        return "<div style=\"text-align:center;\">" + "<h1>Welcome</h1>" + "<p> to Food Delivery Service </p>" + "</div>";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getWelcomeMessageForUser(@RequestParam String name) {
        return "<div style=\"text-align:center;\">" + "<h1>Welcome, " + name + "</h1>" + "<p> How may we assist you today? </p>" + "</div>";
    }

    @RequestMapping(value = "/{resource}", method = RequestMethod.GET)
    public String getWelcomeMessageFromResource(@PathVariable String resource) {
        return "<div style=\"text-align:center;\">" + "<h1>This request was done to the resource: " + resource + "</h1>" + "</div>";
    }

    @RequestMapping(value = "/customizedWelcome", method = RequestMethod.POST)
    public String getWelcomeMessageWithFromJSON(@RequestBody String message) {
        JSONObject json = new JSONObject(message);
        String firstName = "Albert";
        String defaultPictureAddress = "https://cdn-images-1.medium.com/fit/t/1600/672/0*n-2bW82Z6m6U2bij.jpeg";
        String firstNameFromRequest = json.getString("firstName");
        if (StringUtils.isNotBlank(firstNameFromRequest)) {
            firstName = firstNameFromRequest;
        }
        String pictureURLFromRequest = json.getString("pictureURL");
        if (StringUtils.isNotBlank(pictureURLFromRequest)) {
            defaultPictureAddress = pictureURLFromRequest;
        }
        return "<div style=\"text-align:center;\">" + "<h1>Welcome " + firstName + "</h1>" + "<p> How may we assist you today </p>" + "<img src=" + defaultPictureAddress + "></img>" + "</div>";
    }


}

