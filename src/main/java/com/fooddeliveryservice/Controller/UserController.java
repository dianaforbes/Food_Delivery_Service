package com.fooddeliveryservice.Controller;

import com.fooddeliveryservice.Entity.User;
import com.fooddeliveryservice.Service.IUserService;
import com.github.openjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public String createNewUser(@RequestBody String jsonWithUser) throws ParseException {
        JSONObject jsonNewUser = new JSONObject(jsonWithUser);
        String firstName = jsonNewUser.getString("firstName");
        String lastName = jsonNewUser.getString("lastName");
        String userName = jsonNewUser.getString("userName");
        String userPassword = jsonNewUser.getString("userPassword");
        String permission = jsonNewUser.getString("permission");
//        Integer addressId = jsonNewUser.getInt("addressId");
        String emailAddress = jsonNewUser.getString("emailAddress");
        String phoneNumber = jsonNewUser.getString("phoneNumber");
        String lastLogin = jsonNewUser.getString("lastLogin");
        String lastOrder = jsonNewUser.getString("lastOrder");
        if (StringUtils.isBlank(firstName) || StringUtils.isBlank(lastName) || StringUtils.isBlank(userName) ||
                StringUtils.isBlank(userPassword) || StringUtils.isBlank(permission) ||
//                StringUtils.isNoneEmpty(addressId)
                StringUtils.isBlank(emailAddress) || StringUtils.isBlank(phoneNumber) ||
                StringUtils.length(lastLogin) != 4 || StringUtils.length(lastOrder) != 4)
            throw new IllegalArgumentException(

                    "Couldn't parse a JSON from the request. JSON: " + jsonWithUser);

        User userToService = new User();
        userToService.setFirstName(firstName);
        userToService.setLastName(lastName);
        userToService.setUserName(userName);
        userToService.setUserPassword(userPassword);
        userToService.setPermission(permission);
//        userToService.setAddressId(addressId);
        userToService.setEmailAddress(emailAddress);
        userToService.setPhoneNumber(phoneNumber);

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        java.util.Date date = sdf1.parse(lastLogin);
        userToService.setLastLogin(new java.sql.Timestamp(date.getTime()));
        userToService.setLastOrder(new java.sql.Timestamp(date.getTime()));

        User savedUser = iUserService.save(userToService);
        String resultMessage = savedUser != null ? "success" : "failure";
        return "<div style=\"text-align:center;\">" + "<h1> New customer was stored: " + resultMessage

                + " </h1></div>";

    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable String id) {
        return iUserService.findById(Integer.valueOf(id));
    }

}
