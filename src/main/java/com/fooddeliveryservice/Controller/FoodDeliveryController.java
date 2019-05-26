//package com.fooddeliveryservice.Controller;
//
//import com.fooddeliveryservice.Entity.User;
//import com.fooddeliveryservice.Service.IUserService;
//import com.github.openjson.JSONObject;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//
//@RestController
//@RequestMapping("/api")
//public class FoodDeliveryController {
//
//    @Autowired
//    private IUserService iUserService;
//
//    @RequestMapping(value = "/customers", method = RequestMethod.POST)
//    public String createNewUser(@RequestBody String jsonWithUser) throws ParseException {
//        JSONObject jsonNewUser = new JSONObject(jsonWithUser);
//        String firstName = jsonNewUser.getString("firstName");
//        String lastName = jsonNewUser.getString("lastName");
//        String userName = jsonNewUser.getString("userName");
//        String userPassword = jsonNewUser.getString("userPassword");
//        String permission = jsonNewUser.getString("permission");
////        Integer addressId = jsonNewUser.getInt("addressId");
//        String emailAddress = jsonNewUser.getString("emailAddress");
//        String phoneNumber = jsonNewUser.getString("phoneNumber");
//        String lastLogin = jsonNewUser.getString("lastLogin");
//        String lastOrder = jsonNewUser.getString("lastOrder");
//        if (StringUtils.isBlank(firstName) || StringUtils.isBlank(lastName) || StringUtils.isBlank(userName) ||
//                StringUtils.isBlank(userPassword) || StringUtils.isBlank(permission) ||
////                StringUtils.isNoneEmpty(addressId)
//                StringUtils.isBlank(emailAddress) || StringUtils.isBlank(phoneNumber) ||
//                StringUtils.length(lastLogin) != 4 || StringUtils.length(lastOrder) != 4)
//            throw new IllegalArgumentException(
//
//                    "Couldn't parse a JSON from the request. JSON: " + jsonWithUser);
//
//        User userToService = new User();
//        userToService.setFirstName(firstName);
//        userToService.setLastName(lastName);
//        userToService.setUserName(userName);
//        userToService.setUserPassword(userPassword);
//        userToService.setPermission(permission);
////        userToService.setAddressId(addressId);
//        userToService.setEmailAddress(emailAddress);
//        userToService.setPhoneNumber(phoneNumber);
//
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
//        java.util.Date date = sdf1.parse(lastLogin);
//        userToService.setLastLogin(new java.sql.Date(date.getTime()));
//        userToService.setLastOrder(new java.sql.Date(date.getTime()));
//
//        User savedUser = iUserService.save(userToService);
//        String resultMessage = savedUser != null ? "success" : "failure";
//        return "<div style=\"text-align:center;\">" + "<h1> New customer was stored: " + resultMessage
//
//                + " </h1></div>";
//
//    }
//    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
//    public User findById(@PathVariable String id){
//        return iUserService.findById(Integer.valueOf(id));
//    }
//
//
//
//
//
//
//
////    @RequestMapping("/")
////    public String index() {
////        return "<div style=\"text-align:center;\">" + "<h1>Welcome</h1>" + "<p> to Food Delivery Service </p>" + "</div>";
////    }
////
////    @RequestMapping(value = "/user", method = RequestMethod.GET)
////    public String getWelcomeMessageForUser(@RequestParam String name) {
////        return "<div style=\"text-align:center;\">" + "<h1>Welcome, " + name + "</h1>" + "<p> How may we assist you today? </p>" + "</div>";
////    }
//
////    @RequestMapping(value = "/{resource}", method = RequestMethod.GET)
////    public String getWelcomeMessageFromResource(@PathVariable String resource) {
////        return "<div style=\"text-align:center;\">" + "<h1>This request was done to the resource: " + resource + "</h1>" + "</div>";
////    }
//
////    @RequestMapping(value = "/customizedWelcome", method = RequestMethod.POST)
////    public String getWelcomeMessageWithFromJSON(@RequestBody String message) {
////        JSONObject json = new JSONObject(message);
////        String firstName = "Albert";
////        String defaultPictureAddress = "https://cdn-images-1.medium.com/fit/t/1600/672/0*n-2bW82Z6m6U2bij.jpeg";
////        String firstNameFromRequest = json.getString("firstName");
////        if (StringUtils.isNotBlank(firstNameFromRequest)) {
////            firstName = firstNameFromRequest;
////        }
////        String pictureURLFromRequest = json.getString("pictureURL");
////        if (StringUtils.isNotBlank(pictureURLFromRequest)) {
////            defaultPictureAddress = pictureURLFromRequest;
////        }
////        return "<div style=\"text-align:center;\">" + "<h1>Welcome " + firstName + "</h1>" + "<p> How may we assist you today </p>" + "<img src=" + defaultPictureAddress + "></img>" + "</div>";
////    }
//
//
//}
//
